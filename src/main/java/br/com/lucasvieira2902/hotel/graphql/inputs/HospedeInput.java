package br.com.lucasvieira2902.hotel.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospedeInput implements Serializable {

    private Long id;
    private String nome;
    private String dataEntrada;
    private String dataSaida;
    private String documento;
    private String telefone;
}
