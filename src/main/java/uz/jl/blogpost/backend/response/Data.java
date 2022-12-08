package uz.jl.blogpost.backend.response;

import lombok.Getter;

public class Data<D> {

    private D body;
    private Error error;
    private Integer total;
    private final boolean success;

    public Data(D body) {
        this(body, null);
    }

    public Data(D body, Integer total) {
        this.body = body;
        this.total = total;
        this.success = true;
    }

    public Data(Error error) {
        this.error = error;
        this.success = false;
    }

}