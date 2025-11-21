public  class Magician extends Role{
    // 實作抽象方法：戰前準備 (解決編譯錯誤)
    @Override
    public void prepareBattle() {
        System.out.println("【" + this.getName() + "】默唸了咒語，準備施展法術。");
    }

    // 實作抽象方法：戰鬥後的行為 (解決編譯錯誤)
    @Override
    public void afterBattle() {
        if (this.isAlive()) {
            System.out.println("【" + this.getName() + "】收起魔杖，略微休息。");
        } else {
            System.out.println("【" + this.getName() + "】已倒下。");
        }
    }
    // 治癒力
    private int healPower;

    // 建構子：初始化魔法師的名稱、生命值和攻擊力
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }


    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 魔法攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }

    // 治療隊友(劍客/魔法師)，父類別的參考指到子類別物件
    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + " 回復 " + healPower + " 點生命值。" + ally);
    }

    @Override
    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + this.getName() + " 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：群體治療          ║");
        System.out.println("║ 技能描述：治療所有隊友      ║");
        System.out.println("║ 治療量  ║");
        System.out.println("╚═════════════════════════════╝");
    }
}
