package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		return Math.round(Arrays.stream(elements).reduce(0, Integer::sum)/elements.length);
	}

	public static int mode(int[] elements) {
		int[] array = Arrays.stream(elements).sorted().toArray();
		int element = array[0], count = 1, 
			highElement = element, highCount = 0;
		for (int i = 1; i < array.length; i++) {
			if (element == array[i] && i < array.length - 1) {
				count++;
			} else {
				if (count >= highCount) {
					highElement = element;
					highCount = count;
				}
				element = array[i];
				count = 1;
			}
		}
		return highElement;
	}

	public static int median(int[] elements) {
		int[] array = Arrays.stream(elements).sorted().toArray();
		int size = array.length;
		if (size % 2 == 1) {
			return array[Math.floorDiv(size, 2)];
		} else {
			return Math.round((array[size/2] + array[(size/2)-1]) / 2);
		}		
	}
}