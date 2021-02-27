package com.lamia.digitallibrary.dao;

import java.sql.SQLException;

import com.lamia.digitallibrary.model.IStorable;

public interface IRemovable<T extends IStorable> {
	public void remove(T t);
}
