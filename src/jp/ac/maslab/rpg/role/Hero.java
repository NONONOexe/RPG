package jp.ac.maslab.rpg.role;

import jp.ac.maslab.rpg.item.Sword;
import jp.ac.maslab.rpg.role.monster.AbstractMonster;

/**
 * 勇者のクラスです。<br>
 * 剣を装備して戦うことが出来ます。
 */
public class Hero extends AbstractCharacter {

	protected Sword sword;// 勇者の装備する剣

	/**
	 * 新しい勇者を構築します。
	 *
	 * @param name
	 *            構築する勇者の名前
	 * @param hp
	 *            構築する勇者のHP
	 */
	public Hero(String name, int hp) {
		super(name, hp);
	}

	// ====勇者の行動====

	/**
	 * 勇者と別れます。
	 */
	void bye() {
		System.out.println("勇者" + super.name + "は別れを告げた");
	}

	// ====AbstructCharacterの抽象メソッド実装部分====

	@Override
	public void attack(AbstractMonster monster) {
		System.out.println(super.name + "は攻撃した!");
		if (this.sword != null) {
			monster.damage(sword.getDamage());
		} else {
			System.out.println("しかし、" + super.name + "は剣を装備していない!");
		}
	}

	// ====各フィールドのsetter====

	/**
	 * 装備している剣を返します。
	 *
	 * @return 装備しているSwordオブジェクト
	 */
	public Sword getSword() {
		return sword;
	}

	// ====各フィールドのgetter====

	/**
	 * 装備する剣を設定します。
	 *
	 * @param sword
	 *            装備するSwordオブジェクト
	 */
	public void setSword(Sword sword) {
		this.sword = sword;
	}

}
