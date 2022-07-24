package com.cts.usecaseproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.usecaseproject.Model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
	
	Author findByAuthorName(String username);
}
