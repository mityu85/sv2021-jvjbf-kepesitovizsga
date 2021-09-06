package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorders.Recorder;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordDto {

    private Long id;
    private String description;
    private double value;
    private String unitOfMeasure;
    private LocalDate dateOfRecord;
    private Long recorderName;
}
