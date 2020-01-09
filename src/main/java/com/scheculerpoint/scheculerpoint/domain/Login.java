package com.scheculerpoint.scheculerpoint.domain;

import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumUserRole;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tblogin")
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "login_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_username")
    @Size(max = 30)
    @NotEmpty
    private String username;

    @Column(name = "login_password")
    @Size(max = 30)
    @NotEmpty
    private String password;

    @Column(name = "login_role")
    @Enumerated(EnumType.STRING)
    private EnumUserRole role;

    public Login() {
    }

    public Login(@Size(max = 30) @NotEmpty String username, @Size(max = 30) @NotEmpty String password, EnumUserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumUserRole getRole() {
        return role;
    }

    public void setRole(EnumUserRole role) {
        this.role = role;
    }
}
