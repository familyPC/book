package com.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.library.entity.Appointment;

public interface AppointmentDao {

	//通过图书Id和学生Id预约书籍，并插入
	int insertAppointment(@Param("bookId") long bookId,@Param("studentId")long studentId);
	 

	//通过一个学生Id查询预约了那些书籍
	List<Appointment> queryAndReturn(long studentId);
}
