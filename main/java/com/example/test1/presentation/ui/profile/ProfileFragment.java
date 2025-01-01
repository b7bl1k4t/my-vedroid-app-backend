package com.example.test1.presentation.ui.profile;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.test1.presentation.viewmodels.MainViewModel;
import com.example.test1.R;

public class ProfileFragment extends Fragment {

    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        view.findViewById(R.id.button_result_n).setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_nav_profile_to_resultFragment);
        });

        return view;
    }
}
