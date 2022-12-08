package uz.jl.blogpost.backend.response;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Data<D> implements Serializable {
    private D body;
    private Integer total;

    public Data(D body) {
        this(body, null);
    }

    public Data(D body, Integer total) {
        this.body = body;
        this.total = total;
    }
}
