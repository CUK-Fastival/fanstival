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
        return "board/list";
    }

    // 게시글 생성 페이지 이동
    @GetMapping("/create")
    public String boardCreateForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/create";
    }


    // 게시글 생성 처리
    @PostMapping("/create")
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
    @PostMapping("/update")
    public String boardUpdate(@ModelAttribute Board board) {
        boardService.updateBoard(board);
        System.out.println("게시물 수정 성공");
        return "redirect:/board/list";
    }

    // 게시글 삭제 처리
    @RequestMapping(value = "/delete/{board_id}", method = RequestMethod.DELETE)
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
