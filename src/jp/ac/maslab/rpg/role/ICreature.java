package jp.ac.maslab.rpg.role;

/**
 * 生命を表すインターフェースです。
 *
 */
public interface ICreature {
	/**
	 * 指定されたポイントのダメージを受けます。
	 *
	 * @param point
	 *            ダメージを受けるポイント
	 */
	void damage(int point);

	/**
	 * 指定されたポイントの回復をします。
	 *
	 * @param point
	 *            回復するポイント
	 */
	void heal(int point);

	/**
	 * 生きているかどうかを返します。
	 *
	 * @return 生きているかどうか
	 */
	boolean isAlive();

	/**
	 * 死にます。
	 */
	void die();

	/**
	 * HPを返します。
	 *
	 * @return HP
	 */
	int getHp();

}
