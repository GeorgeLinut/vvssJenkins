package exceptions;

public class IncompleteFamilyException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public IncompleteFamilyException() {
        super("Family memebers were added before!");
    }

}