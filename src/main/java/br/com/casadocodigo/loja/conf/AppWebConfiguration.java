package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classe criada para habilitar o Spring MVC e escanear
 * as classes controllers no pacote definido
 */
@EnableWebMvc
@ComponentScan(basePackages="br.com.casadocodigo.loja")
//@ComponentScan(basePackageClasses={HomeController.class})
public class AppWebConfiguration {
}
