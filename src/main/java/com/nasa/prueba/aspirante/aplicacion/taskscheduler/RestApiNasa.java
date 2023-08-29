package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import com.nasa.prueba.aspirante.dominio.dto.InformationResponseDto;
import com.nasa.prueba.aspirante.dominio.entities.InformationEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
public class RestApiNasa {
  private final InformationRepository informationRepository;

  public RestApiNasa(InformationRepository informationRepository){
    this.informationRepository = informationRepository;
  }
  @Scheduled(fixedRate = 60000)
  private void getNasaInformation(){
    String uri = "https://images-api.nasa.gov/search?q=apollo 2011";
    RestTemplate restTemplate = new RestTemplate();
    InformationResponseDto information = restTemplate.getForObject(uri, InformationResponseDto.class);
    LocalDate date = LocalDate.now();
    InformationEntity info = InformationEntity.builder()
            .href(information.getCollection().getHref())
            .center(information.getCollection().getItems().get(0).getData().get(0).getCenter())
            .title(information.getCollection().getItems().get(0).getData().get(0).getTitle())
            .nasaId(information.getCollection().getItems().get(0).getData().get(0).getNasa_id())
            .createdAt(date.toString()).build();
    informationRepository.save(info);
  }
}
