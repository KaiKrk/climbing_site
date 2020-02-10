package oc.projet.p6.Dao;

import oc.projet.p6.Entity.TopoFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopoFileRepository extends JpaRepository<TopoFile, String> {

}
