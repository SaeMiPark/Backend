package quiz;

import java.util.ArrayList;
import java.util.Date;

public class MovieDAO {	
	ArrayList<MovieDTO> mvs = new ArrayList<>();
	
	public void addMovie(MovieDTO dto) {
		mvs.add(dto);
	}
	
	public ArrayList<MovieDTO> getMovies() {
		return mvs;
	}
	
	//검색기능
	public ArrayList<MovieDTO> searchByTitle(String title){ 
		ArrayList<MovieDTO> findlist=new ArrayList<MovieDTO>();
		for(MovieDTO dto:mvs) {
			if(dto.getTitle().equals(title)) {
				findlist.add(dto);
			}
		}
		return findlist;
		
	}
	
	//삭제기능
	public boolean deleteById(String id) {
		for(MovieDTO dto: mvs) {
			if(dto.getId().equals(id)) {
				mvs.remove(dto);
				return true;
			}
		}
		return false;
	}
	
	//수정기능
	public void modifyById(String id, String modifytitle, String modifygenre, Date modifydate) {
		for(MovieDTO dto: mvs) {
			if(dto.getId().equals(id)) {
				dto.setTitle(modifytitle);
				dto.setGenre(modifygenre);
				dto.setDate(modifydate);
			}
		}
	}
	

	
	

}
