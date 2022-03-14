package pl.karpowicz.game_of_life.model;

public class Cell {

    public Cell() {
    }

    public Cell(boolean state, boolean newState) {
        this.state = state;
        this.newState = newState;
    }

    private boolean state;
    private boolean newState = false;

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getNewState() {
        return newState;
    }

    public void setNewState(boolean newState) {
        this.newState = newState;
    }

    public void changeState(boolean state) {
        this.newState = state;
    }

    public void activeState(boolean newState) {
        this.state = newState;
    }

}
