package com.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.library.entity.Book;

public interface BookDao {
	/***
	 * 根据id查询书籍	
	 */
	Book queryById(long id);
	List<Book> querySome(String name);
	List<Book> queryAll(@Param("minNum")int minNum,@Param("maxNum")int maxNum);
	
	/**
	 * 减少库存数量
	 */
	int reduceAmount(long bookId);
}
