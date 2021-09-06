package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordDto {

    private Long id;
    private String description;
    private double value;
    private String unitOfMeasure;
    private LocalDate dateOfRecord;
}
