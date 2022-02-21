import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	// 26984457539 after 256
	//vvv double was the key
	double f0 = 0, f1 = 0, f2 = 0, f3 = 0, f4 = 0, f5 = 0, f6 = 0,f7 = 0, f8 = 0, f8p = 0, f6p = 0;
	for (int fish : fishes){
		if (fish == 0) f0++;
		if (fish == 1) f1++;
		if (fish == 2) f2++;
		if (fish == 3) f3++;
		if (fish == 4) f4++;
		if (fish == 5) f5++;
		if (fish == 6) f6++;
		if (fish == 7) f7++;
		if (fish == 8) f8++;
	}
	for (int i = 0; i < 256 ; i++) {
		f8p = f0;
		f6p = f0;
		
		f0 = f1;
		f1 = f2;
		f2 = f3;
		f3 = f4;
		f4 = f5;
		f5 = f6;
		f6 = f6p + f7;
		f7 = f8;
		f8 = f8p;
	}
	System.out.println(f0+f1+f2+f3+f4+f5+f6+f7+f8);
}
}