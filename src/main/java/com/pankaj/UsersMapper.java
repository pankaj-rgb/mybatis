package com.pankaj;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface UsersMapper {

	@Select("select * from userss")
	List<Users> findAll();
	
	
	@Insert("insert into userss(name,salary) values(#{name}, #{salary})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
	before = false, resultType = Integer.class)
	void insert(Users users);


	@Update("update userss set salary=#{salary} where name=#{name}")
	void updates(Users users);

	@Delete("delete from userss where name=#{name}")
	void delete(Users users);
	
	@Select(value = "{CALL users.userById(#{id, mode=IN, jdbcType=INTEGER})}")
	@Options(statementType = StatementType.CALLABLE)
	List<Users> callProcedure(int id); 
}
