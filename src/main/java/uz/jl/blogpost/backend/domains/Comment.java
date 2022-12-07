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
public class Comment {

    @NonNull
    private String id;

    @NonNull
    private String message;

    @NonNull
    private String postId;


    private boolean deleted;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));
    private LocalDateTime updatedAt;

    @NonNull
    private String createdBy;

    private String updatedBy;

}
