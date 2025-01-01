package com.example.test1.presentation.ui.progress;

import android.os.Bundle;
import com.example.test1.presentation.viewmodels.ProgressViewModel;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.test1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProgressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressFragment extends Fragment {
    private ProgressBar progressBar;
    private ProgressViewModel progressViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress, container, false);
        progressBar = view.findViewById(R.id.progress_bar);
        progressViewModel = new ViewModelProvider(this).get(ProgressViewModel.class);

        progressViewModel.getProgress().observe(getViewLifecycleOwner(), progress -> {
            progressBar.setProgress(progress);
        });

        progressViewModel.getProgress().observe(getViewLifecycleOwner(), progress -> {
            progressBar.setProgress(progress);
            if (progress >= 100) {
                NavController navController = NavHostFragment.findNavController(ProgressFragment.this);
                NavOptions navOptions = new NavOptions.Builder()
                        .setPopUpTo(R.id.progressFragment, true) // Удалить ProgressFragment из стека
                        .build();
                navController.navigate(R.id.action_progressFragment_to_resultFragment, null, navOptions);
            }
        });

        simulateProgress(); // Симуляция прогресса анализа
        return view;
    }

    private void simulateProgress() {
        progressViewModel.startProgress();
    }
}