package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import com.nasa.prueba.aspirante.dominio.entities.InformationEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.InformationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TestRestController {
  private final InformationRepository informationRepository;

  public TestRestController(InformationRepository informationRepository){
    this.informationRepository = informationRepository;
  }
  @GetMapping("/get-all")
  public ResponseEntity<List<InformationEntity>> getInformation(){
    List<InformationEntity> information = informationRepository.findAll();
    return new ResponseEntity<>(information, HttpStatus.OK);
  }
}
