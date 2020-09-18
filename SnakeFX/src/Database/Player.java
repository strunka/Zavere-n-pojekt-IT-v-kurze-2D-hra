package Database;

public class Player {

	private String meno;
	private int score;
	private int id;

	public Player(int id, String meno, int score) {
		this.id = id;
		this.meno = meno;
		this.score = score;
	}

	public String getMeno() {
		return meno;
	}

	public int getScore() {
		return score;
	}

	public int getId() {
		return id;
	}

}
