public class Role {
    private String name;
    private int health;
    private int attackPower;
   //建構子:初始劃角色的名稱、生命值與攻擊力
    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void attack(Role opponent) {
        opponent.health -= this.attackPower;
        System.out.println(this.name + " 攻擊 " + opponent.getName() + "，造成 " + this.attackPower + " 點傷害");
    }
    public boolean isAlive() {
        return this.health > 0;
    }
    public String toString() {
        return "角色名稱: " + name + ", 生命值: " + health + ", 攻擊力: " + attackPower;
    }
}
