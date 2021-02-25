package vop.threadedtcp.requesthandlers;

import vop.serialio.Species;

import java.io.*;
import java.net.Socket;
import java.util.stream.Collectors;

public class ObjectRequestHandler extends AbstractRequestHandler{
    public ObjectRequestHandler(Socket socket){
        super(socket);
    }

    @Override
    public void run() {

    }
}
