package oc.projet.p6.Service;

import oc.projet.p6.Dao.TopoFileRepository;
import oc.projet.p6.Entity.TopoFile;
import oc.projet.p6.exception.FileStorageException;
import oc.projet.p6.exception.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TopoFileStorageService {

    @Autowired
    private TopoFileRepository topoFileRepository;

    public TopoFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            TopoFile topoFile = new TopoFile(fileName, file.getContentType(), file.getBytes());

            return topoFileRepository.save(topoFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public TopoFile getFile(String fileId) {
        return topoFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
