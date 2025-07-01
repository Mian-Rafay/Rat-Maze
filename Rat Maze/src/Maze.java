import java.util.*;

public class Maze {

    static Stack rat_algo(char[][] maze, int x, int y, int rows, int clms, Stack<Character> stack)
    {
        //print out current position of rat
        System.out.println(x + " " + y);

        //check to see if rat has found cheese
        if (maze[x][y] == 'f'){
            return stack;
        }

        // check for a door north of the room
        if(x > 1) {
            if(maze[x-1][y] == 'd'){
                maze[x-1][y] = 'o';
                x = x-2;
                stack.push('u');
                return rat_algo(maze, x, y, rows, clms, stack);
            }
        }
        // check for a door east of the room
        if(y < clms){
            if(maze[x][y+1] == 'd'){
                maze[x][y+1] = 'o';
                y = y+2;
                stack.push('r');
                return rat_algo(maze, x, y, rows, clms, stack);
            }
        }
        // check for a door south of the room
        if(x < rows) {
            if(maze[x+1][y] == 'd'){
                maze[x+1][y] = 'o';
                x = x+2;
                stack.push('d');
                return rat_algo(maze, x, y, rows, clms, stack);
            }
        }
        // check for a door west of the room
        if(y > 0){
            if(maze[x][y-1] == 'd'){
                maze[x][y-1] = 'o';
                y = y-2;
                stack.push('l');
                return rat_algo(maze, x, y, rows, clms, stack);
            }
        }

        //case of no possible solution
        if(stack.isEmpty()){
            System.out.println("No Possible Path");
            return null;
        }

        //backtrack since no un-opened doors found
        char prev = stack.pop();
        if (prev == 'l'){
            y = y + 2;
        } else if (prev == 'r') {
            y = y - 2;
        } else if (prev == 'u') {
            x = x + 2;
        } else if (prev == 'd') {
            x = x - 2;
        }

        return rat_algo(maze, x, y, rows, clms, stack);
    }


    public static void main(String[] args)
    {
        // Initialization of the maze
        char[][] maze = {
                {'r', 'd', 'r', 'w', 'r'},
                {'w', 'w', 'd', 'w', 'd'},
                {'r', 'd', 'r', 'd', 'r'},
                {'d', 'w', 'w', 'w', 'w'},
                {'r', 'd', 'r', 'd', 'f'}
        };

        //starting position of the rat
        int start_x = 0;
        int start_y = 0;

        //rows and columns of maze
        int rows = maze.length-1;
        int clms = maze[0].length-1;

        //Initialization of stack to keep track of path
        Stack<Character> stack = new Stack<>();

        System.out.println(Maze.rat_algo(maze, start_x, start_y, rows, clms, stack));

    }
}