package maze;
// package main.java;

//import java.util.List;
//import java.util.ArrayList;
//import java.util.Queue;
//import java.util.LinkedList;
//import java.util.Random;

// data model for maze grid, start, end
public class Maze {
    private int rows;
    private int cols;
    private int[][] grid; // 1s generated for path, 0s are walls
    private int[] start; // array with {row,col} coordinates
    private int[] end; // array with {row,col} coordinates

    public Maze(int rows,int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new int[rows][cols];
        start = new int[]{0,0};
        end = new int[]{rows - 1, cols - 1};
    }

    public Maze(int[][] layout) {
        this.grid = layout;
        this.rows = layout.length;
        this.cols = layout[0].length;
        // start and end will be null
    }

    public String toString() {
        String mazeString = "";
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                mazeString += this.getGrid()[i][j] + " ";
            }
            mazeString += "\n";
        }
        return mazeString;
    }

    public int[][] getGrid() { return grid; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int[] getStart() { return start; }
    public int[] getEnd() { return end; }
}
