package uz.jl.blogpost.backend.services.base;


import com.google.gson.Gson;
import uz.jl.blogpost.backend.daos.AbstractDAO;
import uz.jl.blogpost.backend.mappers.Mapper;
import uz.jl.blogpost.backend.utils.BaseUtil;
import uz.jl.blogpost.backend.utils.validators.BaseValidator;

import static uz.jl.blogpost.backend.utils.BaseUtil.GSON;


public class AbstractService<R extends AbstractDAO,
        M extends Mapper,V extends BaseValidator> {
    protected final Gson gson;
    protected final R dao;
    protected final M mapper;
    protected final V validator;
    protected final BaseUtil util;

    public AbstractService(R dao, M mapper, V validator) {
        this.validator = validator;
        this.gson = GSON;
        this.dao = dao;
        this.mapper = mapper;
        this.util = new BaseUtil();
    }
}
