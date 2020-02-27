package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository des Secteurs
 */
@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {

    Sector findById(int id);
}
