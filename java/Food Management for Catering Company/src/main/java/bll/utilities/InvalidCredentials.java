package bll.utilities;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials(String a)
    {
        super(a);
    }
}