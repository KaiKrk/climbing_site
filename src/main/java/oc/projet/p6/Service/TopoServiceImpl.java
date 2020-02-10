package oc.projet.p6.Service;

import oc.projet.p6.Dao.TopoRepository;
import oc.projet.p6.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
@Service
public class TopoServiceImpl implements TopoService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private TopoRepository topoRepository;
    @Override
    public List<Topo> findAll() {
        return topoRepository.findAll();
    }


    @Override
    public Topo findById(int theId) {
        Optional<Topo> resultTopo = topoRepository.findById(theId);
        Topo theTopo = null;
        if (resultTopo.isPresent()) {
            theTopo = resultTopo.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find member id - " + theId);
        }
        return theTopo;
    }

    @Override
    public void save(Topo theTopo) { topoRepository.save(theTopo);

    }

    @Override
    public void deleteById(int theId) { topoRepository.deleteById(theId);

    }

//    @Override
//    public List<Topo> findByUser(int userId) {
//        Query results =  entityManager.createQuery("From Topo t where t.user_id = '" + userId +"'");
//        List topoResults = results.getResultList();
//        List<Topo> topos = topoResults;
//        System.out.println(results);
//        return topos;
//    }
    @Override
    public List<Topo> findAllByMemberId(int userId){ return topoRepository.findAllByMemberId(userId);

    }

    public List<Topo> findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(String country, String region) {
        return topoRepository.findAllByCountryIgnoreCaseContainingAndRegionIgnoreCaseContaining(country, region);}

    @Override
    public List<Topo> findAllByTopoStatus(String status) {
        return topoRepository.findAllByTopoStatus(status);
    }

    @Override
    public List<Topo> findAllTopos() {
        return topoRepository.findAllTopos();
    }
}
