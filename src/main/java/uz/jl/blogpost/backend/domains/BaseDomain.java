package uz.jl.blogpost.backend.domains;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BaseDomain implements Entity {

    @NonNull
    private String id;

    private boolean deleted;

    private LocalDateTime createdAt = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));

    private LocalDateTime updatedAt;

    @NonNull
    private String createdBy;

    private String updatedBy;
}
