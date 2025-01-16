package org.games;
public class BlueWizard extends Wizard implements Skill {
    public BlueWizard() {
        super("Blue Wizard", 100);
    }

    @Override
    public void skillAttack1(Wizard target) {
        int damage = 15;
        applyDamage(target, damage);
    }

    @Override
    public void skillAttack2(Wizard target) {
        int damage = 20;
        applyDamage(target, damage);
    }

    @Override
    public void skillAttack3(Wizard target) {
        int damage = 35;
        applyDamage(target, damage);
    }

    private void applyDamage(Wizard target, int baseDamage) {
        int damage = baseDamage;
        if (target instanceof RedWizard) {
            damage = baseDamage; // Damage penuh
        } else if (target instanceof WhiteWizard) {
            damage = (int) (baseDamage * 0.75); // 75% damage
        } else if (target instanceof BlackWizard) {
            damage = (int) (baseDamage * 0.5); // 50% damage
        } else if (target instanceof GreenWizard) {
            damage = (int) (baseDamage * 0.25); // 25% damage
        }
        System.out.println(getName() + " menyerang " + target.getName() + " dengan damage: " + damage);
        target.takeDamage(damage);
    }
}