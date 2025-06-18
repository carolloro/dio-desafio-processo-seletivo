package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) throws Exception {
        //Case 1
        //analisarCandidato(1900.0);
        //analisarCandidato(2200.0);
        //analisarCandidato(2000.0);

        //Case 2
        //selecaoCandidatos();
        //Case 3
        //imprimirSelecionados();
        //case 4
        String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Lucas"};

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    //case 4
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("O candidato " + candidato + " atendeu a ligação");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com o candidato " + candidato + " após " + tentativasRealizadas + " tentativas.");
        } else {
            System.out.println("Não conseguimos contato com o candidato " + candidato + " após " + tentativasRealizadas + " tentativas.");
        }
    }

    //método auxiliar para fazer ligações aos candidatos
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Lucas"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato  de nº " + (indice + 1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interação for each");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado é " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"João", "Maria", "Pedro", "Ana", "Lucas", "Fernanda", "Carlos", "Beatriz", "Rafael", "Juliana"};

        int candidatoSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatoSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato: " + candidato + " solicitou este valor de salário: R$" + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato: " + candidato + "  foi selecionado para a vaga");
                candidatoSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
    }
}
