package uz.jl.blogpost.backend.mappers;

import lombok.NonNull;

import java.util.List;

public interface BaseMapper<T, D, CD, UD> extends Mapper{
    T fromCreateDTO(@NonNull CD dto);

    T fromUpdateDTO(@NonNull CD dto);

    D toDTO(@NonNull T domain);

    List<D> toDTO(@NonNull List<T> domain);

}
