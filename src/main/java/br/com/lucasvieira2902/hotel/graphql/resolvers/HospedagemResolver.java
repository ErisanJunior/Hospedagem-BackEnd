package br.com.lucasvieira2902.hotel.graphql.resolvers;

import br.com.lucasvieira2902.hotel.controllers.HospedagemController;
import br.com.lucasvieira2902.hotel.models.Hospedagem;
import br.com.lucasvieira2902.hotel.models.Hospede;
import br.com.lucasvieira2902.hotel.services.HospedeService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HospedagemResolver implements GraphQLResolver<Hospedagem> {
    @Autowired
    HospedeService hospedeService;

    @Autowired
    HospedagemController hospedagemController;

    public Hospede hospede(Hospedagem h){
        return hospedeService.findById(h.getHospede().getId());
    }

    public Double valorUltimaHospedagem(Hospedagem h){
        return hospedagemController.hospedagem(h.getHospede(), h.getId()).getValorTotalHospedagem();
    }
}
