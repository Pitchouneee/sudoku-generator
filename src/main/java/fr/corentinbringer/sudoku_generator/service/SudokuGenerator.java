package fr.corentinbringer.sudoku_generator.service;

import fr.corentinbringer.sudoku_generator.model.Difficulty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SudokuGenerator {

    @Value("${app.cells-to-remove.easy}")
    private int CELLS_TO_REMOVE_EASY;

    @Value("${app.cells-to-remove.medium}")
    private int CELLS_TO_REMOVE_MEDIUM;

    @Value("${app.cells-to-remove.hard}")
    private int CELLS_TO_REMOVE_HARD;

    public int[][] generateGrid(Difficulty difficulty) {
        int[][] grid = new int[9][9];
        fillGrid(grid);
        removeNumbers(grid, difficulty);
        return grid;
    }

    private boolean fillGrid(int[][] grid) {
        Random random = new Random();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(numbers, random);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    for (int num : numbers) {
                        if (isValid(grid, row, col, num)) {
                            grid[row][col] = num;

                            if (fillGrid(grid)) {
                                return true;
                            }

                            grid[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void shuffleArray(int[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private void removeNumbers(int[][] grid, Difficulty difficulty) {
        Random random = new Random();
        int cellsToRemove = switch (difficulty) {
            case EASY -> CELLS_TO_REMOVE_EASY;
            case HARD -> CELLS_TO_REMOVE_HARD;
            default -> CELLS_TO_REMOVE_MEDIUM;
        };

        while (cellsToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (grid[row][col] != 0) {
                grid[row][col] = 0;
                cellsToRemove--;
            }
        }
    }

    private boolean isValid(int[][] grid, int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (grid[row][x] == num || grid[x][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
