package jp.ac.maslab.rpg.role.monster;

import jp.ac.maslab.rpg.role.AbstractCharacter;
import jp.ac.maslab.rpg.role.ICreature;

/**
 * モンスターを示す抽象クラスです。
 *
 */
public abstract class AbstractMonster implements ICreature {
	protected String name; // 名前
	protected String shuffix; // サフィックス
	protected int hp; // HP
	protected int offense; // 攻撃力
	protected int defense; // 防御力
	protected int speed;// 素早さ
	protected int money; // 倒したときに手に入るお金
	protected int experience;// 倒したときに手に入る経験値

	/**
	 * 新規モンスターを構築します。
	 *
	 * @param name
	 *            モンスターの名前
	 * @param hp
	 *            モンスターのHP
	 * @param offense
	 *            モンスターの攻撃力
	 * @param defense
	 *            モンスターの防御力
	 * @param speed
	 *            モンスターの素早さ
	 * @param money
	 *            倒したときに貰えるお金
	 * @param experience
	 *            倒したときに貰える経験値
	 *
	 */
	public AbstractMonster(String name, int hp, int offense, int defense, int speed, int money, int experience) {
		this.setName(name);
		this.setShuffix("");// サフィックスはグループ化したときに自動で付けられる
		this.setHp(hp);
		this.setOffense(offense);
		this.setDefense(defense);
		this.setSpeed(speed);
		this.setMoney(money);
		this.setExperience(experience);
	}

	// ====モンスターの行動====

	/**
	 * 指定されたキャラクターに攻撃します。
	 *
	 * @param character
	 *            攻撃の対象になるキャラクター
	 */
	public abstract void attack(AbstractCharacter character);

	/**
	 * 走って逃げます。
	 */
	public void run() {
		System.out.println(this.getFullName() + "は逃げ出した!");
	}

	// ====ICreatureインターフェース実装部分====

	/**
	 * 指定されたダメージを受けます。
	 *
	 * @param damage
	 *            受けるダメージ
	 */
	@Override
	public void damage(int damage) {
		if (damage <= 0) {
			System.out.println(getFullName() + "に" + damage + "のダメージを与えた!");
			System.out.println("攻撃が効かない!");
		} else {
			this.hp -= damage;
			if (this.hp <= 0) {
				die();
			}
		}
	}

	/**
	 * 倒れます。
	 */
	@Override
	public void die() {
		System.out.println(this.name + "は倒れた!");
	}

	/**
	 * このモンスターのHPを返します。
	 *
	 * @return このモンスターのHP
	 */
	@Override
	public int getHp() {
		return hp;
	}

	@Override
	public void heal(int point) {
		System.out.println(name + "は" + point + "ポイント回復した。");
		hp += point;
	}

	/**
	 * このモンスターが生きているかどうかを返します。{@code isAlive = (hp <= 0) ? false : true}
	 *
	 * @return このモンスターが生きているかどうか
	 */
	@Override
	public boolean isAlive() {
		return hp <= 0 ? false : true;
	}

	// ====各フィールドのsetter====

	/**
	 * このモンスターのサフィックスを設定します。<br>
	 * サフィックスは複数体モンスターがいた際にA、B、C...とアルファベットを付けられます。
	 *
	 * @param shuffix
	 *            設定するサフィックス
	 */
	public void setShuffix(String shuffix) {
		if (shuffix.length() < 2) {
			throw new IllegalArgumentException("サフィックスは1文字またはなし(空文字)にしてください:" + shuffix);
		}
		this.shuffix = shuffix;
	}

	/**
	 * このモンスターの名前を設定します。
	 *
	 * @param name
	 *            設定する名前
	 *
	 * @exception IllegalArgumentException
	 *                モンスターの名前が0文字または8文字より大きいの場合
	 */
	public void setName(String name) {
		this.name = name;
		if (name == null || name.length() < 1 || 8 < name.length()) {
			String errmsg = "モンスターの名前の文字数が異常です:" + name.length();
			throw new IllegalArgumentException(errmsg);
		}
	}

	/**
	 * このモンスターのHPを設定します。
	 *
	 * @param hp
	 *            設定するHP
	 *
	 * @exception IllegalArgumentException
	 *                HPが0または負に設定された場合
	 */
	public void setHp(int hp) {
		if (hp <= 0) {
			throw new IllegalArgumentException("HPは1以上にしてください:" + hp);
		}
		this.hp = hp;
	}

	/**
	 * このモンスターの攻撃力を設定します。
	 *
	 * @param offense
	 *            設定する攻撃力
	 * @exception IllegalArgumentException
	 *                攻撃力が0または負に設定された場合
	 */
	public void setOffense(int offense) {
		if (offense <= 0) {
			throw new IllegalArgumentException("オフェンスは1以上にしてください:" + offense);
		}
		this.offense = offense;
	}

	/**
	 * このモンスターの防御力を設定します。
	 *
	 * @param defense
	 *            設定する防御力
	 * @exception IllegalArgumentException
	 *                防御力が0または負に設定された場合
	 */
	public void setDefense(int defense) {
		if (defense <= 0) {
			throw new IllegalArgumentException("ディフェンスは1以上にしてください:" + speed);
		}
		this.defense = defense;
	}

	/**
	 * このモンスターの防御力を設定します。
	 *
	 * @param speed
	 *            設定する素早さ
	 * @exception IllegalArgumentException
	 *                素早さが0または負に設定された場合
	 */
	public void setSpeed(int speed) {
		if (speed <= 0) {
			throw new IllegalArgumentException("スピードは1以上にしてください:" + speed);
		}
		this.speed = speed;
	}

	/**
	 * このモンスターを倒したときに貰えるゴールドの量を設定します。
	 *
	 * @param money
	 *            設定するゴールドの量
	 * @exception IllegalArgumentException
	 *                ゴールドの量が0または負に設定された場合
	 */
	public void setMoney(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException("もらえるお金は1ゴールド以上にしてください:" + money);
		}
		this.money = money;
	}

	/**
	 * このモンスターを倒したときに貰える経験値を設定します。
	 *
	 * @param experience
	 *            設定する経験値
	 * @exception IllegalArgumentException
	 *                経験値が0または負に設定された場合
	 */
	public void setExperience(int experience) {
		if (experience <= 0) {
			throw new IllegalArgumentException("もらえる経験値は1以上にしてください:" + experience);
		}
		this.experience = experience;
	}

	// ====各フィールドのgetter====

	/**
	 * このモンスターの名前を返します。
	 *
	 * @return このモンスターの名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * このモンスターのサフィックスを返します。
	 *
	 * @return このモンスターのサフィックス
	 */
	public String getShuffix() {
		return shuffix;
	}

	/**
	 * 防御力を返します。
	 *
	 * @return このモンスターの防御力
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * 名前とサフィックスを連結したフルネームを返します。
	 *
	 * @return フルネーム
	 */
	public String getFullName() {
		return this.name + this.shuffix;
	}
}
