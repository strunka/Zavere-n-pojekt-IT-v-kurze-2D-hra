package Database;

public class Player {

	private String meno;
	private int score;

	public Player(String meno, int score) {
		this.meno = meno;
		this.score = score;
	}

	public Player() {

	}

	public String getMeno() {
		return meno;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Player [meno=" + meno + ", score=" + score + "]";
	}

}
