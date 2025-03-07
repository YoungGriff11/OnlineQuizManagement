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
public class Questions {

    // Instance variables for storing question details
    private String questionText;  // The text of the question
    private List<String> choices; // A list of possible answer choices for the question
    private String correctAnswer; // The correct answer to the question
    
    // Default constructor
    public Questions() {}

    // constructor to initialize a question object with its properties
    public Questions(String questionText, List<String> choices, String correctAnswer) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    // Getter for questionText
    public String getQuestionText() {
        return questionText;
    }

    // Setter for questionText
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // Getter for choices list
    public List<String> getChoices() {
        return choices;
    }

    // Setter for choices list
    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    // Getter for correctAnswer
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Setter for correctAnswer
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}