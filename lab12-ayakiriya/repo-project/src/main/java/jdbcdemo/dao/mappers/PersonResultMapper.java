package jdbcdemo.dao.mappers;

import jdbcdemo.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonResultMapper implements ResultSetMapper<Person>{

    @Override
    public Person map(ResultSet rs) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setSurname(rs.getString("surname"));
        p.setAge(rs.getInt("age"));
        return p;
    }
}
