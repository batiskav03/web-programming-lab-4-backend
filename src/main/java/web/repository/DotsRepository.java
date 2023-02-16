package web.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import web.model.Dot;

import java.util.Date;
import java.util.List;


public interface DotsRepository extends ListPagingAndSortingRepository<Dot, Long> {


    @Query("SELECT * FROM public.dots WHERE x >= :leftLimit AND x <= :rightLimit LIMIT 250 OFFSET :count * 250" )
    List<Dot> getDots(@Param("leftLimit") int leftLimit, @Param("rightLimit") int rightLimit,@Param("count") int count);



    @Query("INSERT INTO dots VALUES (default ,:x, :y, :user, :result, COALESCE(:data, now()))")
    @Modifying
    void saveDot(long x, long y, String user, boolean result, Date data);

}
