package BLL.Validators;

import Model.Client;

public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 30;
    /**
     * Verifica daca clientul t se incadreaza in intervalul de varsta permis
     * @param t clientul care se verifica
     */
    public void validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            System.out.println("The Client Age limit is not respected!");
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }

    }

}

