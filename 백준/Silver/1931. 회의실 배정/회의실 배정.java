import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		List<Meeting> meetings = new ArrayList<>();
		// 회의 데이터 자료구조 만들기
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			meetings.add(new Meeting(start, end));
		}

		// 끝나는 시간을 기준으로 오름차순 정렬 (Greedy)
		Collections.sort(meetings);

		int cnt = 0;
		int endTime = 0;
		for (Meeting meeting : meetings) {
			if (meeting.getMeetingStart() >= endTime) {
				// 선택된 회의가 끝난 시간 이후에 시작하는 경우
				cnt++;
				endTime = meeting.getMeetingEnd();
			}
		}

		System.out.println(cnt);
	}

}

class Meeting implements Comparable<Meeting> {
	private int start;
	private int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getMeetingStart() {
		return this.start;
	}

	public int getMeetingEnd() {
		return this.end;
	}

	// 끝나는 시간을 기준으로 오름차순 정렬
    // 끝나는 시간이 같은 경우 시작시간 기준으로 정렬
	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) {
			return this.start - o.start;
		} else {
			return this.end - o.end;
		}
	}
}
