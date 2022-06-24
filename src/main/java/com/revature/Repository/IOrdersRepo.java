package com.revature.Repository;

import com.revature.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IOrdersRepo extends JpaRepository<Orders,Long> {
    Optional<Orders> findByorderID(Long orderID);
    void deleteByorderID(Long orderID);

}
