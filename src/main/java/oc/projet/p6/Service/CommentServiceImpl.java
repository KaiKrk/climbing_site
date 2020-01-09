package oc.projet.p6.Service;

import oc.projet.p6.Dao.CommentRepository;
import oc.projet.p6.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

//    @Override
//    public List<Comment> findById(int theId) {
//        return commentRepository.findById(theId);
//    }

    @Override
    public List<Comment> findById(int theId) {
        return null;
        // find by id of topo not of comment
    }

    @Override
    public void save(Comment theComment) {
    commentRepository.save(theComment);
    }

    @Override
    public void deleteById(int theId) {
        commentRepository.deleteById(theId);

    }
}
