package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

    // @PersistenceContext
    // private EntityManager manager;

    public void save(Product product) {
        // manager.persist(product);
    }
}
