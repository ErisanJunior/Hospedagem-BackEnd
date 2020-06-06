package br.com.lucasvieira2902.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hospede implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String documento;
    private String telefone;

//    @OneToMany(mappedBy = "checkIns", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<CheckIn> checkIns;
}
