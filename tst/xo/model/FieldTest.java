package xo.model;

import org.junit.jupiter.api.Test;
import xo.model.exceptions.AlreadyOccupiedException;
import xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final Field field = new Field(3);

        assertEquals(3,field.getSize());

    }

    @Test
    void setFigure() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertEquals(inputFigure, actualFigure);
    }

    @Test
    void testGetFigureWhenFigureIsNotSet() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }
    @Test
    void testGetFigureWhenFigureXIsLessThenZero() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
    @Test
    void testGetFigureWhenFigureYIsLessThenZero() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
    @Test
    void testGetFigureWhenFigureXIsMoreThenSize() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
    @Test
    void testGetFigureWhenFigureYIsMoreThenSize() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}