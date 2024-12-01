# Sudoku Generator

The Sudoku Generator is a Spring Boot and Thymeleaf-based web application that allows you to generate Sudoku grids with different difficulty levels.

## Features

- Generation of Sudoku grids with three difficulty levels: Easy, Medium, and Hard
- Display of the generated grid with the missing numbers
- Ability to generate a new grid at any time

## Configuration

The number of cells removed for each difficulty level can be overridden by adding the following properties in the `application.yml` file:

```yaml
app:
  cells-to-remove:
    easy: 20
    medium: 40
    hard: 60
```

## Installation and Execution

1. Clone the Git repository: `git clone https://github.com/Pitchouneee/sudoku-generator.git`
2. Navigate to the project directory: `cd sudoku-generator`
3. Compile and run the application using Maven: `mvn spring-boot:run`
4. Open a web browser and access `http://localhost:8080`

## Requirements

This project requires Java 21 or later to run.

## License

This project is licensed under the MIT License. You are free to use, modify, and redistribute it, including in a journal or any other publication, as long as you mention the authors.

## Contributions

Contributions are welcome ! Feel free to open issues or submit pull requests on the GitHub repository.

## Future Developments

In upcoming versions, a feature will be added to display the solution of the grid alongside the generated grid.
