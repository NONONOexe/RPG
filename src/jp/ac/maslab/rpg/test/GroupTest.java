package jp.ac.maslab.rpg.test;

import jp.ac.maslab.rpg.role.monster.Matango;
import jp.ac.maslab.rpg.role.monster.Slime;
import jp.ac.maslab.rpg.system.MonsterGroup;

public class GroupTest {
	public static void main(String[] args) {
		Matango matango1 = new Matango();
		Matango matango2 = new Matango();
		Matango matango3 = new Matango();
		Matango matango4 = new Matango();
		Matango matango5 = new Matango();
		MonsterGroup monsterGroup1 = new MonsterGroup(matango1, matango2, matango3, matango4, matango5);

		Slime slime1 = new Slime();
		Matango matango6 = new Matango();
		Matango matango7 = new Matango();
		Slime slime2 = new Slime();
		Slime slime3 = new Slime();
		MonsterGroup monsterGroup2 = new MonsterGroup(slime1, matango6, matango7, slime2, slime3);

		Slime slime4 = new Slime();
		Matango matango8 = new Matango();
		Matango matango9 = new Matango();
		Matango matango10 = new Matango();
		Matango matango11 = new Matango();
		MonsterGroup monsterGroup3 = new MonsterGroup(slime4, matango8, matango9, matango10, matango11);

		System.out.println(monsterGroup1);
		System.out.println(monsterGroup2);
		System.out.println(monsterGroup3);
	}
}
