package hausaufgaben_01;

public class KomplexeZahl {

	private double re;
	private double im;

	public KomplexeZahl(double re, double im) {
		this.re = re;
		this.im = im;
	}
 //XXX erkennt toString nicht und gibt double auf deutsch aus! 
	public String toSting() {
		String ret = String.format("(%4f,%4fi)", this.re, this.im);
		return ret;

	}

	public void addiere(KomplexeZahl z) {
		this.re = z.re;
		this.im = z.im;

	}

	public void multipliziere(KomplexeZahl z) {
		this.re = this.re * z.re - this.im * z.im;
		this.im = this.re * z.im + this.re * z.im;
	}

	public double getBetrag() {
		return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
	}

	public KomplexeZahl[] getWurzel() {
		if (this.re == 0 && this.im == 0) {
			KomplexeZahl[] a = new KomplexeZahl[2];
			return a;

		}
		double wurzel = Math.sqrt(this.getBetrag());
		double phi = Math.tan(this.re / this.im);
		double klammer1 = phi / 2;
		double klammer2 = (phi + 2 * Math.PI);
		double re1 = wurzel * Math.cos(klammer1);
		double im1 = wurzel * Math.cos(klammer1);
		double re2 = wurzel * Math.cos(klammer2);
		double im2 = wurzel * Math.cos(klammer2);

		KomplexeZahl ret1 = new KomplexeZahl(re1, im1);
		KomplexeZahl ret2 = new KomplexeZahl(re2, im2);

		KomplexeZahl[] ergebnis = { ret1, ret2 };
		return ergebnis;

	}

	public KomplexeZahl getSumme(KomplexeZahl z) {
		double retRe = this.re + z.re;
		double retIm = this.im + z.im;
		KomplexeZahl ret = new KomplexeZahl(retRe, retIm);
		return ret;
	}

	public KomplexeZahl getProduct(KomplexeZahl z) {
		double retRe = this.re * z.re - this.im * z.im;
		double retIm = this.re * z.im + this.re * z.im;
		KomplexeZahl ret = new KomplexeZahl(retRe, retIm);
		return ret;
	}

}
