package com.example.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MowitnowTests {

    public static void main(String[] args) {
        String inputFile = "5 5 1 2 N GAGAGAGAA 3 3 E AADAADADDA ";
        List<String> inputLines = readInput(inputFile);

        if (inputLines.size() < 3 || inputLines.size() % 2 != 1) {
            System.out.println("Invalid input format.");
            return;
        }

        // Parsing upper-right coordinates of the lawn
        String[] upperRightCoordinates = inputLines.get(0).split(" ");
        int lawnWidth = Integer.parseInt(upperRightCoordinates[0]);
        int lawnHeight = Integer.parseInt(upperRightCoordinates[1]);
        Lawn lawn = new Lawn(lawnWidth, lawnHeight);

        // Processing each mower's initial position and instructions
        for (int i = 1; i < inputLines.size(); i += 2) {
            String[] mowerPosition = inputLines.get(i).split(" ");
            int x = Integer.parseInt(mowerPosition[0]);
            int y = Integer.parseInt(mowerPosition[1]);
            char orientation = mowerPosition[2].charAt(0);
            Mower mower = new Mower(x, y, orientation);

            String instructions = inputLines.get(i + 1);
            processInstructions(lawn, mower, instructions);
            System.out.println(mower.getPosition());
        }
    }

    private static List<String> readInput(String inputFile) {
        List<String> inputLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLines;
    }

    private static void processInstructions(Lawn lawn, Mower mower, String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'D':
                    mower.turnRight();
                    break;
                case 'G':
                    mower.turnLeft();
                    break;
                case 'A':
                    mower.moveForward(lawn);
                    break;
                default:
                    // Ignore unrecognized instructions
                    break;
            }
        }
    }
}

class Lawn {
    private int width;
    private int height;

    public Lawn(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Add methods to check boundaries, if needed
}

class Mower {
    private int x;
    private int y;
    private char orientation;

    public Mower(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void turnRight() {
        // Implement logic to turn the mower right
    }

    public void turnLeft() {
        // Implement logic to turn the mower left
    }

    public void moveForward(Lawn lawn) {
        // Implement logic to move the mower forward
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}
