package ch.fhnw.muellerzumbrunn;

public class Ebene {

	// Parameterform
	double[] r0;
	double[] a;
	double[] b;

	// Normalenform
	double[] n; // r0 ist gleich wie bei der Parameterform

	// Koordinatenform
	double A;
	double B;
	double C;
	double D;

	/**
	 * Parameterformkonstruktor.
	 */
	public Ebene(double[] r0, double[] a, double[] b) {
		initialisierung();

		this.r0 = r0;
		this.a = a;
		this.b = b;

		parameterZuNormalenForm();
		normalenZuKoordinatenForm();
	}

	/**
	 * Normalenformkonstruktor.
	 */
	public Ebene(double[] n, double[] r0) {
		initialisierung();

		this.n = n;
		this.r0 = r0;

		normalenZuKoordinatenForm();
		koordinatenZuParameterForm();
	}

	/**
	 * Koordinatenformkonstruktor.
	 */
	public Ebene(double A, double B, double C, double D) {
		initialisierung();

		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;

		koordinatenZuParameterForm();
		parameterZuNormalenForm();
	}

	/**
	 * Berechnung des Vektors n der Ebene.
	 */
	private void parameterZuNormalenForm() {
		n[0] = (a[1] * b[2]) - (a[2] * b[1]);
		n[1] = (a[2] * b[0]) - (a[0] * b[2]);
		n[2] = (a[0] * b[1]) - (a[1] * b[0]);
	}

	/**
	 * Berechung der Koordinaten A, B, C und D der Ebene.
	 */
	private void normalenZuKoordinatenForm() {
		A = n[0];
		B = n[1];
		C = n[2];
		D = -(n[0] * r0[0] + n[1] * r0[1] + n[2] * r0[2]);
	}

	/**
	 * Berechnung der Vektoren r0, a und b der Ebene.
	 */
	private void koordinatenZuParameterForm() {
		
		// Richtungsvektor r0
		if (A != 0.0) {
			r0[0] = -D / A;
			r0[1] = 0;
			r0[2] = 0;
		} else if (B != 0.0) {
			r0[0] = 0;
			r0[1] = -D / B;
			r0[2] = 0;
		} else {
			r0[0] = 0;
			r0[1] = 0;
			r0[2] = -D / C;
		}

		// Stützvektoren a und b
		if (A == 0.0 && B == 0.0) {
			a[0] = -C;
			a[1] = 0;
			a[2] = A;

			b[0] = 0;
			b[1] = -C;
			b[2] = B;
		} else if (C == 0.0 && B == 0.0) {
			a[0] = -B;
			a[1] = A;
			a[2] = 0;

			b[0] = -C;
			b[1] = 0;
			b[2] = A;
		} else {
			a[0] = -B;
			a[1] = A;
			a[2] = 0;

			b[0] = 0;
			b[1] = -C;
			b[2] = B;
		}
	}

	public void parameterFormAusgabe() {
		StringBuilder sb = new StringBuilder();
		sb.append("Parameterform: \t\t");
		sb.append("r = (");
		sb.append(r0[0]);
		sb.append(", ");
		sb.append(r0[1]);
		sb.append(", ");
		sb.append(r0[2]);
		sb.append(")\u1d40 + t("); // hochgestelltes T (transponiert)
		sb.append(a[0]);
		sb.append(", ");
		sb.append(a[1]);
		sb.append(", ");
		sb.append(a[2]);
		sb.append(")\u1d40 + s(");
		sb.append(b[0]);
		sb.append(", ");
		sb.append(b[1]);
		sb.append(", ");
		sb.append(b[2]);
		sb.append(")\u1d40");
		System.out.println(sb.toString());
	}

	public void normalenFormAusgabe() {
		StringBuilder sb = new StringBuilder();
		sb.append("Normalenform: \t\t");
		sb.append("(");
		sb.append(n[0]);
		sb.append(", ");
		sb.append(n[1]);
		sb.append(", ");
		sb.append(n[2]);
		sb.append(")\u1d40 \u2218 (r - (");
		sb.append(r0[0]);
		sb.append(", ");
		sb.append(r0[1]);
		sb.append(", ");
		sb.append(r0[2]);
		sb.append(")\u1d40) = 0");
		System.out.println(sb.toString());
	}

	public void koordinatenFormAusgabe() {
		StringBuilder sb = new StringBuilder();
		sb.append("Koordinatenform: \t");
		sb.append(A);
		sb.append("x + ");
		sb.append(B);
		sb.append("y + ");
		sb.append(C);
		sb.append("z + ");
		sb.append(D);
		sb.append(" = 0");
		System.out.println(sb.toString());
	}

	public void initialisierung() {
		r0 = new double[3];
		a = new double[3];
		b = new double[3];
		n = new double[3];
	}
	
	public double[] getr0() {
		return r0;
	}

	public double[] geta() {
		return a;
	}

	public double[] getb() {
		return b;
	}
	
	public double getA() {
		return A;
	}

	public double getB() {
		return B;
	}

	public double getC() {
		return C;
	}

	public double getD() {
		return D;
	}
}
