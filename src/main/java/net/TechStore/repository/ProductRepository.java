package net.TechStore.repository;


import net.TechStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findAllCategoryById(int id);
}
