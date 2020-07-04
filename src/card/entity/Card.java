package card.entity;

/**
 * トランプのカードクラス
 *
 * @author Takumi Kimura
 * @version 1.0
 * @see CardDeck
 */

public class Card {

	private int suit;
	private int number;

	/**
	 * 絵柄と数字を指定してカードを生成する
	 *
	 * @param suit
	 *            絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number
	 *            数字 (1-13)
	 */

	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	/**
	 * カードの絵柄を取得する
	 *
	 * @return 絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 */

	public int getSuit() {
		return suit;
	}

	/**
	 * カードの数字を取得する
	 *
	 * @return 数字 (1-13, 0)
	 */

	public int getNumber() {
		return number;
	}

	/**
	 * カードの整数表現を取得する
	 *
	 * @return 整数表現 (0-51, -1)
	 */

	public int toIndex() {

		return getIndex(getSuit(), getNumber());

	}

	/**
	 * カードの文字列表現を取得する
	 *
	 * @return 文字列表現 (スペードA, スペード2, ...)
	 */

	public String toString() {

		return getString(getSuit(), getNumber());

	}

	/**
	 * カードの文字列表現を画面に表示する
	 */

	public void show() {
		System.out.println(toString());
	}

	/**
	 * 与えられた絵柄，数字から整数表現を計算して返す．
	 *
	 * @param suit
	 *            絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number
	 *            数字 (1-13, 0)
	 * @return カードの整数表現 (0-51, -1)
	 */

	public static int getIndex(int suit, int number) {
		if (number == 0) {
			return -1;
		} else {
			return suit * 13 + number - 1;
		}
	}

	/**
	 * 与えられた絵柄，数字から文字列表現を決定して返す．
	 *
	 * @param suit
	 *            絵柄 (0:スペード，1:ダイヤ，2:ハート，3:クラブ, -1:ジョーカー)
	 * @param number
	 *            数字 (1-13, 0)
	 * @return カードの文字列表現 (スペードA, スペード2, ...)
	 */

	public static String getString(int suit, int number) {

		if (suit == -1) {
			return "ジョーカー";
		} else {

			switch (suit) {
			case 0:
				if (number == 1) {
					return "スペードA";
				} else if (number == 11) {
					return "スペードJ";
				} else if (number == 12) {
					return "スペードQ";
				} else if (number == 13) {
					return "スペードK";
				} else {
					return "スペード" + number;
				}
			case 1:
				if (number == 1) {
					return "ダイヤA";
				} else if (number == 11) {
					return "ダイヤJ";
				} else if (number == 12) {
					return "ダイヤQ";
				} else if (number == 13) {
					return "ダイヤK";
				} else {
					return "ダイヤ" + number;
				}
			case 2:
				if (number == 1) {
					return "ハートA";
				} else if (number == 11) {
					return "ハートJ";
				} else if (number == 12) {
					return "ハートQ";
				} else if (number == 13) {
					return "ハートK";
				} else {
					return "ハート" + number;
				}
			case 3:
				if (number == 1) {
					return "クラブA";
				} else if (number == 11) {
					return "クラブJ";
				} else if (number == 12) {
					return "クラブQ";
				} else if (number == 13) {
					return "クラブK";
				} else {
					return "クラブ" + number;
				}
			}
			return "存在しないカード";
		}
	}

}
