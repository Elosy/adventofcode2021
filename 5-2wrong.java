import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static void arrSwap(int[] arr, int i, int j) {
	arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
}

public static void main(String[] args) {
	int[][] coordinates = new int[500][4];
	
	try {
		File input_txt = new File("D:\\Insti\\2021-2022\\Programacion\\Projects\\casa\\src\\5input.txt");
		Scanner scInput = new Scanner(input_txt);
		for (int i = 0; i < coordinates.length; i++) {
			String line_txt = scInput.nextLine();
			line_txt = line_txt.replace(" -> ", ",");
			coordinates[i] = Arrays.stream(line_txt.split(",")).mapToInt(Integer::parseInt).toArray();
		}
		scInput.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred in reading .txt");
		e.printStackTrace();
	}
	
	int[][] map = new int[1000][1000];
	for (int[] coordinate : coordinates) {
		int c0 = coordinate[0];
		int c1 = coordinate[1];
		int c2 = coordinate[2];
		int c3 = coordinate[3];
		if (c1 == c3) {
			if (c0 > c2) {
				arrSwap(coordinate, 0, 2);
			}
			for (int c = c0; c < c2; c++) {
				map[c][c1] += 1;
			}
		}
		if (c0 == c2) {
			if (c1 > c3) {
				arrSwap(coordinate, 1, 3);
			}
			for (int c = c1; c < c3; c++) {
				map[c0][c] += 1;
			}
		}
		if (c0 > c2 && c1 != c3) {
			if (c1 > c3) {
				for (int i = 0; i <= c0 - c2; i++) {
					map[c2 + i][c3 + i] += 1;
				}
			} else {
				for (int i = 0; i <= c0 - c2; i++) {
					map[c2 + i][c3 - i] += 1;
				}
			}
		}
		if (c0 < c2 && c1 != c3) {
			if (c1 < c3) {
				for (int i = 0; i <= c2 - c0; i++) {
					map[c0 + i][c1 + i] += 1;
				}
			} else {
				for (int i = 0; i <= c2 - c0; i++) {
					map[c0 + i][c1 - i] += 1;
				}
			}
		}
	}
	
	int counter_of_dangers = 0;
	for (int[] row : map) {
		for (int m : row) {
			if (m > 1) counter_of_dangers++;
		}
	}
	System.out.println(counter_of_dangers);
}
}