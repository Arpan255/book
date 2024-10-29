package com.demo.book_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.book_service.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    List<Book> findById1(long id1);
}
