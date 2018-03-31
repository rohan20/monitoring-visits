package com.rohantaneja.monitoringvisits.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rohantaneja.monitoringvisits.model.Programme;
import com.rohantaneja.monitoringvisits.model.Question;
import com.rohantaneja.monitoringvisits.model.QuestionAnswer;
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTasks(ArrayList<Task> tasks);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Task task);

    @Query("SELECT * FROM tasks WHERE programmeId = :programmeId")
    List<Task> getTasksForProgramme(int programmeId);

    @Query("SELECT * FROM visits WHERE taskId = :taskId")
    List<Visit> getVisitsForTask(int taskId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVisits(ArrayList<Visit> visits);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVisit(Visit visit);

    @Query("SELECT * FROM questions WHERE programmeId = :programmeId AND visitType = :visitType")
    List<Question> getQuestionsForProgrammeAndVisitType(int programmeId, String visitType);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertQuestions(ArrayList<Question> questions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertQuestion(Question questions);


    @Query("SELECT * FROM questionOptions WHERE questionId = :questionId")
    List<QuestionOption> getQuestionOptions(int questionId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertQuestionOptions(ArrayList<QuestionOption> questionOptions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProgramme(Programme programme);

    @Query("SELECT * FROM tasks")
    List<Task> getAllTasks();

    @Query("SELECT * FROM programmes where programmeId = :id")
    Programme getProgramme(int id);

    @Query("DELETE FROM programmes")
    void deleteProgrammes();

    @Query("DELETE FROM questions")
    void deleteQuestions();

    @Query("DELETE FROM questionOptions")
    void deleteQuestionOptions();

    @Query("DELETE FROM tasks")
    void deleteTasks();


    @Query("DELETE FROM visits")
    void deleteVisits();

    @Query("SELECT * FROM questions")
    List<Question> getAllQuestion();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAnswer(QuestionAnswer answer);

    @Query("SELECT * FROM ANSWERS WHERE questionId = :qid")
    QuestionAnswer getAnswers(int qid);


}
