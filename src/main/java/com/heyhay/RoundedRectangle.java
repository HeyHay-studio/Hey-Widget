package com.heyhay;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

class RoundedRectangle extends Rectangle2D.Float {

    private float topLeftCorner;
    private float topRightCorner;
    private float bottomLeftCorner;
    private float bottomRightCorner;
    // The shape of the rounded rectangle
    private Shape shape;


    public RoundedRectangle() {
        super();
    }


    // The constructor that takes the x, y, width, height and radius parameters
    public RoundedRectangle(float x, float y, float width, float height, float radius) {
        shape = new RoundRectangle2D.Float(x, y, width, height, radius, radius);
    }

    public RoundedRectangle(
            float x,
            float y,
            float width,
            float height,
            float topLeftCorner,
            float topRightCorner,
            float bottomLeftCorner,
            float bottomRightCorner
    ) {
        super(x, y, width, height);
        this.topLeftCorner = topLeftCorner;
        this.topRightCorner = topRightCorner;
        this.bottomLeftCorner = bottomLeftCorner;
        this.bottomRightCorner = bottomRightCorner;
        updateShape();
    }

    // The method that updates the shape of the rounded rectangle
    private void updateShape() {
        // Creates the starting point of the shape to drawn
        Path2D path = new Path2D.Float();

        // Creates the starting point of the shape to drawn
        path.moveTo(getX() + checkRad(topLeftCorner), getY());

        // Draws a line from the current point the specified point
        path.lineTo(getX() + getWidth() - checkRad(topRightCorner), getY());

        // Draw a curve to the right edge
        path.quadTo(getX() + getWidth(), getY(), getX() + getWidth(), getY() + checkRad(topRightCorner));

        // Draw a line to the bottom right corner
        path.lineTo(getX() + getWidth(), getY() + getHeight() - checkRad(bottomRightCorner));

        // Draw a curve to the bottom edge
        path.quadTo(getX() + getWidth(), getY() + getHeight(), getX() + getWidth() - checkRad(bottomRightCorner), getY() + getHeight());

        // Draw a line to the bottom left corner
        path.lineTo(getX() + checkRad(bottomLeftCorner), getY() + getHeight());

        // Draw a curve to the left edge
        path.quadTo(getX(), getY() + getHeight(), getX(), getY() + getHeight() - checkRad(bottomLeftCorner));

        // Draw a line to the top left corner
        path.lineTo(getX(), getY() + checkRad(topLeftCorner));

        path.quadTo(getX(), getY(), getX() + checkRad(topLeftCorner), getY());

        // Close the path
        path.closePath();

        // Set the shape to the path
        shape = path;
    }

    private float checkRad(float rad) {
        if (rad * 2 >= getHeight())
            return (float) (getHeight() / 2f);
        return rad;
    }

    public float getTopLeftCorner() {
        return topLeftCorner;
    }

    public void setTopLeftCorner(float topLeftCorner) {
        this.topLeftCorner = topLeftCorner;
        updateShape();
    }

    public float getTopRightCorner() {
        return topRightCorner;
    }

    public void setTopRightCorner(float topRightCorner) {
        this.topRightCorner = topRightCorner;
        updateShape();
    }

    public float getBottomLeftCorner() {
        return bottomLeftCorner;
    }

    public void setBottomLeftCorner(float bottomLeftCorner) {
        this.bottomLeftCorner = bottomLeftCorner;
        updateShape();
    }

    public float getBottomRightCorner() {
        return bottomRightCorner;
    }

    public void setBottomRightCorner(float bottomRightCorner) {
        this.bottomRightCorner = bottomRightCorner;
        updateShape();
    }

    public Shape getShape() {
        return shape;
    }

}
