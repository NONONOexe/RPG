package jp.ac.maslab.rpg.role;

import jp.ac.maslab.rpg.role.monster.AbstractMonster;

/**
 * 味方のキャラクターを示す抽象クラスです。
 */
public abstract class AbstractCharacter implements IHuman, ICreature {

	protected String name;// 名前
	protected int hp;// 体力
	protected int offense;// 攻撃力
	protected int defense;// 防御力
	protected int money;// 所持金

	/**
	 * 新規キャラクターを構築します。
	 *
	 * @param name
	 *            キャラクターの名前
	 * @param hp
	 *            キャラクターの体力
	 */
	public AbstractCharacter(String name, int hp) {
		this.setName(name);
		this.setHp(hp);
	}

	// ====キャラクターの行動====

	/**
	 * 指定されたモンスターを攻撃します。
	 *
	 * @param monster
	 *            攻撃の対象となるモンスター
	 */
	public abstract void attack(AbstractMonster monster);

	/**
	 * 走って逃げます。
	 */
	@Override
	public void run() {
		System.out.println(this.name + "は逃げ出した。");
	}

	/**
	 * 指定された秒数座ります。1秒あたり1ポイントHPを回復することができます。
	 *
	 * @param sec
	 *            座る秒数
	 */
	public final void sit(int sec) {
		System.out.println(this.name + "は," + sec + "秒座った!");
		this.heal(sec);
	}

	/**
	 * 転びます。HPの2%のダメージを受けます。
	 */
	public final void slip() {
		int damage = (int) (hp / 50);

		System.out.println(this.name + "は転んだ!");
		this.damage(damage);
	}

	/**
	 * 眠ります。体力が100ポイント回復します。
	 */
	public final void sleep() {
		System.out.println(this.name + "は眠って回復した!");
		this.heal(100);
	}

	// ====ICreatureインターフェース実装部分====

	/**
	 * 指定されたポイントのダメージを受けます。
	 *
	 * @param point
	 *            受けるダメージ
	 */
	@Override
	public void damage(int point) {
		System.out.println(this.name + "に" + point + "ポイントのダメージ!");
		this.hp -= point;
		if (!isAlive()) {
			die();
		}
	}

	/**
	 * 指定されたポイントの回復をします。
	 *
	 * @param point
	 *            回復するポイント
	 */
	@Override
	public void heal(int point) {
		System.out.println(point + "ポイント回復した。");
		this.hp += point;
	}

	/**
	 * このキャラクターが生きているかどうかを返します。{@code isAlive = (hp <= 0) ? false : true}
	 *
	 * @return このキャラクターが生きているかどうか
	 */
	@Override
	public boolean isAlive() {
		return hp <= 0 ? false : true;
	}

	/**
	 * 死にます。死んでしまったらゲームオーバーです。
	 */
	@Override
	public void die() {
		this.setHp(0);
		System.out.println(this.name + "は死んでしまった!");
	}

	/**
	 * HPを返します。
	 *
	 * @return HP
	 */
	@Override
	public int getHp() {
		return hp;
	}

	// ====各フィールドのsetter====

	/**
	 * 名前を設定します。
	 *
	 * @param name
	 *            設定する名前
	 */
	public void setName(String name) {
		if (name == null || name.length() < 1 || 8 < name.length()) {
			String errmsg = "キャラクターの名前の文字数が異常です:" + name.length();
			throw new IllegalArgumentException(errmsg);
		}
		this.name = name;
	}

	/**
	 * HPを設定します。
	 *
	 * @param hp
	 *            設定するHP
	 */
	public void setHp(int hp) {
		if (hp <= 0) {
			String errmsg = "HPは0より大きい値に設定してください:" + hp;
			throw new IllegalArgumentException(errmsg);
		}
		this.hp = hp;
	}

	/**
	 * このキャラクターの攻撃力を設定します。
	 *
	 * @param offense
	 *            設定する攻撃力
	 */
	public void setOffense(int offense) {
		this.offense = offense;
	}

	/**
	 * このキャラクターの防御力を設定します。
	 *
	 * @param defense
	 *            設定する防御力
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * このキャラクターの所持金を設定します。
	 *
	 * @param money
	 *            設定する所持金
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	// ====各フィールドのgetter====

	/**
	 * 名前を返します。
	 *
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * このキャラクターの攻撃力を返します。
	 *
	 * @return このキャラクターの攻撃力
	 */
	public int getOffense() {
		return offense;
	}

	/**
	 * このキャラクターの防御力を返します。
	 *
	 * @return このキャラクターの防御力
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * このキャラクターの所持金を返します。
	 *
	 * @return このキャラクターの所持金
	 */
	public int getMoney() {
		return money;
	}

}
