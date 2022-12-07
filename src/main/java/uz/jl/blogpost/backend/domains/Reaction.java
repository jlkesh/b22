
package uz.jl.blogpost.backend.domains;

import lombok.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Reaction extends BaseDomain {

    private boolean like = true;

    @NonNull
    private String postId;

    @Builder(builderMethodName = "childBuilder")
    public Reaction(@NonNull String id, boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt, @NonNull String createdBy, String updatedBy, boolean like, @NonNull String postId) {
        super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
        this.like = like;
        this.postId = postId;
    }
}

