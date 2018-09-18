import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {
    private String inputFile;


    public Parser(String fileName) {
        this.inputFile = fileName;
    }


    public void parseFile() {
        File file = new File(inputFile);
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                line = line.replaceAll("\\s+", " ").trim();

                if (line.isEmpty()) {
                    continue;
                }
                //System.out.println(line);
                String cmd = line.split(" ")[0];
                //System.out.println("Command: " + cmd);
            }

        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void add() {

    }
}
