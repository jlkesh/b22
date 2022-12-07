package uz.jl.blogpost.backend.domains;

import lombok.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;


@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {

    @NonNull
    private String id;

    @NonNull
    @Builder.Default
    private boolean like = true;

    @NonNull
    private String postId;




}
