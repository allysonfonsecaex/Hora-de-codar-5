package QuatroPilares;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== SIMULADOR DE ANIMAL DE ESTIMAÇÃO VIRTUAL ===");
        System.out.println("Escolha o tipo do seu pet:");
        System.out.println("1. Cachorro");
        System.out.println("2. Gato");
        System.out.print("Opção: ");
        int tipoPet = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o nome do seu pet: ");
        String nomePet = entrada.nextLine();

        Bicho pet = (tipoPet == 1) ? new Cachorro(nomePet) : new Gato(nomePet);

        boolean jogoAtivo = true;

        while (jogoAtivo) {
            System.out.println("\n----------------------------------");
            System.out.println("Escolha uma ação para " + pet.getNome() + ":");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Descansar");
            System.out.println("4. Ir ao Banheiro");
            System.out.println("5. Tomar Banho");
            System.out.println("6. Habilidade Especial");
            System.out.println("7. Ouvir Som");
            System.out.println("8. Verificar Status");
            System.out.println("9. Sair do Jogo");
            System.out.print("Opção: ");

            int escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    pet.alimentar();
                    break;
                case 2:
                    pet.brincar();
                    break;
                case 3:
                    System.out.print("Quantas horas de descanso? ");
                    int horas = entrada.nextInt();
                    pet.descansar(horas);
                    break;
                case 4:
                    pet.irAoBanheiro();
                    break;
                case 5:
                    pet.tomarBanho();
                    break;
                case 6:
                    pet.habilidadeEspecial();
                    break;
                case 7:
                    pet.interagir();
                    break;
                case 8:
                    pet.verificarStatus();
                    continue;
                case 9:
                    System.out.println("Saindo do simulador. Até mais!");
                    jogoAtivo = false;
                    continue;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            pet.passarTempo();

            if (pet.verificarDerrota() || pet.verificarVitoria()) {
                jogoAtivo = false;
            }
        }

        entrada.close();
    }
}