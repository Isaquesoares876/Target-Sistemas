
public class Questao_4 {

	public static void main(String[] args) {
		  double sp = 67836.43;
	        double rj = 36678.66;
	        double mg = 29229.88;
	        double es = 27165.48;
	        double outros = 19849.53;

	        double totalFaturamento = sp + rj + mg + es + outros;

	        double percentualSP = (sp / totalFaturamento) * 100;
	        double percentualRJ = (rj / totalFaturamento) * 100;
	        double percentualMG = (mg / totalFaturamento) * 100;
	        double percentualES = (es / totalFaturamento) * 100;
	        double percentualOutros = (outros / totalFaturamento) * 100;

	        System.out.printf("Percentual de SP: %.2f%%\n", percentualSP);
	        System.out.printf("Percentual de RJ: %.2f%%\n", percentualRJ);
	        System.out.printf("Percentual de MG: %.2f%%\n", percentualMG);
	        System.out.printf("Percentual de ES: %.2f%%\n", percentualES);
	        System.out.printf("Percentual de Outros: %.2f%%\n", percentualOutros);
	    }
	}
