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
                String lineWithoutCmd = line.replaceFirst(cmd, "").trim();
                // System.out.println(lineWithoutCmd);

                // The fields following each command
                String[] fields;

                switch (cmd) {
                    case ("add"):
                        fields = lineWithoutCmd.split("<SEP>");
                        add(fields);
                        break;
                    case ("delete"):

                        fields = split(lineWithoutCmd);
                        delete(fields[0], fields[1]);
                        break;
                    case ("print"):
                        if (lineWithoutCmd.equals("ratings")) {
                            printRatings();
                            break;
                        }
                        fields = split(lineWithoutCmd);

                        print(fields[0], fields[1]);

                        break;
                    case ("list"):
                        // need to check if it is the movie or reviewer
                        fields = split(lineWithoutCmd);
                        list(fields[0], fields[1]);
                        break;
                    case ("similar"):
                        // need to check if it is the movie or reviewer
                        fields = split(lineWithoutCmd);
                        similar(fields[0], fields[1]);
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


    /**
     * This decides where to add the fields
     * 
     * @param fields
     *            The reviewer [0], movie [1], rating [2] all separated
     */
    public void add(String[] fields) {
        // 0->reviewer, 1->Movie, 2->rating

    }


    /**
     * This chooses which table and matrix to delete from
     * 
     * @param tableName
     *            Either the reviewer hashTable or the movie hashTable
     * @param name
     *            The name of the movie or the reviewer
     */
    public void delete(String tableName, String name) {
        if (tableName.equals("reviewer")) {

        }
        else {// then it is the movie

        }
    }


    /**
     * This chooses which table to print
     * 
     * @param tableName
     *            Either the reviewer hashTable or the movie hashTable
     * @param name
     *            The name of the movie or the reviewer
     */
    public void print(String tableName, String name) {
        if (tableName.equals("reviewer")) {

        }
        else {// then it is the movie

        }
    }


    /**
     * Prints the ratings that are in the sparse matrix
     */
    public void printRatings() {
        // print the ratings
    }


    /**
     * This chooses which table to list the movies or reviews from
     * 
     * @param tableName
     *            Either the reviewer hashTable or the movie hashTable
     * @param name
     *            The name of the movie or the reviewer
     */
    public void list(String tableName, String name) {
        if (tableName.equals("reviewer")) {

        }
        else {// then it is the movie

        }
    }


    /**
     * This chooses which table to list closest movie or reviewer similar
     * 
     * @param tableName
     *            Either the reviewer hashTable or the movie hashTable
     * @param name
     *            The name of the movie or the reviewer
     */
    public void similar(String tableName, String name) {
        if (tableName.equals("reviewer")) {

        }
        else {// then it is the movie

        }
    }


    public String[] split(String lineWithoutCmd) {
        String[] fields = new String[2];
        // position of the first space
        int pos = lineWithoutCmd.indexOf(" ");

        // The name of the hashTable
        String tableName = lineWithoutCmd.substring(0, pos);
        // The name of the movie or reviewer
        String name = lineWithoutCmd.substring(pos, lineWithoutCmd.length());

        fields[0] = tableName;

        fields[1] = name;

        return fields;
    }
}
