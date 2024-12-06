package fr.corentinbringer.sudokugenerator.service;

import fr.corentinbringer.sudokugenerator.model.Difficulty;
import fr.corentinbringer.sudokugenerator.model.Sudoku;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SudokuService {

    private final SudokuGenerator sudokuGenerator;

    public Sudoku generateSudoku(String difficulty) {
        Difficulty diff = Difficulty.MEDIUM;
        try {
            diff = Difficulty.valueOf(difficulty.toUpperCase());
        } catch (IllegalArgumentException e) {
            log.error("Illegal difficulty");
        }

        return sudokuGenerator.generateGridWithSolution(diff);
    }
}
