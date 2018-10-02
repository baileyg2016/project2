import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The class that parses the command file and stores the information in the
 * appropriate data structure
 * 
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 *
 */
public class Parser {
    /**
     * The input file for the commands
     */
    private String inputFile;
    /**
     * The hashTable for the movies
     * 
     * @param String
     *            the names held in the hash table
     */
    private Hash<String> movieTable;
    /**
     * The hashTable for the reviewers
     * 
     * @param String
     *            the names held in the hash table
     */
    private Hash<String> reviewerTable;

    /**
     * 
     */
    private ReviewerList reviewerList;

    /**
     * The matrix object for storing the ratings
     */
    private SparseMatrix matrix;


    /**
     * Constructor for the class
     * 
     * @param fileName
     *            Sets the file name to import commands from
     * @param movieTable
     *            Sets global hash table object for the movies
     * @param reviewerTable
     *            Sets global hash table object for the reviewers
     */
    public Parser(
        String fileName,
        Hash<String> movieTable,
        Hash<String> reviewerTable) {
        this.inputFile = fileName;
        this.movieTable = movieTable;
        this.reviewerTable = reviewerTable;
    }


    /**
     * parses the file and decides which method to call to store the information
     * in the hash tables and/or sparse matrix
     */
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
                        fields[0] = fields[0].trim();
                        fields[1] = fields[1].trim();
                        fields[2] = fields[2].trim();
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
                        break;
                }

            }

        }
        catch (FileNotFoundException e) {
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

        if (Integer.parseInt(fields[2]) < 1 || Integer.parseInt(
            fields[2]) > 10) {
            System.out.println("Bad score |" + fields[2]
                + "|. Scores must be between 1 and 10.");
            return;
        }

        reviewerTable.insert(fields[0], "Reviwer");
        movieTable.insert(fields[1], "Movie");

        System.out.println("Rating added: |" + fields[0] + "|, |" + fields[1]
            + "|, " + fields[2]);

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
            tableName = tableName.substring(0, 1).toUpperCase() + tableName
                .substring(1);
            reviewerTable.delete(name, tableName);
        }
        else { // then it is the movie
            tableName = tableName.substring(0, 1).toUpperCase() + tableName
                .substring(1);
            movieTable.delete(name, tableName);
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
        if (name.equals("reviewer")) {
            System.out.println("Reviewers:");
            reviewerTable.printTable();
        }
        else { // then it is the movie
            System.out.println("Movies:");
            movieTable.printTable();
        }
    }


    /**
     * Prints the ratings that are in the sparse matrix
     */
    public void printRatings() {
        // print the ratings
        // get the sparse matrix class
        // get the movie singly linked list
        // to string on each entry of the lists
        // Print out the reviewers and their count first
        // ReviewerList rL = SparseMatrix.ReviewerList();
        // System.out.println(rL.printListAndCount());
        // MSLList mL = SparseMatrix.MSLList();
        // System.out.println(mL.printListAndReviews())
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
            // make sure the name exists in the table
            // if the return is null or a tombstone then it does not exist
            int val = reviewerTable.search(name);
            if (reviewerTable.getHashTable()[val] == null || reviewerTable
                .getHashTable()[val].getTombstone()) {
                System.out.println("Cannot list, reviewer |" + name
                    + "| not found in the database.");
            }
            else {
                // We will use the sparse matrix object for this
                // RDLList rL = (sparseMatrix.ReviewerList().getList(name);
                // Node<T> n = rL.getHead().getNextMovie();
                // Node<T> tail = rL.getTail();
                // String s = "Ratings for reviewer |" + name + "|:";
                // while (!(n.equals(tail)) {
                // s += " " + n.getValue()
                // if (!(n.getNextMovie().equals(tail))) {
                // s += ",";
                // }
                // n == n.getNextMovie();
                // }
                // System.out.println(s);
            }

        }

// }
// else {// then it is the movie
// make sure the name exists in the table
// if the return is null or a tombstone then it does not exist
        int val = movieTable.search(name);
        if (movieTable.getHashTable()[val] == null || movieTable
            .getHashTable()[val].getTombstone()) {
            System.out.println("Cannot list, movie |" + name
                + "| not found in the database.");
        }
        else {
            // We will use the sparse matrix object for this
            // MDLList mL = (sparseMatrix.MSLList().getList(name);
            // Node<T> n = mL.getHead().getNextReview();
            // Node<T> tail = mL.getTail();
            // String s = "Ratings for movie |" + name + "|:";
            // while (!(n.equals(tail)) {
            // s += " " + n.getValue()
            // if (!(n.getNextReview().equals(tail))) {
            // s += ",";
            // }
            // n == n.getNextReview();
            // }
            // System.out.println(s);
        }
// }
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
// if (tableName.equals("reviewer")) {
//
// }
// else {// then it is the movie
//
// }
    }


    /**
     * Splits the string without the command into a String Array
     * 
     * @param lineWithoutCmd
     *            The line in the input file without the preceeding command
     * @return
     *         The new line split into fields
     */
    public String[] split(String lineWithoutCmd) {
        String[] fields = new String[2];
        // position of the first space
        int pos = lineWithoutCmd.indexOf(" ");

        // The name of the hashTable
        String tableName = lineWithoutCmd.substring(0, pos);
        // The name of the movie or reviewer
        String name = lineWithoutCmd.substring(pos, lineWithoutCmd.length());

        fields[0] = tableName.trim();

        fields[1] = name.trim();

        return fields;
    }
}
