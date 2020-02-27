package oc.projet.p6.Service;

import oc.projet.p6.Dao.TopoRepository;
import oc.projet.p6.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Classe Service des Topos
 */
@Service
public class TopoServiceImpl implements TopoService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private TopoRepository topoRepository;

    /**
     * Methode qui retourne tous les topos
     * @return List de tous les topos
     */
    @Override
    public List<Topo> findAll() {
        return topoRepository.findAll();
    }

    /**
     * methode qui retourne un topo selon son id
     * @param theId
     * @return
     */
    @Override
    public Topo findById(int theId) {
        Topo theTopo = topoRepository.findById(theId);
        return theTopo;
    }

    /**
     * methode qui insert ou update un topo en bdd
     * @param theTopo
     */
    @Override
    public void save(Topo theTopo) { topoRepository.save(theTopo);

    }

    /**
     * methode qui retourne tous les topos d'un utilisateur
     * @param userId
     * @return
     */
    @Override
    public List<Topo> findAllByMemberId(int userId){ return topoRepository.findAllByMemberId(userId);

    }

    /**
     * methode qui retourne tous les topos ayant comme country et region les parametres
     * @param country
     * @param region
     * @return
     */
    public List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region) {
        return topoRepository.findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(country, region);}

    /**
     * methode qui retourne une list de topo selon son statut
     * @param status
     * @return
     */
    @Override
    public List<Topo> findAllByTopoStatus(String status) {
        return topoRepository.findAllByTopoStatus(status);
    }


    @Override
    public void changeAvaibility(Topo topo,String status) {
        topo.setTopoStatus(status);
    }

    @Override
    public boolean isConnectedMemberTheAuthor(int topoId) {
        Topo topo = topoRepository.findById(topoId);
        if (topo.getMember().getEmail().equals(SecurityContextHolder.getContext().getAuthentication().getName())){
            return true;
        }else {
            return false;
        }
    }
}
