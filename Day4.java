import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input");
        for (int i = 0; i < fileData.size(); i++) {
            fileData.get(i).split("");
        }
        System.out.println(fileData);
        String[][] puzzle = new String[fileData.size()][fileData.getFirst().length()];
        int correct = 0;

        for (int r = 0; r < puzzle.length; r++ ) {
            String[] row = fileData.get(r);
            for (int c = 0; c < puzzle[0].length; c++) {

            }
        }

        for (int r = 0; r < fileData.size(); r++) {
            for (int c = 0; c < fileData)
        }
        System.out.println(correct);
    }

    public static Boolean checkForward(int r, int c) {
        if ()
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