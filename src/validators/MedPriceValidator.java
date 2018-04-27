package validators;

import model.Medication;

public class MedPriceValidator implements Validator<Medication> {
	
	public void validate(Medication med) {
		if(!med.getPrice().matches("^[0-9]*\\.?[0-9]+$")) {
			  throw new IllegalArgumentException("Wrong price input!");
		}
	}

}
