package com.jiangwh.repository;

import com.jiangwh.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByIsbn(String s);

	List<Book> findByTitleContaining(String title);
}
