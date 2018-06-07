  package com.library.dao;

import org.apache.ibatis.annotations.Param;

import com.library.entity.Student;

public interface StudentDao {

	//向数据验证输入的密码是否正确
	Student queryStudent(@Param("studentId")long studentId,@Param("password") long password);
	
}
