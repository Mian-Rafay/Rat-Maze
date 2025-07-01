import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {

    @Test
    void test1() { // Example
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
        Stack<Character> expected = new Stack<>();
        expected.push('r');expected.push('d');expected.push('l');expected.push('d');expected.push('r');expected.push('r');
        assertEquals(expected, Maze.rat_algo(maze, start_x, start_y, rows, clms, stack));
    }

    @Test
    void test2() { // No solution
        // Initialization of the maze
        char[][] maze = {
                {'r', 'd', 'r', 'w', 'r'},
                {'w', 'w', 'd', 'w', 'd'},
                {'r', 'd', 'r', 'd', 'r'},
                {'w', 'w', 'w', 'w', 'w'},
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
        assertEquals(null, Maze.rat_algo(maze, start_x, start_y, rows, clms, stack));
    }

    @Test
    void test3() { // own example
        // Initialization of the maze
        char[][] maze = {
                {'r', 'd', 'r', 'd', 'r'},
                {'w', 'w', 'd', 'w', 'd'},
                {'r', 'w', 'r', 'w', 'r'},
                {'d', 'w', 'w', 'w', 'd'},
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
        Stack<Character> expected = new Stack<>();
        expected.push('r');expected.push('r');expected.push('d');expected.push('d');
        assertEquals(expected, Maze.rat_algo(maze, start_x, start_y, rows, clms, stack));
    }

    @Test
    void test4() { // own example
        // Initialization of the maze
        char[][] maze = {
                {'r', 'w', 'r', 'd', 'r'},
                {'d', 'w', 'd', 'w', 'd'},
                {'r', 'w', 'r', 'd', 'r'},
                {'d', 'w', 'd', 'w', 'd'},
                {'r', 'd', 'r', 'w', 'f'}
        };

        //starting position of the rat
        int start_x = 0;
        int start_y = 0;

        //rows and columns of maze
        int rows = maze.length-1;
        int clms = maze[0].length-1;

        //Initialization of stack to keep track of path
        Stack<Character> stack = new Stack<>();
        Stack<Character> expected = new Stack<>();
        expected.push('d');expected.push('d');expected.push('r');expected.push('u');expected.push('u');expected.push('r');expected.push('d');expected.push('d');
        assertEquals(expected, Maze.rat_algo(maze, start_x, start_y, rows, clms, stack));
    }
}