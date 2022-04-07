package application;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		List<Double> list1 = Arrays.asList(0.0, 11.0, 6.0, 9.0, 37.0, 39.0, 46.0, 70.0, 72.0, 84.0, 52.0, 62.0, 56.0, 57.0, 67.0, 53.0, 69.0, 59.0, 68.0, 60.0, 36.0, 63.0, 76.0, 67.0, 66.0, 55.0, 51.0, 36.0, 51.0, 18.0, 9.0, 3.0, 0.0, 0.0);
		int y  =0;
		List<Double> list2 = Arrays.asList(0.0, 0.0, 0.0, -7.105427357601002e-15, 15.249999999999993, 30.499999999999993, 45.74999999999999, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.0, 61.00000000000006, 48.80000000000001, 36.60000000000002, 24.400000000000034, 12.200000000000045, 0.0, 0.0, 0.0, 0.0);
		
		comparar(list1, list2);
		while(!checklist(list1, list2)) {
			list1 = diferenca(list1, list2);
			y++;
			}
		for(Double n : list1) {
			System.out.println(n);
		}	
		
		System.out.println(y);
	}
	
	public static int comparar(List<Double> lista1, List<Double> lista2) {
		int n = 0;
		for (int i = 0; i <= lista1.size(); i++) {

			if(Math.abs(lista1.get(i) - lista2.get(i)) >= 5 ){
				n=i;
				i = lista1.size() +1;
			}
		}
		return n;
	}
	
	public static List<Double> diferenca(List<Double> lista1, List<Double> lista2) {
		double dif = 0;
		int n = comparar(lista1, lista2);
		List<Double> lista3 = lista1;
		dif = lista1.get(n) - lista2.get(n);
		if(dif < 0) {
			lista3.set(n, lista1.get(n) + dif);
			if(n > 0) {
				lista3.set(n - 1, lista3.get(n - 1) - dif*0.5);
			}
			if(n > lista3.size()) {
				lista3.set(n + 1, lista3.get(n + 1) - dif*0.5);
			}
		}
		if(dif > 0) {
			lista3.set(n, lista1.get(n) - dif);
			if(n > 0) {
				lista3.set(n - 1, lista3.get(n - 1) + dif*0.5);
			}
			if(n < lista3.size()) {
				lista3.set(n + 1, lista3.get(n + 1) + dif*0.5);
			}
		}
		
		return lista3;
	}
	
	public static boolean checklist(List<Double> lista1, List<Double> lista2) {
		int n = 0;
		for (Double num : lista1) {
			if(Math.abs(lista1.get(comparar(lista1, lista2))) - Math.abs(lista2.get(comparar(lista1, lista2))) > 5) {
				n ++;
			}
		}
		if(n > 0) {
			return false;
		}else return true;
	}
	

}
