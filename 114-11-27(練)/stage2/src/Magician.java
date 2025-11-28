public class Magician extends Role {
    private int healPower;

    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    public int getHealPower() {
        return healPower;
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 魔法攻擊 " + opponent.getName() +
                " 造成 " + this.getAttackPower() + " 點傷害。" + opponent);
    }

    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() +
                " 回復 " + healPower + " 點生命值。" + ally);
    }

    // ... 其他方法
}
