package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {
}
