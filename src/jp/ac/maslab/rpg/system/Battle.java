package jp.ac.maslab.rpg.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jp.ac.maslab.rpg.role.AbstractCharacter;
import jp.ac.maslab.rpg.role.monster.AbstractMonster;

/**
 * 戦闘のクラスです。
 */
public class Battle {

	private AbstractCharacter character;
	private AbstractMonster monster;
	private BattleCommand command;
	private boolean isRunning;// どちらかが逃げたならtrue

	/**
	 * 指定されたキャラクターとモンスターとの戦闘を構築します。
	 *
	 * @param character
	 *            戦闘するキャラクター
	 * @param monster
	 *            戦闘するモンスター
	 */
	public Battle(AbstractCharacter character, AbstractMonster monster) {
		this.character = character;
		this.monster = monster;
		isRunning = false;
	}

	/**
	 * 戦闘を始めます。<br>
	 * 戦闘は必ずキャラクターのターンからスタートし、その後にモンスターの行動に移ります。 どちらかが戦闘不能になる、もしくは逃げると戦闘終了になります。
	 */
	public void start() {
		System.out.println(monster.getFullName() + "が現れた");
		while (true) {
			if (character.isAlive()) {
				characterTurn();
				if (isRunning) {
					break;
				}
			} else {
				break;
			}
			if (monster.isAlive()) {
				monsterTurn();
				if (isRunning) {
					break;
				}
			} else {
				break;
			}
		}
	}

	private void monsterTurn() {
		monster.attack(character);
	}

	private void characterTurn() {
		showCommands();
		selectCommand();
		executeCommand();
	}

	private void showCommands() {
		for (int i = 0; i < BattleCommand.values().length; i++) {
			System.out.printf("%d:%s\n", i, BattleCommand.values()[i]);
		}
	}

	private void selectCommand() {
		int num = -1;

		while (num < 0 || BattleCommand.values().length - 1 < num) {
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				num = Integer.valueOf(br.readLine());
				if (num < 0 || BattleCommand.values().length - 1 < num) {
					System.err.println("その番号は選択できません:" + num);
				}
			} catch (NumberFormatException nfe) {
				if (num == -1) {
					continue;
				}
				System.err.println("数字で選択してください:" + num);
			} catch (IOException ioe) {
				System.err.println("入出力エラーが発生しました");
				ioe.printStackTrace();
			}
		}
		this.command = BattleCommand.values()[num];
	}

	// コマンドを実行します。
	private void executeCommand() {
		switch (command) {
		case ATTACK:
			character.attack(monster);
			break;
		case CHANGE:
			System.out.println("こうたいするなかまがいない!");
			break;
		case ITEM:
			System.out.println("どうぐをもっていない!");
			break;
		case RUN:
			character.run();
			isRunning = true;
			break;
		default:
			break;
		}
	}
}
