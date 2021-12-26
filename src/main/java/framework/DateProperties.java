package framework;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class DateProperties {
    public static void changeFile(String fileName, String id) throws Exception {
        FileWriter fr = new FileWriter(System.getProperty("user.dir") + "/src/test/resources/files/" + fileName + ".txt");
        fr.write(id);
        fr.close();
    }

    public static String getFile(String fileName) throws Exception {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/files/" + fileName + ".txt");
        Scanner scan = new Scanner(fr);
        String string = scan.nextLine();
        fr.close();
        return string;
    }
}