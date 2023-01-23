package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import web.Dot;
import web.repository.DotsRepository;


import java.util.List;

@Service
@SessionScope
public class DotsService {

    private int countTake;
    private DotsRepository repository;


    public DotsService(DotsRepository repository) {
        this.countTake = 0;
        this.repository = repository;
    }


    public List<Dot> getDots(int leftLimit, int rightLimit) {
        return repository.getDots(leftLimit, rightLimit, countTake);
    }


    public void saveDot(Dot dot){
        repository.saveDot(dot.getX(), dot.getY(),
                dot.getUser(), dot.isResult(),
                dot.getDate());
    }
}
