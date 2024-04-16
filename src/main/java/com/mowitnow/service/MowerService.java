package com.mowitnow.service;

import java.util.List;

import com.mowitnow.model.Mower;
import com.mowitnow.model.MowerInstruction;
import com.mowitnow.model.MowerPosition;

public class MowerService {
	public void processMowers(Mower mower) {
	    List<String> instructions = mower.getInstructions();
	    MowerPosition currentPosition = mower.getPosition();

	    for (String instruction : instructions) {
	    	String inst = instruction;
	        switch (inst) {
	            case "D":
	                turnRight(currentPosition);
	                break;
	            case "G":
	                turnLeft(currentPosition);
	                break;
	            case "":
	                moveForward(currentPosition);
	                break;
	            default:
	                // Ignore unrecognized instructions
	                break;
	        }
	    }
	}

    private void turnRight(MowerPosition position) {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('E');
                break;
            case 'E':
                position.setOrientation('S');
                break;
            case 'S':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('N');
                break;
            default:
                // Gérer l'erreur si l'orientation n'est pas valide
                break;
        }
    }

    private void turnLeft(MowerPosition position) {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('S');
                break;
            case 'S':
                position.setOrientation('E');
                break;
            case 'E':
                position.setOrientation('N');
                break;
            default:
                // Gérer l'erreur si l'orientation n'est pas valide
                break;
        }
    }

    private void moveForward(MowerPosition position) {
        switch (position.getOrientation()) {
            case 'N':
                position.setY(position.getY() + 1);
                break;
            case 'E':
                position.setX(position.getX() + 1);
                break;
            case 'S':
                position.setY(position.getY() - 1);
                break;
            case 'W':
                position.setX(position.getX() - 1);
                break;
            default:
                // Gérer l'erreur si l'orientation n'est pas valide
                break;
        }
    }


}
