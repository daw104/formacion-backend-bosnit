package com.example.block11uploaddownloadfiles.demo.Files.applicaction;

import com.example.block11uploaddownloadfiles.demo.Files.Erros.Request404;
import com.example.block11uploaddownloadfiles.demo.Files.domain.File;
import com.example.block11uploaddownloadfiles.demo.Files.repository.FileRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.PresentationDirection;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Files;


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;


    public File store(MultipartFile archive) throws Request404, IOException {
        File myfile = new File();


        if ((fileRepository.findByNombre(archive.getOriginalFilename()) != null)) {
            throw new Request404("El fichero con nombre " + archive.getOriginalFilename() + " ya existe, intenta con otro nombre");
        }

        myfile.setNombre(archive.getOriginalFilename());
        myfile.setTipo(archive.getContentType());
        myfile.setMetadato(archive.getBytes());

        return fileRepository.save(myfile);

    }



    //DESCARGAR MUESTRA METADATOS
    public File downloadByIdMetadatos(int id) throws Request404, IOException {
        File myFile = fileRepository.findById(id).orElseThrow(() -> new Request404("\nNo existe el file con el id " + id)); // id de la imagen

        String ruta = "./descargas/";

        new java.io.File(ruta).mkdirs(); //hago ruta

        OutputStream os = new FileOutputStream(ruta + myFile.getNombre());

        os.write(myFile.getMetadato());
        os.close();
        return myFile;
    }





    //DESCARGAR LA IMAGEN SIN MOSTRAD METADATOS
    public File downloadById(int id) throws Request404, IOException {
        File myFile = fileRepository.findById(id).orElseThrow(() -> new Request404("\nNo existe el file con el id " + id)); // id de la imagen


        String ruta = "./descargas/";

        new java.io.File(ruta).mkdirs(); //hago ruta

        OutputStream os = new FileOutputStream(ruta + myFile.getNombre());

        os.write(myFile.getMetadato());
        os.close();
        return myFile;
    }


    public File downloadByNombre(String nombre) throws Request404, IOException {
        File myFile = fileRepository.findByNombre(nombre);

        if ((fileRepository.findByNombre(myFile.getNombre()) == null)) {
            throw new Request404("El fichero con nombre " + myFile + " no existe en nuestros registros, intenta con otro nombre");
        }

        String ruta = "./descargas/";

        new java.io.File(ruta).mkdirs(); //hago ruta

        OutputStream os = new FileOutputStream(ruta + myFile.getNombre());

        os.write(myFile.getMetadato());
        os.close();
        return myFile;

    }






}
