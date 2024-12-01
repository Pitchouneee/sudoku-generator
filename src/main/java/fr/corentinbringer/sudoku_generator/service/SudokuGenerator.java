package fr.corentinbringer.sudoku_generator.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuGenerator {

    public int[][] generateGrid(String difficulty) {
        int[][] grid = new int[9][9];
        fillGrid(grid);
        removeNumbers(grid, difficulty);
        return grid;
    }

    private void fillGrid(int[][] grid) {

    }

    private void removeNumbers(int[][] grid, String difficulty) {

    }

    private boolean isValid(int[][] grid, int row, int col, int num) {
        return true;
    }
}
