package uz.jl.blogpost.backend.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class Response<T> {
    private final T t;
}
