package com.book.plain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.book.base.Person;
import com.book.base.PersonRepository;

public class PlainPersonRepository implements PersonRepository {

	private DataSource dataSource;
	
	@Override
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public int save(Person person) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(getQueryString());
			preparedStatement.setObject(1, person.getFirstName());
			preparedStatement.setObject(2, person.getLastName());
			preparedStatement.setObject(3, person.getDateOfBirth());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return 0;
	}
	
	private String getQueryString(){
		StringBuilder oBuilder = new StringBuilder();
		oBuilder.append("INSERT INTO ");		
		oBuilder.append("JPAEXAMPLES.PERSONS");
		oBuilder.append("( FIRSTNAME, LASTNAME, DATEOFBIRTH ) ");		
		oBuilder.append("VALUES ( ?, ?, ? ) ");
		return oBuilder.toString();
	}
}
