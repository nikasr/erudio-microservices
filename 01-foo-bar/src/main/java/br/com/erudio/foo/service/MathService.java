package br.com.erudio.foo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.erudio.foo.exception.UnsuportedMathOperationException;
import br.com.erudio.foo.util.NumberLib;

@Service
public class MathService {
	@Autowired
	NumberLib numberLib;
	
	public Double sum(String numberOne, String numberTwo) throws Exception {	
		numberLib.validateValues(numberOne, numberTwo);
		
		Double sum = numberLib.convertToDouble(numberOne) + numberLib.convertToDouble(numberTwo);
		return sum;
	}

	
	public Double subtract(String numberOne, String numberTwo) throws Exception {
		numberLib.validateValues(numberOne, numberTwo);
		
		Double sub = numberLib.convertToDouble(numberOne) - numberLib.convertToDouble(numberTwo);
		return sub;
	}

	public Double multiply(String numberOne, String numberTwo) throws Exception {
		numberLib.validateValues(numberOne, numberTwo);
		
		Double mult = numberLib.convertToDouble(numberOne) * numberLib.convertToDouble(numberTwo);
		return mult;
	}
	
	public Double division(String numberOne, String numberTwo) throws Exception {
		numberLib.validateValues(numberOne, numberTwo);
		
		if(numberLib.convertToDouble(numberOne)==0 || numberLib.convertToDouble(numberOne)==0) {
			throw new UnsuportedMathOperationException("Is not possible division by zero");
		}
		
		Double div = numberLib.convertToDouble(numberOne) / numberLib.convertToDouble(numberTwo);
		return div;
	}
	
	public Double average(String numberOne, String numberTwo) throws Exception {
		numberLib.validateValues(numberOne, numberTwo);
		
		Double avg = (numberLib.convertToDouble(numberOne) + numberLib.convertToDouble(numberTwo))/2;
		return avg;
	}
	
	public Double squareRoot(String number) throws Exception {
		if(!numberLib.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		Double sqr = (Double) Math.sqrt(numberLib.convertToDouble(number));
		return sqr;
	}
	
}
