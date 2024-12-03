import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        // you now have an ArrayList of Strings for each number in the file
        // do Advent 2020 day 1!


        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            String[] list = fileData.get(i).split("   ");;
            left.add(Integer.parseInt(list[0]));
            right.add(Integer.parseInt(list[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        int total = 0;
        for (int i = 0; i < left.size(); i++) {
            total += Math.abs(left.get(i) - right.get(i));
        }
        System.out.println(total);
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