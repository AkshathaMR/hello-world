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

      @Test
    void testDoGet() throws Exception {
        // Arrange
        HelloWorldServlet servlet = new HelloWorldServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        // Act
        servlet.doGet(request, response);

        // Assert
        writer.flush(); // Ensure all output is written
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
