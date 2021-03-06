package facades;

import dto.PersonDTO;
import dto.PersonsDTO;
import entities.Person;
import exceptions.MissingInputException;
import exceptions.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author josef
 */
public interface IPersonFacade {
  public PersonDTO addPerson(String fName, String lName, String phone, String street, String zip, String city) throws MissingInputException;  
  public PersonDTO deletePerson(int id) throws PersonNotFoundException;
  public PersonDTO getPerson(int id)throws PersonNotFoundException; 
  public PersonsDTO getAllPersons();  
  public PersonDTO editPerson(PersonDTO p)throws MissingInputException, PersonNotFoundException;  
}

