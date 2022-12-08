package uz.jl.blogpost.backend.response;

import java.io.Serializable;

public class DataDTO<T> implements Serializable {

    protected T data;
    protected ErrorDTO error;
    protected boolean success;
    protected Integer total;

    public DataDTO(boolean success) {
        this.success = success;
    }

    public DataDTO(T body) {
        this(body, null);
    }

    public DataDTO(T body, Integer total) {
        this.data = body;
        this.total = total;
        this.success = true;
    }

    public DataDTO(ErrorDTO error) {
        this.error = error;
        this.success = false;
    }

}