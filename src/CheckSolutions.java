//public class CheckSolutions {

//}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CheckSolutions {

	public static void main(String[] args) throws IOException {
		String rooms[][];
		String students[][];
		int nbr_rooms = 0;
		int nbr_students = 0;
		int nbr_distinct_courses = 0;
		int i = 0;
		int index = 0;
		int nbr_of_places;

		BufferedReader br = new BufferedReader(new FileReader(new File("/datasheets/solutions/car-f-92(3.71).sol")));
		Scanner s = new Scanner(br);
		while (s.hasNext()) {
			nbr_rooms++;
			s.nextLine();
		}
		s.close();
		rooms = new String[2][nbr_rooms];


		br = new BufferedReader(new FileReader(new File("/datasheets/solutions/car-f-92(3.71).sol")));
		s = new Scanner(br);
		while (s.hasNext()) {
			rooms[0][i] = s.next();
			rooms[1][i++] = s.next();
		}
		s.close();
		i = 0;

		br = new BufferedReader(new FileReader(new File("/datasheets/solutions/car-f-92(3.71).sol")));
		s = new Scanner(br);
		while (s.hasNext()) {
			nbr_students++;
			s.nextLine();
		}
		s.close();
		students = new String[2][nbr_students];

		br = new BufferedReader(new FileReader(new File("/datasheets/solutions/car-f-92(3.71).sol")));
		s = new Scanner(br);
		while (s.hasNext()) {
			students[0][i] = s.next();
			students[1][i++] = s.next();
		}
		s.close();
		nbr_of_places = get_all_places(nbr_rooms, rooms);
		System.out.println("Διαθέσιμα:" + nbr_of_places);

		String courses[][] = new String[2][nbr_students];
		i = 0;
		int j = 0;
		for (i = 0; i < nbr_students; i++) {
			if (!found(courses, nbr_students, students[1][i])) {
				courses[0][j++] = students[1][i];
				nbr_distinct_courses++;
			}
		}
		
		i = 0;
		for (j = 0; j < nbr_distinct_courses; j++) {
			courses[1][j] = count_students(courses[0][j], nbr_students, students);
		}

		sort(courses, nbr_distinct_courses);

		Day day_table[] = new Day[10];
		for (j = 0; j < 10; j++) {
			day_table[j] = new Day(j + 1);
		}

		System.out.println("Προσθήκη μαθημάτων και εκτέλεση φόρτωσης.");
		int ii = 0;
		int jjj = 0;
		for (j = 0; j < nbr_distinct_courses; j++) {
			add(ii, jjj, day_table, courses[0][index], Integer.parseInt(courses[1][index++]), nbr_students, students,
					nbr_of_places);
			ii = (ii + 2) % 10;
			jjj = (jjj + 1) % 12;
		}
		System.out.println("Αριθμός μαθημάτων: " + nbr_distinct_courses);
		for (j = 0; j < 10; j++) {
			System.out.println("Ημέρα " + (j + 1) + " : " + day_table[j].exams.size() + " εξέτασης");
			day_table[j].print(j + 1);
		}
		System.out.println("Μεταφορά αποτελεσμάτων");
		
		FileWriter a = new FileWriter("/datasheets/solutions/car-f-92(3.71).sol");
		a.write("\n Προγραμματισμός εξέτασης \n");
		a.write("Αριθμός μαθημάτων: " + nbr_distinct_courses + "\n");
		for (j = 0; j < 10; j++)
			a.write("Μέρα " + (j + 1) + " : " + day_table[j].exams.size() + " εξετάσεις\n");

		a.write("\n Μέρα - Μάθημα \n");
		for (j = 0; j < 10; j++) {
			a.write(day_table[j].print_string(j + 1));
		}
		a.close();
		System.out.println("Done transferring to file results");
		System.out.println("Τέλος");

	}

	public static boolean found(String tab[][], int length, String a) {
		for (int i = 0; i < length; i++) {
			if (tab[0][i] != null && tab[0][i].equals(a))
				return true;
		}
		return false;
	}

	public static String count_students(String course, int length, String[][] tab) {
		int n = 0;
		for (int i = 0; i < length; i++) {
			if (tab[1][i].equals(course)) {
				n++;
			}
		}
		return Integer.toString(n);
	}

	public static void sort(String tab[][], int n) {
		int i, j, val;
		String val1;
		for (i = 1; i < n; i++) {
			val = Integer.parseInt(tab[1][i]);
			val1 = tab[0][i];
			for (j = i - 1; (j >= 0) && (Integer.parseInt(tab[1][j]) < val); j--) {
				tab[1][j + 1] = tab[1][j];
				tab[0][j + 1] = tab[0][j];
			}
			tab[1][j + 1] = Integer.toString(val);
			tab[0][j + 1] = val1;
		}

	}

	public static int get_all_places(int nbr_rooms, String tab[][]) {
		int n = 0;
		for (int i = 0; i < nbr_rooms; i++) {
			n += Integer.parseInt(tab[1][i]);
		}
		return n;
	}

	public static int get_nbr_of_students(int[][] tab, int n, int max) {
		int cmp = 0;
		for (int i = 0; i < n; i++) {
			if (tab[1][i] == max)
				cmp++;
		}
		return cmp;
	}
}
