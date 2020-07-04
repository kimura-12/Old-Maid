package card.game;

/**
 * ババ抜きのCPUプレイヤー．自動的にコンピュータが捨てるカード引くカードを選ぶ．
 * @author 	Takumi Kimura
 * @version 1.0, 2018-06-09
 */
public class CPU extends Player {

	public CPU(String name) {
		super(name);
	}

	/**
	 * CPUが捨てるカードを選択する
	 */
	@Override
	public void getRidOfCards() {

		int i, j;
		for (i = 1; i < deck.size() + 1; i++) {
			for (j = i + 1; j < deck.size() + 1; j++) {
				if (deck.seeCard(i).getNumber() == deck.seeCard(j).getNumber()) {
					System.out.println(deck.takeCard(i) + "と" + deck.takeCard(j - 1) + "を捨てます");
					j = 50;
					i = 0;
				}
			}
		}

		System.out.println("現在の" + name + "のカードの枚数は" + deck.size() + "です");

	}

	/**
	 * CPUが引くカードを選択する
	 */
	@Override
	public void takeCard(Player p) {

		int a = (int) (Math.random() * 100) % p.getDeck().size() + 1;
		deck.addCard(p.getDeck().takeCard(a));

	}
}
