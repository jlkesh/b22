package lomboktest;

import lombok.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Book {
    private String id;
    private String title;
    private Integer pageCount;
}
