package Gamesource.map;

import Gamesource.character.hero.Hero;

public class Mission {
	public static void assign(Hero hero) {
		System.out.println("New mission: Defeat " + hero.level * 2 + " monsters.");
	}
}
