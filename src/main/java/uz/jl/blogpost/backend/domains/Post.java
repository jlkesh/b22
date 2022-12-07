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
public class Post extends BaseDomain {

    @NonNull
    private String title;

    @NonNull
    private String overview;

    @NonNull
    private String content;

    @Builder(builderMethodName = "childBuilder")
    public Post(@NonNull String id, boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt, @NonNull String createdBy, String updatedBy, @NonNull String title, @NonNull String overview, @NonNull String content) {
        super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
        this.title = title;
        this.overview = overview;
        this.content = content;
    }
}
