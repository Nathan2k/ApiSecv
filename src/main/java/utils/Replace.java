package utils;

public class Replace {
	
	public static String format(String cnpj) {
		
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace("-", "");
		
		return cnpj;
		
	}
	
	

}
