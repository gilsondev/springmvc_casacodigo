package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe que faz o papel de controller
 * para a funcionalidade de produtos. Ele recebe
 * a anotação {@link Transactional} para definir que existem
 * métodos que precisam de suporte a transações.
 */
@Controller
@Transactional
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/produtos/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", BookType.values());
        return modelAndView;
    }

    @RequestMapping("/produtos")
    public String save(Product product) {
        System.out.println("Cadastrando o produto: " + product);
        productDAO.save(product);
        return "products/ok";
    }
}
