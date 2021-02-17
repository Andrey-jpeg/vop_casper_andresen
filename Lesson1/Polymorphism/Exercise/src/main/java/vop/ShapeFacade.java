/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {

    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        if (shape == SHAPES.CIRCLE) {
            Circle circle = new Circle(parametre[0]);
            return circle.toString();
        }
        else if (shape == SHAPES.SQUARE){
            Square square = new Square(parametre[0]);
            return square.toString();
        }
        else if (shape == SHAPES.RECTANGLE){
            Rectangle rectangle = new Rectangle(parametre[0], parametre[1]);
            return rectangle.toString();
        }
        else if (shape == SHAPES.ELLIPSE){
            Ellipse ellipse = new Ellipse(parametre[0], parametre[1]);
            return ellipse.toString();
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
