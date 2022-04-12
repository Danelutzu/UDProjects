package BLL;

import java.util.ArrayList;
import java.util.List;

import BLL.Validators.ProductPriceValidator;
import BLL.Validators.Validator;
import Model.Product;
import java.util.NoSuchElementException;

import DAO.ProductDAO;

public class ProductBLL {
    /**
     * Lista de validatoare pentru product
     */
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;
    /**
     * Constructorul clasei unde se initializeaza validatoarele si productDAO
     */
    public ProductBLL(){
        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductPriceValidator());
        productDAO = new ProductDAO();
    }
    /**
     * Gaseste produsul cu id-ul dat ca si parametru
     * @param id paratemtrul dupa care se cauta produsul in tabel
     * @return Produsul cu id-ul dat ca si parametru
     */
    public Product findById(int id) {
        Product p = productDAO.findById(id);

        if (p == null) {
            throw new NoSuchElementException("Nu exista o comanda cu un astfel de id!");
        }
        return p;
    }
    /**
     * Insereaza in tabelul product
     * @param p produsul care trebuie inserat
     * @return Operatia de insert pe product
     */
    public Product insert(Product p) {
        try {
            validators.get(0).validate(p);
            return productDAO.insert(p);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * Sterge in tabelul product
     * @param id produsul care trebuie sters dupa parametru
     */
    public void delete(int id) {
        try {
            productDAO.delete(id);
        } catch (Exception e) {
            throw new NoSuchElementException("Nu exista un astfel de Product!");
        }
    }

    public List<Product> findAll() {
        try {
            List<Product> p = productDAO.findAll();
            return p;
        } catch (Exception e) {
            throw new NoSuchElementException("Nu exista elemente in tabel");
        }
    }
    /**
     * Actualizeaza in tabelul product
     * @param p produsul care trebuie actualizat
     * @return Operatia de update pe product
     */
    public Product update(Product p) {
        try {
            Product p1 = productDAO.update(p);
            return p1;
        }
        catch(Exception e) {
            throw new NoSuchElementException("Nu s-a gasit Productul!");
        }
    }

}
