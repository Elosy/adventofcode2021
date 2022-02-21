import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static void arrSwap(int[] arr, int i, int j) {
	arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
}

public static void main(String[] args) {
	ArrayList<Integer> fishes = new ArrayList<>();
	
	try {
		File inputtxt = new File("D:\\Insti\\2021-2022\\Programacion\\Projects\\casa\\src\\6input.txt");
		Scanner scInput = new Scanner(inputtxt);
		
		String line_txt = scInput.nextLine();
		// line_txt = line_txt.replace(" -> ", ",");
		// coordinates[i] = Arrays.stream(line_txt.split(",")).mapToInt(Integer::parseInt).toArray();
		for (int fish : Arrays.stream(line_txt.split(",")).mapToInt(Integer::parseInt).toArray()) {
			fishes.add(fish);
		}
		scInput.close();
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred in reading .txt");
		e.printStackTrace();
	}
	// 26 after 18, 5934 after 80, (always +1 initial day)
	for (int i = 0; i < 80; i++) {
		// System.out.println(fishes);
		for (int fish = fishes.size() - 1; fish >= 0; fish--) {
			if (fishes.get(fish) > 0) {
				fishes.set(fish, fishes.get(fish) - 1);
			} else {
				fishes.set(fish, 6);
				fishes.add(8);
			}
		}
	}
	System.out.println(fishes.size());
}
}