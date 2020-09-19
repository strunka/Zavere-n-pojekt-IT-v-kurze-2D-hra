package Database;

public class Player {

	private String meno;
	private int score;
	private String id;

	public Player(int id, String meno, int score) {
		this.meno = meno;
		this.score = score;
		this.id = String.valueOf(id);
	}

	public Player(String meno, int score) {
		this.meno = meno;
		this.score = score;
	}

	public Player(String meno) {
		this.meno = meno;
	}

	public String getMeno() {
		return meno;
	}

	public int getScore() {
		return score;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Player [meno=" + meno + ", score=" + score + "]";
	}

}
