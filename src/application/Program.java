package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.Trabalhador;
import entities.ValorDoContrato;
import entities.enums.NivelDoTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		
		System.out.print("Digite o nome do departamento: ");
		String departamentoNome = sc.nextLine();
		System.out.println("Insira os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome,NivelDoTrabalhador.valueOf(nivel),salarioBase,new Departamento(departamentoNome));
		
		System.out.print("Quantos contratos para este trabalhador?: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Insira os dados do contrato nº" +i+ ":");
			System.out.print("DATA(dd/mm/yyyy): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int hora = sc.nextInt();
			
			ValorDoContrato vdc = new ValorDoContrato(dataContrato,valorHora,hora);
			trabalhador.addContrato(vdc);
		}
		System.out.println();
		System.out.print("Insira o mês e o ano para calcular a renda (MM/YYYY): ");
		String lerData = sc.next();
		int mes = Integer.parseInt(lerData.substring(0, 2));
		int ano = Integer.parseInt(lerData.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda para " + lerData + " : " + String.format("%.2f",trabalhador.renda(ano, mes)));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
