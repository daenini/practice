package rock_scissors_paper;

import java.util.Scanner;

public class Rock_scissors_paper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player의 이름을 입력하세요");
        String name = scanner.next(); // Player의 이름을
        System.out.printf("안녕하세요 %s 님 지금부터 게임을 시작할게요. %n",name);
        boolean play = true; //게임이 끝날지 안끝날지
        String[] game = new String[] {"가위","바위","보"}; //컴퓨터 값 출력
        int user,com;

        while (play) {
            System.out.printf("아래 메뉴중 %s 님이 내고싶은 메뉴의 번호를 입력하세요.%n",name);
            System.out.println("1.가위 \t 2.바위 \t 3.보");
            user = scanner.nextInt()-1;
            com = (int)(Math.random()*3);
            if(user>=3){ // 잘못고를경우
                System.out.println("잘못 고르셨습니다 다시 골라주세요.");
                continue;
            }
            System.out.printf("%s님은 %s 내셨습니다.%n",name,game[user]);
            System.out.printf("컴퓨터는 %S를 냈습니다%n",game[com]);
            System.out.println();
            if(user == 0){ //user가 가위일 경우
                switch (com){
                    case 0 : // 컴퓨터가 가위 일경우
                        System.out.println("비겼습니다 🤣");
                        break;
                    case 1: // 컴퓨터가 바위 일경우
                        System.out.println(name+"님이 졌습니다.");
                        break;
                    case 2: //컴퓨터가 보 일경우
                        System.out.println(name+"님이 이겼습니다.");
                        break;
                }
            }else if(user == 1){ //user가 바위일 경우
                if (com == 0 ){ //컴퓨터가 가위일경우
                    System.out.println(name+"님이 이겼습니다.");
                }else if(com == 1){ //컴퓨터가 바위일 경우
                    System.out.println("비겼습니다 🤣");
                } else if (com == 2) { // 컴퓨터가 보 일경우
                    System.out.println(name+"님이 졌습니다.");
                }
            }else if (user ==2){ //user가 보일 경우
                switch (com){
                    case 0 : // 컴퓨터가 가위 일경우
                        System.out.println(name+"님이 졌습니다.");
                        break;
                    case 1: // 컴퓨터가 바위 일경우
                        System.out.println(name+"님이 이겼습니다.");
                        break;
                    case 2: //컴퓨터가 보 일경우
                        System.out.println("비겼습니다 🤣");
                        break;
                }
            }
            System.out.println();
            System.out.println("한 판 더 하시겠어요?");
            System.out.println("1.네 \t 2.그만할래요");
            int stop = scanner.nextInt();
            if(stop == 2){
                play = false;
                System.out.println("다음에 또 놀러오세요 ^^");
            }else continue;
        }
    }
}
