package training360.guinessapp.worldrecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.recorders.Recorder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "world_record")
public class WorldRecord {

    public WorldRecord(Long recorderId) {
        this.recorderId = recorderId;
    }

    public WorldRecord(String description, double value, String unitOfMeasure, LocalDate dateOfRecord, Long recorderId) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorderId = recorderId;
    }

    public WorldRecord(String description, double value, String unitOfMeasure, LocalDate dateOfRecord) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double value;

    @Column(name = "unit_of_measure")
    private String unitOfMeasure;

    @Column(name = "date_of_records")
    private LocalDate dateOfRecord;

    @Column(name = "recorder_id")
    private Long recorderId;

//    public void addRecorder(Recorder recorder) {
//        recorders.add(recorder);
//        recorder.setWorldRecord(this);
//    }
}
