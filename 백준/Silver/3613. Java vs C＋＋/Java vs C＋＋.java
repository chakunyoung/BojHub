import java.io.*;
import java.util.*;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		if (isJava(str)) {
			System.out.println(toCPP(str));
		} else if (isCPP(str)) {
			System.out.println(toJava(str));
		} else {
			System.out.println("Error!");
		}
	}

	static boolean isJava(String str) {
		if (Character.isUpperCase(str.charAt(0)) || str.contains("_")) {
			return false;
		}
		return true;
	}

	static boolean isCPP(String str) {
		if (str.contains("__") || str.endsWith("_") || str.startsWith("_") || Character.isUpperCase(str.charAt(0))) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return false;
			}
		}
		return true;
	}

	static String toCPP(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				sb.append('_').append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	static String toJava(String str) {
		StringBuilder sb = new StringBuilder();
		boolean nextUpper = false;
		for (char c : str.toCharArray()) {
			if (c == '_') {
				nextUpper = true;
			} else if (nextUpper) {
				sb.append(Character.toUpperCase(c));
				nextUpper = false;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
