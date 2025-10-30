package org.sbmicroservice.orders.controller;

import org.sbmicroservice.orders.Repo.OrderRepo;
import org.sbmicroservice.orders.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    private OrderRepo orderRepo;

//======== код Николая ================================================
    @GetMapping("/orders")
    @ResponseBody
    public Iterable<Orders> sorders() {
        return orderRepo.findAll();
    }

    @PostMapping("/orders")
    @ResponseBody
    public ResponseEntity<?> registerOrder(@RequestBody Orders order) {
        if (order.getId() > 0) {orderRepo.deleteById(order.getId());}
        else orderRepo.save(order);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/orders")
//    @ResponseBody
//    public void dellOrder(@RequestBody Orders order) {
//        System.out.println("Удаляю заказ с id - " + order.getId());
//        orderRepo.deleteById(order.getId());
//    }
//======== конец кода Николая =========================================

}
