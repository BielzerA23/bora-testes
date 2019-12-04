package com.example.img.upload.demoigmupload.model;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
public class Endereco {

    private String rua;

    private String numero;

    private String cep;

    private String bairro;

    private Long latitude;

    private Long longitude;

}
