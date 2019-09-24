package com.everest.cricket;

import java.util.Random;

public class Util {

	public static int getRandomScore(int[] scores, int[] probabilities) {
		int size = probabilities.length;
		int probCumulative[] = new int[size];
		probCumulative[0] = probabilities[0];
		for (int i = 1; i < size; i++) {
			probCumulative[i] = probCumulative[i - 1] + probabilities[i];

		}
		int maxRange = probCumulative[size - 1];
		int num = new Random().nextInt(maxRange) + 1;
		int scoreIndex = getScoreIndex(probCumulative, num);

		return scores[scoreIndex];
	}

	private static int getScoreIndex(int[] probCumulative, int num) {
		int low = 0,high = probCumulative.length-1,mid;
		while(low<high) {
			mid = (low+high)/2;
			if(num>probCumulative[mid]) {
				low = mid+1;	
			}
			else {
				high = mid;
				
			}
			
		}
		return (probCumulative[low] >= num) ? low : -1; 
	}

}
