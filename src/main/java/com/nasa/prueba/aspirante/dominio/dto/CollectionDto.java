package com.nasa.prueba.aspirante.dominio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CollectionDto {
  private String version;
  private String href;
  private List<ItemDto> items;
  private MetadataDto metadata;
}
