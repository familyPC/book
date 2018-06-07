package com.library.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.AppointmentDao;
import com.library.dao.BookDao;
import com.library.dao.StudentDao;
import com.library.dto.AppointExecution;
import com.library.entity.Appointment;
import com.library.entity.Book;
import com.library.entity.Student;
import com.library.enums.AppointStateEnum;
import com.library.execption.AppointException;
import com.library.execption.NoNumberException;
import com.library.execption.RepeatAppointException;
import com.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private StudentDao studentDao; 
	
	@Override
	public Book getById(long bookId) { 
		return bookDao.queryById(bookId);
	}  
	@Override
	public List<Book> getList() { 
		return bookDao.queryAll(0, 7);
	} 
	@Override
	public Student validateStu(Long studentId,Long password){
		return studentDao.queryStudent(studentId, password);
	}
	@Override
	public List<Book> getSomeList(String name) {
		 
		return bookDao.querySome(name);
	} 
	@Override
	public List<Appointment> getAppointByStu(long studentId) {
		return appointmentDao.queryAndReturn(studentId);
		 
	}
	@Override
	@Transactional
	public AppointExecution appoint(long bookId, long studentId) {//在Dao的基础上组织逻辑，形成与web成交互用的方法
		try{													  //返回成功预约的类型。		
			int update=bookDao.reduceAmount(bookId);//减库存
			if(update<=0){//已经无库存！
				throw new NoNumberException("no number");
			}else{
				//执行预约操作
				int insert=appointmentDao.insertAppointment(bookId, studentId);
				if(insert<=0){//重复预约
					throw new RepeatAppointException("repeat appoint");
				}else{//预约成功	
					
					return new AppointExecution(bookId,AppointStateEnum.SUCCESS);
				}
				
			}
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 所有编译期异常转换为运行期异常
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}

}
