package maze;
// package main.java;
// class that solves mazes

import java.util.ArrayList;
import java.util.List;

public class MazeSolver {
    private int rows, cols;
    private int[][] grid;
    private boolean[][] visited;
    private List<int[]> shortestPath;

    public MazeSolver(Maze maze) {
        this.grid = maze.getGrid();
        this.rows = maze.getRows();
        this.cols = maze.getCols();
        this.visited = new boolean[rows][cols];
        this.shortestPath = null;
    }

   
    private void dfs(int x, int y, int endX, int endY, List<int[]> currentPath) {
        // bounds check and wall/visited check
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0 || visited[x][y]) {
            return;
        }

        // Add current cell to path and mark visited
        currentPath.add(new int[]{x, y});
        visited[x][y] = true;

        // check if we reached the end
        if (x == endX && y == endY) {
            if (shortestPath == null || currentPath.size() < shortestPath.size()) {
                shortestPath = new ArrayList<>(currentPath); // save shortest path
            }
        } else {
            // explore neighbors: up, down, left, right
            dfs(x + 1, y, endX, endY, currentPath);
            dfs(x - 1, y, endX, endY, currentPath);
            dfs(x, y + 1, endX, endY, currentPath);
            dfs(x, y - 1, endX, endY, currentPath);
        }

        // backtrack
        visited[x][y] = false;
        currentPath.remove(currentPath.size() - 1);
    }

    public Maze solve(int startX, int startY, int endX, int endY) {
        List<int[]> currentPath = new ArrayList<>();
        dfs(startX, startY, endX, endY, currentPath);

        if(shortestPath != null) {
            for(int[] cell : shortestPath) {
                grid[cell[0]][cell[1]] = 2;
            }
        }
        
        return new Maze(grid);
    }
}
