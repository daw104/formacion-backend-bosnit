package com.example.block11uploaddownloadfiles.demo.Files.controller;

import com.example.block11uploaddownloadfiles.demo.Files.Erros.Request404;
import com.example.block11uploaddownloadfiles.demo.Files.applicaction.FileServiceImpl;

import com.example.block11uploaddownloadfiles.demo.Files.domain.File;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;


@RestController
public class FileController {

    @Autowired
    FileServiceImpl fileService;


    @PostMapping(value = "/upload")
    public ResponseEntity<File> saveFile(MultipartFile archive, ModelMap map) throws Request404, IOException {

        File document = fileService.store(archive);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(document.getNombre())
                .toUriString();

        map.put("downloadurl", fileDownloadUri);

        return new ResponseEntity<>(document, HttpStatus.OK);

    }


    // DESCARGA LA imagen Y MUESTRA SUS metadatos
    @GetMapping(value = "/download-file/{id}")
    public ResponseEntity<File> downloadByIdMetadatos(@PathVariable("id") int id, HttpServletResponse response) throws Request404, IOException {
        File archive = fileService.downloadById(id);
        return new ResponseEntity<>(archive, HttpStatus.OK);
    }



    //DESCARGA LA imagen Y LA MUESTRAM PERO NO SUS metadatos
    @GetMapping(value = "/downloadFile/{id}")
    public ResponseEntity<File> downloadById(@PathVariable("id") int id, HttpServletResponse response) throws Request404, IOException {
        File archive = fileService.downloadById(id);

        response.setHeader("content","filename=\"" + archive.getNombre() + "\"");//
        InputStream ins = new ByteArrayInputStream(archive.getMetadato()); //
        IOUtils.copy(ins, response.getOutputStream());

        return new ResponseEntity<>(archive, HttpStatus.OK);
    }

    //Des
    @GetMapping(value = "downloadFile-nombre/{nombre}")
    public ResponseEntity<File> downloadByNombre(@PathVariable("nombre") String nombre) throws Request404, IOException {
        File archive = fileService.downloadByNombre(nombre);

        return new ResponseEntity<>(archive, HttpStatus.OK);

    }


}
