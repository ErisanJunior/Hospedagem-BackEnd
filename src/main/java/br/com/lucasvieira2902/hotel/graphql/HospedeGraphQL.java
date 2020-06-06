package br.com.lucasvieira2902.hotel.graphql;

import br.com.lucasvieira2902.hotel.controllers.HospedeController;
import br.com.lucasvieira2902.hotel.graphql.inputs.HospedeInput;
import br.com.lucasvieira2902.hotel.models.Hospede;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospedeGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private HospedeController controller;

    public Hospede hospede(Long id){
        return controller.hospede(id);
    }

    public List<Hospede> getHospedes(){
        return controller.getHospedes();
    }

    public Hospede saveHospede(HospedeInput input){
        return controller.saveHospede(input);
    }

    public Boolean deleteHospede(Long id){
        return controller.deleteHospede(id);
    }
}
