
package hausaufgaben_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Goldpreis {
	private ArrayList<Goldtagespreis> list = new ArrayList<>();

	public Goldpreis(String dateiname) throws FileNotFoundException, ParseException {
		// Initalisieren von Scanner mit richtigem File, der adressiert wird
		// Scanner sc = null;
		File f = new File(dateiname);
		try (Scanner sc = new Scanner(f);) {
			// read every line and create new object Goldtagespreis
			while (sc.hasNextLine()) {
				String[] rawData = sc.nextLine().split("\t", 0);
				// Test code: System.out.println(Arrays.toString(rawData));

				// cannot easily parse Sting, since it is in the German numbers format. Hence
				// coverting it with NumberFromat into an object, which can get convertred into
				// a double

				double preis; // has to be initialized outside of try-catch
				try {// when there is no price determined, it is set to -1 and added to the list
					if (rawData[1].equals("kein Nachweis")) {
						preis = -1;
						Goldtagespreis newEntry = new Goldtagespreis(rawData[0], preis);
						list.add(newEntry);
						continue;
					}
					NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
					Number number = format.parse(rawData[1]);
					preis = number.doubleValue();
				} catch (ParseException e) {
					continue;
				}

				Goldtagespreis newEntry = new Goldtagespreis(rawData[0], preis);
				list.add(newEntry);
			}

		}
		// TODO: I dont know if the list is set up correctly

	}

	public void printMinMax() {
		// min und max werden mit dem ersten Goldpreis belegt und
		// solange geaendert, bis diese den minimal und maximal Prei beinhalten
		double min = list.get(0).preis, max = list.get(0).preis;
		String sMin = null, sMax = null;
		for (Goldtagespreis a : list) {
			if (a.preis > max) {
				max = a.preis;
				sMax = a.datum;
			}
			if (a.preis < min && a.preis != -1) {
				min = a.preis;
				sMin = a.datum;
			}
		}
		System.out.printf("Den niedrigsten Goldpreis von %.1f gab es an folgenden Tagen:\n%s\n"
				+ "Den hoechsten Goldpreis von %.1f gab es an folgenden Tagen:\n%s\n", min, sMin, max, sMax);
	}

	/**
	 * gibt den Preis an einem bestimmten Tag heraus, falls dieser im richtigen
	 * Format an die Methode uebergeben wird und im Datensatz existiert
	 * 
	 * @param datum
	 * @return
	 */
	public String getPreis(String datum) {
		for (Goldtagespreis a : list) {
			if (datum.equals(a.datum)) { // Achtung: hier mit equals vergleichen!

				return "" + a.preis;
			}
		}
		throw new NumberFormatException();
	}

	public static void main(String[] args) throws ParseException {
//		try {
//			Goldpreis FaMGoldpreis = new Goldpreis("gold.txt");
//			String s1 = FaMGoldpreis.getPreis("2009-01-02");
//			System.out.println(s1);
//			FaMGoldpreis.printMinMax();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			Goldpreis test = new Goldpreis("gold.txt"); // eventuell anderer Pfad
			System.out.println(test.getPreis("2009-10-20")); // 22870.0
			System.out.println(test.getPreis("2009-02-07")); // -1
			test.printMinMax();
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden");
		}
	}
}
