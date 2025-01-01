package com.example.test1.presentation.ui.result;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.test1.R;
import com.example.test1.domain.models.StatisticalDataModel;
import com.example.test1.presentation.viewmodels.ResultViewModel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        view.findViewById(R.id.result_ok_button).setOnClickListener(v -> {
            Navigation.findNavController(view).popBackStack();
        });

        ResultViewModel viewModel = new ViewModelProvider(this).get(ResultViewModel.class);

        viewModel.getStatisticsData().observe(getViewLifecycleOwner(), statistics -> {
            if (statistics == null || statistics.isEmpty()) {
                Log.e("ResultFragment", "No statistical data available");
                return;
            }

            // Разделяем данные по полу
            List<Entry> maleEntries = new ArrayList<>();
            List<Entry> femaleEntries = new ArrayList<>();
            int index = 0;

            for (StatisticalDataModel stat : statistics) {
                if (stat.getCategory().equalsIgnoreCase("Male")) {
                    maleEntries.add(new Entry(index++, (float) stat.getValue()));
                } else if (stat.getCategory().equalsIgnoreCase("Female")) {
                    femaleEntries.add(new Entry(index++, (float) stat.getValue()));
                }
            }

            // Создаём LineDataSet для мужчин
            LineDataSet maleDataSet = new LineDataSet(maleEntries, "Male");
            maleDataSet.setColor(Color.BLUE);
            maleDataSet.setCircleColor(Color.BLUE);

            // Создаём LineDataSet для женщин
            LineDataSet femaleDataSet = new LineDataSet(femaleEntries, "Female");
            femaleDataSet.setColor(Color.MAGENTA);
            femaleDataSet.setCircleColor(Color.MAGENTA);

            // Объединяем данные и отображаем график
            LineData lineData = new LineData(maleDataSet, femaleDataSet);
            LineChart chart = view.findViewById(R.id.chart);
            chart.setData(lineData);

            // Настройки графика
            chart.getDescription().setText("Age by Gender");
            chart.getDescription().setTextSize(12f);
            chart.getAxisLeft().setDrawGridLines(false);
            chart.getXAxis().setDrawGridLines(false);
            chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
            chart.getAxisRight().setEnabled(false); // Отключаем правую ось
            chart.setTouchEnabled(true);
            chart.setDragEnabled(true);
            chart.setScaleEnabled(true);
            chart.invalidate(); // Обновляем график
        });

        viewModel.loadStatistics();
        return view;
    }



}
