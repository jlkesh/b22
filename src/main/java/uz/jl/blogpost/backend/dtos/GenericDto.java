package uz.jl.blogpost.backend.dtos;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericDto implements Dto {
    private String id;
}
