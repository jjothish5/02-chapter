package com.book.plain;

import com.book.base.Person;
import com.book.base.PersonManager;
import com.book.base.PersonRepository;

public class PlainPersonManagerImpl implements PersonManager {

	PersonRepository personRepository;
	
	PlainPersonManagerImpl(PersonRepository personRepository){
		this.personRepository = personRepository;
	}
	
	@Override
	public int save(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}

}
