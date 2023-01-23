package web;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Dot {

    @Id
    private long id;
    private long x;
    private long y;
    private String user;
    private boolean result;
    private String date;

}
