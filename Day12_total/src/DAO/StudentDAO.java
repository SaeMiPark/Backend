package DAO;

import java.util.ArrayList;
import java.util.Date;

import DTO.StudentDTO;

public class StudentDAO {
	ArrayList<StudentDTO> stds=new ArrayList<StudentDTO>();
	
	//생성
	public void addStd(StudentDTO dto) {
		stds.add(dto);
	}
	
	//같은 id등록 check기능, 같은 id가 있다면 true
	public boolean duplicateIdCheck(String id) {
		for(StudentDTO s:stds) {
			if(s.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	//출력
	public ArrayList<StudentDTO> getStds(){
		return stds;
	}
	
	//조회,검색
	public ArrayList<StudentDTO> searchByName(String name){
		ArrayList<StudentDTO> findstds =new ArrayList<StudentDTO>();
		for(StudentDTO dto: stds) {
			if(dto.getName().equals(name)) {
				findstds.add(dto);
			}
		}
		return(findstds);
	}
	
	//수정
	public boolean modifyById(String id, String name, int kor, int eng, int math, Date date) {
		for(StudentDTO dto: stds) {
			if(dto.getId().equals(id)) {
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMath(math);
				dto.setDate(date);
				return true;
			}
		}
		return false;
	}
	
	
	//삭제
	public boolean deleteById(String id) {
		for(StudentDTO dto: stds) {
			if(dto.getId().equals(id)) {
				return stds.remove(dto); 
				//return이 없으면 ConcurrentModificationException
				//순회하면서 삭제하기 때문에 return을 통해 더이상 순히하지 않도록 해준다.
			}
		}
		return false;
	}
	

}
