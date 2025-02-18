package com.noyex.webshopdata.repo;

import com.noyex.webshopdata.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findByUserId(Long userId);
}
