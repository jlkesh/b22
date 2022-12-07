package uz.jl.blogpost.backend.services;

import uz.jl.blogpost.backend.criteria.GenericCriteria;
import uz.jl.blogpost.backend.dtos.Dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <D>
 * @param <ID>
 * @param <C>
 */
public interface GenericService<D extends Dto, ID extends Serializable, C extends GenericCriteria> {
    D get(ID id);

    List<D> getAll(C criteria);
}
