package br.com.codenation;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.lang.Double;

public class StatisticUtil {

	public static int average(int[] elements) {
		return new Double(IntStream.of(elements).average().getAsDouble()).intValue();
	}

	public static int mode(int[] elements) {
		Map<Integer, Long> frequencias = IntStream.of(elements).boxed()
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return frequencias.entrySet().stream()
		.max(Comparator.comparingLong(Map.Entry::getValue))
		.map(Map.Entry::getKey).get().intValue();
	}

	public static int median(int[] elements) {
		if (elements.length % 2 == 1) {
			return IntStream.of(elements).sorted()
			.skip(elements.length/2).findFirst().getAsInt();
		} else {
			return new Double(IntStream.of(elements).sorted()
			.skip(elements.length/2-1).limit(2).average().getAsDouble()).intValue();
		}		
	}
}