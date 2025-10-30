package org.sbmicroservice.users.Repo;




import org.sbmicroservice.users.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Users, Integer> {
    boolean findById(Users iduser);
}
