package br.com.lucasvieira2902.hotel.controllers;

import br.com.lucasvieira2902.hotel.graphql.inputs.HospedeInput;
import br.com.lucasvieira2902.hotel.models.Hospede;
import br.com.lucasvieira2902.hotel.services.HospedeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HospedeController {
    @Autowired
    private HospedeService serv;

    public Hospede hospede(Long id){
        return serv.findById(id);
    }

    public List<Hospede> getHospedes(){
        return serv.findAll();
    }

    public Hospede saveHospede(HospedeInput input){
        ModelMapper m = new ModelMapper();
        Hospede h = m.map(input, Hospede.class);
        return serv.save(h);
    }

    public Boolean deleteHospede(Long id){
        return serv.deleteById(id);
    }
}
