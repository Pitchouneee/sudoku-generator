package fr.corentinbringer.sudoku_generator.service;

import fr.corentinbringer.sudoku_generator.model.Sudoku;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SudokuService {

    private final SudokuGenerator sudokuGenerator;

    public Sudoku generateSudoku(String difficulty) {
        int[][] grid = sudokuGenerator.generateGrid(difficulty);
        return new Sudoku(grid, difficulty);
    }
}
