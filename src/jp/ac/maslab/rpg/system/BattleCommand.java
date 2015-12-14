package jp.ac.maslab.rpg.system;

import java.util.HashMap;
import java.util.Map;

/**
 * 戦闘時にキャラクターが取ることのできる行動の列挙です。
 */
public enum BattleCommand {
	/**
	 * モンスターへの攻撃を示します。
	 */
	ATTACK,
	/**
	 * 他キャラクターとの交代を示します。
	 */
	CHANGE,
	/**
	 * 戦闘中に使用可能な道具を使用します。
	 */
	ITEM,
	/**
	 * 全力で走って逃げます。
	 */
	RUN,;

	@Override
	public String toString() {
		Map<BattleCommand, String> commandName = new HashMap<>();
		commandName.put(ATTACK, "こうげき");
		commandName.put(CHANGE, "こうたい");
		commandName.put(ITEM, "どうぐ");
		commandName.put(RUN, "にげる");
		return commandName.get(this);
	};
}
