public class SwordsMan  extends  Role {

   //建構子:初始劃角色的名稱、生命值與攻擊力
    public SwordsMan(String name, int health, int attackPower) {
       super(name, health, attackPower);
    }


    public void attack(SwordsMan opponent) {
        opponent.setHealth (oppnent.getHealth())- this.getAttackPower();
        System.out.println(this.getName() + " 攻擊 " + opponent.name + "，造成 " + this.attackPower + " 點傷害");
    }


    public boolean isAlive() {
        return this.health > 0;
    }

}
