package com.soecode.lyf.dao;

import com.alibaba.fastjson.JSON;
import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

	/**
	 *  批量插入
	 * @throws Exception
	 */
	@Test
	public void testBatchInsert() throws  Exception{
		//Map<String,Object> map  = new HashMap<String, Object>();
		//map.put("specId","my heart will go on");
		List<Map<String,Object>> list  = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1  = new HashMap<String, Object>();
		map1.put("specId","fffff");
		map1.put("specValue",3);
		Map<String,Object> map2  = new HashMap<String, Object>();
		map2.put("specId","bbb");
		map2.put("specValue",4);
		Map<String,Object> map3  = new HashMap<String, Object>();
		map3.put("specId","dddd");
		map3.put("specValue",5);

		list.add(map1);
		list.add( map2);
		list.add(map3 );

		//map.put("specValue",list);
		// 批量插入 list

		bookDao.batchInsert(list);
		System.out.println(JSON.toJSON(list));
	}


	/**
	 *  批量插入數組
	 */
	@Test
	public void  testBatchInsertArrays(){
		Integer[]  arrays = new Integer[]{1,2,3};
		bookDao.batchInsertArray(arrays);
	}

	/**
	 *  批量插入Map
	 */
	public void  testBatchInsertMap(){
		Map<String,Object>  map  = new HashMap<String, Object>();
		map.put("1",1);
		map.put("2",2);
		bookDao.batchInsertMap(map);
	}

	/**
	 *  批量更新书籍 测试未通过 sql有问题
	 */
	@Test
	public void  testBatchUpdateBook(){
		 Map<String,Object>  map = new HashMap<String, Object>();
		 map.put("aaa",10);
		 map.put("zhang",200);
		 bookDao.batchUpdateBook(map);
	}



}
