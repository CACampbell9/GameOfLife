package com.company;

import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the game of life! What is your name?");
        String name = input.nextLine();
        System.out.println("Welcome " + name);

        System.out.println("Do you want to see the rules for the Game of Life?");
        String answer = input.nextLine();

if (answer.equals("yes")) {
        System.out.println("The rules: Any live cell with fewer than two live neighbors dies as if caused by underpopulation.\n" +
                "Any live cell with two or three live neighbors lives on to the next generation.\n" +
                "Any live cell with more than three live neighbors dies, as if by overpopulation.\n" +
                "Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction."); }


        int A = 10, B = 10;

        // Initializing the grid.
        int[][] gameGrid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (gameGrid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(gameGrid, A, B);
    }

    // Function to print next generation
    static void nextGeneration(int[][] grid, int A, int B) {
        int[][] future = new int[A][B];

        // Loop through every cell
        for (int l = 0; l < A; l++) {
            for (int m = 0; m < B; m++) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l + i >= 0 && l + i < A) && (m + j >= 0 && m + j < B))
                            aliveNeighbours += grid[l + i][m + j];

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
