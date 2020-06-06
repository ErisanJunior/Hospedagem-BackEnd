package br.com.lucasvieira2902.hotel.graphql;

import br.com.lucasvieira2902.hotel.controllers.HospedagemController;
import br.com.lucasvieira2902.hotel.graphql.inputs.HospedagemInput;
import br.com.lucasvieira2902.hotel.models.Hospedagem;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospedagemGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private HospedagemController controller;

    public Hospedagem hospedagem(Long id){
        return controller.hospedagem(id);
    }

    public List<Hospedagem> getHospedagens(){
        return controller.getHospedagens();
    }

    public Hospedagem saveHospedagem(HospedagemInput input){
        return controller.saveHospedagem(input);
    }

    public Boolean deleteHospedagem(Long id){
        return controller.deleteHospedagem(id);
    }

}
