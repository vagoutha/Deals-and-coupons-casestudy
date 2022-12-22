package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.order.orderservice.model.Order;

@EnableMongoRepositories
public interface OrderRepository extends MongoRepository<Order, String> {
  List <Order> findByUserId(int userId);

  Order findByOrderId(int orderId);

List<Order> findByOrderStatus(String orderStatus);



void deleteByOrderId(int orderId);
}
