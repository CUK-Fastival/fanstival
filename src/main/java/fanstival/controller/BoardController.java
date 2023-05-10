package fanstival.controller;

import fanstival.domain.Account;
import fanstival.domain.Board;
import fanstival.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시글 목록 조회
    @GetMapping("/list")
    public String boardList(Model model, HttpSession session) {
        Account account = (Account) session.getAttribute("user");
        if (account == null) {
            return "redirect:/login";
        }
        List<Board> boardList = boardService.getAllBoards();
        model.addAttribute("boardList", boardList);
        return "board/BoardList.jsp";
    }

    @GetMapping("/write")
    public String boardCreateForm(Model model) {
        System.out.println("작동 성공");
        model.addAttribute("board", new Board());
        System.out.println("이동 성공");
        return "board/BoardForm.jsp";
    }

    @PostMapping("/write")
    public String boardCreate(@ModelAttribute Board board, HttpSession session) {
        Account account = (Account) session.getAttribute("user");
        board.setWriter(account.getUser_id());
        boardService.createBoard(board);
        System.out.println("게시물 생성 성공");
        return "redirect:/board/list";
    }

    // 게시글 수정 페이지 이동
    @GetMapping("/update/{board_id}")
    public String boardUpdateForm(@PathVariable int board_id, Model model) {
        Board board = boardService.getBoardById(board_id);
        model.addAttribute("board", board);
        return "board/update";
    }

    // 게시글 수정 처리
    @PostMapping("/update/{board_id}")
    public String boardUpdate(@PathVariable int board_id, @ModelAttribute Board board) {
        board.setBoard_id(board_id); // 수정할 게시글의 id 설정
        boardService.updateBoard(board);
        System.out.println("게시물 수정 성공");
        return "redirect:/board/list";
    }

    // 게시글 삭제 처리
    @GetMapping("/delete/{board_id}")
    public String boardDelete(@PathVariable int board_id) {
        boardService.deleteBoard(board_id);
        System.out.println("게시물 삭제 성공");
        return "redirect:/board/list";
    }

    // 게시글 상세보기
    @GetMapping("/{board_id}")
    public String boardDetail(@PathVariable int board_id, Model model) {
        Board board = boardService.getBoardById(board_id);
        model.addAttribute("board", board);
        return "board/detail";
    }
}
