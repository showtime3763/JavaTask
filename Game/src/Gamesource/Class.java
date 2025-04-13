package Gamesource;

import java.util.Scanner;

public class Class {
	static int hero_level, hero_power, hero_hp, hero_defence, hero_mp, hero_experience, hero_money, atk;
	static int monster_hp, monster_defence, monster_power, monster_mp, monster_level, monster_experience, monster_money,
			Mcase;
	static int q = 0;
	static int Mnum1 = 0;
	static int Mnum2 = 0;
	static int overcount = 0;
	static int shopcount = 0;
	static String hero_name, monster_name;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if (overcount == 0) {
			System.out.print("이름을 입력하세요 : ");
			hero_name = in.next();
		}
		System.out.printf("%s, 던전에 오신 것을 환영합니다.\n", hero_name);
		System.out.println("게임을 시작합니다.");
		System.out.println("****************************");
		hero_level = 1;
		hero_power = 15;
		hero_defence = 25;
		hero_hp = 80;
		hero_experience = 0;
		hero_money = 0;
		while (true) {
			int c = 0;
			System.out.println("****************************");
			System.out.printf(
					"현재 유저 이름 : %s \n 현재 lv : %d \n 현재 힘 : %d \n 현재 방어력 : %d \n 현재 hp : %d \n 현재 경험치 : %d exp \n 현재 돈 : %d 골드",
					hero_name, hero_level, hero_power, hero_defence, hero_hp, hero_experience, hero_money);
			System.out.println("\n****************************");
			if (hero_experience != 0) {
				levelup(hero_experience);
				Questcheck(q);
				System.out.println("입장할 장소를 선택해 주세요. \n1.던전\n2. 상점");
				c = in.nextInt();
				if (c == 2) {
					store_show(hero_money, 0);
				} else if (c == 1) {
					Battle();
				}
			} else {
				Battle();
			}
		}
	}

	static void Battle() {
		Scanner in = new Scanner(System.in);
		System.out.println("\n 던전에 입장하였습니다.");
		System.out.print("전투할 몬스터를 선택하세요.\n 1 : 너구리\n");
		if (shopcount >= 1) {
			System.out.print(" 2: 살쾡이\n");
		}
		int a = in.nextInt();
		if (a == 1) {
			monster_name = "너구리";
			Mcase = 1;
			monster_hp = 100;
			monster_mp = 0;
			monster_level = 1;
			monster_power = 20;
			monster_defence = 5;
			monster_money = 10;
			monster_experience = 10;
		} else if (a == 2) {
			monster_name = "살쾡이";
			Mcase = 2;
			monster_hp = 2000;
			monster_mp = 0;
			monster_level = 5;
			monster_power = 100;
			monster_defence = 20;
			monster_money = 30;
			monster_experience = 50;

		}
		System.out.println("\n전투 개시!");
		while (hero_hp >= 0 && monster_hp >= 0) {
			hero_attack();
			monster_attack();
			if (monster_hp <= 0)
				break;
		}
	}

	static int hero_attack() {
		Scanner in = new Scanner(System.in);
		System.out.printf("%s의 공격입니다.\n 공격 1 : 강타\n공격 번호를 입력하세요 : ", hero_name);
		atk = in.nextInt();
		System.out.printf("\n %s 의 공격!\n", hero_name);
		int Mdamage = 0;
		Mdamage = hero_level * 10 + hero_power * 30;
		if (monster_defence >= Mdamage)
			System.out.print("공격이 효과가 없었다!\n");
		else
			monster_hp = monster_hp + monster_defence - Mdamage;
		System.out.printf(" 공격 성공! \n %d 데미지를 주었다!\n", Mdamage);
		if (monster_hp > 0) {
			System.out.printf("현재 몬스터 hp : %d\n", monster_hp);
		}
		monster_attacked(monster_hp);
		return 0;

	}

	static void hero_attacked(int sum) {
		if (sum <= 0) {
			System.out.println("\n\n     GAME OVER     \n     재도전하세요!     \n");
			overcount += 1;
			main(null);
		} else {
			System.out.printf(" %d 데미지를 입었다!\n현재 hp : %d\n", monster_power - hero_defence, hero_hp);
		}
	}

	static int monster_attack() {
		if (monster_hp <= 0) {
			return 0;
		} else {
			System.out.printf("\n \n %s의 공격!", monster_name);
			if (hero_defence >= monster_power) {
				System.out.print("\n 몬스터의 공격을 방어했습니다!\n");
			} else {
				hero_hp = hero_hp + hero_defence - monster_power;
				hero_attacked(hero_hp);
			}
			return 0;
		}
	}

	static void monster_attacked(int sum) {
		if (sum <= 0) {
			System.out.print("\n 적을 처치했습니다!\n");
			hero_experience += monster_experience;
			hero_money += monster_money;
			if (Mcase == 1) {
				Mnum1 += 1;
			} else {
				Mnum2 += 1;
			}
			System.out.printf("%d 골드와 %d exp를 얻었다!\n\n", monster_experience, monster_money);
		}
	}

	static int levelup(int exp) {
		if (exp >= hero_level * 80) {
			System.out.print(" 레벨 업! \n");
			hero_power += hero_level;
			hero_defence += hero_level;
			hero_money += hero_level * 50;
			System.out.printf(" 힘 %d 증가 | 방어력 %d 증가!\n %d 골드를 획득했다!\n", hero_level, hero_level, hero_level * 50);
			hero_level += 1;
			hero_experience = 0;
		}
		return exp;

	}

	static int store_show(int money, int num) {
		int price = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("상점에 입장하였습니다.");
		System.out.println(
				"1. 힘 증강 포션 (30원)\n2. 방어력 증강 포션 (30원)\n3. 경험치 증강 포션 (100원)\n4. hp 증강 포션 (10원)\n5. MP 증강 포션 (10원)\n6. 의뢰 게시판 보기");
		System.out.print("원하시는 물건을 입력하세요 : ");
		num = in.nextInt();
		switch (num) {
		case 1, 2:
			price = 30;
		case 3:
			price = 100;
		case 4, 5:
			price = 10;
		}
		System.out.println("상점에서 물건 구매를 시도하는 중입니다....");
		if (hero_money < price) {
			System.out.println("돈이 부족합니다.\n");
			return 0;
		} else {
			System.out.println("구매가 완료되었습니다.");
			shopcount += 1;
			switch (num) {
			case 1:
				hero_power += 3;
				hero_money = hero_money - 30;
				return 0;
			case 2:
				hero_defence += 3;
				hero_money = hero_money - 30;
				return 0;
			case 3:
				hero_experience += 50;
				hero_money = hero_money - 100;
				return 0;
			case 4:
				hero_hp += 50;
				hero_money = hero_money - 10;
				return 0;
			case 5:
				hero_mp += 50;
				hero_money = hero_money - 10;
				return 0;
			case 6:
				Questshow();
			default:
				return 0;
			}
		}
	}

	static void Questshow() {
		Scanner in = new Scanner(System.in);
		System.out.print("\n - 의뢰 게시판 - \n");
		System.out.println("1 : 너구리 5마리를 처치하세요.");
		System.out.println("2 : 너구리 3마리와 살쾡이 1마리를 처치하세요.");
		System.out.print("\n의뢰 선택하기(0 입력시 미선택) : ");
		q = in.nextInt();
		Mnum1 = 0;
		Mnum2 = 0;
		switch (q) {
		case 0 -> Questcheck(0);
		case 1 -> Questcheck(1);
		case 2 -> Questcheck(2);
		}
	}

	static int Questcheck(int q) {
		if (q == 1) {
			if (Mnum1 == 5) {
				System.out.print("의뢰 완료!\n");
				System.out.println("150골드를 획득했다!\n");
				hero_money += 150;
			}
			return 0;
		} else if (q == 2) {
			if (Mnum1 == 3 && Mnum2 == 1) {
				System.out.print("의뢰 완료!");
				System.out.println("200골드를 획득했다!");
				hero_money += 200;
			}
			return 0;
		} else
			return 0;
	}

}
