package com.example.testLogiTrack.service;

import com.example.testLogiTrack.entity.Client;
import com.example.testLogiTrack.entity.Order;
import com.example.testLogiTrack.entity.OrderLine;
import com.example.testLogiTrack.entity.Product;
import com.example.testLogiTrack.repository.ClientRepo;
import com.example.testLogiTrack.repository.OrderLineRepo;
import com.example.testLogiTrack.repository.OrderRepo;
import com.example.testLogiTrack.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService{
private final ClientRepo clientRepo;
private final OrderRepo orderRepo;
private final ProductRepo productRepo;
private final OrderLineRepo orderLineRepo;

public OrderService(ClientRepo clientRepo,OrderRepo orderRepo,ProductRepo productRepo,OrderLineRepo orderLineRepo){
    this.clientRepo=clientRepo;
    this.orderRepo=orderRepo;
    this.productRepo=productRepo;
    this.orderLineRepo=orderLineRepo;
}

public Order createOrderForClient(Long clientID){
    Client client= clientRepo.findById(clientID).orElseThrow(()->new RuntimeException("Not found"));
    Order order= new Order();
    order.setClient(client);
    order.setDateOrder(LocalDate.now());
    order.setStatus("EN Attente");
    return orderRepo.save(order);

}
public List<Order> getAllOrders(){
    return orderRepo.findAll();
}
public Order findOrderById(Long id){
    return  orderRepo.findById(id).orElseThrow(()->new RuntimeException("not found "));
}
public OrderLine addProductToOrder(Long orderId,OrderLine request){
    Order order=orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("Not found"));
    Product product=productRepo.findById(request.getProduct().getId()).orElseThrow(()->new RuntimeException("not exist"));

    OrderLine orderLine= new OrderLine();
    orderLine.setOrder(order);
    orderLine.setProduct(product);
    orderLine.setQuantity(request.getQuantity());
   return orderLineRepo.save(orderLine);
}

public Order updateOrder(Long id , String status){
    List<String> statusOrder= Arrays.asList("EN_ATTENTE","EXPEDIEE","LIVREE");
    if(!statusOrder.contains(status)){
        throw new RuntimeException("Not found");
    }
    Order order = orderRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    order.setStatus(status);
    return orderRepo.save(order);
}
public  List<Order> getAllOrdersOfClient(Long clientId){
    return orderRepo.findOrderByClient(clientId);
}
public Long TotalOrders(){
    return  orderRepo.countAllOrders();
}
}
