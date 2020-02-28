package oc.projet.p6.Service;

import oc.projet.p6.Entity.Topo;

import java.util.List;

public interface TopoService {


    List<Topo> findAll();

    Topo findById(int theId);

    void save(Topo theTopo);

    List<Topo> findAllByMemberId(int userId);

    List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region);

    List<Topo> findAllByTopoStatus(String status);

    void changeAvaibility(Topo topo, String status);

    boolean isConnectedMemberTheAuthor(int topoId);
}
