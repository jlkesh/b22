package uz.jl.blogpost.backend.response;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Response<D extends Serializable> {

    private Data<D> data;
    private Error error;
    private final boolean success;

    public Response(Data<D> data) {
        this.data = data;
        this.success = true;
    }

    public Response(Error error) {
        this.error = error;
        this.success = false;
    }
}
