package oc.projet.p6.Service;

import oc.projet.p6.Dao.CommentRepository;
import oc.projet.p6.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Classe Service des commentaires
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    /**
     * methode qui retourne le commentaire selon l'id
     * @param id
     * @return comment
     */
    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    /**
     * methode qui insert dans la bdd le commentaire
     * @param theComment
     */
    @Override
    public void save(Comment theComment) {
    commentRepository.save(theComment);
    }

    /**
     * methode qui supprime un commentaire de la bdd
     * @param theId
     */
    @Override
    public void deleteById(int theId) {
        commentRepository.deleteById(theId);

    }

    /**
     * methode qui retourne tous les commentaire assoscié au topo
     * @param topoId
     * @return
     */
    @Override
    public List<Comment> findAllByTopo(int topoId) {
        return commentRepository.findAllByTopo(topoId);
    }
}
