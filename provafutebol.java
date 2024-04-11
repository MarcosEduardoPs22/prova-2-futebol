import java.util.Scanner;

public class provafutebol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pergunta a quantidade de times e jogadores por time
        System.out.print("Quantidade de times: ");
        int quantidadeTimes = scanner.nextInt();
        System.out.print("Jogadores por time: ");
        int jogadoresPorTime = scanner.nextInt();
        
        // Declaração de variáveis
        int[][] idades = new int[quantidadeTimes][jogadoresPorTime];
        double[][] pesos = new double[quantidadeTimes][jogadoresPorTime];
        double[][] alturas = new double[quantidadeTimes][jogadoresPorTime];
        int jogadoresMenor18 = 0;
        double somaAlturas = 0;
        int totalJogadores = quantidadeTimes * jogadoresPorTime;
        int jogadoresMais80Kg = 0;
        
        // Entrada de dados
        for (int time = 0; time < quantidadeTimes; time++) {
            for (int jogador = 0; jogador < jogadoresPorTime; jogador++) {
                System.out.println("Time " + (time + 1) + ", Jogador " + (jogador + 1) + ":");
                System.out.print("Idade: ");
                idades[time][jogador] = scanner.nextInt();
                System.out.print("Peso (kg): ");
                pesos[time][jogador] = scanner.nextDouble();
                System.out.print("Altura (m): ");
                alturas[time][jogador] = scanner.nextDouble();
                
                // Verifica se o jogador tem menos de 18 anos
                if (idades[time][jogador] < 18) {
                    jogadoresMenor18++;
                }
                
                // Verifica se o jogador tem mais de 80kg
                if (pesos[time][jogador] > 80) {
                    jogadoresMais80Kg++;
                }
                
                // Soma as alturas para calcular a média posteriormente
                somaAlturas += alturas[time][jogador];
            }
        }
        
        // Cálculo das médias e porcentagem
        double mediaIdadePorTime;
        double mediaAltura = somaAlturas / totalJogadores;
        double porcentagemMais80Kg = (jogadoresMais80Kg / (double) totalJogadores) * 100;
        
        // Exibição dos resultados
        System.out.println("Quantidade de jogadores com idade inferior a 18 anos: " + jogadoresMenor18);
        for (int time = 0; time < quantidadeTimes; time++) {
            int somaIdadesTime = 0;
            for (int jogador = 0; jogador < jogadoresPorTime; jogador++) {
                somaIdadesTime += idades[time][jogador];
            }
            mediaIdadePorTime = somaIdadesTime / (double) jogadoresPorTime;
            System.out.println("Média de idade do Time " + (time + 1) + ": " + mediaIdadePorTime);
        }
        System.out.println("Média das alturas de todos os jogadores do campeonato: " + mediaAltura);
        System.out.println("Porcentagem de jogadores com mais de 80 kg: " + porcentagemMais80Kg + "%");
    }
}
