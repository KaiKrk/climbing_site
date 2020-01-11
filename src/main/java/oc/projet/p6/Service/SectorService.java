package oc.projet.p6.Service;

import oc.projet.p6.Entity.Sector;

import java.util.List;

public interface SectorService {

    public Sector findById(int theId);

    public void save(Sector theSector);

    public void deleteById(int theId);
}
