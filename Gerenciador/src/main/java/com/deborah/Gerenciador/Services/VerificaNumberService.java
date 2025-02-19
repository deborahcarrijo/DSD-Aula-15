package com.deborah.Gerenciador.Services;

import org.springframework.stereotype.Service;

@Service
public class VerificaNumberService {
	public boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll(",", ".");
		
		return(number.matches(("[-+]?[0-9]*\\.?[0-9]+")));
	}
	
	public Long convertToLong(String strNumber) {

		if(strNumber == null) throw new UnsupportedOperationException("ID não pode ser nulo");

		String number = strNumber.replaceAll(",", ".");

		if(isNumeric(number)) {
			return(Long.parseLong(number));
		} else throw new UnsupportedOperationException("Não é um ID Válido");
	}
}


