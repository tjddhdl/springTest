package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;

@SpringBootTest
public class RepositoryServiceTest {

	@Autowired
	ReservationService service;

	@Test
	void 예약정보등록() {
		LocalDate date = LocalDate.now();
		ReservationDTO dto = ReservationDTO.builder().checkInDate(date).guestName("악악").guestPhone("010-1313-1313")
				.roomNo(113).build();
		service.register(dto);
	}

	@Test
	void 예약정보목록조회() {
		List<ReservationDTO> list = service.getList();
		for (ReservationDTO dto : list) {
			System.out.println("앍" + dto);
		}
	}

	@Test
	void 예약정보단건조회() {
		ReservationDTO dto = service.read(5);
		System.out.println(dto);
	}
}
