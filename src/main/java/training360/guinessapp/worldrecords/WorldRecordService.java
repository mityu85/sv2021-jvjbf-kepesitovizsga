package training360.guinessapp.worldrecords;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;
import training360.guinessapp.recorders.Recorder;
import training360.guinessapp.recorders.RecorderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper modelMapper;
    private WorldRecordRepository worldRecordRepository;
    private RecorderRepository recorderRepository;


    public List<WorldRecordDto> getWorldRecordsList() {
        return worldRecordRepository.findAll().stream()
                .map(worldRecord -> modelMapper.map(worldRecord, WorldRecordDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public WorldRecordDto addNewWorldRecord(WorldRecordCreateCommand command) {
        Recorder recorder = recorderRepository.findById(command.getRecorderId())
                .orElseThrow(() -> new IllegalArgumentException("recorder not found"));
        WorldRecord worldRecord = new WorldRecord(
                command.getDescription(),
                command.getValue(),
                command.getUnitOfMeasure(),
                command.getDateOfRecord(),
                recorder.getId()
        );
        //worldRecord.addRecorder(recorder);
        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }

    @Transactional
    public BeatWorldRecordDto addBeatRecord(Long id, BeatWorldRecordCommand command) {
        WorldRecord worldRecord = worldRecordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id cannot be found " + id));
        Recorder recorder = recorderRepository.findById(command.getRecorderId())
                .orElseThrow(() -> new IllegalArgumentException("id cannot be found " + command.getRecorderId()));
        worldRecord.setValue(command.getNewRecord());
        //worldRecord.addRecorder(recorder);
        return modelMapper.map(worldRecord, BeatWorldRecordDto.class);
    }
}
