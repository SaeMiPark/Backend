import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPFile;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		FTPClient client = new FTPClient();
		client.setCharset("euckr");

		while(true) {
			System.out.println("==FTP Client Program==");
			System.out.println("1. Connect FTP Server");
			System.out.println("2. Exit Program");
			System.out.print(">>");

			int menu=Integer.parseInt(sc.nextLine());

			if(menu==1) {

				//url, prot입력
				System.out.print("Input URL>>");
				String url=sc.nextLine();
				System.out.print("Input PORT>>");
				int port= Integer.parseInt(sc.nextLine());

				try {
					client.connect(url, port);
					System.out.println("FTP Server is connected");
				}catch(Exception e) {
					System.out.println("에러를 확인하고 다시 입력하세요.");
					e.printStackTrace();
					continue;
				}


				//id,pw입력
				while(true) {
					System.out.print("Input ID>>");
					String id=sc.nextLine();
					System.out.print("Input PW>>");
					String pw= sc.nextLine();

					try {
						client.login(id, pw);
						System.out.println("Login Success!");
						break;
					}catch(Exception e) {
						System.out.println("에러를 확인하고 다시 입력하세요.");
						e.printStackTrace();
						continue;
					}
				}

				//파일 관련 기능들
				while(true) {
					String route="C:/workspace/downloads/";
					System.out.println("==============");
					System.out.println("1. Upload File");
					System.out.println("2. Download File");
					System.out.println("3. Disconnect FTP Server");
					System.out.println("4. Delete File");
					System.out.print(">>");
					int filemenu= Integer.parseInt(sc.nextLine());


					if(filemenu==1) {
						System.out.print("업로드할 파일명을 입력해주세요>>");
						String uploadfilename=sc.nextLine();

						try {
							client.upload(new File(route+uploadfilename));
							System.out.println("업로드가 성공적으로 완료되었습니다.");
						}catch(Exception e) {
							System.out.println("업로드 실패");
							e.printStackTrace();
							continue;
						}


					}else if(filemenu==2){
						try {
							System.out.println("다음 목록 중에서 고르세요.");
							FTPFile[] list = client.list();
							for(int i=0; i<list.length; i++) {
								System.out.print(list[i].getClass());
								System.out.print(" [name= "+list[i].getName());
								System.out.print(" type= "+list[i].getType());
								System.out.print(" size= "+list[i].getSize());
								System.out.print(" moidifiedDate= "+list[i].getModifiedDate()+"]");
								System.out.println();
							}

							System.out.print("다운로드할 파일명을 입력하세요>> ");
							String downfilename=sc.nextLine();
							System.out.print("저장할 파일명을 입력하세요>> ");
							String saevefilename=sc.nextLine();

							try {
								client.download(downfilename, new File(route+saevefilename));
								System.out.println("다운로드가 성공적으로 완료되었습니다.");
							}catch(Exception e) {
								System.out.println("다운로드 실패");
								e.printStackTrace();
								continue;
							}


						}catch(Exception e) {
							System.out.println("list 보기 실패");
							continue;
						}

					}else if(filemenu==3) {
						//연결 끊기
						try {
							client.disconnect(false);
							System.out.println("연결이 끊겼습니다.");
							break;
						}catch(Exception e) {
							System.out.println("연결 끊기가 실패했습니다.");
							e.printStackTrace();
							continue;
						}

					}else if(filemenu==4) {
						System.out.println("다음 목록 중에서 삭제할 파일을 고르세요.");
						try {
							
							FTPFile[] list = client.list();
							for(int i=0; i<list.length; i++) {
								System.out.print(list[i]);
								System.out.println();
							}
							System.out.print("삭제할 파일명을 입력하세요>> ");
							String deletefilename=sc.nextLine();
							client.deleteFile(deletefilename);
							System.out.println("파일 삭제가 성공적으로 완료되었습니다.");
							
						}catch(Exception e) {
							System.out.println("목록 보여주기 실패");
							e.printStackTrace();
							continue;
						}

					}else {
						System.out.println("메뉴선택에 없는 숫자입니다. 다시 확인해주세요.");
					}
				}//파일 while문 끝

			}//menu1끝
			else if(menu==2) {
				System.out.println("프로그램을 종료합니다.");
				try {
					client.disconnect(false);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.exit(0);
			}else {
				System.out.println("선택 메뉴에 없는 숫자입니다. 다시 입력하세요.");
			}
		}//처음 while문 끝
	}
}
