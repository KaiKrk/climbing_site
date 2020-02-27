package oc.projet.p6.Service;

import oc.projet.p6.Entity.Comment;

import java.util.List;


public interface CommentService {

    Comment findById(int id);

    void save(Comment theComment);

    void deleteById(int theId);

    List<Comment> findAllByTopo(int topoId);
}
