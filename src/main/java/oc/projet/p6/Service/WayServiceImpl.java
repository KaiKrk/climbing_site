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
    public void save(Way theWay) {
    wayRepository.save(theWay);
    }


}
