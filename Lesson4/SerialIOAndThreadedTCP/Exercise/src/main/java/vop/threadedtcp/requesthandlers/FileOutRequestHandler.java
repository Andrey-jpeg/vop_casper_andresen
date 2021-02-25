package vop.threadedtcp.requesthandlers;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;

public class FileOutRequestHandler extends AbstractRequestHandler{
    private String fileName;
    public FileOutRequestHandler(Socket socket, String fileName){
        super(socket);
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(new Date().toString() + '\t' + socket.getInetAddress() + '\t' + fileName);
    }
}
