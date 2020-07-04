package card.game;

import java.util.ArrayList;

import card.entity.Card;
import card.entity.CardDeck;

/**
 * ゲームマスタークラス
 *
 * @author Takumi Kimura
 * @version 1.0, 2018-06-09
 *
 */

public class GameMaster {

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<String> winner = new ArrayList<String>();

	private CardDeck cD;
	private int random;

	public GameMaster() {

	}

	/**
	 * プレイヤーを追加する
	 * @param player　ババ抜きに参加するプレイヤー
	 */

	public void addPlayer(Player player) {

		players.add(player);
		System.out.printf("「%s」さんをゲームに登録しました．\n", player.getName());

	}

	/**
	 * ババ抜きに必要なカードデッキを作りシャッフルする
	 */
	public void createCardDeck() {
		cD = new CardDeck();
		cD.createFullDeck();
		Card c = new Card(-1, 0);
		cD.addCard(c);
		cD.shuffle();
	}

	/**
	 * 作ったカードデッキからプレイヤーにカードを分配する
	 */
	public void dealCards() {
		System.out.println();
		System.out.println("-----カードをプレーヤーに配ります-----");

		for (Player p : players) {
			CardDeck cD1 = new CardDeck();
			p.setDeck(cD1);
		}

		while (cD.isEmpty() == false) {
			for (Player p : players) {
				if (cD.isEmpty()) {
					break;
				} else {
					p.setCards(cD.takeCard());
				}
			}
		}

		System.out.println();

	}

	/**
	 * はじめに配ったカードの中に同じ数字があれば捨てる
	 */
	public void getRidOfCards() {

		for (Player p : players) {
			p.getRidOfCards();
			System.out.println();
		}
	}

	/**
	 * ババ抜きを誰からスタートさせるかランダムで決める
	 */
	public void decideTheOder() {
		System.out.println();
		System.out.println("----------ランダムで一番目に引く人を決めます----------");
		int i;
		Player p;
		int a = random = (int) (Math.random() * 100) % players.size();
		System.out.println(players.get(a).getName() + "さんから始めます");
		for (i = 0; i < a; i++) {
			p = players.get(0);
			players.remove(0);
			players.add(p);
		}

		System.out.println();
	}

	/**
	 * 最後の一人になるまでカードを引き同じ数字があれば捨てる作業を繰り返す
	 */
	public void takeCard() {

		while (players.size() != 1) {

			int a = 0;
			int b; //CPUが上がった際に繰り下げがおこり、ユーザからカードを引いていないのに引いたと表示されるのを防止するため。

			for (int i = 0; i < players.size(); i++) {

				b = 0;

				if (i != players.size() - 1) {
					System.out.println("----------" + players.get(i).getName() + "さんが" + players.get(i + 1).getName()
							+ "さんのカードを引きます------------");
				} else {
					System.out.println("----------" + players.get(i).getName() + "さんが" + players.get(0).getName()
							+ "さんのカードを引きます------------");
				}

				if (i + 1 == players.size()) {
					players.get(i).takeCard(players.get(0));
					if (players.get(0).getDeck().isEmpty()) {
						System.out.println(players.get(0).getName() + "さんは上がりました");
						winner.add(players.get(0).getName());
						players.remove(0);
						i--;
						a = 1;
					}
				} else {
					players.get(i).takeCard(players.get(i + 1));
					if (players.get(i + 1).getDeck().isEmpty()) {
						System.out.println(players.get(i + 1).getName() + "さんは上がりました");
						winner.add(players.get(i + 1).getName());
						players.remove(i + 1);
						b = 1;
					}

				}

				if (b == 0) {
					if (players.size() - random == i + 1) {
						if (i + 1 == players.size()) {
							if (players.get(0) instanceof User) {
								System.out.println(players.get(i).getName() + "さんは" + players.get(0).getName() + "さんの"
										+ players.get(i).getDeck().seeCard(players.get(i).getDeck().size()) + "を引きました");
							}
						} else {
							if (players.get(i + 1) instanceof User) {
								System.out.println(players.get(i).getName() + "さんは" + players.get(i + 1).getName()
										+ "さんの"
										+ players.get(i).getDeck().seeCard(players.get(i).getDeck().size()) + "を引きました");
							}
						}
					}
				}

				players.get(i).getRidOfCards();

				if (players.get(i).getDeck().isEmpty()) {
					System.out.println(players.get(i).getName() + "さんは上がりました");
					winner.add(players.get(i).getName());
					players.remove(i);
					i--;
				}

				if (a == 1) {
					break;
				}

				if (players.size() == 1) {
					break;
				}

				System.out.println();

			}
		}

		winner.add(players.get(0).getName());

	}

	/**
	 * ババ抜きの順位を発表する
	 */
	public void announceResult() {
		System.out.println();
		System.out.println("-----結果発表----");
		int i = 1;
		for (String s : winner) {
			System.out.println("第" + i + "位" + s + "さん");
			i++;
		}
	}

	/**
	 * ゲームを開始する
	 */
	public void startGame() {
		createCardDeck();
		dealCards();
		getRidOfCards();
		decideTheOder();
		takeCard();
	}

	//⇓テストのために作成

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<String> getWinner() {
		return winner;
	}


	public void setWinner(ArrayList<String> winner) {
		this.winner = winner;
	}

	public int getRandom() {
		return random;
	}


}
