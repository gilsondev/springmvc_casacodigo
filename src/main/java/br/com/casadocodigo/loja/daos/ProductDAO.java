package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAO {

    @PersistenceContext
    private EntityManager manager;

    /**
     * Listando os produtos cadastrados
     *
     * @return Lista de {@link Product}
     */
    public List<Product> list() {
        return manager.createQuery("select distinct(p) from Product p join fetch p.prices", Product.class).getResultList();
    }

    /**
     * Cadastrando um novo produto
     *
     * @param product Dados do produto a ser inserido no banco de dados
     */
    public void save(Product product) {
        manager.persist(product);
    }
}
