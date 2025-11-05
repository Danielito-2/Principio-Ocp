# Principio-Ocp
# 📐 Principio Abierto/Cerrado (OCP)

El **Principio Abierto/Cerrado (OCP)** es el segundo de los principios **S.O.L.I.D.** y establece que las entidades de software deben estar:

* **Abiertas para extensión**: Se puede añadir nueva funcionalidad.
* **Cerradas para modificación**: No se debe modificar el código existente que ya funciona.

---

### 1. 🛑 Violación del OCP (Ejemplos de Malas Prácticas)

Estos archivos demuestran un diseño **rígido** que requiere modificar clases existentes al agregar nuevas funcionalidades.

#### 1.1. `ViolacionOCP.java` - Calculadora de Comisiones

* **Problema:** La clase `CalculadoraComisionesMal` contiene lógica condicional (`if`/`else if`) acoplada a los tipos específicos de vendedores (`JUNIOR`, `SENIOR`, `PARTNER`, etc.).
* **Clases Afectadas:** `Vendedor` y `CalculadoraComisionesMal`.
* **Consecuencia:** Si se agrega un nuevo `TipoVendedor` (ej. `MANAGER`) o cambia la regla, se **debe abrir y modificar** la clase `CalculadoraComisionesMal`.
* **Violación:** La clase no está cerrada para modificación.

#### 1.2. `AreaSinOCP.java` - Cálculo de Área (Sin Abstracción)

* **Problema:** La clase `CalculadoraAreaMal` está escrita para operar solo con el tipo concreto `Rectangulo`.
* **Consecuencia:** Si quieres calcular el área de un `Círculo` o un `Triángulo`, debes **modificar** `CalculadoraAreaMal` para añadir el nuevo tipo y su fórmula.
* **Violación:** La clase no está cerrada para modificación.

---

### 2. ✅ Cumplimiento del OCP (Ejemplos de Buenas Prácticas)

Estos archivos implementan el OCP utilizando **Interfaces** (Abstracción) y **Polimorfismo**, haciendo el código más flexible.

#### 2.1. `CumpleOCP.java` - Calculadora de Comisiones (OCP)

* **Solución:** Se introduce la interfaz **`PoliticaComision`**.
* **Mecánica:** Cada regla de comisión (`ComisionJunior`, `ComisionSenior`, etc.) es una **nueva clase** que implementa `PoliticaComision`. La clase `CalculadoraComisionesBien` trabaja con la abstracción.
* **Beneficio del OCP:** Para añadir una nueva política de comisión, se crea una **nueva clase** sin tocar el código de `CalculadoraComisionesBien`.

#### 2.2. `AreaConOCP.java` - Cálculo de Área (OCP)

* **Solución:** Se introduce la interfaz **`Figura`** con el método `area()`.
* **Mecánica:** Cada forma (`RectanguloOCP`, `Cuadrado`, etc.) implementa `Figura` y proporciona su propia lógica de área. La clase `CalculadoraAreaBien` simplemente llama a `f.area()`.
* **Beneficio del OCP:** Para añadir una nueva forma (ej. `Triángulo`), solo se crea una **nueva clase** que implemente `Figura`. La `CalculadoraAreaBien` permanece **sin cambios**.
