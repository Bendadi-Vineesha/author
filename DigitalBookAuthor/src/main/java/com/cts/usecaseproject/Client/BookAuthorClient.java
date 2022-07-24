package com.cts.usecaseproject.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Model.Books;

@FeignClient("Digital-Author")
public interface BookAuthorClient {

	@PostMapping("/api/v1/digitalbooks/books//create")
	public Books createBook(@RequestBody Book book);
	
}
