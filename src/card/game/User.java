package card.game;

/**
 * ババ抜きのユーザプレイヤ．ユーザがキーボードで捨てるカードと引くカードを選ぶ
 * @author Takumi Kimura
 * @version 1.0, 2018-06-09
 */
public class User extends Player {

	KeyBoard kB = new KeyBoard();

	public User(String name) {
		super(name);
	}

	/**
	 * ユーザが捨てるカードを選ぶ
	 */
	@Override
	public void getRidOfCards() {

		int a = 1;
		int b;
		while (true) {
			System.out.println("捨てる手札を番号で選んでください 0でスキップ");
			showCards();
			a = kB.inputNumber();
			if (a == 0) {
				break;
			}
			b = kB.inputNumber();

			if ((a < 0 || a > deck.size()) || (b < 0 || b > deck.size())) {
				System.out.println("範囲外です　もう一度");
				continue;
			}else if(a == b) {
				System.out.println("同じ数字を入力しないでください。");
				continue;
			}

			if (deck.seeCard(a).getNumber() == deck.seeCard(b).getNumber()) {
				if (a < b) {
					System.out.println(deck.takeCard(a) + "と" + deck.takeCard(b - 1) + "を捨てます");
				} else {
					System.out.println(deck.takeCard(a) + "と" + deck.takeCard(b) + "を捨てます");
				}
			} else {
				System.out.println("数字が一致しません");
			}
		}

	}

	/**
	 * ユーザが引くカードを選ぶ
	 */
	@Override
	public void takeCard(Player p) {

		System.out.println(p.getName() + "は現在" + p.getDeck().size() + "枚のカードを持っています");
		System.out.println("1 ~ " + p.getDeck().size() + "の数字で引きたいものを選んでください");
		int a = kB.inputNumber();
		while (a < 1 || a > p.getDeck().size()) {
			System.out.println("範囲外です　もう一度");
			a = kB.inputNumber();
		}
		deck.addCard(p.getDeck().takeCard(a));

	}
}
