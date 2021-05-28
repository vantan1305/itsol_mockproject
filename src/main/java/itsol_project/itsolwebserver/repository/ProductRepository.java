package itsol_project.itsolwebserver.repository;

import itsol_project.itsolwebserver.entity.Brand;
import itsol_project.itsolwebserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteAllByBrand(Brand brand);

    @Query("select pro from Product pro where pro.status like '%new' ")
    List<Product> getProductNew();


    @Query("select pro from Product pro where pro.status like '%sale' ")
    List<Product> getProductSale();

    @Query("select p from  Product p join  Brand br on p.brand.id = br.id" +
            " where br.id = :id or p.brand.id = :id")
    List<Product> getAllByBrands(Long id);

    //    @Query("select p from Product p where lower(p.name) like concat('%', :name, '%')")
    @Query("select p from Product p where lower(p.name) like concat('%', :name, '%')")

    List<Product>search (String name);
}
