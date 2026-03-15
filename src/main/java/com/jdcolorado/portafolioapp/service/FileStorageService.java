package com.jdcolorado.portafolioapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String upLoadDir;

    public String storeFile(MultipartFile file) throws IOException {

        if(file.isEmpty()){
            throw new IOException("El archivo esta vacio");
        }

        String originalFilename = file.getOriginalFilename();
        String extension = "";

        if(originalFilename != null) {
            int dotIndex = originalFilename.lastIndexOf('.');

            if(dotIndex > 0){
                extension = originalFilename.substring(dotIndex);
            }
        }

        String fileName = UUID.randomUUID() + extension;

        Path filePath = Paths.get(upLoadDir, fileName).normalize();

        Files.copy(file.getInputStream(), filePath);

        return "/img/projects/" + fileName;
    }
}
