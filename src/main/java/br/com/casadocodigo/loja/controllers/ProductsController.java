package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.validation.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Classe que faz o papel de controller
 * para a funcionalidade de produtos. Ele recebe
 * a anotação {@link Transactional} para definir que existem
 * métodos que precisam de suporte a transações.
 */
@Controller
@RequestMapping("/produtos")
@Transactional
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    /**
     * Método anotado com {@link InitBinder} será
     * chamado sempre que um request cair no controller.
     *
     * OBS.: Usando Bean validator
     */

    // @InitBinder
    // protected void initBinder(WebDataBinder binder) {
    //     binder.setValidator(new ProductValidator());
    // }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());
        return modelAndView;
    }

    @RequestMapping("/form")
    public ModelAndView form(Product product) {
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", BookType.values());
        return modelAndView;
    }

    @RequestMapping(value="/", method=RequestMethod.POST, name="saveProduct")
    public ModelAndView save(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            return form(product);
        }
        productDAO.save(product);
        redirectAttributes.addAttribute("sucesso", "Produto cadastrado com sucesso");
        return new ModelAndView("redirect:produtos");
    }
}
