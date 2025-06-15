package Gamesource.map;

import java.util.Scanner;

import Gamesource.character.hero.Hero;

public class Map {
	public static void move(Hero hero, Scanner sc) {
		while (true) {
			System.out.println("\n-- Map --");
			System.out.println("1) 포션 상점");
			System.out.println("2) 무기 상점");
			System.out.println("0) 메인 메뉴로 돌아가기");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				PotionStore.visit(hero, sc);
				break;
			case 2:
				WeaponStore.visit(hero, sc);
				break;
			case 0:
				return;
			default:
				System.out.println("선택할 수 없습니다.");
			}
		}
	}
}
