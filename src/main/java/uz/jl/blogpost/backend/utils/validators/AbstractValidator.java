package uz.jl.blogpost.backend.utils.validators;

import uz.jl.blogpost.backend.dtos.Dto;
import uz.jl.blogpost.backend.dtos.GenericDto;

import java.io.Serializable;

public abstract class AbstractValidator<CD extends Dto,
        UD extends GenericDto,
        ID extends Serializable> implements BaseValidator {

    public void checkOnCreate(CD dto) throws IllegalArgumentException {

    }

    public void checkOnUpdate(UD dto) throws IllegalArgumentException {

    }

    public void checkID(ID id) throws IllegalArgumentException {

    }

}
