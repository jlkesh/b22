package uz.jl.blogpost.backend.domains;


import lombok.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseDomain {

    @NonNull
    private String message;

    @NonNull
    private String postId;

    @Builder(builderMethodName = "childBuilder")
    public Comment(@NonNull String id, boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt, @NonNull String createdBy, String updatedBy, @NonNull String message, @NonNull String postId) {
        super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
        this.message = message;
        this.postId = postId;
    }
}
