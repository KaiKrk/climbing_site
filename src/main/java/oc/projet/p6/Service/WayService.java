package oc.projet.p6.Service;

import oc.projet.p6.Entity.Way;

import java.util.List;

public interface WayService {

    public Way findById(int theId);

    public void save(Way theWay);

    public void deleteById(int theId);

    boolean isConnectedMemberTheAuthor(int id);
}
