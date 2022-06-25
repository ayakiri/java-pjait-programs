package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import jdbcdemo.dao.PersonRepository;
import jdbcdemo.dao.mappers.PersonResultMapper;
import jdbcdemo.domain.Person;


public class MainProgram
{
    public static void main( String[] args ) throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

		PersonRepository repo = new PersonRepository(connection, new PersonResultMapper());
    	repo.createTable();
    	
    	Person janek = new Person();
    	janek.setAge(30);
    	janek.setName("Jan");
    	janek.setSurname("Kowalski");
    	
    	repo.add(janek);
    	
    	List<Person> people = repo.getAll();
    	for(Person p : people){
    		System.out.println(p.getId()+"\t" 
    				+ p.getName()+"\t"
    				+ p.getSurname()+"\t"
    				+ p.getAge());
    	}
    	
        System.out.println( "Koniec" );
    }
}
