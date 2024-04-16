package com.mowitnow.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mowitnow.model.Mower;
import com.mowitnow.service.MowerService;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	 @Autowired
	    private StepBuilderFactory stepBuilderFactory;

	    @Bean
	    public StepBuilderFactory stepBuilderFactory() {
	        return stepBuilderFactory;
	    }

    @Autowired
    private MowerService mowerService;

    @Bean
    public Step myStep(MowerService lawnMowerService) {
        return stepBuilderFactory.get("myStep")
                .tasklet((contribution, chunkContext) -> {
                	  Mower mower =new Mower();
                	  
                    List<String> instructions = readInstructions("input.txt");
                   
                    mower.setInstructions(instructions);
                    // Control lawn mowers
                    mowerService.processMowers(mower);
                

                    return null;
                })
                .build();
    }

    private List<String> readInstructions(String inputFile) {
        List<String> instructions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming each line contains an instruction
                instructions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instructions;
    }
}
