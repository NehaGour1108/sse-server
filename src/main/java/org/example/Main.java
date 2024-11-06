package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        // Create a server instance, binding to port 8080
        Server server = new Server(8080);

        // Create a context handler for the "/events" URL
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Map the SseServlet to /events
        context.addServlet(SseServlet.class, "/events");

        // Set the handler and start the server
        server.setHandler(context);
        server.start();
        System.out.println("SSE Server started at http://localhost:8080");
        server.join();
    }
}