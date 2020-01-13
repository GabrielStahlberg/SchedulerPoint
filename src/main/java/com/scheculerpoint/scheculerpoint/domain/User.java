package com.scheculerpoint.scheculerpoint.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumGender;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

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
    private EnumGender gender;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "login_id", nullable = false)
    private Login login;

    //@LazyToOne(LazyToOneOption.NO_PROXY)

    public User() {
    }

    public User(@Size(max = 100) @NotEmpty String name, @Size(max = 100) @NotEmpty String email, EnumGender gender, Login login) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.login = login;
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
