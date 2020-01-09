package oc.projet.p6.Service;

import oc.projet.p6.Dao.SectorRepository;
import oc.projet.p6.Entity.Member;
import oc.projet.p6.Entity.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectorServiceImpl implements SectorService{
    @Autowired
    private SectorRepository sectorRepository;

    @Override
    public List<Sector> findAll() {
        return sectorRepository.findAll();
    }

    @Override
    public Sector findById(int theId) {
        Optional<Sector> result = sectorRepository.findById(theId);

       Sector theSector = null;

        if (result.isPresent()) {
            theSector = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find sector id - " + theId);
        }

        return theSector;
    }

    @Override
    public void save(Sector theSector) {
        sectorRepository.save(theSector);
    }



    @Override
    public void deleteById(int theId) {
        sectorRepository.deleteById(theId);
    }

}
