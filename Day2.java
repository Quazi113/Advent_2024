import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input");

        int correct = 0;

        for (int i = 0; i < fileData.size(); i++) {
            String[] level = fileData.get(i).split(" ");
            ArrayList<String> levelArray = new ArrayList<>();
            for (int j = 0; j < level.length; j++) {
                levelArray.add(level[j]);
            }

            if (checkZero(levelArray) && checkSign(levelArray) && checkDifference(levelArray)) {
                correct++;
            }
        }
        System.out.println(correct);
    }

    public static Boolean checkZero(ArrayList<String> data) {
        for (int i = 1; i < data.size(); i++) {
            int difference = Integer.parseInt(data.get(i - 1)) - Integer.parseInt(data.get(i));
            if (difference == 0) {
                data.remove(i);
                break;
            }
        }

        for (int i = 1; i < data.size(); i++) {
            int difference = Integer.parseInt(data.get(i - 1)) - Integer.parseInt(data.get(i));
            if (difference == 0) {
                return false;
            }
        }
        return true;
    }


    // Part 1 Iteration
    public static Boolean checkDifference(ArrayList<String> data) {
        for(int i = 1; i < data.size(); i++) {
            int difference = Integer.parseInt(data.get(0)) - Integer.parseInt(data.get(1));
            int differencetwo = Integer.parseInt(data.get(i - 1)) - Integer.parseInt(data.get(i));
            if (difference > 0) {
                if (differencetwo > 3) {
                    data.remove(i);
                    break;
                }
            } else {
                if (differencetwo < -3) {
                    data.remove(i);
                    break;
                }
            }
        }

        for(int i = 1; i < data.size(); i++) {
            int difference = Integer.parseInt(data.get(0)) - Integer.parseInt(data.get(1));
            int differencetwo = Integer.parseInt(data.get(i - 1)) - Integer.parseInt(data.get(i));
            if (difference > 0) {
                if (differencetwo > 3) {
                    return false;
                }
            } else {
                if (differencetwo < -3) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean checkSign(ArrayList<String> data) {
        boolean sign = false;

        for(int i = 1; i < data.size(); i++) {
            int difference = Integer.parseInt(data.get(0)) - Integer.parseInt(data.get(1));
            if (difference > 0) {
                if (!(Integer.parseInt(data.get(i)) < Integer.parseInt(data.get(i-1)))) {
                    data.remove(i);
                    break;
                }
            } else {
                if (!(Integer.parseInt(data.get(i)) > Integer.parseInt(data.get(i-1)))) {
                    data.remove(i);
                    break;
                }
            }
        }

        for(int i = 1; i < data.size(); i++) {
            int difference = Integer.parseInt(data.get(0)) - Integer.parseInt(data.get(1));
            if (difference > 0) {
                if (!(Integer.parseInt(data.get(i)) < Integer.parseInt(data.get(i-1)))) {
                    return false;
                }
            } else {
                if (!(Integer.parseInt(data.get(i)) > Integer.parseInt(data.get(i-1)))) {
                    return false;
                }
            }
        }
        return true;
    }








//    public static Boolean checkZero(String[] data) {
//        for (int i = 1; i < data.length; i++) {
//            int difference = Integer.parseInt(data[i - 1]) - Integer.parseInt(data[i]);
//            if (difference == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static Boolean checkDifference(String[] data) {
//        for(int i = 1; i < data.length; i++) {
//            int difference = Integer.parseInt(data[0]) - Integer.parseInt(data[1]);
//            int differencetwo = Integer.parseInt(data[i - 1]) - Integer.parseInt(data[i]);
//            if (difference > 0) {
//                if (differencetwo > 3) {
//                    return false;
//                }
//            } else {
//                if (differencetwo < -3) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public static Boolean checkSign(String[] data) {
//        boolean sign = false;
//
//        for(int i = 1; i < data.length; i++) {
//            int difference = Integer.parseInt(data[0]) - Integer.parseInt(data[1]);
//            if (difference > 0) {
//                if (Integer.parseInt(data[i]) < Integer.parseInt(data[i - 1])) {
//                    sign = true;
//                } else {
//                    return false;
//                }
//            } else {
//                if (Integer.parseInt(data[i]) > Integer.parseInt(data[i - 1])) {
//                    sign = true;
//                } else {
//                    return false;
//                }
//            }
//        }
//        return sign;
//    }

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
