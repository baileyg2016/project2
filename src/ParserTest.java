import student.TestCase;

/**
 * 
 */

/**
 * @author Bailey Spell and Adam Tapp
 * @version Milestone 1
 *
 */
public class ParserTest extends TestCase {

    /**
     * Testing the parser
     */
    public void testParser() {
        Hash<String> movies = new Hash<String>(6);
        Hash<String> reviewers = new Hash<String>(6);
        ReviewerList reviewersList = new ReviewerList();
        MSLList moviesList = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewersList, moviesList);
        Parser parser = new Parser("P2SampleInput.txt", movies, reviewers,
            reviewersList, moviesList, matrix);
        parser.parseFile();
        assertEquals(4, movies.getNumEntries());
        assertEquals(4, reviewers.getNumEntries());
    }


    /**
     * Testing Similar
     */
    public void testSimilar() {
        Hash<String> movies = new Hash<String>(6);
        Hash<String> reviewers = new Hash<String>(6);
        ReviewerList reviewersList = new ReviewerList();
        MSLList moviesList = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewersList, moviesList);
        Parser parser = new Parser("P2SampleInput.txt", movies, reviewers,
            reviewersList, moviesList, matrix);

        String[] r0 = { "Hayao Miyazaki", "Spirited Away", "10" };
        String[] r1 = { "Hayao Miyazaki", "Joker", "3" };
        String[] r2 = { "Hayao Miyazaki", "Batman", "6" };
        String[] r3 = { "Bob", "Spirited Away", "7" };
        String[] r4 = { "Bob", "Joker", "8" };
        String[] r5 = { "Bob", "Batman", "9" };
        String[] r6 = { "Adam", "Spirited Away", "9" };
        String[] r7 = { "Adam", "Batman", "6" };
        String[] r8 = { "Adam", "Superman", "8" };
        String[] r9 = { "Joe", "Bam!", "9" };
        String[] r10 = { "Joe", "Bing", "6" };
        String[] r11 = { "Joe", "Ram", "8" };
        String[] r12 = { "Billy", "Slo", "8" };
        // Testing similar on a reviewer
        System.out.println("\n\n");
        parser.add(r0);
        parser.add(r1);
        parser.add(r2);
        assertEquals(3, movies.getNumEntries());
        parser.list("reviewer", "Hayao Miyazaki");
        parser.similar("reviewer", "Hayao Miyazaki");

        parser.add(r3);
        parser.list("reviewer", "Bob");

        parser.list("movie", "Spirited Away");
        parser.add(r4);
        parser.add(r5);

        parser.similar("reviewer", "Bob");
        parser.add(r6);
        parser.add(r7);
        parser.add(r8);

        // Testing movies and reviewers with big lists
        parser.similar("reviewer", "Bob");
        parser.similar("movie", "Batman");
        parser.add(r9);
        parser.add(r10);
        parser.add(r11);
        parser.add(r12);
        parser.similar("reviewer", "Joe");
        parser.similar("movie", "Slo");
        parser.similar("reviewer", "KA");
        parser.similar("movie", "BA");

        parser.similar("reviewer", "Billy");

    }


    /**
     * Testing similar some more
     */
    public void testSimilar2() {
        Hash<String> movies = new Hash<String>(6);
        Hash<String> reviewers = new Hash<String>(6);
        ReviewerList reviewersList = new ReviewerList();
        MSLList moviesList = new MSLList();
        SparseMatrix matrix = new SparseMatrix(reviewersList, moviesList);
        Parser parser = new Parser("P2SampleInput.txt", movies, reviewers,
            reviewersList, moviesList, matrix);

        String[] r0 = { "Hayao Miyazaki", "Spirited Away", "10" };
        String[] r1 = { "Hayao Miyazaki", "Joker", "3" };
        String[] r2 = { "Hayao Miyazaki", "Batman", "6" };
        String[] r3 = { "Bob", "Spirited Away", "7" };
        String[] r4 = { "Bob", "Joker", "8" };
        String[] r5 = { "Bob", "Batman", "9" };
        String[] r6 = { "Adam", "Spirited Away", "7" };
        String[] r7 = { "Adam", "Joker", "8" };
        String[] r8 = { "Adam", "Batman", "9" };

        System.out.println("\n\n");
        parser.add(r0);
        parser.add(r1);
        parser.add(r2);
        assertEquals(3, movies.getNumEntries());

        // parser.add(r5);
        // parser.add(r4);
        parser.add(r4);
        parser.add(r3);

        parser.add(r6);
        parser.add(r7);
        parser.add(r8);

        parser.add(r5);
        // parser.add(r4);
        // parser.add(r3);
        parser.list("movie", "Spirited Away");

        parser.similar("reviewer", "Hayao Miyazaki");
        parser.similar("reviewer", "Bob");

    }

}
