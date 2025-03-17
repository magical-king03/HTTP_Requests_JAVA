# Java HTTP Requests Project

This project demonstrates different types of HTTP requests in Java using `HttpURLConnection`. Each file corresponds to a specific type of request and showcases its implementation.

## Project Structure

The project consists of the following Java files:

1. **SimpleHttpConnection.java**  
   - Establishes a basic HTTP connection to a URL.
   - Demonstrates how to open a connection and check for a successful response.
   - Example usage of `HttpURLConnection`.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/732e90cf-fb4d-41b1-a6c5-059e4c75a311)


2. **GetRequest**  
   - Sends an HTTP GET request to a specified URL.
   - Retrieves and prints the response.
   - Handles input stream reading and error handling.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/3b15b293-a842-463b-b290-69fd7e9b9c82)


3. **PostRequest**  
   - Sends an HTTP POST request with a request body.
   - Demonstrates setting headers and sending JSON data.
   - Reads and prints the response from the server.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/456140b0-80de-4206-8a14-4c1afde05390)


4. **PutRequest**  
   - Implements an HTTP PUT request to update existing data.
   - Demonstrates setting request headers and sending JSON payload.
   - Handles server responses effectively.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/9525b766-bedf-4d74-bd24-2ff72044906e)


5. **DeleteRequest**  
   - Sends an HTTP DELETE request to remove a resource.
   - Shows how to handle server responses for delete actions.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/b4fcc404-a7f1-435f-aa3f-e40063767d73)


6. **HeadRequest**  
   - Sends an HTTP HEAD request to fetch headers without a body.
   - Useful for checking resource metadata.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/31b90bbf-16aa-41cb-ab44-26de0faa72ef)


7. **Timeouts**  
   - Demonstrates setting connection and read timeouts.
   - Handles timeout exceptions gracefully.
   
   _Example Output:_  
   ![image](https://github.com/user-attachments/assets/5ef9932b-3f01-4c4f-a1a1-1603910583bb)


## Prerequisites

- Java 8 or higher
- Internet connection (to test API requests)

## How to Run

1. Clone the repository:
   ```sh
   git clone <repo-url>
   cd <project-folder>
   ```
2. Compile and run any Java file:
   ```sh
   javac <FileName>.java
   java <FileName>
   ```

## Notes

- You can modify the URLs used in the examples to test against different APIs.
- Ensure that the target server supports the request methods being tested.

## Author
### Visweish KM


The client side page used in this demo - https://duty-dash.vercel.app/

The server used in this demo - https://todo-application-rho-sand.vercel.app/

---
