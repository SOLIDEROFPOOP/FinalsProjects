package com.muratkapparov.springbootlibrary.dao;

import com.muratkapparov.springbootlibrary.entity.Checkout;
import org.hibernate.annotations.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface CheckoutRepository extends JpaRepository<Checkout , Long> {
    Checkout findByUserEmailAndBookId( String email , Long bookId);
    List<Checkout> findBooksByUserEmail(String userEmail);
}
