package fr.corentinbringer.sudokugenerator.controller;

import fr.corentinbringer.sudokugenerator.model.Sudoku;
import fr.corentinbringer.sudokugenerator.service.SudokuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SudokuController {

    private final SudokuService sudokuService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sudoku")
    public String generateSudoku(@RequestParam(defaultValue = "medium") String difficulty,
                                 Model model) {
        Sudoku sudoku = sudokuService.generateSudoku(difficulty);
        model.addAttribute("sudoku", sudoku);

        return "sudoku";
    }
}
