interface Figura {
    double area();
}

class RectanguloOCP implements Figura {
    double base, altura;
    public RectanguloOCP(double b, double a) {
        base = b;
        altura = a;
    }

    public double area() {
        return base * altura;
    }
}

class Cuadrado implements Figura {
    double lado;
    public Cuadrado(double l) {
        lado = l;
    }

    public double area() {
        return lado * lado;
    }
}

class CalculadoraAreaBien {
    double calcularArea(Figura f) {
        return f.area();
    }
}
