import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            list.add(new Member(age, name, i));
        }

        Collections.sort(list);

        for (Member member : list) {
            System.out.println(member.age + " " + member.name);
        }
    }
}

class Member implements Comparable<Member> {
    int age;
    String name;
    int i;

    public Member(int age, String name, int i) {
        super();
        this.age = age;
        this.name = name;
        this.i = i;
    }

    @Override
    public int compareTo(Member o) {
        if (this.age == o.age) {
            return this.i - o.i;
        }
        return this.age - o.age;
    }
}
