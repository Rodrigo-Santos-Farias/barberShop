/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Model.Agendamento;

/**
 *
 * @author raianefarias300
 */
public class Correio {
    public void notificarPoEmail(Agendamento agendamento){
        
        String emailformatado = formarEmail(agendamento);
        String destinatario = agendamento.getCliente().getEmail();
        
        //Uso da classe Email
        Email email = new Email("Agendamento BarberShop", emailformatado, destinatario);
        email.enviar();
    }

    private String formarEmail(Agendamento agendamento){
        String nomeCliente = agendamento.getCliente().getNome();
        String servico = agendamento.getServico().getDescricao();
        String dataAgendamento = agendamento.getDataFormatada();
        String horaAgendamento= agendamento.getHoraFormatada();
        float valor = agendamento.getValor();
        
        
        return "Olá "+ nomeCliente + " Vai dar um tapa no visu... Seu agendamento para "
                + servico + ", está marcado para o dia "+ dataAgendamento +
                " às "+ horaAgendamento +" O preço pra você sai baratin fica R$ "+ valor+ " Forte Abraço!!";
            
    }
    
}
