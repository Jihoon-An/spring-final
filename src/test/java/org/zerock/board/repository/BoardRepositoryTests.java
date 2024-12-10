package org.zerock.board.repository;


import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

@SpringBootTest
@EnableJpaAuditing
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;


    @Transactional
    @Test
    public void testGetBoards() {
        List<Board> boards = boardRepository.getBoardsBy("test@email.com");

        Assertions.assertFalse(boards.isEmpty());
    }


    @Transactional
    @Test
    public void testRead1() {
        //조인명령을 활용한다.
        Optional<Board> result = boardRepository.findById(101L); //데이터베이스에 존재하는 번호

        Board board = result.get();

        System.out.println("testRead1()..............");
        System.out.println(board);
        System.out.println(board.getWriter());

    }


}
