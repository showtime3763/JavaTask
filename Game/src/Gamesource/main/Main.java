package Gamesource.main;

import java.util.Scanner;

import Gamesource.character.hero.Hero;
import Gamesource.character.monster.Monster;
import Gamesource.map.Map;
import Gamesource.map.PotionStore;
import Gamesource.map.WeaponStore;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Hero creation and job selection
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		Hero hero = Hero.chooseJob(name, sc);

		// Main game loop
		System.out.printf("%s, 던전에 오신 것을 환영합니다.\n", hero.name);
		System.out.println("게임을 시작합니다.");
		System.out.println("****************************");
		boolean playing = true;
		while (playing) {
			System.out.println("****************************");
			System.out.printf(
					"현재 유저 이름 : %s \n 현재 lv : %d \n 현재 힘 : %d \n 현재 방어력 : %d \n 현재 hp : %d \n 현재 경험치 : %d exp \n 현재 돈 : %d 골드",
					hero.name, hero.level, hero.power, hero.defense, hero.hp, hero.experience, hero.money);
			System.out.println("\n****************************");
			System.out.println("1) 전투  2) 지도 보기  0) 나가기"); // 추가됨
			int act = sc.nextInt();
			sc.nextLine();

			if (act == 0)
				break;
			else if (act == 2) {
				Map.move(hero, sc); // 추가됨: 맵 이동 기능 호출
				continue;
			}
			System.out.println("\n 던전에 입장하였습니다.");
			System.out.print("전투할 몬스터를 선택하세요.\n");
			Monster monster = Monster.selectMonster(sc);
			System.out.println("Encountered: " + monster.getName());

			// Battle loop
			while (monster.isAlive() && hero.isAlive()) {
				System.out.println("\n-- 전투 개시! --");
				hero.showAttacks();
				int choice = sc.nextInt();
				sc.nextLine();

				int dmg = hero.attack(monster, choice);
				System.out.println(hero.getName() + " 의 공격 " + choice + "! 적에게 " + dmg + " 데미지를 주었다!");

				if (!monster.isAlive()) {
					System.out.println(monster.getName() + " 은(는) 쓰러졌다!");
					hero.gainRewards(monster);
					break;
				}

				int mdmg = monster.attack(hero);
				System.out.println(monster.getName() + " 의 공격! " + mdmg + " 데미지를 입었다.");
				if (!hero.isAlive()) {
					System.out.println("---  GAME OVER  ---/n 영웅이 HP 1로 부활합니다.");
					hero.revive();
					break;
				}
			}

			// Level up and mission assignment
			hero.checkLevelUp();

			// Visit stores
			System.out.println("상점 방문 (1: 포션, 2: 무기, 0: 넘기기)");
			int shopChoice = sc.nextInt();
			sc.nextLine();
			if (shopChoice == 1) {
				PotionStore.visit(hero, sc);
			} else if (shopChoice == 2) {
				WeaponStore.visit(hero, sc);
			}
		}

	}
}