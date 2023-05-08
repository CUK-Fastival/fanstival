package fanstival.service;

import fanstival.domain.Board;
import fanstival.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public List<Board> getAllBoards() {
        return boardMapper.getAllBoards();
    }

    public void createBoard(Board board) {
        boardMapper.createBoard(board);
    }

    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(int board_id) {
        boardMapper.deleteBoard(board_id);
    }

    public Board getBoardById(int board_id) {
        return boardMapper.getBoardById(board_id);
    }
}

