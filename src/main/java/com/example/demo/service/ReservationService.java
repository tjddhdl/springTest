package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {

	// dto entity 변환
	default Reservation dtoToEntity(ReservationDTO dto) {
		Reservation reservation = Reservation.builder().no(dto.getNo()).checkInDate(dto.getCheckInDate())
				.guestName(dto.getGuestName()).guestPhone(dto.getGuestPhone()).roomNo(dto.getRoomNo()).build();
		return reservation;
	}

	// entity dto변환
	default ReservationDTO entityToDTO(Reservation reservation) {
		ReservationDTO dto = ReservationDTO.builder().no(reservation.getNo()).checkInDate(reservation.getCheckInDate())
				.guestName(reservation.getGuestName()).guestPhone(reservation.getGuestPhone())
				.roomNo(reservation.getRoomNo()).build();
		return dto;
	}

	// 예약 리스트 조회
	List<ReservationDTO> getList();

	// 예약 정보 등록
	void register(ReservationDTO dto);

	// 예약 상세 조회
	ReservationDTO read(int no);
}
