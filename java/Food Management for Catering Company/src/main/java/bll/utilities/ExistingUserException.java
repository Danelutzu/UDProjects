package bll.utilities;

public class ExistingUserException extends RuntimeException{

    public ExistingUserException(String a)
    {
        super(a);
    }
}
