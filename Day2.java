import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input");

        int incorrect = 0;
        int total = fileData.size();


        for (int i = 0; i < fileData.size(); i++) {
            String[] level = fileData.get(i).split(" ");
            boolean sign = false;
            boolean prevsign = false;

            for (int j = 1; j < level.length; j++) {
                int difference = Integer.parseInt(level[j -1]) - Integer.parseInt(level[j]);
                if (j > 1) {
                    prevsign = sign;
                }
                if (difference < 0) {
                    sign = false;
                } else if (difference > 0){
                    sign = true;
                } else {
                    incorrect++;
                    break;
                }

                if (sign == false) {
                    if (difference < -3 || prevsign != sign) {
                        incorrect++;
                        break;
                    }
                } else {
                    if (difference > 3 || prevsign != sign) {
                        incorrect++;
                        break;
                    }
                }
            }
        }
        System.out.println(total - incorrect);

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
