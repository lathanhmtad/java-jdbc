package dao;

import java.util.List;

import model.Person;

public class PersonDAO implements DAOInterface<Person> {

	@Override
	public List<Person> selectAll() {
		
		return null;
	}

	@Override
	public Person selectById(Person t) {
		return null;
	}

	@Override
	public boolean insertT(Person t) {
		return false;
	}

	@Override
	public boolean update(Person t) {
		return false;
	}

	@Override
	public boolean delete(Person t) {
		return false;
	}

}
