public class ShieldSwordsMan extends SwordsMan{
    private int defenseCapacity;
    // 建構子：初始化持盾劍士的名稱、生命值和攻擊力
    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = defenseCapacity;
    }

    // 實作抽象方法：戰前準備 (解決編譯錯誤)
    @Override
    public void prepareBattle() {
        System.out.println("【" + this.getName() + "】舉起盾牌，擺出了防禦姿勢。");
    }

    // 實作抽象方法：戰鬥後的行為 (解決編譯錯誤)
    @Override
    public void afterBattle() {
        if (this.isAlive()) {
            System.out.println("【" + this.getName() + "】收回盾牌，保持警惕。");
        } else {
            System.out.println("【" + this.getName() + "】已倒下。");
        }
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5; // 持盾劍士攻擊力減少5點
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                reducedDamage + " 點傷害。" + opponent);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence() {
        this.setHealth(this.getHealth() + defenseCapacity);
        System.out.println(this.getName() + " 使用盾牌防禦，恢復 " + defenseCapacity + " 點生命值。" + this);
    }
    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：群體治療          ║");
        System.out.println("║ 技能描述：治療所有隊友      ║");
        System.out.println("║ 治療量：" + defenseCapacity + " 點生命值       ║");
        System.out.println("╚═════════════════════════════╝");
    }
}
