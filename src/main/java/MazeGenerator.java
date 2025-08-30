package main.java;
// class that generates mazes

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Stack;

public class MazeGenerator {
    public Maze generate(int rows, int cols) {
        Maze mazeObject = new Maze(rows, cols);
        Stack<int[]> stack = new Stack<>(); // int[] will be coordinates. {1,5} is row 1 col 5
        int[][] grid = mazeObject.getGrid();

        // generate maze grid to make all cells walls
        for (int i=0; i < mazeObject.getRows(); i++) {
            for (int j=0; j < mazeObject.getCols(); j++) {
                grid[i][j] = 0;
            }
        }
        // manually make the top-left starting cell and the bottom-right end cell paths
        grid[mazeObject.getStart()[0]][mazeObject.getStart()[1]] = 1;
        grid[mazeObject.getEnd()[0]][mazeObject.getEnd()[1]] = 1;

        // depth-first search algorithm to generate a viable start-to-end path
        int[] start = new int[]{mazeObject.getStart()[0],mazeObject.getStart()[1]};
        stack.push(start);
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            if ((current[0] == mazeObject.getEnd()[0]) && (current[1] == mazeObject.getEnd()[1])) {
                break;
            }
            int r = current[0];
            int c = current[1];
            
            int[][] neighbors = {
                {r-2, c},
                {r+2, c},
                {r, c-2},
                {r, c+2}
            };

            // converts neighbor array into a list
            List<int[]> neighborList = Arrays.asList(neighbors);

            // shuffles the order so we are checking neighboring cells in random order
            Collections.shuffle(neighborList);

            for (int[] n : neighborList) {
                int nr = n[0];
                int nc = n[1];
                int rowChange = nr - r;
                int colChange = nc - c;
                if (isInBounds(nr, nc, mazeObject.getRows(), mazeObject.getCols()) && grid[nr][nc] == 0) {
                    // changes neighbor that's 2 tiles from current to a path
                    grid[nr][nc] = 1;
                    // logic to change the wall that's between the current current tile and its 2-tile neighbor into a path
                    if (rowChange == 0) {
                        grid[nr][c + (colChange/2)] = 1;
                    }
                    if (colChange == 0) {
                        grid[r + (rowChange/2)][nc] = 1;
                    }
                    stack.push(n);
                } else if ((rowChange == 0) && isInBounds(nr, (c + colChange/2), mazeObject.getRows(), mazeObject.getCols()) 
                    && grid[nr][c + colChange/2] == 0 
                    && !isInBounds(nr, nc, mazeObject.getRows(), mazeObject.getCols()))
                    {
                    // occurs when 1 tile neighbor is in-bounds, but 2 tile neighbor isn't (On same row)
                    grid[nr][c + (colChange/2)] = 1;
                } else if ((colChange == 0) && isInBounds((r + rowChange/2), nc, mazeObject.getRows(), mazeObject.getCols())
                    && grid[r + rowChange/2][nc] == 0
                    && !isInBounds(nr, nc, mazeObject.getRows(), mazeObject.getCols()))
                    {
                    // occurs when 1 tile neighbor is in-bounds, but 2 tile neighbor isn't (In same column)
                    grid[r + (rowChange/2)][nc] = 1;
                }
            }

        }
        // return Maze object
        return mazeObject;
    }

    // checks to make sure a coordinate pair is within the maze length and width
    public boolean isInBounds(int testRow, int testCol, int mazeRows, int mazeCols) {
        if ((testRow < 0 ) || (testRow >= mazeRows)) {
            return false;
        }
        if ((testCol < 0 ) || (testCol >= mazeCols)) {
            return false;
        }
        return true;
    }
}
