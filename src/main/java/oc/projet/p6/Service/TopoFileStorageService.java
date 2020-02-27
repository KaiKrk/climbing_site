package oc.projet.p6.Service;

import oc.projet.p6.Dao.TopoFileRepository;
import oc.projet.p6.Entity.Topo;
import oc.projet.p6.Entity.TopoFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Classe Service de TopoFile
 */
@Service
public class TopoFileStorageService {

    @Autowired
    private TopoFileRepository topoFileRepository;

    @Autowired
    private TopoService topoService;

    /**
     * methode qui insert un fichier d'un topo
     * @param file
     * @param topoId
     * @throws IOException
     */
    public void storeFile(MultipartFile file, int topoId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Topo theTopo = topoService.findById(topoId);
            TopoFile topoFile = new TopoFile(fileName, file.getContentType(), theTopo, file.getBytes());
            topoFileRepository.save(topoFile);
    }

    public TopoFile getFile(int topoId) {
        Topo theTopo =  topoService.findById(topoId);
        return topoFileRepository.findByTopo(theTopo);
    }
}
