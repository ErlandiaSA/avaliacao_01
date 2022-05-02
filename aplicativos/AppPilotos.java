package aplicativos;

import java.util.InputMismatchException;
import java.util.Scanner;

import aplicativos.Aeronave;
import aplicativos.Piloto;
import aplicativos.PilotoNaoEncontradoException;

public class AppPilotos {
    private final static int TAMANHO_INICIAL_LISTAS = 3;
    private static Scanner scanner = new Scanner(System.in);
    private static Piloto[] _pilotos = new Piloto[TAMANHO_INICIAL_LISTAS];
    private static int _numeroPilotos = 0;
    private static Aeronave[] _aeronaves = new Aeronave[TAMANHO_INICIAL_LISTAS];
    private static int _numeroAeronaves = 0;

    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                continuarExecutando = true;
            }
        } while (continuarExecutando);
    }

    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 0: {
                System.out.println("Saindo do sistema...");
                return false;
            }
            case 1: {
                cadastrarPiloto();
                break;
            }
            case 2: {
                listarPilotos();
                break; 
                
            }
            case 3: {
                System.out.println("Digite o CPF do piloto para a busca:");
                String cpf = scanner.nextLine();
                Piloto piloto = buscarPiloto(cpf);       
                if (piloto != null) {
                    System.out.println("Resultado da busca: " + piloto);
                    break;
                }            
                break;
            }
            case 4: {                
               // if (_numeroPilotos == _pilotos.length) {
                    Piloto[] novaLista = new Piloto[_pilotos.length * 2];
                        
                    // Copio os elementos da lista antiga para a nova lista.
                    for (int i = 0; i < _pilotos.length; i++) {
                        novaLista[i] = _pilotos[i];
                    }
            
                    // Substituo a lista antiga pela nova.
                    _pilotos = novaLista;

                    System.out.println("Espaçõ de armazenamento almentada para : " + _pilotos.length);
                //}
                
                break;
            }
            default: {
                System.out.println("Ainda não implementado!");
                break;
            }
        }

        return true;
    }

    private static void listarPilotos() {
        System.out.println("Lista de pilotos cadastrados:");
        for (int i = 0; i < _numeroPilotos; i++) {
            System.out.println(_pilotos[i]);
        }
    }

    private static void listarAeronaves() {
        System.out.println("Lista de aeronaves cadastrados:");
        for (int i = 0; i < _numeroAeronaves; i++) {
            System.out.println(_aeronaves[i]);
        }
    }

    private static void cadastrarAeronave() throws PilotoNaoEncontradoException {
        System.out.println("Cadastro de aeronaves");
        System.out.println("Digite o modelo da aeronave:");
        String modeloAE = scanner.nextLine();
        System.out.println("Digite o registroAE da aeronave:");
        int registroAE = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o CPF do piloto:");
        String cpf = scanner.nextLine();
        Piloto piloto = buscarPiloto(cpf);

        Aeronave aeronave = new Aeronave(modeloAE, registroAE, piloto);
        adicionarAeronaveNaLista(aeronave);
    }

    private static void adicionarAeronaveNaLista(Aeronave aeronave) {
        if (_numeroAeronaves == _aeronaves.length) {
            Aeronave[] novaLista = new Aeronave[_aeronaves.length * 2];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _aeronaves.length; i++) {
                novaLista[i] = _aeronaves[i];
            }

            // Substituo a lista antiga pela nova.
            _aeronaves = novaLista;
        }

        // Adiciono o aeronave a lista.
        _aeronaves[_numeroAeronaves] = aeronave;
        _numeroAeronaves++;        
    }

    private static Piloto buscarPiloto(String cpf) throws PilotoNaoEncontradoException {
        for (Piloto piloto: _pilotos) {
            if (piloto != null && piloto.getCpf().equals(cpf)) {
                return piloto;
            }
        }

        throw new PilotoNaoEncontradoException(cpf);
    }

    private static void adicionarPilotoNaLista(Piloto piloto) {
        if (_numeroPilotos == _pilotos.length) {
            Piloto[] novaLista = new Piloto[_pilotos.length * 2];
            
            // Copio os elementos da lista antiga para a nova lista.
            for (int i = 0; i < _pilotos.length; i++) {
                novaLista[i] = _pilotos[i];
            }

            // Substituo a lista antiga pela nova.
            _pilotos = novaLista;
        }

        // Adiciono o piloto a lista.
        _pilotos[_numeroPilotos] = piloto;
        _numeroPilotos++;
    }

    private static void cadastrarPiloto() throws InputMismatchException {
        System.out.println("Cadastro de pilotos");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Matricula: ");
        int matricula = Integer.parseInt(scanner.nextLine());
        System.out.println("BREVE: ");
        String breve = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        Piloto piloto = new Piloto(nome, matricula, breve, cpf);
        adicionarPilotoNaLista(piloto);
    }

    private static void imprimirMenu() {
        System.out.println("Cadastro de aeronaves!");
        System.out.println("1 - Cadastrar piloto");
        //System.out.println("2 - Cadastrar aeronave");
        //System.out.println("3 - Listar pilotos cadastrados");
        //System.out.println("4 - Listar aeronaves");

        System.out.println("2 - Listar pilotos cadastrados");
        System.out.println("3 - Localizar piloto pelo CPF");
        System.out.println("4 - Aumentar espaço de armazenamento");

        System.out.println("0 - Sair");
    }

    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 0 && opcao <= 4);
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
}
