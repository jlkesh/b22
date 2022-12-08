package uz.jl.blogpost.backend.response;

import java.io.Serializable;

public record Response<T extends Serializable>(T data) { }
