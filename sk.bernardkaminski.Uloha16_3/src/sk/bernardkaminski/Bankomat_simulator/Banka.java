package sk.bernardkaminski.Bankomat_simulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Trieda reprezentuje Banku.
 * 
 * @author berni
 *
 */
public class Banka {

	private ArrayList<Klient> klienti;

	/**
	 * vytvara novy objekt banka
	 */
	public Banka() {
		klienti = new ArrayList<>();
	}

	/**
	 * nacita klientske udaje zo suboru
	 * 
	 * @param nazovSuboru subor s udajmi o klientoch
	 * @throws FileNotFoundException vynimka subor sa nenasiel
	 */
	public void nacitajKlientov(String nazovSuboru) throws FileNotFoundException {
		Scanner vstupZoSuboru = new Scanner(new FileReader(nazovSuboru));

		while (vstupZoSuboru.hasNext()) {
			int klientskeCislo = vstupZoSuboru.nextInt();
			int pin = vstupZoSuboru.nextInt();
			Klient klient = new Klient(klientskeCislo, pin);
			pridajKlienta(klient);
		}

		vstupZoSuboru.close();
	}

	/**
	 * pridava klienta do zoznamu klientov
	 * 
	 * @param klient novy klient
	 */
	public void pridajKlienta(Klient klient) {
		klienti.add(klient);
	}

	/**
	 * vyhlada klienta a zisti ci sa jeho udaje zhoduju s udajmi v banke
	 * 
	 * @param klientskeCislo klientske cislo klienta
	 * @param pin            pin klienta
	 * @return vrati klienta ak presiel validaciou v opacnom priprade vrati null
	 */
	public Klient vyhladajKlienta(int klientskeCislo, int pin) {
		for (Klient klient : klienti) {
			if (klient.jeTotoznyS(klientskeCislo, pin)) {
				return klient;
			}
		}
		JOptionPane.showMessageDialog(null, "Nespravne klientske cislo alebo PIN");
		return null;
	}
}
