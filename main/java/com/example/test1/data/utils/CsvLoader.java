package com.example.test1.data.utils;

import android.content.Context;
import android.util.Log;

import com.example.test1.data.entities.DataEntity;
import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static List<DataEntity> loadCsvFromAssets(Context context, String fileName) {
        List<DataEntity> data = new ArrayList<>();
        try (InputStream inputStream = context.getAssets().open(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             CSVReader csvReader = new CSVReader(inputStreamReader)) {
            String[] nextLine;
            boolean isHeader = true; // Флаг для пропуска заголовка
            while ((nextLine = csvReader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Пропускаем первую строку (заголовок)
                    continue;
                }
                try {
                    // Извлекаем данные из колонок
                    String patientId = nextLine[0].trim();
                    int ageYears = Integer.parseInt(nextLine[1].trim());
                    String gender = nextLine[2].trim();
                    String seizure = nextLine[3].trim();
                    String localization = nextLine[4].trim();
                    String lateralization = nextLine[5].trim();
                    int eegChannel = Integer.parseInt(nextLine[6].trim());
                    int numberSeizures = Integer.parseInt(nextLine[7].trim());
                    int recTimeMinutes = Integer.parseInt(nextLine[8].trim());

                    // Создаём объект DataEntity и добавляем в список
                    data.add(new DataEntity(patientId, ageYears, gender, seizure, localization,
                            lateralization, eegChannel, numberSeizures, recTimeMinutes));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    Log.e("CsvLoader", "Error parsing line: " + String.join(",", nextLine), e);
                }
            }
        } catch (Exception e) {
            Log.e("CsvLoader", "Error reading CSV", e);
        }
        return data;
    }

}
