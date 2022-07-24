package com.cts.usecaseproject.Service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cts.usecaseproject.Model.Author;
import com.cts.usecaseproject.Model.AuthorModel;
import com.cts.usecaseproject.Repository.AuthorRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private AuthorRepository repo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String authorname) throws UsernameNotFoundException {
		Author user = repo.findByAuthorName(authorname);
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + authorname);
		}
		else {
			if ("admin".equals(user)) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
				authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));
				authorities.add(new SimpleGrantedAuthority("ROLE_" + "OWNER"));
			}
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
//		if ("admin".equals(user)) {
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + "OWNER"));
//		}
//		return new User(user.getUsername(), user.getPassword(), authorities);
	}

	

	public Author save(AuthorModel author) {
		Author newUser = new Author();
		newUser.setUsername(author.getUsername());
		newUser.setPassword(bcryptEncoder.encode(author.getPassword()));
		return repo.save(newUser);
	}

}
