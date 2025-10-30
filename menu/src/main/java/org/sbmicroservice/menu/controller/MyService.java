package org.sbmicroservice.menu.controller;

import org.apache.coyote.Request;
import org.sbmicroservice.menu.dto.OrderDto;
import org.sbmicroservice.menu.dto.UserDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class MyService {

    private static final ParameterizedTypeReference<List<OrderDto>> LIST_ORDER_DTO_TYPE_REF = new ParameterizedTypeReference<>() {
    };

    private static final ParameterizedTypeReference<List<UserDto>> LIST_USER_DTO_TYPE_REF = new ParameterizedTypeReference<>() {
    };


    private final RestTemplate restTemplate;

    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//=============== получение и отправка данных из БД через микросервис orders ==============
//=========== запрос на получение в menu данных из БД через микросервис orders ============
    public List<OrderDto> getOrders() {
        var request = RequestEntity.get(URI.create("http://localhost:8082/orders")).build();
        ResponseEntity<List<OrderDto>> ordersResponse =
                restTemplate.exchange(request, LIST_ORDER_DTO_TYPE_REF);
        return ordersResponse.getBody();
    }
//==== ответ на предачу данных из menu в БД через микросервис orders для добавления нового заказа =====
    public void registerOrder(OrderDto newOrder) {
        RequestEntity<OrderDto> request = RequestEntity.post(URI.create("http://localhost:8082/orders"))
                .body(newOrder);
        restTemplate.exchange(request, Object.class);
    }
//====== ответ на предачу данных из menu в БД через микросервис orders для удаления заказа ==========
    public void dellOrder(OrderDto newOrder) {
        RequestEntity<OrderDto> request = RequestEntity.post(URI.create("http://localhost:8082/orders"))
                .body(newOrder);
        restTemplate.exchange(request, Object.class);
    }


//=============== получение и отправка данных из БД через микросервис users ==============
//=========== запрос на получение в menu данных из БД через микросервис users ============
    public List<UserDto> getUsers() {
        var request = RequestEntity.get(URI.create("http://localhost:8081/users")).build();
        ResponseEntity<List<UserDto>> usersResponse =
                restTemplate.exchange(request, LIST_USER_DTO_TYPE_REF);
        //System.out.println(ordersResponse);
        return usersResponse.getBody();
    }
//=========== ответ на предачу данных из menu в БД через микросервис users ==============
    public void registerUser(UserDto newUser) {
        RequestEntity<UserDto> request = RequestEntity.post(URI.create("http://localhost:8081/users"))
                .body(newUser);
        restTemplate.exchange(request, Object.class);
    }

}
