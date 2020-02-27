package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Way;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository des voies
 */
@Repository
public interface WayRepository extends JpaRepository<Way,Integer> {

    Way findById(int id);


}
