class Rectangulo {
    double base, altura;
    public Rectangulo(double b, double a) {
        base = b;
        altura = a;
    }
}

class CalculadoraAreaMal {
    double calcularArea(Rectangulo r) {
        return r.base * r.altura;
    }
}
