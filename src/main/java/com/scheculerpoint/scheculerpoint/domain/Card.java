package com.scheculerpoint.scheculerpoint.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumCardFlag;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumCardType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tbcard")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "card_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    @Size(max = 16)
    @NotEmpty
    private String number;

    @Column(name = "card_flag")
    @Enumerated(EnumType.STRING)
    @NotNull
    private EnumCardFlag flag;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private EnumCardType type;

    @Column(name = "card_avaliable_value", columnDefinition = "numeric")
    @NotNull
    private BigDecimal avaliableValue;

    @JsonBackReference(value = "user_cards")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonManagedReference(value = "card_movimentations")
    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
    private List<Movimentation> movimentations;

    public Card() {
    }

    public List<Movimentation> getMovimentations() {
        return movimentations;
    }

    public void setMovimentations(List<Movimentation> movimentations) {
        this.movimentations = movimentations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public EnumCardFlag getFlag() {
        return flag;
    }

    public void setFlag(EnumCardFlag flag) {
        this.flag = flag;
    }

    public EnumCardType getType() {
        return type;
    }

    public void setType(EnumCardType type) {
        this.type = type;
    }

    public BigDecimal getAvaliableValue() {
        return avaliableValue;
    }

    public void setAvaliableValue(BigDecimal avaliableValue) {
        this.avaliableValue = avaliableValue;
    }
}
