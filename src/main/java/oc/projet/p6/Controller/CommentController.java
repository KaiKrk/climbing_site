package oc.projet.p6.Controller;

import oc.projet.p6.Entity.Comment;
import oc.projet.p6.Service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller de l'entite comment
 */
@Controller
@RequestMapping("/comments")
public class CommentController {
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    CommentService commentService;

    /**
     * methode qui insert ou update un commentaire
     * @param comment
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute Comment comment ){
        commentService.save(comment);
        int id = comment.getTopo().getId();

        logger.info("comment save : " + comment);

        return "redirect:/topo/detail?id=" + id;
    }

    /**
     * methode qui retourne une form de l'entite commentaire
     * @param theModel
     * @param commentId
     * @return
     */
    @GetMapping("/update")
    public String update(Model theModel, int commentId){
       Comment comment =  commentService.findById(commentId);
       theModel.addAttribute("comment", comment);
       return "forms/comment-form";
    }

    @GetMapping("/delete")
    public String  delete(int id, int topoId){
        commentService.deleteById(id);
        return "redirect:/topo/detail?id=" + topoId;
    }

}
