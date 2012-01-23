package szwedi.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import szwedi.project.*;
import szwedi.services.*;


@SessionScoped
@Named("personBean")
public class PersonFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	Person person = new Person(null, null);

	ListDataModel<Person> persons = new ListDataModel<Person>();

	@Inject
	PersonDBManager personDBManager = new PersonDBManager();

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String addPerson() {
		personDBManager.addPerson(person);
		return "showPersons";
	}
		
	public ListDataModel<Person> getAllPersons() {
		persons.setWrappedData(personDBManager.getAllPersons());
		return persons;
	}


	public void deletePerson() {
		Person personToDelete = persons.getRowData();
		personDBManager.deletePerson(personDBManager.findPersonByName(personToDelete.getName()));
	}


}
