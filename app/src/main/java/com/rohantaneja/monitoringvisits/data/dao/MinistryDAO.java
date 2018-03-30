package com.rohantaneja.monitoringvisits.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.rohantaneja.monitoringvisits.model.Question;
import com.rohantaneja.monitoringvisits.model.QuestionOption;
import com.rohantaneja.monitoringvisits.model.Task;
import com.rohantaneja.monitoringvisits.model.Visit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ralph on 30/03/18.
 */

@Dao
public interface MinistryDAO {

    @Insert
    void insertTasks(ArrayList<Task> tasks);

    @Insert
    void insertTask(Task task);

    @Query("SELECT * FROM tasks WHERE districtName = :districtName")
    List<Task> getTasksForDistrict(String districtName);

    @Query("SELECT * FROM tasks WHERE programmeId = :programmeId")
    List<Task> getTasksForProgramme(int programmeId);

    @Query("SELECT * FROM visits WHERE taskId = :taskId")
    List<Visit> getVisitsForTask(int taskId);

    @Insert
    void insertVisits(ArrayList<Visit> visits);

    @Insert
    void insertVisit(Visit visit);

    @Query("SELECT * FROM questions WHERE programmeId = :programmeId AND visitType = :visitType")
    List<Question> getQuestionsForProgrammeAndVisitType(int programmeId, String visitType);

    @Insert
    void insertQuestions(ArrayList<Question> questions);

    @Insert
    void insertQuestion(Question questions);


    @Query("SELECT * FROM questionOptions WHERE questionId = :questionId")
    List<QuestionOption> getQuestionOptions(int questionId);

    @Insert
    void insertQuestionOptions(ArrayList<QuestionOption> questionOptions);


}
