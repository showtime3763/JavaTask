package Gamesource.character.hero;

import Gamesource.character.Character;

public class Warrior extends Hero {
	public Warrior(String name) {
		super(name);
		this.job = "전사";
		this.hp = 100;
		this.power = 10;
		this.defense = 20;
		this.mp = 20;
		this.Skill1 = "강타";
		this.Skill2 = "회전베기";
		this.BasicWP = "낡은 검";
		this.StrongWP = "기사의 검";
		this.UltimateWP = "용사의 검";
	}

	@Override
	protected int useSpecialSkill(Character target) {
		System.out.println("[전사] 의 스킬 [강타]!");
		if (target.getName() == "들개")
			return power * level + 30;
		return power * level + 20;

	}

	@Override
	protected int useUltimateSkill(Character target) {
		System.out.println("[전사] 의 스킬 [회전베기]!");
		if (target.getName() == "들개")
			return power * level + 40;
		return power * level + 30;
	}
}
