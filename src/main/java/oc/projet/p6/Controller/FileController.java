package oc.projet.p6.Controller;

import oc.projet.p6.Entity.TopoFile;
import oc.projet.p6.Service.TopoFileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Classe Controller des fichiers de topo
 */
@Controller
public class FileController {


     Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private TopoFileStorageService topoFileStorageService;

    /**
     * methode qui insert dans la bdd le fichier d'un topo
     * @param file
     * @param id
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, int id) throws IOException {
            topoFileStorageService.storeFile(file, id);
            logger.info("File Uploaded :" + file.getName());
        return "redirect:/topo/myTopoDetail?id=" + id ;

    }

    /**
     * methode qui telecharge le fichier d'un topo
     * @param id
     * @return
     */
    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam int id) {
        TopoFile dbFile = topoFileStorageService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

}
