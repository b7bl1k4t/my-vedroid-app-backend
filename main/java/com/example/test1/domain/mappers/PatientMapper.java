package com.example.test1.domain.mappers;

import com.example.test1.data.entities.DataEntity;
import com.example.test1.domain.models.PatientModel;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {

    // Преобразование DataEntity -> PatientModel
    public static PatientModel mapToPatientModel(DataEntity entity) {
        return new PatientModel(
                entity.getPatientId(),
                entity.getAgeYears(),
                entity.getGender(),
                entity.getSeizure(),
                entity.getLocalization(),
                entity.getLateralization(),
                entity.getEegChannel(),
                entity.getNumberSeizures(),
                entity.getRecTimeMinutes()
        );
    }

    // Преобразование списка DataEntity -> List<PatientModel>
    public static List<PatientModel> mapToPatientModelList(List<DataEntity> entities) {
        List<PatientModel> patients = new ArrayList<>();
        for (DataEntity entity : entities) {
            patients.add(mapToPatientModel(entity));
        }
        return patients;
    }
}
