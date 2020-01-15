package com.scheculerpoint.scheculerpoint.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbmovimentation")
public class Movimentation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "movimentation_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movimentation_date", columnDefinition = "date")
    private Date movimentDate;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "movimentation_value", columnDefinition = "numeric")
    @NotNull
    private BigDecimal value;

    @Column(name = "movimentation_description")
    @Size(max = 256)
    @NotEmpty
    private String description;

    @Column(name = "movimentation_installments_quantity")
    @NotNull
    private Integer installmentsQuantity;

    @JsonBackReference(value = "user_movimentations")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonBackReference(value = "card_movimentations")
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public Movimentation() {
    }

    @PrePersist
    private void movimentDate() {
        movimentDate = new Date();
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getMovimentDate() {
        return movimentDate;
    }

    public void setMovimentDate(Date movimentDate) {
        this.movimentDate = movimentDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInstallmentsQuantity() {
        return installmentsQuantity;
    }

    public void setInstallmentsQuantity(Integer installmentsQuantity) {
        this.installmentsQuantity = installmentsQuantity;
    }
}
