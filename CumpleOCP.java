interface PoliticaComision {
    boolean aplicaA(Vendedor vendedor);
    double calcular(Vendedor vendedor);
}

class ComisionJunior implements PoliticaComision {
    public boolean aplicaA(Vendedor vendedor) {
        return vendedor.getTipo() == TipoVendedor.JUNIOR;
    }
    public double calcular(Vendedor vendedor) {
        return vendedor.getVentas() * 0.02;
    }
}

class ComisionSenior implements PoliticaComision {
    public boolean aplicaA(Vendedor vendedor) {
        return vendedor.getTipo() == TipoVendedor.SENIOR;
    }
    public double calcular(Vendedor vendedor) {
        return vendedor.getVentas() * 0.035;
    }
}

class ComisionPartner implements PoliticaComision {
    public boolean aplicaA(Vendedor vendedor) {
        return vendedor.getTipo() == TipoVendedor.PARTNER;
    }
    public double calcular(Vendedor vendedor) {
        return vendedor.getVentas() * 0.05;
    }
}

import java.util.*;

class CalculadoraComisionesBien {
    private final List<PoliticaComision> politicas;

    public CalculadoraComisionesBien(List<PoliticaComision> politicas) {
        this.politicas = politicas;
    }

    public double calcular(Vendedor vendedor) {
        return politicas.stream()
                .filter(p -> p.aplicaA(vendedor))
                .findFirst()
                .map(p -> p.calcular(vendedor))
                .orElseThrow(() -> new IllegalArgumentException("Tipo no soportado"));
    }
}
