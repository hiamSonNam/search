package vn.music.Service;

import org.springframework.stereotype.Service;

import vn.music.DTO.PaginateDTO;
@Service
public class PaginateServiceImpl {
	public PaginateDTO getInfoPaginate(int totalData, int limit, int currentPage) {
		PaginateDTO p = new PaginateDTO();
		p.setLimit(limit);
		p.setTotalPage(setInfoTotalPage(totalData, limit));
		p.setCurrentPage(checkCurrentPage(currentPage, p.getTotalPage()));
		int start = findStart(p.getCurrentPage(), limit);
		p.setStart(start);
		int end = findEnd(p.getStart(), limit, totalData);
		p.setEnd(end);
		return p;
	}

	private int findEnd(int start, int limit, int totalData) {
		// TODO Auto-generated method stub
		return start + limit > totalData ? totalData : (start + limit); //limit - 1
	}

	private int findStart(int current, int limit) {
		// TODO Auto-generated method stub
		return ((current - 1) * limit); //+1
	}

	private int setInfoTotalPage(int totalData, int limit) {
		// TODO Auto-generated method stub
		int totalPage = 0;
		totalPage = totalData/limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;	
	}
	
	public int checkCurrentPage(int currentPage, int totalPage) {
		if(currentPage < 1) {
			return 1;
		}
		if(currentPage > totalPage){
			return 	totalPage;
		}
		return currentPage;
	}
}
