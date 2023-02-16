package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import web.model.Dot;
import web.repository.DotsRepository;


import java.util.Date;
import java.util.List;

@Service
@SessionScope
public class DotsService {

    private int countTake;
    private DotsRepository repository;


    public DotsService(DotsRepository repository) {
        this.countTake = -1;
        this.repository = repository;
    }

    //todo: заменить костыль count на countTake
    public List<Dot> getDots(int leftLimit, int rightLimit, int count) {
        countTake++;
        List<Dot> result = repository.getDots(leftLimit, rightLimit, count);
        return result;
    }


    public Dot saveDot(Dot dot) {
        if (dot.getDate() == null){
            dot.setDate(new Date());
        }
        if (!dot.isResult()) {
            dot.setResult(checkAccuracy(dot));
        }
        repository.saveDot(dot.getX(), dot.getY(),
                dot.getUser(), dot.isResult(),
                dot.getDate());

        return dot;
    }


    public boolean checkAccuracy(Dot dot) {
        long y = dot.getY();
        long x = dot.getX();
        if (y >= (Math.log(x) * 25) && y <= ((x * x /150) + 100) && y <= (-x/2 + 880)) return true;
        else return false;
    }
    public boolean checkAccuracy(long x, long y) {
        if (y >= (Math.log(x) * 25) && y <= ((x * x /150) + 100) && y <= (-x/2 + 880)) return true;
        else return false;
    }
}
