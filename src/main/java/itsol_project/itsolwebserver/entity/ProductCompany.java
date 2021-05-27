package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "productCompany")
@Getter
@Setter
public class ProductCompany extends  BaseEntity{
    private String name;
    private String code;
    private String image;
    public ProductCompany() {}
}
