package fr.corentinbringer.sudoku_generator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sudoku {

    private int[][] grid;
    private String difficulty;
}
