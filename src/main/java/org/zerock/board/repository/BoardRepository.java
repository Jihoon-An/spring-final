package org.zerock.board.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b from Board b left join b.writer w where w.email = :email")
    List<Board> getBoardsBy(@Param("email") String email);
}
