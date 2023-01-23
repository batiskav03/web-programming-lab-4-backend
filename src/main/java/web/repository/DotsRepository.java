package web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.Dot;

import javax.xml.crypto.Data;
import java.util.List;


public interface DotsRepository extends ListPagingAndSortingRepository<Dot, Long> {


    @Query("SELECT * FROM public.dots WHERE y <= sin(x/120)*20 + 600 AND y >= sin(x/100)*50 + 200 AND x >= :leftLimit AND x <= :rightLimit LIMIT 250 OFFSET :count * 250" )
    List<Dot> getDots(@Param("leftLimit") int leftLimit, @Param("rightLimit") int rightLimit,@Param("count") int count);



    @Query("INSERT INTO dots VALUES (default ,:x, :y, :user, :result, COALESCE(:data, now()))")
    @Modifying
    void saveDot(long x, long y, String user, boolean result, String data);

}
