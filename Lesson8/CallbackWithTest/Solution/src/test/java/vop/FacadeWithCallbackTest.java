/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author fsan
 */
public class FacadeWithCallbackTest {

    FacadeWithCallback facade;
    CallBackInterface soutCallBack;
    Dice dice;

    public FacadeWithCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        soutCallBack = new CallBackInterface() {
            @Override
            public void updateMessage(String message) {
                System.out.println(message);

            }

            @Override
            public void updateImages(File i1, File i2) {
                System.out.println("Pics: " + i1.getName() + " " + i2.getName());
            }
        };
        facade = new FacadeWithCallback(soutCallBack, FacadeWithCallback.class.getResource("").getPath());
        facade.start();
    }

    @After
    public void tearDown() {
        facade.interrupt();
    }

    /**
     * Test of run method, of class FacadeWithCallback.
     */

    @Test
    public void testRun() {

        dice = facade.getDice();
        while (!dice.equalsMax()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(FacadeWithCallbackTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        assertEquals(6, dice.getDie1());
        assertEquals(6, dice.getDie2());
    }

}
