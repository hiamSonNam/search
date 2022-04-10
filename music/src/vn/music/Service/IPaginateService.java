package vn.music.Service;

import org.springframework.stereotype.Service;

import vn.music.DTO.PaginateDTO;

@Service
public interface IPaginateService {
	public PaginateDTO getInfoPaginate(int total, int limit, int current);
}
