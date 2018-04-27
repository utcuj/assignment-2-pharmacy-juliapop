package validators;

import java.util.regex.Pattern;

import model.Medication;



public class MedNameValidator implements Validator<Medication> {

	
	public void validate(Medication med) {
		
		Pattern name = Pattern.compile("[a-zA-Z\\s']+");
		
		if(!name.matcher(med.getName()).matches()) {
			   throw new IllegalArgumentException("The name must contain only letters and spaces");
		}
	}
	
	
}