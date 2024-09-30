package mati.com.backend.service.implments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import mati.com.backend.model.PagamentosModel;
import mati.com.backend.service.PagamentoService;

public class Pagamentosimplements implements PagamentoService{


      private List<PagamentosModel> pagamentos = new ArrayList<>();

    @Override
    public void pagar(PagamentosModel pagamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagar'");
    }

    @Override
    public List<PagamentosModel> findByDataVencimentoBeforeAndMultaAplicadaFalse(LocalDate dataVencimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDataVencimentoBeforeAndMultaAplicadaFalse'");
    }

    @Override
    public void adicionarPagamento(PagamentosModel pagamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarPagamento'");
    }

    @Override
    public void atualizarPagamento(PagamentosModel pagamento) {
          Optional<PagamentosModel> existingPagamento = pagamentos.stream()
            .filter(p -> p.getID().equals(pagamento.getID()))
            .findFirst();
        
        existingPagamento.ifPresent(p -> {
            p.setValorPagamento(pagamento.getValorPagamento());
            p.setValorComMulta(pagamento.getValorComMulta());
            p.setMultaAplicada(pagamento.isMultaAplicada());
            p.setDataPagamentos(pagamento.getDataPagamentos());
            
        });
    }

    @Override
    public void cancelarPagamento(Long pagamentoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarPagamento'");
    }

    @Override
    public List<PagamentosModel> findByStatus(String status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStatus'");
    }

    @Override
    public double calcularMulta(PagamentosModel pagamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMulta'");
    }

    @Override
    public List<PagamentosModel> findVencidos(LocalDate dataAtual) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findVencidos'");
    }

    @Override
    public List<PagamentosModel> findByUsuarioId(Long usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsuarioId'");
    }

    @Override
    public List<PagamentosModel> findByDataVencimentoBetween(LocalDate startDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDataVencimentoBetween'");
    }

    @Override
    public boolean isAtrasado(PagamentosModel pagamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAtrasado'");
    }

    @Override
    public double calcularTotalPagamentosRealizados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalPagamentosRealizados'");
    }

    @Override
    public List<PagamentosModel> gerarRelatorioPagamentos(LocalDate startDate, LocalDate endDate) {
       return pagamentos.stream()
            .filter(p -> p.getDataPagamentos() != null && 
                         !p.getDataPagamentos().toLocalDate().isBefore(startDate) &&
                         !p.getDataPagamentos().toLocalDate().isAfter(endDate))
            .collect(Collectors.toList()); }

    @Override
    public List<PagamentosModel> findByTipoPagamento(String tipoPagamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTipoPagamento'");
    }

    @Override
    public void restituirPagamento(Long pagamentoId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'restituirPagamento'");
    }

    @Override
    public void notificarPagamentosPendentes(Long usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarPagamentosPendentes'");
    }
    
}
