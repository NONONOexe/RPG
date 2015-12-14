package jp.ac.maslab.rpg.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.ac.maslab.rpg.role.monster.AbstractMonster;

/**
 * 集団のモンスターを表すクラスです。
 */
public class MonsterGroup {

	// モンスターを格納するリスト
	private List<AbstractMonster> monsterList = new ArrayList<>();

	/**
	 * 引数のモンスターをグループ化します。<br>
	 * 複数体いるモンスターは自動でサフィックスがA, B, C, ...と付けられます。
	 *
	 * @param monsters
	 *            グループ化するモンスター
	 */
	public MonsterGroup(AbstractMonster... monsters) {
		if (monsters.length < 1) {
			throw new IllegalArgumentException("引数のモンスター数は1以上にしてください:" + monsters.length);
		}
		if (5 < monsters.length) {
			throw new IllegalArgumentException("引数のモンスター数は5以下にしてください:" + monsters.length);
		}
		// サフィックスを付ける
		autoShuffix(monsters);
		// 引数のモンスターをフィールドに設定
		this.monsterList.addAll(Arrays.asList(monsters));
	}

	private void autoShuffix(AbstractMonster... monsters) {
		Map<String, AbstractMonster> lastShuffixMonsterMap = new HashMap<>();
		for (AbstractMonster monster : monsters) {
			String name = monster.getName();
			if (lastShuffixMonsterMap.containsKey(name)) {
				AbstractMonster lastShuffixMonster = lastShuffixMonsterMap.get(name);
				String shuffix = lastShuffixMonster.getShuffix();
				if (shuffix.isEmpty()) {
					lastShuffixMonster.setShuffix("A");
					monster.setShuffix("B");
				} else {
					shuffix = String.valueOf((char) (shuffix.charAt(0) + 1));
					monster.setShuffix(shuffix);
				}
			}
			lastShuffixMonsterMap.put(name, monster);
		}
	}

	/**
	 * 指定されたインデックスのモンスターを返します。
	 *
	 * @param index
	 *            モンスターのインデックス
	 * @return 指定されたインデックスのモンスター
	 */
	public AbstractMonster getMonster(int index) {
		return monsterList.get(index);
	}

	/**
	 * 指定されたインデックスのモンスターを除去します。
	 *
	 * @param index
	 *            除去するモンスターのインデックス
	 */
	public void removeMonster(int index) {
		monsterList.remove(index);
	}

	@Override
	public String toString() {
		String str = "";
		for (AbstractMonster monster : monsterList) {
			str += monster.getFullName() + ", ";
		}
		return str;
	}
}
