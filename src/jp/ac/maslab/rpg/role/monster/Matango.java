package jp.ac.maslab.rpg.role.monster;

import java.util.Random;

import jp.ac.maslab.rpg.role.AbstractCharacter;

/**
 * モンスターのマタンゴのクラスです。
 */
public class Matango extends AbstractMonster {

	/**
	 * 新しいマタンゴを構築します。
	 */
	public Matango() {
		super("マタンゴ", 25, 10, 10, 10, 8, 3);
	}

	/**
	 * 指定されたキャラクターに攻撃します。
	 */
	@Override
	public void attack(AbstractCharacter character) {
		// 防御力はランダムで0～100％適応される
		int defense = (int) (character.getDefense() * new Random().nextDouble());
		int damage = this.offense - defense;

		System.out.println(super.name + super.shuffix + "の攻撃!");
		character.damage(damage);
	}
}
