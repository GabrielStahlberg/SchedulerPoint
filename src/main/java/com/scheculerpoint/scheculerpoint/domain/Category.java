package com.scheculerpoint.scheculerpoint.domain;

import com.scheculerpoint.scheculerpoint.domain.enumeration.EnumCategoryType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tbcategory")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "category_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    @Size(max = 100)
    @NotEmpty
    private String name;

    @Column(name = "category_description")
    @Size(max = 256)
    private String description;

    @Column(name = "category_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private EnumCategoryType type;

    public Category() {
    }

    public Category(@Size(max = 100) @NotEmpty String name, @Size(max = 256) @NotEmpty String description, @NotNull EnumCategoryType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumCategoryType getType() {
        return type;
    }

    public void setType(EnumCategoryType type) {
        this.type = type;
    }
}
