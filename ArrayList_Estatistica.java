import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class media_lista {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<Double> num = new ArrayList<Double>();
        
        System.out.println("Insira os valores:");
        while (true) {
            String input = leia.nextLine();
            if (input.isEmpty()) {
                break;
            }
            try {
                double valor = Double.parseDouble(input);
                num.add(valor);
            } catch (NumberFormatException e) {
                System.out.println("Insira um número válido.");
            }
        }

        if (num.size() > 0) {
            double media = calcularMedia(num);
            double moda = calcularModa(num);
            double minimo = Collections.min(num);
            double maximo = Collections.max(num);
            double desvioPadrao = calcularDesvioPadrao(num, media);

            System.out.println("Média = " + media);
            System.out.println("Moda = " + moda);
            System.out.println("Mínimo = " + minimo);
            System.out.println("Máximo = " + maximo);
            System.out.println("Desvio Padrão = " + desvioPadrao);
        } else {
            System.out.println("Nenhum valor foi informado.");
        }

        leia.close();
    }

    public static double calcularMedia(ArrayList<Double> lista) {
        double soma = 0;
        for (double num : lista) {
            soma += num;
        }
        return soma / lista.size();
    }

    public static double calcularModa(ArrayList<Double> lista) {
        Collections.sort(lista);
        double moda = lista.get(0);
        int maxCount = 0;

        for (int i = 0; i < lista.size(); i++) {
            double currentNum = lista.get(i);
            int count = 1;

            while (i + 1 < lista.size() && lista.get(i + 1).equals(currentNum)) {
                count++;
                i++;
            }

            if (count > maxCount) {
                maxCount = count;
                moda = currentNum;
            }
        }

        return moda;
    }

    public static double calcularDesvioPadrao(ArrayList<Double> lista, double media) {
        double soma = 0;
        for (double num : lista) {
            soma += Math.pow(num - media, 2);
        }
        return Math.sqrt(soma / lista.size());
    }
}
