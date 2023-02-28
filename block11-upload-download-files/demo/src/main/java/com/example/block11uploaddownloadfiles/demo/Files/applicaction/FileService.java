package com.example.block11uploaddownloadfiles.demo.Files.applicaction;

import com.example.block11uploaddownloadfiles.demo.Files.Erros.Request404;
import com.example.block11uploaddownloadfiles.demo.Files.domain.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public interface FileService {


      File store(MultipartFile archive) throws Request404, IOException;

      File downloadByIdMetadatos(int id) throws Request404, IOException; //MUESTRA METADATOS, SOLO IMAGEN

      File downloadById(int id) throws Request404, IOException; //NO MUESTRA METADATOS, SOLO IMAGEN

      File downloadByNombre(String nombre) throws Request404, IOException;






}
