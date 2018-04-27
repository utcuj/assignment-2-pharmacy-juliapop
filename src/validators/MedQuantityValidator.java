package validators;

import java.util.regex.Pattern;
import model.Medication;

public class MedQuantityValidator implements Validator<Medication> {
	
	public void validate(Medication med) {
		if(!med.getQuantity().matches("^[0-9]")) {
			  throw new IllegalArgumentException("Wrong quantity input!");
		}
	}
}
