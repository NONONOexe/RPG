package jp.ac.maslab.rpg.test;

import jp.ac.maslab.rpg.role.Hero;
import jp.ac.maslab.rpg.role.monster.Matango;
import jp.ac.maslab.rpg.system.Battle;

public class BattleTest {
	public static void main(String[] args) {
		// ヒーローを作成
		Hero hero = new Hero("みなと", 100);
		// 敵を作成
		Matango matango = new Matango();
		// バトルを作成
		Battle battle = new Battle(hero, matango);
		// バトル開始
		battle.start();
	}
}
