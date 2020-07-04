package card.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * トランプのカードデッキクラス
 *
 * @author Takumi Kimura
 * @version 1.0
 */

public class CardDeck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	public CardDeck() {

	}

	/**
	 * 52枚のフルデッキを作る
	 */
	public void createFullDeck() {
		int i, j;
		System.out.println("フルデッキを作ります");
		for (i = 0; i < 4; i++) {
			for (j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				addCard(card);
			}
		}
	}

	/**
	 * デッキを空にする
	 */
	public void clear() {
		cards.clear();
	}

	/**
	 * デッキをシャッフルする
	 */
	public void shuffle() {
		System.out.println("デッキをシャッフルします");
		Collections.shuffle(cards);
	}

	/**
	 * デッキの一番最後に，任意のカードcardを追加する
	 *
	 * @param card 任意に作成したトランプのカード
	 *
	 */
	public void addCard(Card card) {
		cards.add(card);
	}

	/**
	 * デッキの i 番目に，任意のカードcardを追加する
	 *
	 * @param i デッキのi番目
	 * @param card 任意に作成したトランプのカード
	 */

	public void addCard(int i, Card card) {
		cards.add(i - 1, card);
	}

	/**
	 *デッキの一番上の（１番目の）カードを取る
	 *
	 * @return 一番上のカード
	 */

	public Card takeCard() {
		Card a;
		a = cards.get(0);
		cards.remove(0);
		return a;
	}

	/**
	 * デッキの i 番目から，カードを抜き取る
	 * @param i デッキの i 番目
	 * @return i番目のカード
	 */

	public Card takeCard(int i) {
		Card a;
		a = cards.get(i - 1);
		cards.remove(i - 1);
		return a;
	}

	/**
	 * デッキのi番目にあるカードを見る
	 * @param i デッキのi番目
	 * @return i番目のカード
	 */

	public Card seeCard(int i) {
		return cards.get(i - 1);
	}

	/**
	 * 絵柄suitと番号numberを与えて，そのカードがデッキの何番目にあるかを調べる
	 *
	 * @param suit 絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number 数字 (1-13)
	 * @return カードが何番目にあるか
	 */

	public int searchCard(int suit, int number) {
		int i;
		for (i = 1; i < size() + 1; i++) {
			if (seeCard(i).getSuit() == suit && seeCard(i).getNumber() == number) {
				break;
			}
		}
		return i;
	}

	/**
	 * 現在のデッキが空かどうか，判定する
	 * @return true or false
	 */

	public boolean isEmpty() {

		return cards.isEmpty();

	}

	/**
	 * 現在デッキにあるカード枚数を返す
	 * @return カード枚数
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * 現在のすべてのカードを画面に表示する
	 */

	public void showAllCards() {
		int i;
		System.out.println("--------------現在の山を表示します-------------");
		for (i = 1; i < size() + 1; i++) {
			System.out.print(i + "番目のカード:");
			System.out.println(seeCard(i));
		}
		System.out.println("-----------------------------------------------");

	}

	/**
	 * 現在デッキにある全てのカードを返す
	 * @return すべてのカード
	 */

	public List<Card> getAllCards() {
		int i;
		List<Card> cards = new ArrayList<Card>();
		for (i = 1; i < size() + 1; i++) {
			cards.add(seeCard(i));
		}
		return cards;
	}

}
