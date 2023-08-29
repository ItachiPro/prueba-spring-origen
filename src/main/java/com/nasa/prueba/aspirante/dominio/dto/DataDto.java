package com.nasa.prueba.aspirante.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DataDto {
  private String center;
  private String title;
  private List<String> keywords;
  private String nasa_id;
  private String date_created;
  private String media_type;
  private String description;
}
