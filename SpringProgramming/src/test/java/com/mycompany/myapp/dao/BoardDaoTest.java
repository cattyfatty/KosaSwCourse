package com.mycompany.myapp.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.ApplicationContextLoader;
import com.mycompany.myapp.dto.Board;

import org.junit.Assert;

public class BoardDaoTest extends ApplicationContextLoader{

	@Autowired // dao object injection
	private BoardDao boardDao;
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("test1");
		board.setContent("test content1");
		board.setWriter("tester");
		
		Integer bno = boardDao.insert(board);
		Assert.assertNotNull(bno);
	}
	
	@Test
	public void testSelectByPage() {
		List<Board> list = boardDao.selectByPage(1, 10);
		
		Assert.assertEquals(10, list.size());
	}
	
	@Test
	public void testDelete() {
		Board board = new Board();
		board.setTitle("test1");
		board.setContent("test content1");
		board.setWriter("tester");
		
		Integer bno = boardDao.insert(board);
		int row = boardDao.delete(bno);
		Assert.assertEquals(1, row);
	}
	
	@Test
	public void testUpdate() {
		Board board = new Board();
		board.setTitle("test1");
		board.setContent("test content1");
		board.setWriter("tester");
		
		Integer bno = boardDao.insert(board);
		
		board.setTitle("test2");
		board.setContent("test content2");
		int row = boardDao.update(board);
		Assert.assertEquals(1, row);
		
		Board board2 = boardDao.selectByPk(bno);
		Assert.assertEquals("test2", board2.getTitle());
		Assert.assertEquals(board.getContent(), board2.getContent());
	}
}
