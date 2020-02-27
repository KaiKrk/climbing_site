package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository des topos
 */
@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

    Topo findById(int theId);
    /**
     * methode qui retourne tous les topos ayant comme auteur le membre avec userId
     * @param userId
     * @return List de topo
     */
    @Query("select topo from Topo topo join topo.member a where a.id = :userId")
    List<Topo> findAllByMemberId(int userId);

    /**
     * methode qui retourne tous les topos ayant comme country et region les parametres
     * @param country
     * @param region
     * @return List de topo
     */
    List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region);

    /**
     * retourne une liste de tous les topos ayant comme statut le parametre
     * @param status
     * @return List de topo
     */
    List<Topo> findAllByTopoStatus(String status);


}
