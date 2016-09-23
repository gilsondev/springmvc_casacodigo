package br.com.casadocodigo.loja.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Price {
    @Column(scale = 2)
    private BigDecimal value;

    private BookType bookType;
}
