package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Comment;
import oc.projet.p6.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("save")
    public String save(@ModelAttribute Comment comment){

        commentService.save(comment);
        return "redirect:/topo/list";
    }

}
