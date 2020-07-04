package card.game;

/**
 * ババ抜きゲームアプリ
 * @author Takumi Kimura
 * @version 1.0, 2018-06-09
 */

public class OldMaidApp {

	public User user;
	GameMaster gM = new GameMaster();
	KeyBoard kB = new KeyBoard();

	public OldMaidApp() {

	}

	/**
	 * アプリを開始する
	 */
	public void startApp() {
		initialize();
		doGame();
		announceResult();
	}

	/**
	 * ババ抜きの初期設定する
	 */
	public void initialize() {

		System.out.println("■ババ抜きゲームアプリを起動します．");
		System.out.print("名前を入力してください：　");
		String name = kB.inputString();

		// プレイヤ数を入力
		int n;
		do {
			System.out.print("何人で遊びますか(2以上の整数)：");
			n = kB.inputNumber();
		} while (n < 2);

		user = new User(name);
		gM.addPlayer(user);

		for (int i = 1; i < n; i++) {
			gM.addPlayer(new CPU("CPU" + i));
		}

	}

	/**
	 * 結果を発表する
	 */
	public void announceResult() {

		gM.announceResult();
	}

	/**
	 * ババ抜きを行う
	 */
	public void doGame() {

		gM.startGame();

	}

	// テストのために作成
	public GameMaster getGameMaster() {
		return gM;
	}

}
