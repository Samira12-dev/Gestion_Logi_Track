package com.example.testLogiTrack.controller;


import com.example.testLogiTrack.entity.Order;
import com.example.testLogiTrack.entity.OrderLine;
import com.example.testLogiTrack.service.ClientService;
import com.example.testLogiTrack.service.OrderService;
import com.example.testLogiTrack.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private  final OrderService orderService;
    private ClientService clientService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService,
                           ClientService clientService) {
        this.orderService = orderService;
        this.productService = productService;
        this.clientService = clientService;
    }
    @PostMapping("/client/{clientId}")
    public Order createOrderForClient(@PathVariable Long clientId){
        return orderService.createOrderForClient(clientId);
    }
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/{orderId}/products")
    public OrderLine addProductToOrder(@PathVariable Long orderId, @RequestBody OrderLine request){
        return orderService.addProductToOrder(orderId,request);
    }
@GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
}

    @PutMapping("/{id}/status")
    public Order updateStatusOrder(@PathVariable Long id , @RequestBody String status){
        return  orderService.updateOrder(id,status);
}

@GetMapping("/client/clientId")
    public List<Order> getAllOrdersOFClient(@PathVariable Long clientId){
        return orderService.getAllOrdersOfClient(clientId);
}
@GetMapping("/count")
    public Long countTotalOrders(){
        return orderService.TotalOrders();
}
}
