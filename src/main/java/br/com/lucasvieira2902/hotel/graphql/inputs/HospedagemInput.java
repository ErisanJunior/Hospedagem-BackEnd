package br.com.lucasvieira2902.hotel.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospedagemInput implements Serializable {

    private Long id;
    private String dataEntrada;
    private String dataSaida;
    private Boolean adicionaVeiculo;
    private Long hospedeId;
}
