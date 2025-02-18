package com.noyex.webshopdata.repo;

import com.noyex.webshopdata.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUserId(Long userId);
}
