package oc.projet.p6.Service;

import oc.projet.p6.Entity.Comment;

import java.util.List;


public interface CommentService {

    public void save(Comment theComment);

    public void deleteById(int theId);

    List<Comment> findAllByTopo(int topoId);
}
