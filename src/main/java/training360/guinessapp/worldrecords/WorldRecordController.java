package training360.guinessapp.worldrecords;

import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/worldrecords")
public class WorldRecordController {

    private WorldRecordService worldRecordService;

    public WorldRecordController(WorldRecordService worldRecordService) {
        this.worldRecordService = worldRecordService;
    }

    @GetMapping
    public List<WorldRecordDto> getWorldRecordsList() {
        return worldRecordService.getWorldRecordsList();
    }

    @PostMapping
    public WorldRecordDto addNewWorldRecord(@Valid @RequestBody WorldRecordCreateCommand command) {
        return worldRecordService.addNewWorldRecord(command);
    }

    @PutMapping("{id}/beatrecords")
    public BeatWorldRecordDto addBeatRecord(@PathVariable("id") Long id, @Valid @RequestBody BeatWorldRecordCommand command) {
        return worldRecordService.addBeatRecord(id, command);
    }
}
