package main.java;
// import static spark.Spark.*;
//import com.google.gson.Gson;

//import java.util.List;

// main method: Starts the SparkJava server, exposes /maze and /solve API endpoints

public class MazeScriptRunner {

    public static void main(String[] args) {
        // TEST CODE

        Maze maze = new MazeGenerator().generate(8, 8);
        System.out.println(maze.toString());
        //List<int[]> path = new MazeSolver().solve(maze);
        //System.out.println(path);





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
