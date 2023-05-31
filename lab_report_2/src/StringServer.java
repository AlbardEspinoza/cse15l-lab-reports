import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> messages = new ArrayList<>();

    public String handleRequest(URI url) {
        System.out.println("Path: " + url.getPath());
        if (url.getPath().equals("/add-message")) {
            /* Instead of creating a String Array here I just passed
             * the value of the Query to the ArrayList directly. It's 
             * not as readable, but it's a little more efficient.
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
