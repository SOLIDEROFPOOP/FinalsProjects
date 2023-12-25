package com.muratkapparov.springbootlibrary.dao;

import com.muratkapparov.springbootlibrary.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByBookId(@RequestParam("book_id") Long bookId, Pageable pageable);
    Review findByUserEmailAndBookId(String userEmail, Long BookId);
    @Modifying
    @Query("delete from Review r where r.bookId = :book_id")
    void deleteAllByBookId(@Param("book_id") Long bookId);
}
