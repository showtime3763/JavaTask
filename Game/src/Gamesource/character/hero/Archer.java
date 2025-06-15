package Gamesource.character.hero;

import Gamesource.character.Character;

public class Archer extends Hero {
	public Archer(String name) {
		super(name);
		this.job = "궁수";
		this.hp = 90;
		this.power = 8;
		this.defense = 8;
		this.mp = 40;
		this.Skill1 = "관통 화살";
		this.Skill2 = "화살비";
		this.BasicWP = "낡은 활";
		this.StrongWP = "궁수의 활";
		this.UltimateWP = "명사수의 활";
	}

	@Override
	protected int useSpecialSkill(Character target) {
		System.out.println("[궁수] 의 스킬 [관통 화살]!");
		if (target.getName() == "너구리")
			return power * level + 30;
		return power * level + 20;
	}

	@Override
	protected int useUltimateSkill(Character target) {
		System.out.println("[궁수] 의 스킬 [화살비]!");
		if (target.getName() == "너구리")
			return power * level + 40;
		return power * level + 30;
	}
}