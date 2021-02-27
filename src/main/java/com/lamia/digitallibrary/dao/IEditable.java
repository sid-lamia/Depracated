package com.lamia.digitallibrary.dao;

import java.sql.SQLException;

import com.lamia.digitallibrary.model.IStorable;

public interface IEditable<T extends IStorable> {
	public T update(T t);
}
