package szwedi.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("gameNameValidator")
public class GameNameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String name = (String) value;
		
		if (name.length() < 2) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Nazwa musi składać się z conajmniej 2 znaki");
			message.setSummary("Nazwa musi składać się z conajmniej 2 znaki");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
