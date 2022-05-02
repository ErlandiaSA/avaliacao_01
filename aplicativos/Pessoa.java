package aplicativos;

public abstract class Pessoa {
    private String _nome;
    private String _cpf;

    protected Pessoa(String nome, String cpf) {
        // Se nome for null, lança exceção.
        _nome = nome;
        // Se cpf for inválido, lança exceção.
        _cpf = cpf;
        
    }

    public String getNome() {
        return _nome; 
    }

    public String getCpf() {
        return _cpf;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " [nome=" + _nome + ", cpf=" + _cpf + "]";
    }
}
