package org.games;
public class WhiteWizard extends Wizard implements Skill {
    public WhiteWizard() {
        super("White Wizard", 100);
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
        if (target instanceof BlackWizard) {
            damage = (int) (baseDamage * 0.7); // 70% damage
        } else if (target instanceof RedWizard || target instanceof GreenWizard || target instanceof BlueWizard) {
            damage = (int) (baseDamage * 0.3); // 30% damage
        }
        System.out.println(getName() + " menyerang " + target.getName() + " dengan damage: " + damage);
        target.takeDamage(damage);
    }
}