package com.mycompany.csc211.week11.paintappdemo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PrimaryController {

    double startX, startY;
    String selectedShape = "LINE";
    Color selectedColor = Color.BLUE;
    
    @FXML
    private Slider strokeSize;
    @FXML
    private Canvas myCanvas;

    @FXML
    private void selectShape(ActionEvent event) {
        
        switch (  ((Button)event.getSource()).getText()   ){
            case "LINE": selectedShape = "LINE"; break;
            case "RECT": selectedShape = "RECT"; break;
            case "OVAL": selectedShape = "OVAL"; break;
        }
    }

    @FXML
    private void selectColor(ActionEvent event) {
        switch (  ((Button)event.getSource()).getText()   ){
            case "RED": selectedColor = Color.RED; break;
            case "BLUE": selectedColor = Color.BLUE; break;
            case "BLACK": selectedColor = Color.BLACK; break;
        }
    }

    @FXML
    private void onMouseReleased(MouseEvent event) {
        GraphicsContext g = myCanvas.getGraphicsContext2D();
        g.setStroke(selectedColor);
        double endx = event.getX();
        double endy = event.getY();
        switch (  selectedShape   ){
            case "LINE": g.strokeLine(startX, startY, endx, endy); break;
            case "RECT": g.strokeRect(
                    (startX>endx)?endx:startX,
                    (startY>endy)?endy:startY,
                    Math.abs(endx-startX),
                    Math.abs(endy-startY)); break;
            case "OVAL": g.strokeOval(
                    (startX>endx)?endx:startX,
                    (startY>endy)?endy:startY,
                    Math.abs(endx-startX),
                    Math.abs(endy-startY)); break;
        }
        
        
    }

    @FXML
    private void onMouseDragged(MouseEvent event) {
    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        startX=event.getX();
        startY=event.getY();
    }
}
