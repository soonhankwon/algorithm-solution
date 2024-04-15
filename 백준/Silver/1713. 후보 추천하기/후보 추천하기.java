import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
 * 후보 추천하기
 * 1. 추천 시작 전 모든 사진틀은 비어있음
 * 2. 추천 -> 학생의 사진이 사진틀에 게시
 * 3. 비어있는 사진틀이 없는 경우 추천받은 횟수가 가장 적은 학생 사진 삭제 & 새로운 추천사진 게시
 * 3.1 추천 받은 횟수가 가장 적은 학생이 두 명 이상인 경우 가장 오래된 사진 삭제
 * 4. 게시된 학생이 추천을 받은 경우 횟수만 증가
 * 5. 삭제되는 경우 추천받은 횟수 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 3
        int m = Integer.parseInt(br.readLine()); // 총 추천가능 횟수
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int studentId = inputs[i];
            Optional<Student> optionalStudent = students.stream()
                    .filter(student -> student.id == studentId)
                    .findFirst();

            // Id 가 존재하는 경우
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                student.cnt++;
                continue;
            }

            // Id 가 존재하지 않는 경우 - 프레임 공간이 남은 경우
            if (students.size() < n) {
                students.add(new Student(studentId, 1, i));
                continue;
            }

            // Id 가 존재하지 않는 경우 - 프레임 공간이 남지 않은 경우
            // 추천 횟수의 최소값 카운트
            int min = students.stream()
                    .map(student -> student.cnt)
                    .min(Comparator.comparingInt(Integer::intValue))
                    .get();

            // 최소값을 가지고 있는 학생 카운트
            long minCnt = students.stream().filter(student -> student.cnt == min)
                    .count();

            Optional<Student> optionalDeleteStudent;
            // 최소값을 가지고 있는 학생이 다수라면 - 해당 학생중 시간이 가장 오래된 학생
            if (minCnt > 1) {
                optionalDeleteStudent = students.stream().filter(student -> student.cnt == min)
                        .min(Comparator.comparing(student -> student.time));

            }
            // 최소값을 가지고 있는 학생이 하나라면 - 추천횟수가 가장 적은 학생
            else {
                optionalDeleteStudent = students.stream().filter(student -> student.cnt == min)
                        .min(Comparator.comparing(student -> student.cnt));
            }
            // 골라서 삭제함
            optionalDeleteStudent.ifPresent(students::remove);
            // 그리고 새로운 학생 추가
            students.add(new Student(studentId, 1, i));
        }

        StringBuilder sb = new StringBuilder();
        students.stream()
                .sorted(Comparator.comparing(student -> student.id))
                .forEach(i -> sb.append(i.id).append(" "));
        System.out.println(sb.toString().trim());
        br.close();
    }

    private static class Student {
        int id;
        int cnt;
        int time;

        public Student(int id, int cnt, int time) {
            this.id = id;
            this.cnt = cnt;
            this.time = time;
        }
    }
}
