package jp.ac.maslab.rpg.test;

import jp.ac.maslab.rpg.role.AbstractCharacter;
import jp.ac.maslab.rpg.role.Hero;

public class CharcterTest {

	public static void main(String[] args) {
		// キャラクターとしてHeroを作成
		AbstractCharacter character = new Hero("みなと", 100);

		// 座って20ポイント回復
		character.sit(20);
		// 30のダメージ
		character.damage(30);
		// 転んで5％のダメージ
		character.slip();
		// 走って逃げ出す
		character.run();
	}

}
