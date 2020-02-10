package oc.projet.p6.Service;

import oc.projet.p6.Entity.Topo;

import java.util.List;

public interface TopoService {


    public List<Topo> findAll();

    public Topo findById(int theId);

    public void save(Topo theTopo);

    public void deleteById(int theId);

    public List<Topo> findAllByMemberId(int userId);

    public List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region);

    public List<Topo> findAllByTopoStatus(String status);

    public List<Topo> findAllTopos();
}
