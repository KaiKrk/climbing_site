package oc.projet.p6.Service;

import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Topo;

import java.util.List;

public interface TopoService {



    public List<Topo> findAll();

    public Topo findById(int theId);

    public void save(Topo theTopo);

    public List<Topo> findAllByMemberId(int userId);

    public List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region);

    public List<Topo> findAllByTopoStatus(String status);

    public void changeAvaibility (Topo topo, String status);

    boolean isConnectedMemberTheAuthor(int topoId);
}
