package org.example;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/events")
public class SseServlet extends HttpServlet implements Servlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type to "text/event-stream" and character encoding to UTF-8
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        // Set the Cache-Control header to prevent caching of the SSE response
        response.setHeader("Cache-Control", "no-cache");

        PrintWriter writer = response.getWriter();
        int counter = 0;

        while (true) {
            try {
                // Send an event every 2 seconds
                writer.write("data: Event number " + counter + "\n\n");
                writer.flush();
                counter++;
                Thread.sleep(2000);  // Simulate some work
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}