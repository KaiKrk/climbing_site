package oc.projet.p6.Service;

import oc.projet.p6.Dao.CommentRepository;
import oc.projet.p6.Dao.SectorRepository;
import oc.projet.p6.Dao.TopoRepository;
import oc.projet.p6.Dao.WayRepository;
import oc.projet.p6.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TopoServiceImpl implements TopoService {

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
}
