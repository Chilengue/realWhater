package mati.com.backend.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import mati.com.backend.model.PagamentosModel;

@Service
public class PagamentoRelatorioService {
    
    public String gerarRelatorioPagamentos(List<PagamentosModel> pagamentos) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("Relatório de Pagamentos\n");
        relatorio.append("-----------------------\n");

        for (PagamentosModel pagamento : pagamentos) {
            relatorio.append("ID do Pagamento: ").append(pagamento.getID()).append("\n");
            relatorio.append("Consumidor: ").append(pagamento.getConsumidorModel() != null 
                    ? pagamento.getConsumidorModel().getName() 
                    : "N/A").append("\n");
            relatorio.append("Consumo: ").append(pagamento.getConsumo()).append(" m³\n");
            relatorio.append("Valor Pagamento: ").append(String.format("%.2f", pagamento.getValorPagamento())).append(" MT\n");
            relatorio.append("Data do Pagamento: ").append(pagamento.getDataPagamentos() != null 
                    ? pagamento.getDataPagamentos().format(formatter) 
                    : "Não realizado").append("\n");
            relatorio.append("Multa Aplicada: ").append(pagamento.isMultaAplicada() ? "Sim" : "Não").append("\n");
            relatorio.append("-----------------------\n");
        }

        return relatorio.toString();
    }
}




