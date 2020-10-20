package com.cos.board.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;
import com.cos.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm";
	}
	
	@PostMapping("/save")
	public String save(BoardSaveRequestDto dto) {
		boardService.글쓰기(dto);
			
		return "redirect:/list";
	}
	
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "updateForm";
	}
	
	@GetMapping({"","/","/list"})
	public String list(Model model, @PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {
		
		model.addAttribute("boards", boardService.글목록보기(pageable));
		return "list";
	}
	
	@GetMapping("/list/test")
	@ResponseBody
	public Page<Board> listTest(
			@PageableDefault(size = 5, sort = "id", direction = Direction.DESC) Pageable pageable) {
		return boardService.글목록보기(pageable);
	}
	
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) throws Exception {
//		Board board = boardRepository.findById(id).orElse(new Board());
//		Board board = boardRepository.findById(id).orElseGet(() -> new Board());
//		Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("다른 값이 들어왔음"));
	
		model.addAttribute("board", boardService.글상세보기(id));
		return "detail";
	}
	
	@DeleteMapping("/board/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		boardService.글삭제하기(id);
		return "ok";
	}
	
	@PutMapping("/board/{id}")
	@ResponseBody
	public String update(@PathVariable int id, @RequestBody BoardSaveRequestDto dto) {
		boardService.글수정하기(id, dto);
		return "ok";
	}
}
