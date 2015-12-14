package jp.ac.maslab.rpg.role;

import java.util.Random;

import jp.ac.maslab.rpg.role.monster.AbstractMonster;

public class Fighter extends AbstractCharacter {

	public Fighter(String name, int hp) {
		super(name, hp);
		if (name == null || name.length() < 1 || 8 < name.length()) {
			String errmsg = "格闘家の名前の文字数が異常です:" + name.length();
			throw new IllegalArgumentException(errmsg);
		}
	}

	void bye() {
		System.out.println("格闘家" + super.name + "は別れを告げた");
	}

	@Override
	public void attack(AbstractMonster monster) {
		System.out.println(super.name + "は攻撃した!");
		int defense = (int) (monster.getDefense() * new Random().nextDouble());
		int damage = this.offense - defense;
		monster.damage(damage);
	}

}
