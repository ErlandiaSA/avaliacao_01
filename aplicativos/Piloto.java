package aplicativos;
public class Piloto extends Pessoa {
    private int _matricula;
    private String _breve;
    private Aeronave _veiculo;

    public Piloto(String nome, int matricula, String breve, String cpf) {
        super(nome, cpf);
        _matricula = matricula;
        _breve = breve;
    }

    public int getMatricula() {
        return _matricula;
    }

    public String getBreve() {
        return _breve;
    }

    public Aeronave getVeiculo() {
        return _veiculo;
    }

    public void setVeiculo(Aeronave aeronave) {
        _veiculo = aeronave;
    }

    @Override
    public String toString() {
        return super.toString() + ":[matricula=" + _matricula + ", breve=" + _breve + ", aeronave=" + _veiculo + "]";
    }

    @Override
    public String getTipo() {
        return "Piloto";
    }

    
}
