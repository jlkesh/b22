package uz.jl.blogpost.backend.services.base;


import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.GenericCriteria;
import uz.jl.blogpost.backend.dtos.Dto;
import uz.jl.blogpost.backend.dtos.GenericDto;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;

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
    Response<DataDTO<ID>> create(@NonNull CD dto);

    Response<DataDTO<Boolean>> update(@NonNull UD dto);

    Response<DataDTO<Boolean>> delete(@NonNull ID id);
}
