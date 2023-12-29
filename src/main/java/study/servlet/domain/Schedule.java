package study.servlet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class Schedule {
    private Long id;
    private String title;
    private String date;
    private String tag;

    public void setId(final Long id) {
        this.id = id;
    }

    public Schedule(final String title, final String date, final String tag) {
        this.title = title;
        this.date = date;
        this.tag = tag;
    }
}
