package org.zerock.board.controller;


import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list/{email}")
    public String list(@PathVariable String email, Model model) {
        log.info("list");
        List<BoardDTO> boards = boardService.getListBy(email);
        model.addAttribute("boards", boards);

        return "/board/list";
    }

    @GetMapping("/register")
    public void register() {
        log.info("regiser get...");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {

        log.info("dto..." + dto);
        //새로 추가된 엔티티의 번호
        Long bno = boardService.register(dto);

        log.info("BNO: " + bno);

        redirectAttributes.addFlashAttribute("msg", bno);

        return "redirect:/board/list";
    }


}
