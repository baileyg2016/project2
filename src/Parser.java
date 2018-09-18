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
                // System.out.println(line);
                String cmd = line.split(" ")[0];

                switch (cmd) {
                    case ("add"):
                        add();
                        break;
                    case ("delete"):
                        // need to check if its a movie or a reviewer
                        break;
                    case ("print"):
                        // need to check wish hashTable to print or the ratings
                        break;
                    case ("list"):
                        // need to check if it is the movie or reviewer
                        break;
                    case ("similar"):
                        // need to check if it is the movie or reviewer
                        break;
                    default:
                        System.out.println("--------You fucked up--------");
                }

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
