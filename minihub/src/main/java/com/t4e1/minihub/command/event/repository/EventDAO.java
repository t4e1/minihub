package com.t4e1.minihub.command.event.repository;


import com.t4e1.minihub.command.event.aggregate.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDAO extends JpaRepository<Event, Integer> {


}
