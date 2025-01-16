package org.games;
public abstract class Wizard {
    private int hp;
    private String name;

    public Wizard(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public int getHP() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0; // Pastikan HP tidak negatif
    }

    public abstract void skillAttack1(Wizard target);
    public abstract void skillAttack2(Wizard target);
    public abstract void skillAttack3(Wizard target);
}