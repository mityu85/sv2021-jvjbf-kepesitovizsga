package training360.guinessapp.recorders;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RecorderService {

    private ModelMapper modelMapper;
    private RecorderRepository recorderRepository;


    public List<RecorderShortDto> getRecordersList() {
        return recorderRepository.findAll().stream()
                .filter(recorder -> recorder.getName().contains("e") || recorder.getName().startsWith("B"))
                .map(recorder -> modelMapper.map(recorder, RecorderShortDto.class))
                .collect(Collectors.toList());
    }

    public RecorderDto addNewRecorder(RecorderCreateCommand command) {
        return modelMapper.map(recorderRepository.save(new Recorder(
                command.getName(),
                command.getDateOfBirth()
        )), RecorderDto.class);
    }
}
