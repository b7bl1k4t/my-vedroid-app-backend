package com.example.test1.presentation.ui.settings;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.test1.R;

public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Настройка переключателей для выбора языка, темы и отправки диагностических данных
        Spinner languageSpinner = view.findViewById(R.id.language_spinner);
        SwitchCompat themeSwitch = view.findViewById(R.id.theme_switch);
        SwitchCompat diagnosticsSwitch = view.findViewById(R.id.diagnostics_switch);

//        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String selectedLanguage = (String) parent.getItemAtPosition(position);
//                switch (selectedLanguage) {
//                    case "Русский":
//                        setLocale("ru");
//                        break;
//                    case "English":
//                        setLocale("en");
//                        break;
////                    case "Français":
////                        setLocale("fr");
////                        break;
////                    case "Español":
////                        setLocale("es");
////                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // Ничего не делать
//            }
//        });

        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Логика переключения темы
        });

        diagnosticsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Логика включения/отключения отправки диагностических данных
        });

        return view;
    }

//    private void setLocale(String langCode) {
//        Locale locale = new Locale(langCode);
//        Locale.setDefault(locale);
//        Resources resources = getResources();
//        Configuration config = resources.getConfiguration();
//        config.setLocale(locale);
//        resources.updateConfiguration(config, resources.getDisplayMetrics());
//
//        getParentFragmentManager()
//                .beginTransaction()
//                .detach(this)
//                .attach(this)
//                .commit();
//    }
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(LocaleUtils.updateLocale(context, "ru"));  // Пример для русского языка
//    }
}
