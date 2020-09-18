package sk.bernardkaminski.Bankomat_simulator;

import javax.swing.JOptionPane;

/**
 * Trieda reprezentuje bankovy ucet v banke
 * 
 * @author berni
 *
 */
public class BankovyUcet {

	private double aktualnyZostatok;

	/**
	 * vytvara novy bankovy ucet s nulovym pociatocnym zostatkom
	 */
	public BankovyUcet() {
		this(0);
	}

	/**
	 * vytvara bankovy ucet s pociatocnym zostatok
	 * 
	 * @param pociatocnyZostatok pociatocny zostatok na ucte
	 */
	public BankovyUcet(double pociatocnyZostatok) {
		this.aktualnyZostatok = pociatocnyZostatok;
	}

	/**
	 * vracia aktualny zostatok na ucte
	 * 
	 * @return
	 */
	public double getAktualnyZostatok() {
		return aktualnyZostatok;
	}

	/**
	 * vklada ciastku na ucet
	 * 
	 * @param ciastka na vklad
	 */
	public void vloz(double ciastka) {

		if (ciastka < 0)
			JOptionPane.showMessageDialog(null, "Nepovolena transakcia");
		else
			this.aktualnyZostatok += ciastka;
	}

	/**
	 * vybera ciastku z uctu
	 * 
	 * @param ciastka ciastka na vyber
	 */
	public void vyber(double ciastka) {

		if (ciastka < 0 || ciastka > aktualnyZostatok)
			JOptionPane.showMessageDialog(null, "Nepovolena transakcia");
		else
			this.aktualnyZostatok -= ciastka;
	}
}
