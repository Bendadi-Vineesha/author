package com.cts.usecaseproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.usecaseproject.Model.Author;
import com.cts.usecaseproject.Repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository repo;
	
	public Author saveAuthor(Author authordetails) {
		return repo.save(authordetails);
	}
	

}
