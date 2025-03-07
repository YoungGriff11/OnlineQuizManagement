/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conorgriffin.onlinequizmanagement.filter;

import jakarta.ws.rs.ForbiddenException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
/**
 * 31/31/12
 * @author Conor School
 */

@Provider
public class APIKeyFilter implements ContainerRequestFilter {

    // Constant for the header name where the API key is expected
    private static final String API_KEY_HEADER = "X-API-Key";
    // Sample API key for authorized access (teacher access in this case)
    private static final String API_KEY = "teacher123";  

    // This method is called to process incoming requests
    @Override
    public void filter(ContainerRequestContext context) throws WebApplicationException {
        // Retrieve the API key from the request headers
        String apiKey = context.getHeaderString(API_KEY_HEADER);

        // Check if the API key is valid
        if (apiKey == null || !apiKey.equals(API_KEY)) {
            // If the API key is missing or incorrect, throw a ForbiddenException (HTTP 403)
            throw new ForbiddenException("Unauthorized access");
        }
    }
}