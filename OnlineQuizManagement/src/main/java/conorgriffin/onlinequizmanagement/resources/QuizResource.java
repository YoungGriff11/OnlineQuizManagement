/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conorgriffin.onlinequizmanagement.resources;

import conorgriffin.onlinequizmanagement.model.Quiz;
import conorgriffin.onlinequizmanagement.model.Questions;
import conorgriffin.onlinequizmanagement.service.QuizService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

/**
 * 31/12/24
 *
 * @author Conor School
 */
@Path("/quizzes")
public class QuizResource {

    // Instance of the QuizService to handle quiz operations
    private final QuizService quizService = new QuizService();

    // POST endpoint to create a new quiz
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createQuiz(Quiz quiz) {
        // Check if the received quiz object is valid
        if (quiz == null || quiz.getQuizId() == null || quiz.getTitle() == null || quiz.getQuestions() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid quiz data").build();
        }
        // Call the service to create the quiz
        quizService.createQuiz(quiz.getQuizId(), quiz.getTitle(), quiz.getQuestions());
        // Return a response with status CREATED and the quiz object
        return Response.status(Response.Status.CREATED).entity(quiz).build();
    }

    // GET endpoint to retrieve all quizzes
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuizzes() {
        // Return all quizzes using the service
        return Response.ok(quizService.getAllQuizzes()).build();
    }

    // GET endpoint to retrieve a specific quiz by its ID
    @GET
    @Path("/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuiz(@PathParam("quizId") String quizId) {
        // Retrieve the quiz using the quizId
        Quiz quiz = quizService.getQuiz(quizId);
        // If quiz not found, return NOT_FOUND status
        if (quiz == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Quiz not found").build();
        }
        // Return the found quiz
        return Response.ok(quiz).build();
    }

    // DELETE endpoint to delete a quiz by its ID
    @DELETE
    @Path("/{quizId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteQuiz(@PathParam("quizId") String quizId) {
        // Check if the quiz exists before attempting to delete it
        Quiz quiz = quizService.getQuiz(quizId);
        if (quiz == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Quiz not found").build();
        }
        // Delete the quiz using the service
        quizService.deleteQuiz(quizId);
        // Return NO_CONTENT status after successful deletion
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // POST endpoint to update the questions of a quiz
    @POST
    @Path("/{quizId}/questions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateQuizQuestions(@PathParam("quizId") String quizId, List<Questions> newQuestions) {
        // Retrieve the quiz to update
        Quiz quiz = quizService.getQuiz(quizId);
        if (quiz == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Quiz not found").build();
        }
        // Set the new questions for the quiz
        quiz.setQuestions(newQuestions);
        // Return the updated quiz
        return Response.ok(quiz).build();
    }

    // PUT endpoint to submit answers for a quiz and calculate the score
    @PUT
    @Path("/{quizId}/submit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response submitQuizAnswers(@PathParam("quizId") String quizId, List<String> studentAnswers) {
        // Retrieve the quiz for grading
        Quiz quiz = quizService.getQuiz(quizId);
        if (quiz == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Quiz not found").build();
        }
        // Check if the number of answers matches the number of questions
        if (studentAnswers.size() != quiz.getQuestions().size()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Number of answers doesn't match the number of questions").build();
        }
        // Calculate the score by comparing answers to the correct ones
        int score = 0;
        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            if (studentAnswers.get(i).equalsIgnoreCase(quiz.getQuestions().get(i).getCorrectAnswer())) {
                score++;
            }
        }
        // Return the calculated score
        return Response.ok("Your score is: " + score + "/" + quiz.getQuestions().size()).build();
    }
}


    /* sample,for testing
    @GET
    @Path("/sample")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSampleQuiz() {
        List<Questions> questions = Arrays.asList(
                new Questions("Why is Death Stranding a good game?",
                        Arrays.asList("Beautiful", "Calming", "Excellent Story", "All the above"), "All the above")
        );
        Quiz quiz = quizService.createQuiz("1", "Gaming Question", questions);
        return Response.ok(quiz).build();
    }
}
*/

