
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> qu1 = new LinkedList<>(); //N 숫자 담을 곳 
		Queue<Integer> qu2 = new LinkedList<>(); // 요세푸스 담을곳
		for (int i = 1; i <= N; i++) { //큐에 N을 담음
			qu1.add(i);
		}
		int cnt = 1;
		while(!qu1.isEmpty()) {
			if(cnt == K) {
				qu2.add(qu1.poll());
				cnt = 1;
			} else {
				qu1.add(qu1.poll());
				cnt++;
			}
		}
		System.out.print("<");
		for (int i = 0; i < N - 1; i++) {
			System.out.printf("%d, ", qu2.poll());
		}
		System.out.printf("%d", qu2.poll());
		System.out.print(">");
	}

}
