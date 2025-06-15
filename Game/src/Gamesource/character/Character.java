package Gamesource.character;

public abstract class Character {
	public String name;
	public int level;
	public int hp;
	public int power;
	public int defense;
	public int mp;

	public Character(String name) {
		this.name = name;
		this.level = 1;
	}

	public String getName() {
		return name;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public abstract int attack(Character target);
}
