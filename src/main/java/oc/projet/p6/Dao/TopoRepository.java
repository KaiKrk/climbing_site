package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

    @Query("select topo from Topo topo join topo.member a where a.id = :userId")
    public List<Topo> findAllByMemberId(int userId);

    public List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region);

    public List<Topo> findAllByTopoStatus(String status);

//    @Query("Select Topo from Reservation R left join fetch R")
//    List<Topo> findReservatedTopo();

}
