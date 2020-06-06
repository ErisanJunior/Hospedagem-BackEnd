package br.com.lucasvieira2902.hotel.controllers;

import br.com.lucasvieira2902.hotel.graphql.inputs.HospedagemInput;
import br.com.lucasvieira2902.hotel.models.Hospedagem;
import br.com.lucasvieira2902.hotel.models.Hospede;
import br.com.lucasvieira2902.hotel.services.HospedagemService;
import br.com.lucasvieira2902.hotel.services.HospedeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HospedagemController {
    @Autowired
    private HospedagemService serv;

    @Autowired
    private HospedeService hospedeService;

    public Hospedagem hospedagem(Long id){
        return serv.findById(id);
    }

    public Hospedagem hospedagem(Hospede h, Long hospedagemId){return serv.findByHospede(h, hospedagemId);}

    public List<Hospedagem> getHospedagens(){
        return serv.findAll();
    }

    public Hospedagem saveHospedagem(HospedagemInput input){
        ModelMapper m = new ModelMapper();
        Hospedagem c = m.map(input, Hospedagem.class);

        if(input.getDataEntrada() != null && !input.getDataEntrada().isEmpty()) {
            c.setDataEntrada(LocalDateTime.parse(input.getDataEntrada(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
        if(input.getDataSaida() != null && !input.getDataSaida().isEmpty()){
            c.setDataSaida(LocalDateTime.parse(input.getDataSaida(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            c.setValorTotalHospedagem(getValorTotalHospedagem(input));
        }else{
            c.setDataSaida(null);
        }

        c.setHospede(hospedeService.findById(input.getHospedeId()));
        return serv.save(c);
    }

    public Boolean deleteHospedagem(Long id){
        return serv.deleteById(id);
    }

   //Calcula total das diarias
    public Double getValorTotalHospedagem(HospedagemInput h) {
        if(h.getDataSaida() != null && !h.getDataSaida().isEmpty()) {
            double taxaSemana = 120.0;
            double taxaFimSemana = 150.0;
            double taxaGaragemSemana = 15.0;
            double taxaGaragemFimSemana = 20.0;
            LocalTime horaLimiteCheckOut = LocalTime.of(16, 30);
            double valorCalculado = 0.0;

            LocalDateTime dtCheckin = LocalDateTime.parse(h.getDataEntrada());
            LocalDateTime dtCheckout = LocalDateTime.parse(h.getDataSaida());

            int nroDiarias = 1;
            nroDiarias += dtCheckout.compareTo(dtCheckin);

            //verifica se passou do horario limite do checkout
            if (dtCheckout.getHour() >= horaLimiteCheckOut.getHour() && dtCheckout.getMinute() > horaLimiteCheckOut.getMinute()) {
                nroDiarias++;
            }

            for (int i = 0; i < nroDiarias; i++) {

                if (dtCheckin.plusDays(i).getDayOfWeek().getValue() >= 6) {
                    valorCalculado += taxaFimSemana;
                    //verifica cobranca garagem
                    if (h.getAdicionaVeiculo()) {
                        valorCalculado += taxaGaragemFimSemana;
                    }
                } else {
                    valorCalculado += taxaSemana;
                    if (h.getAdicionaVeiculo()) {
                        valorCalculado += taxaGaragemSemana;
                    }
                }
            }
            return valorCalculado;
        }
        return null;
    }
}
