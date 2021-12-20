import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
public static void arrSwap(int[] arr, int i, int j) {
	arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
}

public static void main(String[] args) {
	int[][] coordinates = new int[500][4];
	try {
		File input_txt = new File("5input.txt");
		Scanner myReader = new Scanner(input_txt);
		for (int i = 0; i < coordinates.length; i++) {
			String line_txt = myReader.nextLine();
			line_txt = line_txt.replace(" -> ", ",");
			coordinates[i] = Arrays.stream(line_txt.split(",")).mapToInt(Integer::parseInt).toArray();
		}
		myReader.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred in reading .txt");
		e.printStackTrace();
	}
	int[][] map = new int[1000][1000];
	for (int[] coordinate : coordinates) {
		
		if (coordinate[0] == coordinate[2]) {
			if (coordinate[1] > coordinate[3]) {
				arrSwap(coordinate, 1, 3);
			}
			for (int c = coordinate[1]; c < coordinate[3]; c++) {
				map[coordinate[0]][c] += 1;
			}
		}
		if (coordinate[1] == coordinate[3]) {
			if (coordinate[0] > coordinate[2]) {
				arrSwap(coordinate, 0, 2);
			}
			for (int c = coordinate[0]; c < coordinate[2]; c++) {
				map[c][coordinate[1]] += 1;
			}
		}
	}
	int counter_of_dangers = 0;
	for (int[] i : map) {
		for (int m : i) {
			if (m >= 2) counter_of_dangers++;
		}
	}
	System.out.println(counter_of_dangers);
}
}