package oc.projet.p6.Service;

import oc.projet.p6.Dao.WayRepository;
import oc.projet.p6.Entity.Topo;
import oc.projet.p6.Entity.Way;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayServiceImpl implements WayService {

    @Autowired
    private WayRepository wayRepository;


    @Override
    public Way findById(int theId) {
        return null;// return a list way according to topo_id
    }

    @Override
    public void save(Way theWay) {
    wayRepository.save(theWay);
    }

    @Override
    public void deleteById(int theId) { wayRepository.deleteById(theId);

    }

    @Override
    public boolean isConnectedMemberTheAuthor(int id) {
        Way way = wayRepository.findById(id);
        if (way.getSector().getTopo().getMember().getEmail().equals(SecurityContextHolder.getContext().getAuthentication().getName())){
            return true;
        }else {
            return false;
        }
    }
}
