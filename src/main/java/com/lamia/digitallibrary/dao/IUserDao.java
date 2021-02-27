package com.lamia.digitallibrary.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.lamia.digitallibrary.model.User;

public interface IUserDao extends IStorage<User>, IEditable<User>, IRemovable<User> {
	public User findByUsername(String username);
	List<String> findAllUsernames();
}
