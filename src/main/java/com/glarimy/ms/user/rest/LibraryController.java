package com.glarimy.ms.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glarimy.ms.user.data.LibraryRepo;
import com.glarimy.ms.user.model.Book;

@RestController
public class LibraryController {
	@Autowired
	private LibraryRepo repo;

	@RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
	public ResponseEntity<Book> find(@PathVariable("isbn") int isbn) {
		System.out.println("ISBN: " + isbn);
		Book book = repo.findByIsbn(isbn);
		System.out.println("Book: " + book);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
	}

}