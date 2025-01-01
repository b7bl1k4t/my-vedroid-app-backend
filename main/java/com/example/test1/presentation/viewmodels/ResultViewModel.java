package com.example.test1.presentation.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.test1.data.entities.DataEntity;
import com.example.test1.data.repository.AppDatabase;
import com.example.test1.data.utils.CsvLoader;
import com.example.test1.domain.mappers.PatientMapper;
import com.example.test1.domain.mappers.StatisticalDataMapper;
import com.example.test1.domain.models.PatientModel;
import com.example.test1.domain.models.StatisticalDataModel;

import java.util.List;
import java.util.concurrent.Executors;

public class ResultViewModel extends AndroidViewModel {
    private final MutableLiveData<List<StatisticalDataModel>> statisticsData = new MutableLiveData<>();
    private final AppDatabase database;

    public ResultViewModel(Application application) {
        super(application);
        database = AppDatabase.getInstance(application);
    }

    public LiveData<List<StatisticalDataModel>> getStatisticsData() {
        return statisticsData;
    }

    public void loadStatistics() {
        Executors.newSingleThreadExecutor().execute(() -> {
            // Получаем DataEntity из базы данных
            List<DataEntity> entities = database.dataDao().getAllData();
            Log.d("RoomData", "Loaded rows from database: " + entities.size());

            if (entities.isEmpty()) {
                // Если база пуста, загружаем данные из CSV
                List<DataEntity> csvData = CsvLoader.loadCsvFromAssets(getApplication(), "subject_info.csv");
                Log.d("CsvLoader", "Loaded rows from CSV: " + csvData.size());

                if (!csvData.isEmpty()) {
                    database.dataDao().insertData(csvData);
                    Log.d("RoomData", "Inserted rows into database: " + csvData.size());
                }
            }


            // Преобразуем DataEntity -> PatientModel
            List<PatientModel> patients = PatientMapper.mapToPatientModelList(entities);

            // Преобразуем PatientModel -> StatisticalDataModel
            List<StatisticalDataModel> stats = StatisticalDataMapper.mapToStatisticalDataModelList(patients);

            // Передаём данные для отображения
            statisticsData.postValue(stats);
        });
    }
}
