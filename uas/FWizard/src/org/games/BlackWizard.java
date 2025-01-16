package org.games;
public class BlackWizard extends Wizard implements Skill {
    public BlackWizard() {
        super("Black Wizard", 100);
    }

    @Override
    public void skillAttack1(Wizard target) {
        int damage = 20;
        applyDamage(target, damage);
    }

    @Override
    public void skillAttack2(Wizard target) {
        int damage = 20;
        applyDamage(target, damage);
    }

    @Override
    public void skillAttack3(Wizard target) {
        int damage = 30;
        applyDamage(target, damage);
    }

    private void applyDamage(Wizard target, int baseDamage) {
        int damage = baseDamage;
        if (target instanceof RedWizard || target instanceof BlueWizard || target instanceof GreenWizard) {
            damage = (int) (baseDamage * 0.7); // 70% damage
        } else if (target instanceof WhiteWizard) {
            damage = (int) (baseDamage * 0.3); // 30% damage
        }
        System.out.println(getName() + " menyerang " + target.getName() + " dengan damage: " + damage);
        target.takeDamage(damage);
    }
}