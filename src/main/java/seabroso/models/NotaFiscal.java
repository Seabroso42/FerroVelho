package seabroso.models;

import java.time.LocalDateTime;
import java.util.List;

public class NotaFiscal {

    private long idNotaFiscal;
    private LocalDateTime momento;
    private List<ItemVenda> compras;
    private Double valorTotal;
    private User vendedor;
    private User cliente;
    private Boolean enviado;

    public NotaFiscal(long idNotaFiscal, LocalDateTime momento, List<ItemVenda> compras, Double valorTotal, User vendedor, User cliente, Boolean enviado) {
        this.idNotaFiscal = idNotaFiscal;
        this.momento = momento;
        this.compras = compras;
        this.valorTotal = valorTotal;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.enviado = enviado;
    }
}
