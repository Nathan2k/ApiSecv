package service;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Calendar;

public class CalcIdade {

	public static String calc(Long idade) {

		Calendar cIdade = Calendar.getInstance();
		Calendar dataAtual = Calendar.getInstance();

		System.out.println(cIdade.get(Calendar.MONTH));

		LocalDate dataNasc = LocalDate.of(cIdade.getTime().getDay(), cIdade.getTime().getMonth(),
				cIdade.getTime().getDay());

		LocalDate dataAt = LocalDate.of(dataAtual.getTime().getYear(), dataAtual.getTime().getMonth(),
				dataAtual.getTime().getDay());

		Integer idadeTotal = Period.between(dataNasc, dataAt).getYears();

		return idadeTotal.toString();
	}

}
