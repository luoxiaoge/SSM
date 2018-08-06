package com.soecode.lyf.dao;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoTest extends BaseTest {

	@Autowired
	private BookDao bookDao;

	@Test
	public void testQueryById() throws Exception {
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		System.out.println(book);
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}

   @Test
	public void testTransaction() {
	   testInnerTransaction(1000);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void testInnerTransaction(long bookId){

		int update = bookDao.reduceNumber(bookId);
		int a =0;

		try{
			Map<String,Object> paramsMap = new HashMap();
			paramsMap.put("bookId",9999);
			paramsMap.put("name","曾国藩");
			paramsMap.put("number",10);
			int b = bookDao.saveBook(paramsMap);
			System.out.println("update"+b);
			int c =10/a;
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
