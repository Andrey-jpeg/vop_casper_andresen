# Binary File I/O and Threaded TCP:

# Tasks

## Task 1 - Serial I/O

This project contains a reduced version of `Species.java` (Listing 10.9) and a version of Listing 10.10, where new
executions of the program tries to append Species to the file. It throws the exception. Change it so we don’t get the
exception.

## Task 2 - Threaded TCP

Threaded TCP Server: The project also contains the example we saw half an hour ago ;-). Develop
a `FileOutRequestHandler extends AbstractRequestHandler` in the `requesthandler`-package. It must contain:

- A constructor with signature `public FileOutRequestHandler(Socket socket, String fileName)`.
    - Remember to call `super(socket)`. 
- When receiving a String it shall write to the file:
  - Timestamp (`new Date()`)
  - Who is the client (`INetAddress:port`)
  - The received String
  - Put a Tab character (“\t”) between the info

## Task 3

Challenging: Make a `RequestHandler` that uses `ObjectInputStream` to receive an object, and writes it to `System.out` by
   calling `toString()` on it, and a Client that sends a Serialized object (e.g. a `Species`) to the server.