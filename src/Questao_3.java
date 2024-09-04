import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Questao_3 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\ISAQUE\\Downloads\\dados.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            List<Double> valores = processarJson(content);

            if (valores.isEmpty()) {
                System.out.println("Não há dados de faturamento para processar.");
                return;
            }

            double menorValor = valores.stream().min(Double::compareTo).orElseThrow();
            double maiorValor = valores.stream().max(Double::compareTo).orElseThrow();

            double soma = valores.stream().mapToDouble(Double::doubleValue).sum();
            double mediaMensal = soma / valores.size();

            long diasAcimaMedia = valores.stream().filter(v -> v > mediaMensal).count();

            System.out.println("Menor valor de faturamento: R$ " + menorValor);
            System.out.println("Maior valor de faturamento: R$ " + maiorValor);
            System.out.println("Número de dias com faturamento superior à média mensal: " + diasAcimaMedia);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    private static List<Double> processarJson(String json) {
        List<Double> valores = new ArrayList<>();
        json = json.trim();

        if (json.startsWith("[") && json.endsWith("]")) {
            json = json.substring(1, json.length() - 1);
        }

        String[] objetos = json.split("},\\{");
        for (int i = 0; i < objetos.length; i++) {
            if (i == 0) objetos[i] = objetos[i].replaceFirst("^\\{", "");
            if (i == objetos.length - 1) objetos[i] = objetos[i].replaceFirst("\\}$", "");

            String[] pares = objetos[i].split(",");
            for (String par : pares) {
                String[] chaveValor = par.split(":");
                if (chaveValor.length == 2 && chaveValor[0].trim().equals("\"valor\"")) {
                    try {
                        double valor = Double.parseDouble(chaveValor[1].trim());
                        if (valor > 0) {
                            valores.add(valor);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }

        return valores;
    }
}
