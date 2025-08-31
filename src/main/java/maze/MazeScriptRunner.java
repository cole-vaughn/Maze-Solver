package maze;
// package main.java;
// import static spark.Spark.*;
//import com.google.gson.Gson;

//import java.util.List;

// main method: Starts the SparkJava server, exposes /maze and /solve API endpoints

public class MazeScriptRunner {

    public static void main(String[] args) {
        // TEST CODE
        long startGeneration = System.currentTimeMillis();
        Maze maze = new MazeGenerator().generate(30, 30);
        long endGeneration = System.currentTimeMillis();
        System.out.println(maze.toString());
        System.out.println("Generation time: " + (endGeneration - startGeneration) + " ms");

        long startSolve = System.currentTimeMillis();
        MazeSolver solvedMaze = new MazeSolver(maze);
        Maze solution = solvedMaze.solve(maze.getStart()[0], maze.getStart()[1], maze.getEnd()[0], maze.getEnd()[1]);
        long endSolve = System.currentTimeMillis();
        System.out.println(solution.toString());
        System.out.println("Solve time: " + (endSolve - startSolve) + " ms");





        //port(4567); // Set server port

        // Gson gson = new Gson();
        // MazeGenerator generator = new MazeGenerator();
        // MazeSolver solver = new MazeSolver();

        // // Endpoint to generate a maze
        // get("/maze", (req, res) -> {
        //     int rows = Integer.parseInt(req.queryParams("rows"));
        //     int cols = Integer.parseInt(req.queryParams("cols"));

        //     Maze maze = generator.generate(rows, cols);
        //     res.type("application/json");
        //     return maze;
        // }, gson::toJson);

        // // Endpoint to solve a maze
        // post("/solve", (req, res) -> {
        //     Maze maze = gson.fromJson(req.body(), Maze.class);
        //     List<int[]> solutionPath = solver.solve(maze);

        //     res.type("application/json");
        //     return solutionPath;
        // }, gson::toJson);
    }
}
