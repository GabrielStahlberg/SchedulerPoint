package com.scheculerpoint.scheculerpoint.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumGender;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbuser")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @Size(max = 100)
    @NotEmpty
    private String name;

    @Column(name = "user_email")
    @Size(max = 100)
    @NotEmpty
    private String email;

    @Column(name = "user_gender")
    @Enumerated(EnumType.STRING)
    @NotNull
    private EnumGender gender;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "login_id", nullable = false)
    private Login login;

    @JsonManagedReference(value = "user_movimentations")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Movimentation> movimentations;

    @JsonManagedReference(value = "user_cards")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Card> cards;

    public User() {
    }

    public User(@Size(max = 100) @NotEmpty String name, @Size(max = 100) @NotEmpty String email, EnumGender gender, Login login, List<Movimentation> movimentations) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.movimentations = movimentations;
    }

    public List<Movimentation> getMovimentations() {
        return movimentations;
    }

    public void setMovimentations(List<Movimentation> movimentations) {
        this.movimentations = movimentations;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
