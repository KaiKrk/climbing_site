package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository des Commentaires
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query("select comment from Comment comment join comment.topo topo where topo.id = :topoId")
    List<Comment> findAllByTopo(int topoId);

    Comment findById(int id);
}
