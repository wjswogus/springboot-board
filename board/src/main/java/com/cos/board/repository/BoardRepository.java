package com.cos.board.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.board.model.Board;


//자동 IoC 등록됨
public interface BoardRepository extends JpaRepository<Board, Integer> {
	//public abstract 생략
	
	@Query(value = "select * from board where id = :id", nativeQuery = true)
	Board mFindById(int id);

	@Modifying
	@Query(value = "delete from board where id = :id", nativeQuery = true)
	int mDeleteById(int id);
}
