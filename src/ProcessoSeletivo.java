import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        imprimirSelecionados();

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void analisaCandidato(double salarioPretendido){
        double salarioBase = 2000;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if(salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRA PROPOSTA");
        } else{
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];

            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + "Solicitou este valor de salário " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("Imprimindo a lista de candidatos selecionados: \n");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice+1) + " é o " + candidatos[indice]);
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void entrandoEmContato(String candidato){
        System.out.println("\nEntrando em contato...");

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender(); 
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            }else{
                System.out.println("O contato foi realizado com sucesso!");
            }

        }while(continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("\nConseguimos contato com " + candidato + " na " + tentativasRealizadas);
        }else{
            System.out.println("Não conseguimos contato com " + candidato + ", numero máximo tentativas " + tentativasRealizadas);
        }
    }
}
