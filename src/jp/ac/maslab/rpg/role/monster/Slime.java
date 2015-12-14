package jp.ac.maslab.rpg.role.monster;

import java.util.Random;

import jp.ac.maslab.rpg.role.AbstractCharacter;

/**
 * モンスターのスライムのクラスです。
 */
public class Slime extends AbstractMonster {

	/**
	 * 新しいスライムを構築します。
	 */
	public Slime() {
		super("スライム", 20, 10, 5, 20, 5, 1);
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
