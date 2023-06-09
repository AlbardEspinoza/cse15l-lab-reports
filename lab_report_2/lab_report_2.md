# Lab Report 2

## Part 1

**StringServer**

```java
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    
    ArrayList<String> messages = new ArrayList<>();

    public String handleRequest(URI url) {
        System.out.println("Path: " + url.getPath());
        if (url.getPath().equals("/add-message")) {
            /* Instead of creating a String Array here I just passed
             * the value of the Query to the ArrayList directly. It's 
             * not as redable, but it's a little more efficient.
            */
            messages.add(url.getQuery().split("=")[1]);
        }
        else {
            return "404 Not Found!";
        }
        return String.join("\n", messages);
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```

**Server(Implemented the same one as Lab 2)**

```java
// A simple web server using Java's built-in HttpServer

// Examples from https://dzone.com/articles/simple-http-server-in-java were useful references

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

interface URLHandler {
    String handleRequest(URI url);
}

class ServerHttpHandler implements HttpHandler {
    URLHandler handler;
    ServerHttpHandler(URLHandler handler) {
      this.handler = handler;
    }
    public void handle(final HttpExchange exchange) throws IOException {
        // form return body after being handled by program
        try {
            String ret = handler.handleRequest(exchange.getRequestURI());
            // form the return string and write it on the browser
            exchange.sendResponseHeaders(200, ret.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(ret.getBytes());
            os.close();
        } catch(Exception e) {
            String response = e.toString();
            exchange.sendResponseHeaders(500, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

public class Server {
    public static void start(int port, URLHandler handler) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        //create request entrypoint
        server.createContext("/", new ServerHttpHandler(handler));

        //start the server
        server.start();
        System.out.println("Server Started! Visit http://localhost:" + port + " to visit.");
    }
}
```

**Example of calling "localhost:8081"**

![Image](screenshots/404_not_found.png)

**Examples of calling "/add-message" path**

![Image](screenshots/First_attempt.png)

* Which methods are called in this example? What are the relevant arguments to those methods, and the values of any relevant fields of the class?
  1. Main method in StringServer.java to begin the program
     * The relevant arguments are the args String array, which contains in the first index the port number to start to the server.
  2. Within the main method, if the user did not provide a port number when running the program System.out.println(SOPL) is called to display the user with an error about not providing the port number.
  3. Within the main method, Server.start(in Server.java) is called to start the web server.
     * The relevant arguments for Server.start are the port number and the instance of a Handler object.
  4. Within the main method, SOPL is called again to display the the server has started to the terminal.
  5. When I head to **http://localhost:8081/add-message?s=First%20attempt.** the handle method is called in Server.java in the ServerHttpHandler class.
     * The relevant arguments for the handle method are HttpExchange parameter.
     * The relevant fields of the ServerHttpHandler class are the URLHandler which gets assigned the instance variable of the Handler object mentioned in step 3.
  6. Within the handle method in the ServerHttpHandler class the handleRequest method is called which is in StringServer.java in the Handler class.
     * The relevant arguments in that class are the URI parameter which gets assigned the URI argument that gets returned when the HttpExchange parameter in the handle method calls getRequestURI.
     * The relevant field in that class is the messages ArrayList which gets initiated immediately in its declaration with a reference to an object in the heap.
  7. Within handleRequest SOPL is called to print out the URL path to the Terminal.
  8. Within handleRequest the URI parameter calls getPath and the return value calls the equals method in the String class to verify that you're calling **/add-message** path.
  9. Lastly the messages field adds the value of the value of the query string to its ArrayList and returns the value to the handleRequestMethod.

* How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
  * The only value of any field that changed from this specific request was the messages field in the Handler class in StringServer.java. The way it changed was by passing a specific value to the query string in the **/add-mesages** path, which was "First attempt." This was stored in the first index of the messages ArrayList.

![Image](screenshots/Second_attempt.png)

* Which methods are called in this example? What are the relevant arguments to those methods, and the values of any relevant fields of the class?
  * The answers to these questions are the same as the previous example.
* How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.
  * The only value of any field that changed from this specific request was the messages field in the Handler class in StringServer.java. The way it changed was by passing a specific value to the query string in the **/add-mesages** path, which was "First attempt." This was stored in the first index of the messages ArrayList. Then when called the **/add-mesages** path again the messages field stored a second value in its ArrayList, which was "Second attempt."

## Part 2

**Failure-inducing input and an input that doesn't induce failure for ArrayExamples.ReverseInPlace**

```Java
import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
  
  // Test with input that doesn't induce failure
	@Test 
	public void testReverseInPlace() {
    		int[] input1 = { 3 };
    		ArrayExamples.reverseInPlace(input1);
    		assertArrayEquals(new int[]{ 3 }, input1);
	}
	
  // Test with failure-inducing input
	@Test
	public void testReversedInPlace2() {
				int[] input1 = {1, 2, 3, 4};
				ArrayExamples.reverseInPlace(input1);
  			assertArrayEquals(new int[]{ 4, 3, 2, 1 }, input1);
	}
}
```

```Java
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
}
```

**Symptoms of tests**

![Image](screenshots/symptom_of_tests.png)

**Bug before fix**

```Java
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
}
```

**Bug after fix**

```Java
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
	int[] copyArr = new int[arr.length];
	System.arraycopy(arr, 0, copyArr, 0, arr.length);
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = copyArr[copyArr.length - i - 1];
    }
  }
}
```

**Fix description**

* What was happening in reverseInPlace before the fix was that it was reversing the array on top of the original array. So, it was able to copy correctly up until half of the array, if the array was of even-length, or until half of the array plus one, if the array was of odd-length. The fix was to simple store a copy of the original array and use the copy as as a reference to copy to correct values into the original array.

## Part 3

* In a couple of sentences describe something new that you learned from lab in week 2 or week 3.
  * Week 2: I learned to use the **curl** command. It was very interesting and useful since it allowed me to create a Bash file that was able to test if the output of my server was correct or not.
  * Week 3: I learned about the **JUnit testing framework**. It was really useful since before knowing abou this framework I usually tested my code manually without any unit tests. It was very time-consuming and a very deprecated way to test code. JUnit allowed me to automate a lot of tasks when testing my code.