package ch.fhnw.muellerzumbrunn;

public class Schnitt {

	Ebene ebene1;
	Ebene ebene2;

	// neue Vektoren und Konstanten
	double[] g; // Stützvektor
	double[] h; // Richtungsvektor
	double p;
	double q;

	// Kopien der Vektoren aus den 2 Ebenen
	double[] r0;
	double[] a;
	double[] b;
	double A;
	double B;
	double C;
	double D;

	boolean ebenenParallel;
	boolean ebenenGleich;

	public Schnitt(Ebene ebene1, Ebene ebene2) {
		this.ebene1 = ebene1;
		this.ebene2 = ebene2;

		initialisierung();

		schnittBerechnung();
	}

	private void schnittBerechnung() {
		double pZaehler = A * b[0] + B * b[1] + C * b[2];
		double pNenner = A * a[0] + B * a[1] + C * a[2];
		
		if (pNenner == 0.0) {
			// Ebenen sind parallel, Schnittgerade wird nicht berechnet
			ebenenParallel = true;

			double[] r0e2 = ebene2.getr0();
			if ((r0[0] == r0e2[0] && r0[1] == r0e2[1] && r0[2] == r0e2[2]) // r0 ist gleich
			        || (A == ebene1.getA() && B == ebene1.getB() && C == ebene1.getC() && D == ebene1.getD())) {
			            // Ebenen sind in Koordinatenform gleich
				// Ebenen sind gleich
				ebenenGleich = true;
			}
		} else {
			// Ebenen sind nicht parallel, also existiert eine Schnittgerade
			p = -(pZaehler / pNenner);
			q = ((A * r0[0] + B * r0[1] + C * r0[2]) / (A * a[0] + B * a[1] + C * a[2]));

			g[0] = r0[0] + q * a[0];
			g[1] = r0[1] + q * a[1];
			g[2] = r0[2] + q * a[2];

			h[0] = p * a[0] + b[0];
			h[1] = p * a[1] + b[1];
			h[2] = p * a[2] + b[2];
		}
	}

	public void schnittAusgabe() {
		if (ebenenGleich) {
			System.out.println("\n--- Die Ebenen sind gleich.");
		} else if (ebenenParallel) {
			System.out.println("\n--- Die Ebenen sind parallel.");
		} else {
			System.out.println("\n--- Schnittgerade der beiden Ebenen:");
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(g[0]);
			sb.append(", ");
			sb.append(g[1]);
			sb.append(", ");
			sb.append(g[2]);
			sb.append(")\u1d40 + s("); // hochgestelltes T (transponiert)
			sb.append(h[0]);
			sb.append(", ");
			sb.append(h[1]);
			sb.append(", ");
			sb.append(h[2]);
			sb.append(")\u1d40");
			System.out.println(sb.toString());
		}
	}

	private void initialisierung() {
		g = new double[3];
		h = new double[3];

		r0 = new double[3];
		a = new double[3];
		b = new double[3];

		r0 = ebene1.getr0();
		a = ebene1.geta();
		b = ebene1.getb();

		A = ebene2.getA();
		B = ebene2.getB();
		C = ebene2.getC();
		D = ebene2.getD();

		ebenenParallel = false;
		ebenenGleich = false;
	}

}
