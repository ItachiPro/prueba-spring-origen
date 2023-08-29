package com.nasa.prueba.aspirante.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class ItemDto {
  private String href;
  private List<DataDto> data;
  private List<LinkDto> links;
}
