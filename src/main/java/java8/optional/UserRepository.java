package java8.optional;

import java.util.*;

import java8.optional.OptionalExample.User;

public class UserRepository {
	Map<Integer, User> users = null;

	public UserRepository() {
		users = new HashMap<Integer, User>();
		users.put(1, new User(1, "John", "Doe", 32, Optional.empty()));
		users.put(2, new User(2, "carry", "Doe", 34,  Optional.ofNullable("male")));
	}

	public Optional<User> findById(int id) {
		return  Optional.ofNullable(users.get(id));
	}
	
	public User findUserById(int id) {
		return  users.get(id);
	}
	public Collection<User> findAllUser() {
		return  users.values();
	}
	// public Option[User] findById(id: Int){ users.get(id)}

}
