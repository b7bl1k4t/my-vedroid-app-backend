package com.example.test1.domain.usecase;

import java.util.ArrayList;
import java.util.List;

public class ProcessDataUseCase {

    public List<Float> calculateAverages(List<String[]> data) {
        List<Float> averages = new ArrayList<>();
        for (String[] row : data) {
            try {
                float sum = 0;
                for (String value : row) {
                    sum += Float.parseFloat(value.trim());
                }
                averages.add(sum / row.length);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return averages;
    }
}
