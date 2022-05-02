package aplicativos;
public class Aeronave {
    private String _modeloAeronave;     
    private int _registroAE;
    private Piloto _piloto;

    public Aeronave(String modeloAE, int registroAE, Piloto piloto) throws IllegalArgumentException {
        this(registroAE, piloto);
        
        validarModeloAE(modeloAE);
        _modeloAeronave = modeloAE.substring(0, 7);
    }

    public Aeronave(int registroAE, Piloto piloto) throws IllegalArgumentException {
        validarRegistroAE(registroAE);
        _registroAE = registroAE;
        _piloto = piloto;
        _piloto.setVeiculo(this);
    }

    public String getModeloAE() {
        return _modeloAeronave;
    }

    public int getRegistroAE() {
        return _registroAE;
    }

    public Piloto getPiloto() {
        return _piloto;
    }

    @Override
    public String toString() {
        return "Aeronave [modeloAE=" + getModeloAE() + ", registroAE=" + _registroAE + "]";
    }

    private void validarModeloAE(String modeloAE) throws IllegalArgumentException {
        if (modeloAE == null || modeloAE.length() != 7) {
            throw new IllegalArgumentException("ModeloAE inválida, a modeloAE deve conter 7 caracteres");
        }
    }

    private void validarRegistroAE(int registroAE) throws IllegalArgumentException {
        if (registroAE < 1000000 || registroAE > 9999999) {
            throw new IllegalArgumentException("RegistroAE inválido, o valor aceito é entre 1000000 e 9999999!");
        }
    }
}
