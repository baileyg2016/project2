import student.TestCase;
/**
 * 
 */

/**
 * @author BaileySpell
 *
 */
public class ParserTest extends TestCase {
    public void testParser() {
        Parser parser = new Parser("P2SampleInput.txt");
        parser.parseFile();
        System.out.println("working");
    }
}
