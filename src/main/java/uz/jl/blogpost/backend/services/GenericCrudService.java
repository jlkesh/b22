package uz.jl.blogpost.backend.services;


import uz.jl.blogpost.backend.criteria.GenericCriteria;
import uz.jl.blogpost.backend.dtos.Dto;
import uz.jl.blogpost.backend.dtos.GenericDto;

import java.io.Serializable;


/**
 *
 * @param <D> DTO -> data transfer object
 * @param <CD> Create DTO for creating domain in db
 * @param <UD> Update DTO for updating specific domain
 * @param <ID> Id
 * @param <C> Criteria
 */
public interface GenericCrudService<
        D extends GenericDto,
        CD extends Dto,
        UD extends GenericDto,
        ID extends Serializable,
        C extends GenericCriteria>
        extends GenericService<D, ID, C> {
    ID create(CD dto);

    Boolean update(UD dto);

    Boolean delete(ID id);
}
