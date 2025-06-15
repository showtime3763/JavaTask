package Gamesource.character.hero;

import Gamesource.character.Character;

public class Mage extends Hero {
	public Mage(String name) {
		super(name);
		this.job = "마법사";
		this.hp = 80;
		this.power = 6;
		this.defense = 10;
		this.mp = 100;
		this.Skill1 = "파이어볼";
		this.Skill2 = "메테오";
		this.BasicWP = "낡은 지팡이";
		this.StrongWP = "마법사의 지팡이";
		this.UltimateWP = "대마법사의 지팡이";
	}

	@Override
	protected int useSpecialSkill(Character target) {
		System.out.println("[마법사] 의 주문 [파이어볼]!");
		if (target.getName() == "살쾡이")
			return power * level + 30;
		return power * level + 20;
	}

	@Override
	protected int useUltimateSkill(Character target) {
		System.out.println("[마법사] 의 주문 [메테오]!");
		if (target.getName() == "살쾡이")
			return power * level + 40;
		return power * level + 30;
	}
}