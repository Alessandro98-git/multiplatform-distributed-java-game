package it.polimi.ingsw.core;

// necessary imports of Java SE
import java.awt.Color;
import java.util.Observable;

public class Worker extends Observable {
    private Cell position;
    private Color color;

    public Worker(Color color){
        this.color = color;
    }

    // getter of position
    public Cell getPos() {
        return position;
    }

    //setter of position
    public void setPos(Cell c){
        position = c;
    }

    public void notifyAthena(){
        //athena update();
    }
}