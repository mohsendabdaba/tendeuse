package com.mowitnow.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.mowitnow.model.Mower;
import com.mowitnow.model.MowerPosition;

public class MowerFileWriter {
    public void writeMowerPositions(String fileName, List<Mower> mowers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Mower mower : mowers) {
                MowerPosition position = mower.getPosition();
                writer.write(position.getX() + " " + position.getY() + " " + position.getOrientation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
