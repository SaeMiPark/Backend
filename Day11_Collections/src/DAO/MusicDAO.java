package DAO;

import java.util.ArrayList;
import java.util.Date;

import DTO.MusicDTO;

public class MusicDAO extends MusicDTO{
	private ArrayList<MusicDTO> musics=new ArrayList<>();

	//입력
	public void addMusic(MusicDTO dto) {
		musics.add(dto);
	}

	//조회,검색 searchByTitle
	public ArrayList<MusicDTO> findMusic(String title) {
		/*실험: MusicDTO는 null타입이 될 수 있다.
		for(int i=0; i<musics.size(); i++) {
			if(musics.get(i).equals(title)) {
				return musics.get(i);
			}
		}
		return null;*/
		
		ArrayList<MusicDTO> musiclist=new ArrayList<>();
		//musiclist는 비어있지 않다. 주소값을 가지고 있다.
		for(MusicDTO m:musics) {
			if(m.getTitle().equals(title)) {
				musiclist.add(m);
			}
		}
		return musiclist;
	}

	//삭제, id를 기준으로 지우기 때문에 break있는게 좋다.
	//id는 식별자라 하나만 있기 때문이다.
	public Boolean removeMusic(String id) {
		for(MusicDTO dto :musics) {
			if(dto.getId().equals(id)) {
				return musics.remove(dto); //찾는 순간 빠져나옴
			}
		}
		return false;
	}

	//수정
	public Boolean modifyMusic(String id, String title, String singer, Date date) {
		Boolean flag=false;
		for(MusicDTO m:musics) {
			if(m.getId().equals(id)) {
				m.setTitle(title);
				m.setSinger(singer);
				m.setDate(date);
				flag=true;
			}
		}
		return flag;
	}


	public ArrayList<MusicDTO> getmusiclist(){
		return musics;
	}

}
