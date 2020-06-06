package br.com.lucasvieira2902.hotel.graphql;

import br.com.lucasvieira2902.hotel.graphql.inputs.HospedagemInput;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class QueryGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {


}