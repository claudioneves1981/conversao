package conversao;

import java.util.Scanner;

public class Conversao {
	
	public enum HexaD {
	    h00('0'), h01('1'), h02('2'), h03('3'), h04('4'),h05('5'),h06('6'),h07('7'),h08('8'),
	    h09('9'),h010('A'),h011('B'),h012('C'),h013('D'),h014('E'),h015('F');
	   
	    public char valorHexa;
	    HexaD(char valor) {
	        valorHexa = valor;
	    }
	}

	public static void main(String[] args) {
		
		
		
		System.out.println("Conversão de Bases");
		System.out.println("1 - Decimal base X");
		System.out.println("2 - Base X Decimal");
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Escolha a opção desejada");
		
		int menu = entrada.nextInt();
		
		switch(menu){
		
		case 1:
			
			subMenuDecimal();
			
		case 2:
			
			subMenuBase();
			
		}

	}
		
	
	public static void subMenuDecimal() {
		
		int decimal;
		int base;
		String resultado="";
		int op;
		
		System.out.println("Conversão Decimal para Binario, Octal e Hexadecimal");
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o decimal");
		decimal = entrada.nextInt();
		System.out.println("Escolha a Base:");
		System.out.println("1 - Binario:");
		System.out.println("2 - Octal");
		System.out.println("3 - Hexadecimal");
		op = entrada.nextInt();
		
		switch(op){
		
		case 1:
			base = 2;
			System.out.println("Binario de "+decimal+" é "+decimalParaBaseX(decimal,base,resultado));
			break;
		case 2:
			base = 8;
			System.out.println("Octal de "+decimal+" é "+decimalParaBaseX(decimal,base,resultado));
			break;
		case 3:
			base = 16;
			System.out.println("Hexadecimal de "+decimal+" é "+decimalParaBaseX(decimal,base,resultado));
			break;
		default:
			System.out.println("Opção errada tente novamente");
			subMenuDecimal();
		}
		
	}
	
	public static void subMenuBase() {
		
		int op;
		int base;
		String numero;
		
		System.out.println("Conversão  Binario, Octal e Hexadecimal para Decimal");
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escolha a Base:");
		System.out.println("1 - Binario:");
		System.out.println("2 - Octal");
		System.out.println("3 - Hexadecimal");
		System.out.println();
		
		op = entrada.nextInt();
		entrada.reset();
	
		System.out.println("Digite o numero que será convertido para Decimal");
		numero = entrada.next();
		
		switch(op){
		
		case 1:
			base = 2;
			System.out.println("Decimal de numero binario "+numero+" é "+baseXParaDecimal(base, numero));
			break;
		case 2:
			base = 8;
			System.out.println("Decimal de numero Octal "+numero+" é "+baseXParaDecimal(base, numero));
			break;
		case 3:
			base = 16;
			System.out.println("Decimal de numero Hexa "+numero+" é "+baseXParaDecimal(base, numero));
			break;
		default:
			System.out.println("Opção errada tente novamente");
			subMenuBase();
		}
		
	}

	
	public static String decimalParaBaseX(int decimal, int base, String resultado) {
		
				if(decimal<base) {
					
				resultado = resultado+HexaD.valueOf("h0"+decimal%base).valorHexa;
					
				}else {
				
				resultado = decimalParaBaseX(decimal/base,base,resultado)+HexaD.valueOf("h0"+decimal%base).valorHexa+resultado;
				
				}
		
		return resultado;
	}
	
	
	public static String baseXParaDecimal(int base, String numero) {
		
		String resultado="";
		int num = 0;
			
		for(int i = 1; i <= numero.length();i++) {
			
			for (HexaD numhexa : HexaD.values()) {
				
				if (numhexa.valorHexa == numero.charAt(numero.length()-i)){
					
					num = num+(int)Math.pow(base,i-1)*numhexa.ordinal();
					
					resultado = String.valueOf(num);
					
				}
				
				
			}
			
		}
				
	//}
		
		return resultado;
	
		
	}
}
		


