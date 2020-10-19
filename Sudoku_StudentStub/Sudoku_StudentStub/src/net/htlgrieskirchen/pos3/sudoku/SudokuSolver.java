package net.htlgrieskirchen.pos3.sudoku;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/* Please enter here an answer to task four between the tags:
 * <answerTask4>
 *    Hier sollte die Antwort auf die Aufgabe 4 stehen.
 * </answerTask4>
 */
public class SudokuSolver implements ISodukoSolver {
    private static final String TEST_FILENAME = "1_sudoku_level1.csv";

    public static void main(String[] args) {
        File file = new File(TEST_FILENAME);
        SudokuSolver ss=new SudokuSolver();
        ss.readSudoku(file);
    }

    public SudokuSolver() {
        //initialize if necessary
    }

    @Override
    public final int[][] readSudoku(File file) {
        int[][] sud= new int[9][9];
        List<String> stringList = new ArrayList();
        try {

            stringList = Files.lines(file.toPath())
                    .collect(Collectors.toList());

            for(int i=0; i<9; i++){
                sud[i] = Arrays.stream(stringList.get(i).split(";"))
                        .mapToInt(x-> Integer.parseInt(x))
                        .toArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sud;
    }

    @Override
    public boolean checkSudoku(int[][] rawSudoku) {
        HashSet set = new HashSet();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set.add(rawSudoku[i][j]);
            }
            if(set.contains(0)) return false;
            if(set.size()< 9)  return false;
            set.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set.add(rawSudoku[j][i]);
            }
            if(set.contains(0)) return false;
            if(set.size()< 9) return false;
            set.clear();
        }
        return true;

    }

    @Override
    public int[][] solveSudoku(int[][] rawSudoku) {
        // implement this method
        return new int[0][0]; // delete this line!
    }
    
    @Override
    public int[][] solveSudokuParallel(int[][] rawSudoku) {
        // implement this method
        return new int[0][0]; // delete this line!
    }

    // add helper methods here if necessary
}
