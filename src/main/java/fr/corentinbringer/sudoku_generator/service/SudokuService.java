package fr.corentinbringer.sudoku_generator.service;

import fr.corentinbringer.sudoku_generator.model.Difficulty;
import fr.corentinbringer.sudoku_generator.model.Sudoku;
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

        int[][] grid = sudokuGenerator.generateGrid(diff);
        return new Sudoku(grid, diff);
    }
}
