package model;

public class Member {
    private String plate;      // 車牌
    private String name;       // 會員姓名
    private String memberType; // 會員等級 (例如 "VIP", "Regular")

    public Member(String plate, String name, String memberType) {
        this.plate = plate;
        this.name = name;
        this.memberType = memberType;
    }

    // Getters
    public String getPlate() { return plate; }
    public String getName() { return name; }
    public String getMemberType() { return memberType; }
}