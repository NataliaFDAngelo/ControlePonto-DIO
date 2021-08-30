package br.com.dio.ponto.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Ocorrencia {

    @Id
    private Long id;

    private String nome;

    private String descricao;

}
