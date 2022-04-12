package BLL.Validators;

import Model.Product;

/**
 * Clasa responsabila de validarea produsului
 */
public class ProductPriceValidator implements Validator<Product> {
    private static final int MIN_PRICE=0;
        /**
         * Verifica daca produseul p respecta conditia de pret minim
         * @param p produsul care se verifica
         */
        @Override
        public void validate(Product p){
            if(p.getPrice()<MIN_PRICE){
                throw new IllegalArgumentException("produsul are pretul <0");
        }
        }
}
