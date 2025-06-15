package Gamesource.character.hero;

import Gamesource.character.Character;

public class Thief extends Hero {
	public Thief(String name) {
		super(name);
		this.job = "도적";
		this.hp = 85;
		this.power = 9;
		this.defense = 10;
		this.mp = 30;
		this.Skill1 = "기습";
		this.Skill2 = "암살";
		this.BasicWP = "낡은 단검";
		this.StrongWP = "도적의 단검";
		this.UltimateWP = "사신의 단검";
	}

	@Override
	protected int useSpecialSkill(Character target) {
		System.out.println("[도적] 의 스킬 [기습]!");
		if (target.getName() == "늑대")
			return power * level + 30;
		return power * level + 20;
	}

	@Override
	protected int useUltimateSkill(Character target) {
		System.out.println("[도적] 의 스킬 [암살]!");
		if (target.getName() == "늑대")
			return power * level + 40;
		return power * level + 30;
	}
}