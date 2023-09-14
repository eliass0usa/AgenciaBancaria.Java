package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
	
//	Puxa bibliotecas para a formatação dos valores em Reais
	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##,0.00");
	
//	Transformando os valores mostrados em Double para String
//	Método? e Parametros
	public static String doubleToString(Double valor) {
		return formatandoValores.format(valor);
	}
	
}
