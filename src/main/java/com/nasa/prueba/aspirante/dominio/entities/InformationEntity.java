package com.nasa.prueba.aspirante.dominio.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "information")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class InformationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "href")
  private String href;
  @Column(name = "center")
  private String center;
  @Column(name = "title")
  private String title;
  @Column(name = "nasa_id")
  private String nasaId;
  @Column(name = "created_at")
  private String createdAt;
}
