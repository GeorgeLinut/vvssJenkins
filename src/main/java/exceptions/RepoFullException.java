package exceptions;



public class RepoFullException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public RepoFullException() {
        super("Repo full!");
    }

}