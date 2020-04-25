package mp.exceptions.admin;

import mp.exceptions.Result;
import mp.subforos.Entrada;
import mp.subforos.EntradaGenerica;

public class EntradaValidada extends Result {
    public EntradaValidada(EntradaGenerica entrada) {
        super("Entrada con titulo " + entrada.getTitulo() + ", y con id  " + entrada.getId() + " validada correctamente. VALIDACIÓN ENTRADA CORRECTA");
    }
}
