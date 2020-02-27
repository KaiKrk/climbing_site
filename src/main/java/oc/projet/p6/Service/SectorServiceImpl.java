package oc.projet.p6.Service;

import oc.projet.p6.Dao.SectorRepository;
import oc.projet.p6.Entity.Sector;
import oc.projet.p6.Entity.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe Service des secteurs
 */
@Service
public class SectorServiceImpl implements SectorService{

    @Autowired
    private SectorRepository sectorRepository;

    /**
     * methode qui retourne un secteur selon son id
     * @param theId
     * @return
     */
    @Override
    public Sector findById(int theId) {
        Sector theSector = sectorRepository.findById(theId);
        return theSector;
    }

    /**
     * methode qui insert ou update un secteur en bdd
     * @param theSector
     */
    @Override
    public void save(Sector theSector) {
        sectorRepository.save(theSector);
    }

    @Override
    public boolean isConnectedMemberTheAuthor(int sectorId) {
        Sector secteur = sectorRepository.findById(sectorId);
        if (secteur.getTopo().getMember().getEmail().equals(SecurityContextHolder.getContext().getAuthentication().getName())){
            return true;
        }else {
            return false;
        }
    }

}
