package aplicativos;

public class PilotoNaoEncontradoException extends Exception {
    public PilotoNaoEncontradoException(String cpf) {
        super("Não foi possível encontrar o motorista com o CPF: " + cpf);  
        
    }   
}
