public class SwordsMan extends Role {

    // 建構子
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() +
                " 造成 " + this.getAttackPower() + " 點傷害。" + opponent);
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("┌─────────────────────────────┐");
        System.out.println("│ " + this.getName() + " 的特殊技能        │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│ 技能名稱：連續斬擊          │");
        System.out.println("│ 技能描述：快速揮劍三次      │");
        System.out.println("│ 技能效果：造成 150% 傷害    │");
        System.out.println("└─────────────────────────────┘");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 倒下了...");
        System.out.println("⚔️  劍掉落在地上，發出清脆的聲響。");
        System.out.println("🛡️  護甲碎裂散落一地。");
        System.out.println("---");
    }

    @Override
    public void prepareBattle() {
        System.out.println("⚔️  " + this.getName() + " 準備戰鬥...");
        System.out.println("✨ 擦拭劍刃，劍身反射出凜冽的寒光...");
    }

    @Override
    public void afterBattle() {
        System.out.println("🗡️  " + this.getName() + " 將劍收入劍鞘。");
    }
}
