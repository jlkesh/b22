package uz.jl.blogpost.backend.services.base;

import lombok.NonNull;
import uz.jl.blogpost.backend.criteria.GenericCriteria;
import uz.jl.blogpost.backend.dtos.Dto;
import uz.jl.blogpost.backend.response.DataDTO;
import uz.jl.blogpost.backend.response.Response;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <D>
 * @param <ID>
 * @param <C>
 */
public interface GenericService<D extends Dto, ID extends Serializable, C extends GenericCriteria> {
    Response<DataDTO<D>> get(@NonNull ID id);

    Response<DataDTO<List<D>>> getAll(@NonNull C criteria);
}
