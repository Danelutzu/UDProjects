package BLL;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import BLL.Validators.ClientAgeValidator;
import BLL.Validators.EmailValidator;
import DAO.ClientDAO;
import Model.Client;
import BLL.Validators.Validator;

public class ClientBLL {

    private ArrayList<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());
        clientDAO=new ClientDAO();
    }

    public Client findClientById(int id) {
        Client c = clientDAO.findById(id);

        if (c == null) {
            throw new NoSuchElementException("Nu exista client cu acest id : " + id);
        }

        return c;
    }

    public Client insertClient(Client c) {
        try {
            validators.get(0).validate(c);
            validators.get(1).validate(c);
            return clientDAO.insert(c);
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(int id) {
       try {
           clientDAO.delete(id);
       }
    catch(Exception e){
        throw new NoSuchElementException("Nu exista clientul acesta!");
    }
    }

    public List<Client> findAll() {
        List<Client> clienti = new ArrayList<Client>();
        try {
            clienti = clientDAO.findAll();
        }
        catch(Exception e) {
            throw new NoSuchElementException("Nu sunt clienti deloc :( ");
        }
        return clienti;
    }

    public Client update(Client c) {
        try {
            Client c1 = clientDAO.update(c);
            return c1;
        }
        catch(Exception e) {
            throw new NoSuchElementException("Nu exista acest client petru a-l updata");
        }
    }
}

