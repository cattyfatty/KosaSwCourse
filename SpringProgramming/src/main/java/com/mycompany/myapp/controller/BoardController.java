package com.mycompany.myapp.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.websocket.server.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.mycompany.myapp.dto.*;
import com.mycompany.myapp.service.*;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public String list(Model model, @RequestParam(defaultValue="1") int pageNo, HttpSession session) {
		logger.info("list()");
		
		session.setAttribute("pageNo", pageNo);
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		// 전체 게시물 수
		int totalBoardNo = boardService.getTotalBoardNo();
		
		// 전체 페이지 수
		int totalPageNo = totalBoardNo / rowsPerPage;
		if(totalBoardNo % rowsPerPage > 0) { totalPageNo += 1; }
		
		// 전체 그룹 수
		int totalGroupNo = totalPageNo / pagesPerGroup;
		if(totalPageNo % pagesPerGroup > 0) { totalGroupNo += 1; }
		
		// 현제 그룹 번호, 시작 페이지 번호, 끝 페이지 번호
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		// 현재 페이지 게시물 리스트
		List<Board> list = boardService.getPage(pageNo, rowsPerPage);
		
		// view로 넘길 데이터
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
//		model.addAttribute("pageNo", pageNo);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("/board/writeForm")
	public ModelAndView writeForm() {
		logger.info("writeForm()");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/writeForm");
		return mav;
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String write() {
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	/*public String write(String title, String writer, String content, @RequestParam(defaultValue="") MultipartFile attach, HttpSession session) {*/
	public String write(Board board, HttpSession session) {
		logger.info("write()");
		String dirPath = null;
		String originalFileName = null;
		String filesystemName = null;
		String contentType = null;
		if(!board.getAttach().isEmpty()) {
			// 파일 정보 얻기
			ServletContext application = session.getServletContext();
			dirPath = application.getRealPath("/resources/uploadfiles");
			originalFileName = board.getAttach().getOriginalFilename();
			filesystemName = System.currentTimeMillis() + "-" + originalFileName;
			contentType = board.getAttach().getContentType();
			
			// 파일 저장하기
			try {
				board.getAttach().transferTo(new File(dirPath + "/" + filesystemName));
			} catch (Exception e) {	e.printStackTrace(); }
			
		}
		
		// 데이터 베이스에 저장
		if(!board.getAttach().isEmpty()) {
			board.setOriginalFileName(originalFileName);
			board.setFilesystemName(filesystemName);
			board.setContentType(contentType);
		}
		boardService.add(board);
		
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/updateForm")
	public String updateForm(@RequestParam("bno") int boardNo, Model model) {
		logger.info("updateForm()");
		
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);
		
		return "board/updateForm";
	}
	
	@RequestMapping("/board/update")
	public String update(Board board, Model model) {
		logger.info("update()");
		
		boardService.modify(board);
		
		return "redirect:/board/detail?boardNo=" + board.getNo();
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView detail(int boardNo) {
		logger.info("detail()");
		ModelAndView mav = new ModelAndView();
		boardService.addHitcount(boardNo);
		Board board = boardService.getBoard(boardNo);
		mav.addObject("board", board);
		mav.setViewName("board/detail");
		
		return mav;
	}
	
	@RequestMapping("/board/delete/{boardNo}")
	public String delete(@PathVariable int boardNo) {
		logger.info("delete()");
		
		boardService.remove(boardNo);
		
		return "redirect:/board/list";
	}
}
