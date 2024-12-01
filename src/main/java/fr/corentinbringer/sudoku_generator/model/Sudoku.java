package fr.corentinbringer.sudoku_generator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sudoku {

    private int[][] grid;
    private Difficulty difficulty;
}
