package ua.strychak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.strychak.entity.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
