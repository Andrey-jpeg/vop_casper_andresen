package vop.threadedtcp.requesthandlers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class ObjectRequestHandler extends AbstractRequestHandler{

    public ObjectRequestHandler(Socket socket) {
        super(socket);
    }

    @Override
    public void run() {
        System.out.println("RequestHandler started for " + socket.getPort());
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println("Server ready. Send your Serialized object:");

                System.out.println("Received: " + ois.readObject());
                

        } catch (IOException ex) {
            Logger.getLogger(FlipRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
 
}
