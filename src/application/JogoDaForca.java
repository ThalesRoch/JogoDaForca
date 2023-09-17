package application;

import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        String[] palavras = {"cachorro", "gato", "elefante", "leao", "tigre", "girafa", "macaco"};
        Random random = new Random();
        String palavraEscolhida = palavras[random.nextInt(palavras.length)];
        int tentativasMaximas = 6;
        int tentativas = 0;
        StringBuilder palavraDescoberta = new StringBuilder("_".repeat(palavraEscolhida.length()));
        boolean jogoEncerrado = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Adivinhe a palavra secreta.");

        while (!jogoEncerrado) {
            System.out.println("Palavra: " + palavraDescoberta);
            System.out.println("Tentativas restantes: " + (tentativasMaximas - tentativas));
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            if (palavraEscolhida.contains(String.valueOf(letra))) {
                for (int i = 0; i < palavraEscolhida.length(); i++) {
                    if (palavraEscolhida.charAt(i) == letra) {
                        palavraDescoberta.setCharAt(i, letra);
                    }
                }
            } else {
                tentativas++;
                System.out.println("Letra incorreta.");
            }

            if (tentativas >= tentativasMaximas) {
                System.out.println("Você perdeu! A palavra era: " + palavraEscolhida);
                jogoEncerrado = true;
            }

            if (palavraEscolhida.equals(palavraDescoberta.toString())) {
                System.out.println("Parabéns! Você acertou a palavra: " + palavraEscolhida);
                jogoEncerrado = true;
            }
        }

        scanner.close();
    }
}
