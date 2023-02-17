package web.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Dot {



    @Id
    private long id;
    private long x;
    private long y;
    private String user;
    private boolean accuracy;
    private Date date;

}
