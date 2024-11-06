To implement Server-Sent Events (SSE) in a Java Maven project, we'll use a combination of Java's Servlet API and a web server like Jetty to handle the SSE. Here's a step-by-step guide to setting up a basic SSE implementation using Maven.

### 1. **Project Structure**

Create a Maven project with the following structure:

```
sse-server
│
├── src
│   └── main
│       └── java
│           └── org
│               └── example
│                   ├── Main.java
│                   └── SseServlet.java
├── pom.xml
└── target
```


### 2. **Run the Application**

Now that the `Main.java` sets up the Jetty server and the `SseServlet.java` serves SSE events, you can run the application using Maven.

In the root of your project, run:

```bash
mvn clean install
mvn exec:java
```

This will start the Jetty server on port 8080.

### 3. **Access the Events from a Web Browser**

Now you can listen for events on the `/events` URL. Open your browser's developer tools (Console) and run the following JavaScript:

```javascript
const eventSource = new EventSource("http://localhost:8080/events");

eventSource.onmessage = function(event) {
    console.log("New Event:", event.data);
};

eventSource.onerror = function(error) {
    console.error("Error in SSE:", error);
};
```

### Expected Output

The browser console should log the events received from the server every 2 seconds:

```
New Event: Event number 0
New Event: Event number 1
New Event: Event number 2
New Event: Event number 3
...
```

### Conclusion

This is a simple example of how to implement Server-Sent Events (SSE) in a Java Maven project using Jetty as the embedded web server. You can expand this further by adding more advanced features like dynamic event content, error handling, and client-side interaction.
