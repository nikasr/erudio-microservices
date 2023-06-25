package br.com.erudio.foo.util;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.erudio.foo.exception.UnsuportedMathOperationException;

@Component
public class NumberLib {
	public Double convertToDouble(String strNumber) {
		if (Objects.isNull(strNumber)) {
			return 0D;
		}else{
			String number = strNumber.replace(",", ".");
			if (isNumeric(number)) return Double.parseDouble(number);
			return 1D;
		}
	}

	public boolean isNumeric(String strNumber) {
		if (Objects.isNull(strNumber)) {
			return false;
		}else{
			String number = strNumber.replace(",", ".");
			return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		}
		
	}
	
	
	public void validateValues(String numberOne, String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		if(numberOne.isEmpty() || numberTwo.isEmpty()) {
			throw new UnsuportedMathOperationException("Two values are required");
		}
	}

	
}
