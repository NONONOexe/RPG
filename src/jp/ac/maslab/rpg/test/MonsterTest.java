package jp.ac.maslab.rpg.test;

import jp.ac.maslab.rpg.role.monster.AbstractMonster;
import jp.ac.maslab.rpg.role.monster.Matango;

public class MonsterTest {
	public static void main(String[] args) {
		// モンスターとしてマタンゴを作成
		AbstractMonster monster = new Matango();

		// 30のダメージ
		monster.damage(30);
		// 走って逃げます
		monster.run();
	}
}
