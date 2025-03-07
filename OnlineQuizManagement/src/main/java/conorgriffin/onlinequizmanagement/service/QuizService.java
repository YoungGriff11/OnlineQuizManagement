/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conorgriffin.onlinequizmanagement.service;

import conorgriffin.onlinequizmanagement.model.Quiz;
import conorgriffin.onlinequizmanagement.model.Questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 31/12/24
 * @author Conor School
 */

public class QuizService {
    // A map to store quizzes by their unique quizId
    private static final Map<String, Quiz> quizzes = new HashMap<>();

    // Method to create a new quiz and store it in the map
    public Quiz createQuiz(String quizId, String title, List<Questions> questions) {
        // Create a new Quiz object with the provided parameters
        Quiz quiz = new Quiz(quizId, title, questions);
        // Store the created quiz in the map using the quizId as the key
        quizzes.put(quizId, quiz);
        // Return the created quiz
        return quiz;
    }

    // Method to retrieve a quiz by its quizId
    public Quiz getQuiz(String quizId) {
        // Return the quiz by with the given quizId, or null if not found
        return quizzes.get(quizId);
    }

    // Method to delete a quiz by its quizId
    public void deleteQuiz(String quizId) {
        // Remove the quiz with the given quizId from the map
        quizzes.remove(quizId);
    }

    // Method to retrieve all quizzes stored in the system
    public Map<String, Quiz> getAllQuizzes() {
        // Return the map containing all quizzes
        return quizzes;
    }
}