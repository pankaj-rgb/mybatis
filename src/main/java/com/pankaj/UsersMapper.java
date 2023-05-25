package com.pankaj;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

@Mapper
public interface UsersMapper {

	@Select("select * from userss")
	List<Users> findAll();
	
	
	@Insert("insert into userss(name,salary) values(#{name}, #{salary})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
	before = false, resultType = Integer.class)
	void insert(Users users);
}
