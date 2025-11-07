public class Magician  extends  Role {
    private int healPower;
    //建構子:初始劃角色的名稱、生命值與攻擊力
    public Magician(String name, int health, int attackPower) {
       super(name, health, attackPower);
    }

    public int getHealPower() {
        return healPower;
    }


//攻擊對手
    public void attack(Magician opponent) {
        opponent.setHealth(opponent.getHealth()-this.getAttackPower());
        System.out.println(this.getName() + " 使用魔法攻擊 " + opponent.getName() + "，造成 " +
                this.getAttackPower ()+ " 點傷害");
    }
    public void heal(SwordsMan ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + "，恢復 " + healPower + " 點生命值"+ally);
    }
    @Override
      public String toString() {
      return super.toString()+", 治療力: " + healPower;
    }
}
