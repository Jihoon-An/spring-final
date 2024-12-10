package org.zerock.board.service;


import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.repository.BoardRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;

    @Override
    public Long register(BoardDTO dto) {

        log.info(dto);

        Board board = dtoToEntity(dto);

        repository.save(board);

        return board.getBno();
    }

    @Override
    public List<BoardDTO> getListBy(String email) {
        return repository
            .getBoardsBy(email)
            .stream()
            .map(board ->
                entityToDTO(board, board.getWriter(), 0L)
            ).collect(Collectors.toList());
    }
};
