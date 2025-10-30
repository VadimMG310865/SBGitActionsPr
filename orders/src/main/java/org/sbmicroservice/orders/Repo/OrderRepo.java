package org.sbmicroservice.orders.Repo;

import org.springframework.data.repository.CrudRepository;
import org.sbmicroservice.orders.entity.Orders;

public interface OrderRepo extends CrudRepository<Orders, Integer> {
    boolean findById(Orders idorder);

}
