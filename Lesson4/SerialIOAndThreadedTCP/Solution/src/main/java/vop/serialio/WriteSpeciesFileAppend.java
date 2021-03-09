package vop.serialio;

/**
 * File name: WriteSpeciesFile.java
 *
 * A class to build binary files of Species records (type Species). It is a
 * utility file for FindSpeciesRecords.java.
 *
 * Note: after all records are written to the file it displays the values
 * entered so they can be verified.
 *
 * Based on ClassObjectIODemo.java, Listing 10.10
 *
 * Uses Species.java, Listing 10.9
 *
 * Written by: Lew Rakocy email address: LRakocy@devrycols.edu Date: 04/05/2003
 * Updated for fourth edition by Brian Durney, January 2005.
 */
import java.io.*;
import java.util.*;


public class WriteSpeciesFileAppend {

    public static void main(String[] args) {
        String fileName = getFileName("Enter output file name.");
        File file = new File(fileName);
        try (ObjectOutputStream outputStream = 
                file.exists() ? 
                new ObjectOutputStream(new FileOutputStream(file, true)) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        super.reset();
                    }
                }
                : new ObjectOutputStream(new FileOutputStream(file, true));)
        {
            Species califCondor
                    = new Species("Calif. Condor", 27, 0.02);
            outputStream.writeObject(califCondor);

            Species blackRhino
                    = new Species("Black Rhino", 100, 1.0);
            outputStream.writeObject(blackRhino);

        } catch (IOException e) {
            System.err.println("Error opening output file "
                    + fileName + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Records sent to file "
                + fileName + ".");
        System.out.println(
                "Now let's reopen the file and echo the records.");
        int records = 0;
        Species readOne;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(fileName))) {

            while (true) {  //Reads untill EOF
                readOne = (Species) inputStream.readObject();
                System.out.println(readOne);
                System.out.println();
                records++;
            }
        } catch (EOFException eof) {
            System.out.println("Reading Done! "  + records);

        } catch (IOException e) {
            System.err.println("Error opening input file "
                    + fileName + ": " + e.getMessage());
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }

    }

    private static String getFileName(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        String fileName = null;
        System.out.println(prompt);
        fileName = keyboard.next();

        return fileName;
    }
}
