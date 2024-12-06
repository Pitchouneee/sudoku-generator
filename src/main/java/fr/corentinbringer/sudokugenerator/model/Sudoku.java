package fr.corentinbringer.sudokugenerator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sudoku {

    private int[][] grid;
    private final int[][] solution;
    private Difficulty difficulty;

    public int getCellFromGrid(int rowIndex, int colIndex) {
        return this.grid[rowIndex][colIndex];
    }
}
