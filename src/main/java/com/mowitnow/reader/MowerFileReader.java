package com.mowitnow.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mowitnow.model.Mower;
import com.mowitnow.model.MowerInstruction;
import com.mowitnow.model.MowerPosition;

public class MowerFileReader {
    public List<Mower> readMowers(String fileName) {
        List<Mower> mowers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length == 3) {
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    char orientation = parts[2].charAt(0);
                    MowerPosition position = new MowerPosition(x, y, orientation);

                    line = reader.readLine();
                    if (line != null) {
                        String instructions = line.trim();
                        MowerInstruction instruction = new MowerInstruction(instructions);
                        Mower mower = new Mower(position, (List<String>) instruction);
                        mowers.add(mower);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mowers;
    }
}