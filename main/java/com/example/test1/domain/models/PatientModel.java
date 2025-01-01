package com.example.test1.domain.models;

public class PatientModel {
    private String patientId;
    private int ageYears;
    private String gender;
    private String seizureType;
    private String localization;
    private String lateralization;
    private int eegChannel;
    private int numberSeizures;
    private int recordingTimeMinutes;

    public PatientModel(String patientId, int ageYears, String gender, String seizureType,
                        String localization, String lateralization, int eegChannel,
                        int numberSeizures, int recordingTimeMinutes) {
        this.patientId = patientId;
        this.ageYears = ageYears;
        this.gender = gender;
        this.seizureType = seizureType;
        this.localization = localization;
        this.lateralization = lateralization;
        this.eegChannel = eegChannel;
        this.numberSeizures = numberSeizures;
        this.recordingTimeMinutes = recordingTimeMinutes;
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public String getGender() {
        return gender;
    }

    public String getSeizureType() {
        return seizureType;
    }

    public String getLocalization() {
        return localization;
    }

    public String getLateralization() {
        return lateralization;
    }

    public int getEegChannel() {
        return eegChannel;
    }

    public int getNumberSeizures() {
        return numberSeizures;
    }

    public int getRecordingTimeMinutes() {
        return recordingTimeMinutes;
    }
}

