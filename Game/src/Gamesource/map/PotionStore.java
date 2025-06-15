package Gamesource.map;

import java.util.Scanner;

import Gamesource.character.hero.Hero;
import Gamesource.character.monster.Monster;

public class PotionStore {
	public static void visit(Hero hero, Scanner sc) {
		System.out.println("포션 상점: 1) HP 포션(30골드) 2) MP 포션(30골드) 3) EXP 병(100골드)");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			hero.hp += 50;
			hero.money -= 30;
			System.out.println("HP가 50 회복되었다..");
			break;
		case 2:
			hero.mp += 50;
			hero.money -= 30;
			System.out.println("MP가 50 회복되었다.");
			break;
		case 3:
			hero.gainRewards(new Monster("Dummy", 1, 0, 0, 0, 50, -100));
			break;
		default:
			System.out.println("상점 나가기");
			return;
		}
	}
}
