package com.mowitnow.model;

import java.util.List;

public class Mower {
    private MowerPosition position;
    private List<String> instructions;

    public Mower() {
    }

    public Mower(MowerPosition position, List<String> instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public MowerPosition getPosition() {
        return position;
    }

    public void setPosition(MowerPosition position) {
        this.position = position;
    }

    public List<String> getInstructions() {
        return instructions;
    }


    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }
    
}
    
    
