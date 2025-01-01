package com.example.test1.domain.mappers;

import android.util.Log;

import com.example.test1.domain.models.PatientModel;
import com.example.test1.domain.models.StatisticalDataModel;

import java.util.ArrayList;
import java.util.List;

public class StatisticalDataMapper {

    // Преобразование PatientModel -> StatisticalDataModel
    public static StatisticalDataModel mapToStatisticalDataModel(PatientModel patient) {
        Log.d("StatisticalMapper", "Mapping PatientModel: " + patient.getPatientId() + ", Gender: " + patient.getGender());
        return new StatisticalDataModel(patient.getGender(), patient.getAgeYears());
    }

    // Преобразование списка PatientModel -> List<StatisticalDataModel>
    public static List<StatisticalDataModel> mapToStatisticalDataModelList(List<PatientModel> patients) {
        List<StatisticalDataModel> stats = new ArrayList<>();
        for (PatientModel patient : patients) {
            stats.add(mapToStatisticalDataModel(patient));
        }
        return stats;
    }
}
