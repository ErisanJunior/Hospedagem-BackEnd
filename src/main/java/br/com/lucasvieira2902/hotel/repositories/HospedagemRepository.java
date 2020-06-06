package br.com.lucasvieira2902.hotel.repositories;

import br.com.lucasvieira2902.hotel.models.Hospedagem;
import br.com.lucasvieira2902.hotel.models.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem,Long> {

    Hospedagem findFirstByHospedeAndDataSaidaNotNullAndIdNotOrderByIdDesc(Hospede id, Long Id);
}
