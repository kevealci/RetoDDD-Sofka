package com.retoddd.delivery.domain.cliente.commands;

import co.com.sofka.domain.generic.Command;
import com.retoddd.delivery.domain.cliente.values.*;

public class AgregarCompra extends Command {

    private final ClienteId clienteId;
    private final CompraId compraId;
    private final SubTotal subTotal;
    private final Impuesto impuesto;
    private final Total total;
    private final Detalle detalle;

    public AgregarCompra(ClienteId clienteId, CompraId compraId, SubTotal subTotal, Impuesto impuesto, Total total, Detalle detalle) {
        this.clienteId = clienteId;
        this.compraId = compraId;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.total = total;
        this.detalle = detalle;
    }

    public ClienteId getClienteId() { return clienteId; }

    public CompraId getCompraId() { return compraId; }

    public SubTotal getSubTotal() { return subTotal; }

    public Impuesto getImpuesto() { return impuesto; }

    public Total getTotal() { return total; }

    public Detalle getDetalle() { return detalle; }
}
