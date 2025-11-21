public  class SwordsMan extends Role{
    // 建構子：初始化劍士的名稱、生命值和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 實作抽象方法 1: 戰前準備 (解決編譯錯誤)
    @Override
    public void prepareBattle() {
        System.out.println("【" + this.getName() + "】磨亮了劍刃，準備發動攻擊！");
    }

    // 實作抽象方法 2: 戰鬥後的行為 (解決編譯錯誤)
    @Override
    public void afterBattle() {
        if (this.isAlive()) {
            System.out.println("【" + this.getName() + "】將劍收入鞘中，體力微幅恢復。");
        } else {
            System.out.println("【" + this.getName() + "】已倒下。");
        }
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }
    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：群體治療          ║");
        System.out.println("║ 技能描述：治療所有隊友      ║");
        System.out.println("║ 治療量   ║");
        System.out.println("╚═════════════════════════════╝");
    }
}
