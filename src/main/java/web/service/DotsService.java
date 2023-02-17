package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import web.model.Dot;
import web.repository.DotsRepository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@SessionScope
public class DotsService {

    private int countTake;
    private DotsRepository repository;
    private List<Dot> dotslist;


    public DotsService(DotsRepository repository) {
        this.countTake = -1;
        this.repository = repository;
        this.dotslist = new ArrayList<>();
    }

    public List<Dot> getDots(int leftLimit, int rightLimit) {
        if (countTake > 700) {
            countTake = 0;
        }
        countTake++;
        List<Dot> result = repository.getDots(leftLimit, rightLimit, countTake);

        return result;
    }

    public List<Dot> getOwnDots() {
        return dotslist;
    }


    public Dot saveDot(Dot dot) {
        if (dot.getDate() == null){
            dot.setDate(new Date());
        }
        if (!dot.isAccuracy()) {
            dot.setAccuracy(checkAccuracy(dot));
        }
        dotslist.add(dot);
        repository.saveDot(dot.getX(), dot.getY(),
                dot.getUser(), dot.isAccuracy(),
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
