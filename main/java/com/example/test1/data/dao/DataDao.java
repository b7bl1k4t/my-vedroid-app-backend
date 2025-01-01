package com.example.test1.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.test1.data.entities.DataEntity;

import java.util.List;

@Dao
public interface DataDao {

    @Insert
    void insertData(List<DataEntity> data);

    @Query("SELECT * FROM data_table")
    List<DataEntity> getAllData();
}
