package com.example.demo.entity;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.ReservationRepository;

@SpringBootTest
public class ReservationRepostioryTest {

	@Autowired
	ReservationRepository repository;

	@Test
	void 데이터추가() {
		LocalDate date = LocalDate.of(2024, 9, 05);
		Reservation reservation = Reservation.builder().checkInDate(date).guestName("또치").guestPhone("010-3333-4444")
				.roomNo(202).build();
		repository.save(reservation);
	}

	@Test
	void 데이터추가2() {
		LocalDate date = LocalDate.of(2024, 9, 10);
		Reservation reservation = Reservation.builder().checkInDate(date).guestName("도우너").roomNo(201).build();
		repository.save(reservation);
	}

}
