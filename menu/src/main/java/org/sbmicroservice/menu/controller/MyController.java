package org.sbmicroservice.menu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.sbmicroservice.menu.dto.OrderDto;
import org.sbmicroservice.menu.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String menupage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "menu/home";
    }
//========================= эндпоинты users ========================
    //============= показать всех пользователей ====================
    @GetMapping("/users")
    public ModelAndView menupageus() {
        var mavu = new ModelAndView("menu/users");
        var users = myService.getUsers();
        mavu.addObject("users", users);
        return mavu;
    }
    //========= показать форму добавления пользователя =============
    @GetMapping("/useradd")
    public String usersAddPage() {
        return "menu/useradd";
    }
    //========= добавить пользователя ==============================
    @PostMapping("/newuseradd")
    public String registerUser(Model model, HttpServletRequest req) {
        var userDto = new UserDto(
                null,
                (String) req.getParameter("name"),
                Integer.parseInt((String) req.getParameter("balance"))
        );

        myService.registerUser(userDto);
        return "redirect:/users";
    }

    //========= удалить пользователя =====================================
    @GetMapping("/userdell/{id}")
    public String dellUser(Model model, HttpServletRequest req, @PathVariable int id) {

        var userDto = new UserDto(id, null, 0);
        myService.registerUser(userDto);
        return "redirect:/users";

    }

    //========================= эндпоинты orders =======================
    //============= показать все заказы ====================
    @GetMapping("/orders")
    public ModelAndView menupageord() {
        var mavo = new ModelAndView("menu/orders");
        var orders = myService.getOrders();

        mavo.addObject("orders", orders);
        return mavo;
    }
    //========= показать форму добавления заказа ===================
    @GetMapping("/orderadd")
    public ModelAndView ordersAddPage() {
        var ordadd = new ModelAndView("menu/orderadd");
        var users = myService.getUsers();
        ordadd.addObject("users", users);
        return ordadd;

    }
    //========= добавить заказ =====================================
    @PostMapping("/neworderadd")
    public String registerOrder(Model model, HttpServletRequest req) {
        var orderDto = new OrderDto(
                null,
                (String) req.getParameter("ordnum"),
                Integer.parseInt((String) req.getParameter("ordsum")),
                Integer.parseInt((String) req.getParameter("iduser"))
        );

        myService.registerOrder(orderDto);
        return "redirect:/orders";
    }
    //========= удалить заказ =====================================
    @GetMapping("/orderdell/{id}")
    public String dellOrder(Model model, HttpServletRequest req, @PathVariable int id) {

        var orderDto = new OrderDto(id, null, 0, 0);
        //myService.dellOrder(orderDto);
        myService.registerOrder(orderDto);
        return "redirect:/orders";

    }

//=================== конец эндпоинты orders =======================
}
