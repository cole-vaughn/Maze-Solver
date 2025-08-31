rm -rf bin
javac -d bin src/main/java/maze/*.java
java -cp bin maze.MazeScriptRunner
