package sk.bernardkaminski.Bankomat_simulator;

/**
 * Trieda reprezentuje klienta.
 * 
 * @author berni
 *
 */
public class Klient {

	private int id;
	private int pin;
	private BankovyUcet beznyUcet;
	private BankovyUcet sporiaciUcet;

	/**
	 * vytvara novy objekt klient s vlastnym klientsky cislom a pinom
	 * 
	 * @param id  klientske cislo
	 * @param pin pin klienta
	 */
	public Klient(int id, int pin) {
		this.id = id;
		this.pin = pin;
		beznyUcet = new BankovyUcet();
		sporiaciUcet = new BankovyUcet();
	}

	/**
	 * zistuje ci je su klientove udaje totozne s udajmi v banke
	 * 
	 * @param klientskeCislo klientske cislo
	 * @param pin            pin klienta
	 * @return true / false
	 */
	public boolean jeTotoznyS(int klientskeCislo, int pin) {
		return (this.id == klientskeCislo && this.pin == pin);
	}

	/**
	 * vracia bezny ucet klienta
	 * 
	 * @return bezny ucet klienta
	 */
	public BankovyUcet getBeznyUcet() {
		return beznyUcet;
	}

	/**
	 * vracia sporiaci ucet klienta
	 * 
	 * @return sporiaci ucet klienta
	 */
	public BankovyUcet getSporiaciUcet() {
		return sporiaciUcet;
	}
}
