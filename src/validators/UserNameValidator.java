package validators;

import java.util.regex.Pattern;

import model.User;



public class UserNameValidator implements Validator<User> {

	
	public void validate(User user) {
		
		Pattern name = Pattern.compile("[a-zA-Z\\s']+");
		
		if(!name.matcher(user.getName()).matches()) {
			   throw new IllegalArgumentException("The name must contain only letters and spaces");
		}
	}
	
	
}