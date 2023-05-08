package fanstival.mapper;

import fanstival.domain.Board;

import java.util.List;

public interface BoardMapper {

    public List<Board> getAllBoards();

    public void createBoard(Board board);

    public void updateBoard(Board board);

    public void deleteBoard(int board_id);

    public Board getBoardById(int board_id);

}
