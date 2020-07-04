package card.game;

import card.entity.Card;
import card.entity.CardDeck;

/**
 * ババ抜きのプレーヤクラス
 *
 * @author Takumi Kimura
 * @version 1.0, 2018-06-09
 */

public abstract class Player {
	protected CardDeck deck;
	protected String name;

	/**
	 * 名前を指定してプレイヤを作成する
	 * @param name 名前
	 */
	public Player(String name) {

		if (name.length() == 0 || name == null) {
			this.name = "名無し";
		} else {
			this.name = name;
		}
	}

	/**
	 * プレイヤが同じ数字のカードがあれば捨てる．具体的な選び方はサブクラスに任せる
	 */
	public abstract void getRidOfCards();

	/**
	 * プレイヤーが自分の次のプレイヤーのカードを引く　具体的な引き方はサブクラスに任せる
	 * @param p　自分の次のプレイヤー
	 */
	public abstract void takeCard(Player p);

	/**
	 * 自分の持ちカードをすべて公開する
	 */
	public void showCards() {
		deck.showAllCards();
	}

	/**
	 * プレイヤーの名前を返す
	 * @return　名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * プレイヤーのデッキにカードを追加する
	 * @param card
	 */
	public void setCards(Card card) {
		deck.addCard(card);
	}

	/**
	 * プレイヤーのデッキに受け取ったデッキをセットする
	 * @param cD　デッキ
	 */
	public void setDeck(CardDeck cD) {
		deck = cD;
	}

	/**
	 * プレイヤーのデッキを返す
	 * @return　プレイヤーのデッキ
	 */
	public CardDeck getDeck() {
		return deck;
	}

}
