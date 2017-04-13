package com.book.base;

import javax.sql.DataSource;

public interface PersonRepository {
	
	int save(Person person);
	void setDataSource(DataSource dataSource);
	
}
