package my.group.ws;

import javax.jws.WebService;

@WebService(name = "CalculatorWs", targetNamespace = "http://localhost/wsdl")
public class Calculator implements CalculatorWs {

	@Override
	public int multiply(int arg0, int arg1) {
		return arg0 * arg1;
	}

	@Override
	public int sum(int arg0, int arg1) {
		return arg0 + arg1;
	}

}
