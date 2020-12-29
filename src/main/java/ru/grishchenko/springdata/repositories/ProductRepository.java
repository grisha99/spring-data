package ru.grishchenko.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.grishchenko.springdata.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCostBetween(int min, int max);

    List<Product> findAllByCostIsGreaterThanEqual(int min);

    List<Product> findAllByCostLessThanEqual(int max);

}
