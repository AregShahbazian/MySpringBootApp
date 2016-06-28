package com.myspingbootapp.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO
{
	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> errors = new ArrayList<>();

	public ValidationErrorDTO()
	{
	}

	public void addValidationError(String error)
	{
		errors.add(error);
	}

	public List<String> getErrors()
	{
		return errors;
	}

	public String getErrorMessage()
	{
		if (getErrors().size() > 0)
		{
			return "Validatie mislukt. " + errors.size() + " fout(en)";
		}
		else
		{
			return "Validatie gelukt.";
		}
	}

}
