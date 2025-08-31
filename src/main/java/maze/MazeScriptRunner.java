package maze;
// package main.java;
// import static spark.Spark.*;
//import com.google.gson.Gson;

//import java.util.List;

// main method: Starts the SparkJava server, exposes /maze and /solve API endpoints

public class MazeScriptRunner {

    public static void main(String[] args) {

        long startGeneration = System.nanoTime();
        Maze maze = new MazeGenerator().generate(30, 30);
        long endGeneration = System.nanoTime();

        System.out.println(maze.toString());
        double generateTime = (endGeneration - startGeneration) / 1_000_000.0;
        System.out.printf("Generation time: %.2f ms%n", generateTime);

        MazeSolver solvedMaze = new MazeSolver(maze);

        long startSolve = System.nanoTime();
        Maze solution = solvedMaze.solve(maze.getStart()[0], maze.getStart()[1], maze.getEnd()[0], maze.getEnd()[1]);
        long endSolve = System.nanoTime();

        System.out.println("\n" + solution.toString());
        double solveTime = (endSolve - startSolve) / 1_000_000.0;
        System.out.printf("Solve time: %.2f ms%n", solveTime);





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
