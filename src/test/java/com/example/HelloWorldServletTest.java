package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldServletTest {

    private HelloWorldServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter printWriter;

    @BeforeEach
    void setUp() {
        servlet = new HelloWorldServlet(); // Create a new instance of the servlet
        request = mock(HttpServletRequest.class); // Mock HttpServletRequest
        response = mock(HttpServletResponse.class); // Mock HttpServletResponse
        
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        
        // Mock the response.getWriter() method to return our custom PrintWriter
        when(response.getWriter()).thenReturn(printWriter);
    }

    @Test
    void testDoGet() throws IOException {
        // Act: Call the doGet method on the servlet
        servlet.doGet(request, response);
        
        // Flush the writer to ensure all content is written
        printWriter.flush();
        
        // Assert: Verify the output is what we expect
        assertEquals("<h1>Hello, World!</h1>", stringWriter.toString().trim());
    }
    // @Mock private HttpServletRequest request;
    // @Mock private HttpServletResponse response;
    // @Mock private ServletConfig servletConfig;
    // @Mock private ServletContext servletContext;
    // @Mock private PrintWriter writer;

    // private HelloWorldServlet servlet;

    // @BeforeEach
    // void setUp() throws Exception {
    //     MockitoAnnotations.openMocks(this);
    //     servlet = new HelloWorldServlet();
    //     when(response.getWriter()).thenReturn(writer);
    // }

    // // Test 1: Simple HelloWorldServlet Response
    // @Test
    // void testServletResponse() throws Exception {
    //     servlet.doGet(request, response);
    //     verify(writer).write("Hello World");
    // }

    // // Test 2: Check HTTP Status Code
    // @Test
    // void testHttpStatusCode() throws Exception {
    //     servlet.doGet(request, response);
    //     verify(response).setStatus(HttpServletResponse.SC_OK);
    // }

    // // Test 3: Check Content-Type header
    // @Test
    // void testContentType() throws Exception {
    //     servlet.doGet(request, response);
    //     verify(response).setContentType("text/html");
    // }

    // // Test 4: Test Error Handling - Simulating Error (e.g., request error)
    // @Test
    // void testErrorHandling() throws Exception {
    //     when(request.getParameter("error")).thenReturn("true"); // simulate an error
    //     servlet.doGet(request, response);
    //     verify(response).sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request parameter");
    // }
}
