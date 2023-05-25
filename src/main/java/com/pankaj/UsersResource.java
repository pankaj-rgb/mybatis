package com.pankaj;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

	private UsersMapper usersMapper;

	public UsersResource(UsersMapper usersMapper) {
//		super();
		this.usersMapper = usersMapper;
	}

	@GetMapping("/all")
	public List<Users> getAll() {
		return usersMapper.findAll();
	}
	
	@GetMapping("/update")
	public List<Users> update(){
		Users users=new Users();
//		users.setId(3);
		users.setName("utube");
		users.setSalary(2700l);
		usersMapper.insert(users);
		
		return usersMapper.findAll();
	}

}
