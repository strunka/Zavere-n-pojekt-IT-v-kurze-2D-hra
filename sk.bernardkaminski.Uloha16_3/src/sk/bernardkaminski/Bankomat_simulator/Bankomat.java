package sk.bernardkaminski.Bankomat_simulator;

/**
 * Bankomat ma pristup do banky (patri konkretnej banke).
 */
public class Bankomat {
	private int stav;
	private int klientskeCislo;
	private Klient aktualnyKlient;
	private BankovyUcet aktualnyUcet;
	private Banka banka;

	public static final int START = 1;
	public static final int PIN = 2;
	public static final int UCET = 3;
	public static final int TRANSAKCIA = 4;

	public static final int BEZNY = 1;
	public static final int SPORIACI = 2;

	/**
	 * vytvara novy objekt bankomat s pristupom do konkretnej banky
	 * 
	 * @param banka banka s vlastnym zoznamom klientov
	 */
	public Bankomat(Banka banka) {
		this.banka = banka;
		reset();
	}

	/**
	 * vyresetuje bankomat a nastavy sa na start
	 */
	public void reset() {
		klientskeCislo = -1;
		aktualnyKlient = null;
		stav = START;
	}

	/**
	 * nastavuje klientske cislo
	 * 
	 * @param cislo klientske cislo
	 */
	public void nastavKlientskeCislo(int cislo) {
		assert stav == START;
		this.klientskeCislo = cislo;
		stav = PIN;
	}

	/**
	 * validuje spravnost udajov klienta na zaklade pinu a klientskeho cisla
	 * 
	 * @param pin
	 */
	public void nastavKlienta(int pin) {
		assert stav == PIN;
		this.aktualnyKlient = banka.vyhladajKlienta(klientskeCislo, pin);
		if (aktualnyKlient == null) {
			stav = START;
		} else {
			stav = UCET;
		}
	}

	/**
	 * nastavuje typ uctu
	 * 
	 * @param ucet bezny ucet alebo sporiaci ucet
	 */
	public void nastavTypUctu(int ucet) {
		assert stav == UCET || stav == TRANSAKCIA;
		if (ucet == BEZNY) {
			this.aktualnyUcet = aktualnyKlient.getBeznyUcet();
		} else {
			this.aktualnyUcet = aktualnyKlient.getSporiaciUcet();
		}
		stav = TRANSAKCIA;
	}

	/**
	 * vybera danu ciastku z uctu
	 * 
	 * @param ciastka ciastka na vyber
	 */
	public void vyber(double ciastka) {
		assert stav == TRANSAKCIA;

		this.aktualnyUcet.vyber(ciastka);
	}

	/**
	 * vklada zadanu ciastku na ucet
	 * 
	 * @param ciastka zadana ciastka na vklad
	 */
	public void vloz(double ciastka) {
		assert stav == TRANSAKCIA;

		this.aktualnyUcet.vloz(ciastka);
	}

	/**
	 * vracia aktualny zostatok na ucte
	 * 
	 * @return aktualny zostatok na ucte
	 */
	public double getAktualnyZostatok() {
		assert stav == TRANSAKCIA;
		return this.aktualnyUcet.getAktualnyZostatok();
	}

	/**
	 * nastavy bankomat do predchadzajuceho stavu
	 */
	public void nastavPredchadzajuciStav() {
		if (stav == TRANSAKCIA) {
			stav = UCET;
		} else if (stav == UCET) {
			stav = PIN;
		} else if (stav == PIN) {
			stav = START;
		}
	}

	/**
	 * vrati aktualny stav bankomatu
	 * 
	 * @return aktualny sav bankomatu
	 */
	public int getStav() {
		return this.stav;
	}
}
