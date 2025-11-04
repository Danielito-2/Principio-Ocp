enum TipoVendedor {
    JUNIOR,
    SENIOR,
    PARTNER
}

class Vendedor {
    private TipoVendedor tipo;
    private double ventas;

    public Vendedor(TipoVendedor tipo, double ventas) {
        this.tipo = tipo;
        this.ventas = ventas;
    }

    public TipoVendedor getTipo() {
        return tipo;
    }

    public double getVentas() {
        return ventas;
    }
}

class CalculadoraComisionesMal {
    public double calcular(Vendedor vendedor) {
        if (vendedor.getTipo() == TipoVendedor.JUNIOR) {
            return vendedor.getVentas() * 0.02;
        }
        if (vendedor.getTipo() == TipoVendedor.SENIOR) {
            return vendedor.getVentas() * 0.035;
        }
        if (vendedor.getTipo() == TipoVendedor.PARTNER) {
            return vendedor.getVentas() * 0.05;
        }
        throw new IllegalArgumentException("Tipo de vendedor no soportado");
    }
}
