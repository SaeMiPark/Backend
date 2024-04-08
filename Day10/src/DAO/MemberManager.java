package DAO;

import classes.Member;

public class MemberManager {
	private Member[] Members=new Member[10]; //배열은 동일한 타입의 변수를 담는 곳
	private int index=0;
	
	public void addMember(Member member) {
		Members[index++]=member;
	}


	public Member[] getMembers() { 
		return Members;
	}


	public int getIndex() {
		return index;
	}


}

//silver, 어떤 멤버에 얼마 포인트를 더할 건지
/*public void addPoint(Silver member, int point) {
		member.setPoint(member.getPoint()+point);
	}*/
