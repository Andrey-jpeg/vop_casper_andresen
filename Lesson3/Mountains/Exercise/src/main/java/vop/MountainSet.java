package vop;

import java.io.File;
import java.net.URISyntaxException;

public class MountainSet {

    public static void main(String[] args) throws URISyntaxException {
        String path = MountainSet.class.getResource("FranskeBjerge.csv").toURI().getPath();
        File f =new File(path);
    }
}
