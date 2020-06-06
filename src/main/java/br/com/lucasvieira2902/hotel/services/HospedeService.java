package br.com.lucasvieira2902.hotel.services;

import br.com.lucasvieira2902.hotel.models.Hospede;
import br.com.lucasvieira2902.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospedeService {
    @Autowired
    private HospedeRepository rep;

    public Hospede findById(Long id){
        return rep.findById(id).orElse(null);
    }

    public List<Hospede> findAll(){
        return rep.findAll();
    }

    @Transactional
    public Hospede save(Hospede h){
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
}
