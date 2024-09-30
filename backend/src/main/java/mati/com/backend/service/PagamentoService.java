package mati.com.backend.service;

import java.time.LocalDate;
import java.util.List;

import mati.com.backend.model.PagamentosModel;

public interface PagamentoService {
    

    void pagar(PagamentosModel pagamento);

    List<PagamentosModel> findByDataVencimentoBeforeAndMultaAplicadaFalse(LocalDate dataVencimento);

    void adicionarPagamento(PagamentosModel pagamento);

    void atualizarPagamento(PagamentosModel pagamento);

    void cancelarPagamento(Long pagamentoId);

    List<PagamentosModel> findByStatus(String status);

    double calcularMulta(PagamentosModel pagamento);

    List<PagamentosModel> findVencidos(LocalDate dataAtual);

    // Busca pagamentos por usuário ou cliente
    List<PagamentosModel> findByUsuarioId(Long usuarioId);

    // Busca pagamentos por intervalo de datas
    List<PagamentosModel> findByDataVencimentoBetween(LocalDate startDate, LocalDate endDate);


    // Verifica se um pagamento está atrasado
    boolean isAtrasado(PagamentosModel pagamento);

    // Retorna a soma total dos pagamentos realizados
    double calcularTotalPagamentosRealizados();

    // Gera um relatório de pagamentos por período
    List<PagamentosModel> gerarRelatorioPagamentos(LocalDate startDate, LocalDate endDate);

    // Busca pagamentos por tipo (ex: mensalidade, taxa, etc.)
    List<PagamentosModel> findByTipoPagamento(String tipoPagamento);

    // Restitui um pagamento, se aplicável
    void restituirPagamento(Long pagamentoId);

    // Notifica o usuário sobre pagamentos pendentes
    void notificarPagamentosPendentes(Long usuarioId);
}
