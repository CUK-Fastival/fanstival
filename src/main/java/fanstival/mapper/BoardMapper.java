package fanstival.mapper;

import fanstival.domain.Board;

import java.util.List;

public interface BoardMapper {
    List<Board> getBoards(String board_id);

    Board getBoardById(String board_id);

    void createBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(String board_id);
}
