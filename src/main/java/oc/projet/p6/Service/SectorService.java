package oc.projet.p6.Service;

import oc.projet.p6.Entity.Sector;

import java.util.List;

public interface SectorService {

    Sector findById(int theId);

    void save(Sector theSector);

    boolean isConnectedMemberTheAuthor(int sectorId);


}
