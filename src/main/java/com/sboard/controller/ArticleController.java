package com.sboard.controller;

import com.sboard.config.AppInfo;
import com.sboard.dto.ArticleDTO;
import com.sboard.service.ArticleService;
import com.sboard.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final FileService fileService;


    @GetMapping("/article/list")
    public String list(){

        return "/article/list";
    }

    @GetMapping("/article/write")
    public String write(){

        return "/article/write";
    }

    @PostMapping("/article/write")
    public String write(ArticleDTO articleDTO, HttpServletRequest req){
        String regip = req.getRemoteAddr();
        articleDTO.setRegip(regip);
        log.info(articleDTO);

        // 파일 업로드
        fileService.uploadFile(articleDTO);

        // 글 저장
        articleService.insertArticle(articleDTO);

        return "redirect:/article/list";
    }


    @GetMapping("/article/view")
    public String view(){
        return "/article/view";
    }

    @GetMapping("/article/modify")
    public String modify(){
        return "/article/modify";
    }
}
