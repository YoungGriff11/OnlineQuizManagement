/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conorgriffin.onlinequizmanagement.model;

import java.util.List;

/**
 * 31/12/24
 * @author Conor School
 */

public class Quiz {

    // Instance variables for storing quiz details
    private String quizId;  // The unique identifier for the quiz
    private String title;   // The title of the quiz
    private List<Questions> questions;  // A list to hold the questions of the quiz
    
    // Default constructor
    public Quiz() {}

    // Parameterized constructor to initialize a Quiz object with its properties
    public Quiz(String quizId, String title, List<Questions> questions) {
        this.quizId = quizId;
        this.title = title;
        this.questions = questions;
    }

    // Getter for quizId
    public String getQuizId() {
        return quizId;
    }

    // Setter for quizId
    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for questions list
    public List<Questions> getQuestions() {
        return questions;
    }

    // Setter for questions list
    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}
