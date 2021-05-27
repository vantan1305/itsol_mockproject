package itsol_project.itsolwebserver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productInfo")
@Getter
@Setter
public class ProductInfo extends BaseEntity {
    @ManyToOne
    private Product product;
    //1 sản phẩm có nhiều chi tiêts
    private String image; // ảnh
    private Long numberProduct; // số sản phẩm

    public ProductInfo() {}
}
