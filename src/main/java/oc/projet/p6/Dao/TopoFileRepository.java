package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Topo;
import oc.projet.p6.Entity.TopoFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository des fichiers de topo
 */
@Repository
public interface TopoFileRepository extends JpaRepository<TopoFile, String> {


    /**
     * methode qui retourne le fichier lie au topo si il y en a
     * @param topo
     * @return
     */
     TopoFile findByTopo(Topo topo);
}
