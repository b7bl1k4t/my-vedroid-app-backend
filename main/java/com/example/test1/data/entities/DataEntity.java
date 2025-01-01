package com.example.test1.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_table")
public class DataEntity {
    @PrimaryKey(autoGenerate = true)
    private int id; // Автоматический ID для Room

    private String patientId;
    private int ageYears;
    private String gender;
    private String seizure;
    private String localization;
    private String lateralization;
    private int eegChannel;
    private int numberSeizures;
    private int recTimeMinutes;

    public DataEntity(String patientId, int ageYears, String gender, String seizure,
                      String localization, String lateralization, int eegChannel,
                      int numberSeizures, int recTimeMinutes) {
        this.patientId = patientId;
        this.ageYears = ageYears;
        this.gender = gender;
        this.seizure = seizure;
        this.localization = localization;
        this.lateralization = lateralization;
        this.eegChannel = eegChannel;
        this.numberSeizures = numberSeizures;
        this.recTimeMinutes = recTimeMinutes;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(int ageYears) {
        this.ageYears = ageYears;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSeizure() {
        return seizure;
    }

    public void setSeizure(String seizure) {
        this.seizure = seizure;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getLateralization() {
        return lateralization;
    }

    public void setLateralization(String lateralization) {
        this.lateralization = lateralization;
    }

    public int getEegChannel() {
        return eegChannel;
    }

    public void setEegChannel(int eegChannel) {
        this.eegChannel = eegChannel;
    }

    public int getNumberSeizures() {
        return numberSeizures;
    }

    public void setNumberSeizures(int numberSeizures) {
        this.numberSeizures = numberSeizures;
    }

    public int getRecTimeMinutes() {
        return recTimeMinutes;
    }

    public void setRecTimeMinutes(int recTimeMinutes) {
        this.recTimeMinutes = recTimeMinutes;
    }
}
