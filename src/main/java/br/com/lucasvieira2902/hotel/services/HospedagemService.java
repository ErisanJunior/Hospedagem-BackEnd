package br.com.lucasvieira2902.hotel.services;

import br.com.lucasvieira2902.hotel.models.Hospedagem;
import br.com.lucasvieira2902.hotel.models.Hospede;
import br.com.lucasvieira2902.hotel.repositories.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository rep;

    public Hospedagem findById(Long id){
        return rep.findById(id).orElse(null);
    }

    public List<Hospedagem> findAll(){
        return rep.findAll();
    }

    @Transactional
    public Hospedagem save(Hospedagem h){
        return rep.save(h);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if(rep.findById(id).isPresent()){
            rep.deleteById(id);
            return true;
        }
        return false;
    }

    public Hospedagem findByHospede(Hospede h, Long hospedagemId) {
        return rep.findFirstByHospedeAndDataSaidaNotNullAndIdNotOrderByIdDesc(h, hospedagemId);
    }
}
