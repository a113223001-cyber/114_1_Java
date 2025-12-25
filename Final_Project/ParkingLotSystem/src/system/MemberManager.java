package system;

import model.Member;
import java.util.HashMap;
import java.util.Map;

public class MemberManager {
    private Map<String, Member> members = new HashMap<>();

    public MemberManager() {
        // 預設資料：車牌分別為VIP-111  和 PRE-888
        addMember(new Member("VIP-111", "Emily", "VIP"));
        addMember(new Member("PRE-888", "Sarah", "Premium"));
    }

    public void addMember(Member m) {
        members.put(m.getPlate().toUpperCase(), m);
    }

    public boolean isMember(String plate) {
        return members.containsKey(plate.toUpperCase());
    }

    public Member getMember(String plate) {
        return members.get(plate.toUpperCase());
    }
}