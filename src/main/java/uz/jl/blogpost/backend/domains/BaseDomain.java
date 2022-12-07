package uz.jl.blogpost.backend.domains;

import lombok.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;




@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDomain {

    private boolean deleted;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));
    private LocalDateTime updatedAt;

    @NonNull
    private String createdBy;

    private String updatedBy;
}
