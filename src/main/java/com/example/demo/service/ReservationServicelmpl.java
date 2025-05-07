package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationRepository;

@Service
public class ReservationServicelmpl implements ReservationService {

	@Autowired
	ReservationRepository repository;

	// 예약 리스트 조회
	@Override
	public List<ReservationDTO> getList() {
		List<Reservation> list = repository.findAll();
		List<ReservationDTO> dtoList = list.stream().map(entity -> entityToDTO(entity)).toList();
		return dtoList;
	}

	// 예약 정보 등록
	@Override
	public void register(ReservationDTO dto) {
		Reservation reservation = dtoToEntity(dto);
		repository.save(reservation);
	}

	// 예약 상세 조회
	@Override
	public ReservationDTO read(int no) {
		Optional<Reservation> optional = repository.findById(no);
		if (optional.isPresent()) {
			Reservation reservation = optional.get();
			ReservationDTO dto = entityToDTO(reservation);
			return dto;
		}
		return null;
	}

}
