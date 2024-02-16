import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		Student[] arr = new Student[size];

		int recomSize = Integer.parseInt(br.readLine());
		int[] recomArr = new int[recomSize];

		st = new StringTokenizer(br.readLine());

		int idx = 0;
		while (st.hasMoreTokens())
			recomArr[idx++] = Integer.parseInt(st.nextToken());
		
		/*
		 *  '가장 최근에 추천받은 순서'로 비교하고 계신데 '사진틀에 게시된 순서'로 비교
		 */
		
		q: for (int i = 0; i < recomArr.length; i++) {
			int studentNumber = recomArr[i];

			// 틀에 해당 학생 번호가 있는지 찾는다.
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == null) {
					arr[j] = new Student(studentNumber, 1, i); // 게시
					continue q;
					// 있다면 증가
					// time 최신으로 변경
				}
				
				if (arr[j].studentNumber == studentNumber) {
					arr[j].recom++;
					continue q;
				}
			}

			// min 추천 횟수를 본다.
			int minRecom = Integer.MAX_VALUE;
			for (int j = 0; j < arr.length; j++) {
				if (minRecom > arr[j].recom)
					minRecom = arr[j].recom;
			}

			// minRecom 이면서 그자리 알아내기
			// minRecom 이면서 최초 게시를 비교
			int minTime = Integer.MAX_VALUE;
			int minTimeIdx = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].recom == minRecom && minTime > arr[j].time) { // 최소 추천이고, 오래된 사진
					minTime = arr[j].time;
					minTimeIdx = j;
				}
			}

			arr[minTimeIdx] = new Student(studentNumber, 1, i); // 게시
		}

		List<Integer> stn = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null)
				break;
			stn.add(arr[i].studentNumber);
		}

		Collections.sort(stn);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stn.size(); i++) 
			sb.append(stn.get(i)).append(" ");

		System.out.println(sb.toString());
	}

	static class Student {
		int studentNumber;
		int recom;
		int time;

		public Student(int studentNumber, int recom, int time) {
			this.studentNumber = studentNumber;
			this.recom = recom;
			this.time = time;
		}
	}
};