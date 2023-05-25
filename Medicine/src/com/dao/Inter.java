package com.dao;

import java.util.List;

import com.dto.Medicine;
import com.exception.NorecordFound;
import com.exception.SomethingWentWrong;

public interface Inter {

	void Add(Medicine a) throws SomethingWentWrong;

	void Update(Medicine a) throws SomethingWentWrong;

	void Deletd(String id) throws SomethingWentWrong;

	List<Medicine> View() throws NorecordFound;

}
