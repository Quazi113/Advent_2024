import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input");
        String[][] puzzle = new String[fileData.size()][fileData.getFirst().length()];

        for (int i = 0; i < fileData.size(); i++) {
            fileData.get(i).split("");
            for (int j = 0; j < fileData.get(i).length(); j++) {
                puzzle[i][j] = fileData.get(i).substring(j, j+1);
            }
        }

        int correct = 0;

        for (int r = 0; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[0].length; c++) {
                if (puzzle[r][c].equals("X")) {
                    if (checkForward(r,c,puzzle)) {
                        correct++;
                        System.out.println("1");
                    }
                    if (checkDown(r,c,puzzle)) {
                        correct++;
                        System.out.println("2");
                    }
                    if (checkBack(r,c,puzzle)) {
                        correct++;
                        System.out.println("3");
                    }
                    if (checkUp(r,c,puzzle)) {
                        correct++;
                        System.out.println("4");
                    }
                    if (checkUpRight(r,c,puzzle)) {
                        correct++;
                        System.out.println("5");
                    }
                    if (checkUpLeft(r,c,puzzle)) {
                        correct++;
                        System.out.println("6");
                    }
                    if (checkDownRight(r,c,puzzle)) {
                        correct++;
                        System.out.println("7");
                    }
                    if (checkDownLeft(r,c,puzzle)) {
                        correct++;
                        System.out.println("8");
                    }
                }
            }
        }
        System.out.println(correct);
    }


    public static Boolean checkForward(int r, int c, String[][] data) {
        if (data[c].length > c + 3) {
            if (data[r][c + 1].equals("M") && data[r][c + 2].equals("A") && data[r][c + 3].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkDown(int r, int c, String[][] data) {
        if (data.length > r + 3) {
            if (data[r + 1][c].equals("M") && data[r + 2][c].equals("A") && data[r + 3][c].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkBack(int r, int c, String[][] data) {
        if (c - 3 > 0) {
            if (data[r][c - 1].equals("M") && data[r][c - 2].equals("A") && data[r][c - 3].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkUp(int r, int c, String[][] data) {
        if (r - 3 > 0) {
            if (data[r - 1][c].equals("M") && data[r - 2][c].equals("A") && data[r - 3][c].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkUpRight(int r, int c, String[][] data) {
        if ((r - 3) > 0 && data[c].length > (c + 3)) {
            if (data[r - 1][c + 1].equals("M") && data[r - 2][c + 2].equals("A") && data[r - 3][c + 3].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkDownRight(int r, int c, String[][] data) {
        if (data[c].length > (c + 3) && data.length > (r + 3)) {
            if (data[r + 1][c + 1].equals("M") && data[r + 2][c + 2].equals("A") && data[r + 3][c + 3].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkUpLeft(int r, int c, String[][] data) {
        if ((r - 3) > 0 && (c - 3) > 0) {
            if (data[r - 1][c - 1].equals("M") && data[r - 2][c - 2].equals("A") && data[r - 3][c - 3].equals("S")) {
                return true;
            }
        }
        return false;
    }

    public static Boolean checkDownLeft(int r, int c, String[][] data) {
        if (c - 3 > 0 && data.length > (r + 3)) {
            if (data[r + 1][c - 1].equals("M") && data[r + 2][c - 2].equals("A") && data[r + 3][c - 3].equals("S")) {
                return true;
            }
        }
        return false;
    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
