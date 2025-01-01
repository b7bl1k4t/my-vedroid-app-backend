package com.example.test1.presentation.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.test1.presentation.viewmodels.MainViewModel;
import com.example.test1.R;

public class HomeFragment extends Fragment {

    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        view.findViewById(R.id.button_upload).setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_nav_home_to_progressFragment);
        });

        return view;
    }
}
