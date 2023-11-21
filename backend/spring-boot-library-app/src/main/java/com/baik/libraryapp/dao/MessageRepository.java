package com.baik.libraryapp.dao;

import com.baik.libraryapp.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    Page<Message> findByUserEmail(@RequestParam("user_email") String userEmail, Pageable pageable);



    Page<Message> findByClosed(@RequestParam("closed") boolean closed, Pageable pageable);


    @Query("select count(o) from Message o where o.closed = :closed and o.userEmail = :userEmail")
    int findMessagessByClosed(@RequestParam(value = "closed") boolean closed, String userEmail);

    @Query("select o from Message o where o.mid = :mid")
    Optional<Message> findByMId(Long mid);


    @Query("select o.mid from Message o order by o.mid desc limit 1")
    Long findMid();
}
