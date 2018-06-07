package com.library.service;

import java.util.List;

import com.library.dto.AppointExecution;
import com.library.entity.Appointment;
import com.library.entity.Book;
import com.library.entity.Student;

public interface BookService {

	/**
	 * 查询一本书
	 */
	Book getById(long bookId);
	
	/**
	 * 查询所有图书
	 */
	List <Book> getList();
	
	/**
	 * 登录时查询数据库是否有该学生记录
	 */
	Student validateStu(Long studentId,Long password);
	
	/**
	 * 按照图书名查询
	 * 按照条件搜索图书
	 */
	List<Book> getSomeList(String name);
	
	/**
	 * 查看某学生预约的所有图书
	 */
	List<Appointment> getAppointByStu(long studentId);
	
	/**
	 * 预约图书
	 */
	AppointExecution appoint(long bookId,long studentId);//返回预约成功的实体类
	
}
