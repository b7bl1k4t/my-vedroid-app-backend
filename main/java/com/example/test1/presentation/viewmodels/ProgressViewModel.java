package com.example.test1.presentation.viewmodels;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProgressViewModel extends ViewModel {
    private final MutableLiveData<Integer> progress = new MutableLiveData<>();
    private final Handler handler = new Handler();
    private int progressStatus = 0;

    public LiveData<Integer> getProgress() {
        return progress;
    }

    public void startProgress() {
        progressStatus = 0;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (progressStatus < 100) {
                    progressStatus += 1;
                    progress.setValue(progressStatus);
                    if (progressStatus < 100) {
                        handler.postDelayed(this, 50);
                    }
                }
            }
        }, 50);
    }
}
