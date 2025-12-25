public class RPG {
    public static void main(String[] args) {
        System.out.println("════════════════════════════════════════");
        System.out.println("        🎮 RPG 遊戲 - 第三階段");
        System.out.println("      展示：多層繼承結構設計");
        System.out.println("════════════════════════════════════════");
        System.out.println();

<<<<<<< HEAD
        // ==========================================
        // 1. 顯示類別繼承結構（新增）
        // ==========================================
        System.out.println("【📋 類別繼承結構】");
        System.out.println("─────────────────────────────────────");
        System.out.println("Role (最高層抽象類別)");
        System.out.println("├─ MeleeRole (近戰角色抽象類別)");
        System.out.println("│  ├─ SwordsMan (劍士)");
        System.out.println("│  └─ ShieldSwordsMan (持盾劍士)");
        System.out.println("└─ RangedRole (遠程角色抽象類別)");
        System.out.println("   ├─ Magician (魔法師)");
        System.out.println("   └─ Archer (弓箭手)");
        System.out.println();

        // ==========================================
        // 2. 建立角色（參數變更）
        // ==========================================
        System.out.println("【創建角色】");
        System.out.println("─────────────────────────────────────");

        // 近戰角色：需要 armor（護甲值）
        SwordsMan swordsMan_light = new SwordsMan("光明劍士", 100, 20, 5);
        System.out.println("✅ " + swordsMan_light);

        SwordsMan swordsMan_dark = new SwordsMan("黑暗劍士", 100, 25, 3);
        System.out.println("✅ " + swordsMan_dark);

        ShieldSwordsMan shieldSwordsMan = new ShieldSwordsMan("持盾劍士", 120, 18, 8, 10);
        System.out.println("✅ " + shieldSwordsMan);

        // 遠程角色：需要 range（射程）和 maxEnergy（最大能量）
        Magician magician_light = new Magician("光明法師", 80, 15, 10, 8, 100);
        System.out.println("✅ " + magician_light);

        Magician magician_dark = new Magician("黑暗法師", 80, 20, 5, 8, 100);
        System.out.println("✅ " + magician_dark);

        // 新增角色：弓箭手
        Archer archer = new Archer("精靈射手", 90, 18, 10, 80, 30);
        System.out.println("✅ " + archer);

        System.out.println();

        // ==========================================
        // 3. 將所有角色放入陣列
        // ==========================================
        Role[] gameRoles = {swordsMan_light, swordsMan_dark, shieldSwordsMan,
                magician_light, magician_dark, archer};

        // ==========================================
        // 4. 展示類別特性（新增）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          🔍 角色類別特性展示");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【近戰角色特性】");
        System.out.println("─────────────────────────────────────");
        for (Role role : gameRoles) {
            if (role instanceof MeleeRole) {
                MeleeRole melee = (MeleeRole) role;
                System.out.println("⚔️  " + role.getName() + "：");
                System.out.println("    武器類型：" + melee.getWeaponType());
                System.out.println("    護甲值：" + melee.getArmor());
                System.out.println();
            }
        }

        System.out.println("【遠程角色特性】");
        System.out.println("─────────────────────────────────────");
        for (Role role : gameRoles) {
            if (role instanceof RangedRole) {
                RangedRole ranged = (RangedRole) role;
                System.out.println("🎯 " + role.getName() + "：");
                System.out.println("    攻擊類型：" + ranged.getRangedAttackType());
                System.out.println("    射程：" + ranged.getRange() + " 米");
                System.out.println("    能量：" + ranged.getEnergy() + "/" + ranged.getMaxEnergy());

                // 如果是弓箭手，額外顯示箭矢
                if (role instanceof Archer) {
                    Archer a = (Archer) role;
                    System.out.println("    箭矢：" + a.getArrowCount() + " 支");
                }
                System.out.println();
            }
        }

        // ==========================================
        // 5. 顯示所有角色的特殊技能
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          ⚔️  特殊技能展示");
=======
        System.out.println("📋 類別繼承結構：");
        System.out.println("Role (最高層)");
        System.out.println("├─ MeleeRole (近戰角色)");
        System.out.println("│  ├─ SwordsMan (劍士)");
        System.out.println("│  └─ ShieldSwordsMan (持盾劍士)");
        System.out.println("└─ RangedRole (遠程角色)");
        System.out.println("   ├─ Magician (魔法師)");
        System.out.println("   └─ Archer (弓箭手)");
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // 建立角色 - 注意參數變化
        // 近戰角色：需要 armor（護甲值）
        SwordsMan swordsMan_light = new SwordsMan("光明劍士", 100, 20, 5);
        SwordsMan swordsMan_dark = new SwordsMan("黑暗劍士", 100, 25, 3);
        ShieldSwordsMan shieldSwordsMan = new ShieldSwordsMan("持盾劍士", 120, 18, 8, 10);

        // 遠程角色：需要 range（射程）和 maxEnergy（能量值）
        Magician magician_light = new Magician("光明法師", 80, 15, 10, 8, 100);
        Magician magician_dark = new Magician("黑暗法師", 80, 20, 5, 8, 100);
        Archer archer = new Archer("精靈射手", 90, 18, 10, 80, 30);

        Role[] gameRoles = {swordsMan_light, swordsMan_dark, shieldSwordsMan,
                magician_light, magician_dark, archer};

        // ========== 展示所有角色的特殊技能 ==========
        System.out.println("════════════════════════════════════════");
        System.out.println("          📋 角色特殊技能展示");
>>>>>>> 48c27cfade06c07cbef05a5eacf1a6ee49da914f
        System.out.println("════════════════════════════════════════");
        System.out.println();

        for (Role role : gameRoles) {
            role.showSpecialSkill();
            System.out.println();
        }

<<<<<<< HEAD
        // ==========================================
        // 6. 戰鬥前準備
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          🛡️  戰鬥前準備");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        for (Role role : gameRoles) {
            role.prepareBattle();
            System.out.println();
        }

        // ==========================================
        // 7. 戰鬥測試：護甲減免展示（新增）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("      ⚔️  戰鬥測試 1：護甲減免效果");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【測試：光明劍士受到 30 點傷害】");
        System.out.println("護甲值：" + ((MeleeRole)swordsMan_light).getArmor());
        System.out.println("預期實際傷害：30 - 5 = 25");
        System.out.println("─────────────────────────────────────");
        swordsMan_light.takeDamage(30);
        System.out.println("實際狀態：" + swordsMan_light);
        System.out.println();

        System.out.println("【測試：持盾劍士受到 30 點傷害】");
        System.out.println("護甲值：" + ((MeleeRole)shieldSwordsMan).getArmor());
        System.out.println("預期實際傷害：30 - 8 = 22");
        System.out.println("─────────────────────────────────────");
        shieldSwordsMan.takeDamage(30);
        System.out.println("實際狀態：" + shieldSwordsMan);
        System.out.println();

        // ==========================================
        // 8. 戰鬥測試：能量系統展示（新增）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("      ✨ 戰鬥測試 2：能量消耗系統");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【光明法師連續攻擊測試】");
        System.out.println("當前能量：" + ((RangedRole)magician_light).getEnergy());
        System.out.println("─────────────────────────────────────");

        System.out.println("\n第 1 次攻擊：");
        magician_light.attack(swordsMan_dark);

        System.out.println("\n第 2 次攻擊：");
        magician_light.attack(swordsMan_dark);

        System.out.println("\n第 3 次攻擊：");
        magician_light.attack(swordsMan_dark);

        System.out.println("\n當前能量：" + ((RangedRole)magician_light).getEnergy());
        System.out.println();

        // ==========================================
        // 9. 戰鬥測試：箭矢系統展示（新增）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("      🏹 戰鬥測試 3：箭矢消耗系統");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【精靈射手連續射擊測試】");
        System.out.println("當前箭矢：" + archer.getArrowCount() + " 支");
        System.out.println("當前能量：" + ((RangedRole)archer).getEnergy());
        System.out.println("─────────────────────────────────────");

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n第 " + i + " 次射擊：");
            archer.attack(swordsMan_dark);
        }

        System.out.println("\n剩餘箭矢：" + archer.getArrowCount() + " 支");
        System.out.println("剩餘能量：" + ((RangedRole)archer).getEnergy());
        System.out.println();

        // ==========================================
        // 10. 戰鬥測試：受傷與死亡
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("        ⚔️  戰鬥測試 4：致命傷害");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【黑暗劍士受到致命傷害】");
        System.out.println("當前生命值：" + swordsMan_dark.getHealth());
        System.out.println("即將受到 200 點傷害...");
        System.out.println("─────────────────────────────────────");
        swordsMan_dark.takeDamage(200);
        System.out.println();

        // ==========================================
        // 11. 角色互相攻擊測試
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          ⚔️  角色互相攻擊");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【戰鬥 1：持盾劍士 vs 黑暗法師】");
        shieldSwordsMan.attack(magician_dark);
        System.out.println();

        System.out.println("【戰鬥 2：黑暗法師反擊】");
        magician_dark.attack(shieldSwordsMan);
        System.out.println();

        // ==========================================
        // 12. 魔法師治療測試（含能量消耗）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          💚 治療測試");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【光明法師治療持盾劍士】");
        System.out.println("治療前能量：" + ((RangedRole)magician_light).getEnergy());
        magician_light.heal(shieldSwordsMan);
        System.out.println("治療後能量：" + ((RangedRole)magician_light).getEnergy());
        System.out.println();

        // ==========================================
        // 13. 持盾劍士特殊能力測試
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("        🛡️  持盾劍士防禦測試");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【持盾劍士使用防禦技能】");
        System.out.println("當前生命值：" + shieldSwordsMan.getHealth());
        shieldSwordsMan.defence();
        System.out.println("防禦後生命值：" + shieldSwordsMan.getHealth());
        System.out.println();

        // ==========================================
        // 14. 戰鬥後行為（含能量恢復）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          🌙 戰鬥結束");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【所有存活角色的戰後行為】");
        System.out.println("─────────────────────────────────────");

        for (Role role : gameRoles) {
            if (role.isAlive()) {
                System.out.println("\n" + role.getName() + " 的戰後行為：");

                // 顯示戰前能量（如果是遠程角色）
                if (role instanceof RangedRole) {
                    RangedRole ranged = (RangedRole) role;
                    System.out.println("戰前能量：" + ranged.getEnergy() + "/" + ranged.getMaxEnergy());
                }

                role.afterBattle();

                // 顯示戰後能量（如果是遠程角色）
                if (role instanceof RangedRole) {
                    RangedRole ranged = (RangedRole) role;
                    System.out.println("戰後能量：" + ranged.getEnergy() + "/" + ranged.getMaxEnergy());
                }
            }
        }
        System.out.println();

        // ==========================================
        // 15. 最終狀態報告（增強版）
        // ==========================================
        System.out.println("════════════════════════════════════════");
        System.out.println("          📊 最終狀態報告");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        int aliveCount = 0;
        int deadCount = 0;
        int meleeCount = 0;
        int rangedCount = 0;

        System.out.println("【角色狀態詳情】");
        System.out.println("─────────────────────────────────────");

        for (Role role : gameRoles) {
            String status = role.isAlive() ? "✅ 存活" : "💀 陣亡";
            String type = "";

            if (role instanceof MeleeRole) {
                type = "⚔️  近戰";
                meleeCount++;
            } else if (role instanceof RangedRole) {
                type = "🎯 遠程";
                rangedCount++;
            }

            System.out.println(status + " | " + type + " | " + role);

            if (role.isAlive()) {
                aliveCount++;
            } else {
                deadCount++;
            }
        }

        System.out.println();
        System.out.println("【統計資訊】");
        System.out.println("─────────────────────────────────────");
        System.out.println("總角色數：" + gameRoles.length + " 名");
        System.out.println("近戰角色：" + meleeCount + " 名");
        System.out.println("遠程角色：" + rangedCount + " 名");
        System.out.println("存活角色：" + aliveCount + " 名");
        System.out.println("陣亡角色：" + deadCount + " 名");
        System.out.println("─────────────────────────────────────");
        System.out.println();
        System.out.println("🎮 遊戲結束！");
    }
}
=======
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ========== 展示類別特性 ==========
        System.out.println("════════════════════════════════════════");
        System.out.println("          🔍 角色類別特性展示");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【近戰角色特性】");
        for (Role role : gameRoles) {
            if (role instanceof MeleeRole) {
                MeleeRole melee = (MeleeRole) role;
                System.out.println(role.getName() + "：武器=" + melee.getWeaponType() +
                        "，護甲=" + melee.getArmor());
            }
        }
        System.out.println();

        System.out.println("【遠程角色特性】");
        for (Role role : gameRoles) {
            if (role instanceof RangedRole) {
                RangedRole ranged = (RangedRole) role;
                System.out.println(role.getName() + "：攻擊類型=" + ranged.getRangedAttackType() +
                        "，射程=" + ranged.getRange() +
                        "，能量=" + ranged.getEnergy() + "/" + ranged.getMaxEnergy());
            }
        }
        System.out.println();
        System.out.println("════════════════════════════════════════");
        System.out.println();

        // ========== 戰鬥流程 ==========
        System.out.println("⚔️  戰鬥開始！");
        System.out.println();

        int round = 1;
        int maxRounds = 5; // 限制回合數避免輸出過長

        for (Role currentRole : gameRoles) {
            if (round > maxRounds) break;
            if (!currentRole.isAlive()) {
                continue;
            }

            System.out.println("━━━━━━━━━━ 第 " + round + " 回合 ━━━━━━━━━━");

            // 戰前準備
            currentRole.prepareBattle();
            System.out.println();

            // 執行動作
            if (currentRole instanceof ShieldSwordsMan) {
                // 持盾劍士：可能先防禦
                ShieldSwordsMan shield = (ShieldSwordsMan) currentRole;
                if (Math.random() < 0.3) {
                    shield.defence();
                    System.out.println();
                }
                Role target = getRandomAliveTarget(gameRoles, currentRole);
                if (target != null) {
                    currentRole.attack(target);
                }
            } else if (currentRole instanceof SwordsMan) {
                // 一般劍士：直接攻擊
                Role target = getRandomAliveTarget(gameRoles, currentRole);
                if (target != null) {
                    currentRole.attack(target);
                }
            } else if (currentRole instanceof Archer) {
                // 弓箭手：遠程攻擊
                Role target = getRandomAliveTarget(gameRoles, currentRole);
                if (target != null) {
                    currentRole.attack(target);
                }
            } else if (currentRole instanceof Magician) {
                // 魔法師：攻擊或治療
                Magician magician = (Magician) currentRole;
                if (Math.random() < 0.6) {
                    Role target = getRandomAliveTarget(gameRoles, currentRole);
                    if (target != null) {
                        currentRole.attack(target);
                    }
                } else {
                    Role ally = getRandomAliveRole(gameRoles);
                    if (ally != null) {
                        magician.heal(ally);
                    }
                }
            }

            System.out.println();

            // 戰後行為
            if (currentRole.isAlive()) {
                currentRole.afterBattle();
            }

            System.out.println();
            round++;
        }

        // ========== 戰鬥結束 ==========
        System.out.println("════════════════════════════════════════");
        System.out.println("          🏆 戰鬥結束");
        System.out.println("════════════════════════════════════════");
        System.out.println();

        System.out.println("【近戰角色狀態】");
        for (Role role : gameRoles) {
            if (role instanceof MeleeRole && role.isAlive()) {
                MeleeRole melee = (MeleeRole) role;
                System.out.println("✅ " + role.getName() + " - 生命值：" + role.getHealth() +
                        "，護甲：" + melee.getArmor());
            }
        }
        System.out.println();

        System.out.println("【遠程角色狀態】");
        for (Role role : gameRoles) {
            if (role instanceof RangedRole && role.isAlive()) {
                RangedRole ranged = (RangedRole) role;
                System.out.println("✅ " + role.getName() + " - 生命值：" + role.getHealth() +
                        "，能量：" + ranged.getEnergy() + "/" + ranged.getMaxEnergy());
            }
        }
        System.out.println();

        System.out.println("【陣亡角色】");
        boolean hasDeadRoles = false;
        for (Role role : gameRoles) {
            if (!role.isAlive()) {
                System.out.println("💀 " + role.getName());
                hasDeadRoles = true;
            }
        }
        if (!hasDeadRoles) {
            System.out.println("所有角色都存活！");
        }
    }

    /**
     * 隨機選擇一個存活的目標（排除自己）
     */
    private static Role getRandomAliveTarget(Role[] roles, Role self) {
        Role[] aliveRoles = new Role[roles.length];
        int count = 0;

        for (Role role : roles) {
            if (role != self && role.isAlive()) {
                aliveRoles[count++] = role;
            }
        }

        if (count == 0) return null;
        return aliveRoles[(int) (Math.random() * count)];
    }

    /**
     * 隨機選擇一個存活的角色（包括自己）
     */
    private static Role getRandomAliveRole(Role[] roles) {
        Role[] aliveRoles = new Role[roles.length];
        int count = 0;

        for (Role role : roles) {
            if (role.isAlive()) {
                aliveRoles[count++] = role;
            }
        }

        if (count == 0) return null;
        return aliveRoles[(int) (Math.random() * count)];
    }
}

>>>>>>> 48c27cfade06c07cbef05a5eacf1a6ee49da914f
