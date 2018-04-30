package JDBC.action;


import JDBC.dao.PersonDao;
import JDBC.model.Person;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zkq on 2017/2/5.
 */
public class DBAction {
    public void addPerson(Person person){
        PersonDao personDao = new PersonDao();
        personDao.addPerson(person);
    }

    public void deletePerson(Integer id){
        PersonDao personDao = new PersonDao();
        personDao.deletePerson(id);
    }

    public void updatePerson(Person person){
        PersonDao personDao = new PersonDao();
        personDao.updatePerson(person);
    }

    public List<Person> selectAllPerson(){
        PersonDao personDao = new PersonDao();
        return personDao.searchPerson();

    }

    public List<Person> selectPersonByParams(List<HashMap<String,Object>> params){

        PersonDao personDao = new PersonDao();
        return personDao.searchPersonByParams(params);
    }

    public List<Person> selectPersonByName(String name){
        PersonDao personDao = new PersonDao();
        return personDao.searchPersonByName(name);
    }


    public List<Person> selectPersonByAge(Integer age){
        PersonDao personDao = new PersonDao();
        return personDao.searchPersonByAge(age);
    }

    public Person selectPersonById(Integer id){
        PersonDao personDao = new PersonDao();
        return personDao.searchOnePerson(id);
    }
}
