package com.example.block11uploaddownloadfiles.demo.Files.repository;

import com.example.block11uploaddownloadfiles.demo.Files.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {

    File findByNombre(String nombre_fichero);

    File findByTipo(String tipo);


}
