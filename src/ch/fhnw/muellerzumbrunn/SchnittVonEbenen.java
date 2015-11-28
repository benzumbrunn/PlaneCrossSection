package ch.fhnw.muellerzumbrunn;

import java.util.Scanner;

public class SchnittVonEbenen {

	static Ebene ebene1;
	static Ebene ebene2;
	static Scanner sc;
	static Schnitt schnitt;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		programmStart();
		int funktionsAuswahl = sc.nextInt();

		if (funktionsAuswahl == 1) { // Eine Ebene transformieren
			ebene1Start();
		} else if (funktionsAuswahl == 2) { // Schnitt zweier Ebenen untersuchen
			// Erste Ebene
			ebene1Start();
			// Zweite Ebene
			ebene2Start();

			// Schnitt der Ebenen
			schnitt = new Schnitt(ebene1, ebene2);
			schnitt.schnittAusgabe();
		} else {
			System.out.println("Falsche Eingabe, Programm wird beendet.");
			System.exit(1);
		}

		sc.close();
	}

	/**
	 * Prints bei Start des Programmes.
	 */
	private static void programmStart() {
		System.out.println("\n--- Schnitt von Ebenen ---");
		System.out.println("Was möchten Sie tun? [1 / 2]");
		System.out.println("1: Ebene in andere Formen umwandeln");
		System.out.println("2: Schnitt von zwei Ebenen untersuchen");
	}

	/**
	 * Prints für Ebene 1.
	 */
	private static void ebene1Start() {
		System.out.println("\nGeben Sie eine Ebene ein.\n");
		System.out.println("Welche Form geben Sie ein? [1 / 2 / 3]");
		System.out.println("1: Parameterform");
		System.out.println("2: Normalenform");
		System.out.println("3: Koordinatenform");

		int ebene1Auswahl = sc.nextInt();

		if (ebene1Auswahl == 1) {
			ebene1 = parameterFormEingabe();

			ebene1.parameterFormAusgabe();
			ebene1.normalenFormAusgabe();
			ebene1.koordinatenFormAusgabe();
		} else if (ebene1Auswahl == 2) {
			ebene1 = normalenFormEingabe();

			ebene1.normalenFormAusgabe();
			ebene1.koordinatenFormAusgabe();
			ebene1.parameterFormAusgabe();
		} else if (ebene1Auswahl == 3) {
			ebene1 = koordinatenFormEingabe();

			ebene1.koordinatenFormAusgabe();
			ebene1.parameterFormAusgabe();
			ebene1.normalenFormAusgabe();
		} else {
			System.out.println("Falsche Eingabe der ersten Ebene, Programm wird beendet.");
			System.exit(1);
		}
	}

	/**
	 * Prints für Ebene 2.
	 */
	private static void ebene2Start() {
		System.out.println("\nGeben Sie nun eine zweite Ebene ein.\n");
		System.out.println("Welche Form geben Sie ein? [1 / 2 / 3]");
		System.out.println("1: Parameterform");
		System.out.println("2: Normalenform");
		System.out.println("3: Koordinatenform");

		int ebene2Auswahl = sc.nextInt();

		if (ebene2Auswahl == 1) {
			ebene2 = parameterFormEingabe();

			ebene2.parameterFormAusgabe();
			ebene2.normalenFormAusgabe();
			ebene2.koordinatenFormAusgabe();
		} else if (ebene2Auswahl == 2) {
			ebene2 = normalenFormEingabe();

			ebene2.normalenFormAusgabe();
			ebene2.koordinatenFormAusgabe();
			ebene2.parameterFormAusgabe();
		} else if (ebene2Auswahl == 3) {
			ebene2 = koordinatenFormEingabe();

			ebene2.koordinatenFormAusgabe();
			ebene2.parameterFormAusgabe();
			ebene2.normalenFormAusgabe();
		} else {
			System.out.println("Falsche Eingabe der zweiten Ebene, Programm wird beendet.");
			System.exit(1);
		}
	}

	/**
	 * Prints und Scanner für Koordinatenformeingabe.
	 * 
	 * @return neue Ebene anhand von Koordinatenformkonstruktor erstellt.
	 */
	private static Ebene koordinatenFormEingabe() {
		System.out.println("Koordinatenform: Ax + By + Cz + D = 0");

		System.out.println("Geben Sie A ein:");
		double A = sc.nextDouble();
		System.out.println("Geben Sie B ein:");
		double B = sc.nextDouble();
		System.out.println("Geben Sie C ein:");
		double C = sc.nextDouble();
		System.out.println("Geben Sie D ein:");
		double D = sc.nextDouble();

		return new Ebene(A, B, C, D);
	}

	/**
	 * Prints und Scanner für Normalenformeingabe.
	 * 
	 * @return neue Ebene anhand von Normalenformkonstruktor erstellt.
	 */
	private static Ebene normalenFormEingabe() {
		System.out.println("Normalenform: n \u2218 (r - r0) = 0");

		double[] n = new double[3];
		System.out.println("Geben Sie n1 ein:");
		n[0] = sc.nextDouble();
		System.out.println("Geben Sie n2 ein:");
		n[1] = sc.nextDouble();
		System.out.println("Geben Sie n3 ein:");
		n[2] = sc.nextDouble();

		double[] r0 = new double[3];
		System.out.println("Geben Sie r0.1 ein:");
		r0[0] = sc.nextDouble();
		System.out.println("Geben Sie r0.2 ein:");
		r0[1] = sc.nextDouble();
		System.out.println("Geben Sie r0.3 ein:");
		r0[2] = sc.nextDouble();

		return new Ebene(n, r0);
	}

	/**
	 * Prints und Scanner für Parameterformeingabe.
	 * 
	 * @return neue Ebene anhand von Parameterformkonstruktor erstellt.
	 */
	private static Ebene parameterFormEingabe() {
		System.out.println("Parameterform: r = r0 + ta + sb");

		double[] r0 = new double[3];
		System.out.println("Geben Sie r0.1 ein:");
		r0[0] = sc.nextDouble();
		System.out.println("Geben Sie r0.2 ein:");
		r0[1] = sc.nextDouble();
		System.out.println("Geben Sie r0.3 ein:");
		r0[2] = sc.nextDouble();

		double[] a = new double[3];
		System.out.println("Geben Sie a1 ein:");
		a[0] = sc.nextDouble();
		System.out.println("Geben Sie a2 ein:");
		a[1] = sc.nextDouble();
		System.out.println("Geben Sie a3 ein:");
		a[2] = sc.nextDouble();

		double[] b = new double[3];
		System.out.println("Geben Sie b1 ein:");
		b[0] = sc.nextDouble();
		System.out.println("Geben Sie b2 ein:");
		b[1] = sc.nextDouble();
		System.out.println("Geben Sie b3 ein:");
		b[2] = sc.nextDouble();

		return new Ebene(r0, a, b);
	}

}
