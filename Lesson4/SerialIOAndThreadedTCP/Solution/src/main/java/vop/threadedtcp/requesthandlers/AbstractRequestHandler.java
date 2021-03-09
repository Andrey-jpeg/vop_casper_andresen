package vop.threadedtcp.requesthandlers;

import java.net.Socket;

/**
 *
 * @author erso
 */
public abstract class AbstractRequestHandler implements Runnable{
    
    protected Socket socket;

    public AbstractRequestHandler(Socket socket) {
        this.socket = socket;
    }
    
    
}
