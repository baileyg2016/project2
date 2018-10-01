
public class SparseMatrix {

    public ReviewerList<String> reviewers;

    public MSLList movies;

    private int count;

    public SparseMatrix(ReviewerList<String> reviewers, MSLList movies) {
        this.reviewers = reviewers;
        this.movies = movies;
        count = 0;
    }


    public void insert(String reviewer, String movie, int rating) {

        Node<Integer> matrixNode = new Node<Integer>(rating);
        
        reviewers.insert(reviewer);

        movies.add(movie);
        
        
        movies.tail.list.add(matrixNode);
        reviewers.getTail().list.add(matrixNode);
        count++;
    }
    
    public int getCount() {
        return count;
    }
}
