package com.muratkapparov.springbootlibrary.service;

import com.muratkapparov.springbootlibrary.RequestModels.AddBookRequest;
import com.muratkapparov.springbootlibrary.dao.BookRepository;
import com.muratkapparov.springbootlibrary.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {
    private BookRepository bookRepository;
    @Autowired
    public AdminService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void postBook(AddBookRequest addBookRequest){
        Book book =new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCopiesAvailable(addBookRequest.getCopies());
        book.setCopies(addBookRequest.getCopies());
        book.setImg(addBookRequest.getImg());
        bookRepository.save(book);
    }
}
