import java.util.HashMap;
import java.util.Map;

class Solution {
    
    static int continuousTurn = 0;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        Character character = new Character(health, bandage[0], bandage[1], bandage[2]);

        Map<Integer, Integer> map = new HashMap<>();

        int lastTurn = 0;
        for (int[] attack : attacks) {
            int attackTurn = attack[0];
            lastTurn = Math.max(lastTurn, attackTurn);
            map.put(attackTurn, attack[1]);
        }

        for (int i = 1; i <= lastTurn; i++) {
            Integer pattern = map.get(i);
            if (pattern == null) {
                continuousTurn++;
                character.increaseHp(continuousTurn);
            }
            else {
                character.decreaseHp(pattern);
                continuousTurn = 0;
            }
            if (!character.isCharacterAlive()) {
                return -1;
            }
        }
        return character.getCurrentHp();
    }
    
    private static class Character {
        private final int maxHp;
        private int currentHp;
        private final int bandageSkillCastingTime;
        private final int bandageSkillEffectPerSecond;
        private final int bandageSkillAdditionalEffect;

        public Character(int maxHp, int bandageSkillCastingTime, int bandageSkillEffectPerSecond, int bandageSkillAdditionalEffect) {
            this.maxHp = maxHp;
            this.currentHp = maxHp;
            this.bandageSkillCastingTime = bandageSkillCastingTime;
            this.bandageSkillEffectPerSecond = bandageSkillEffectPerSecond;
            this.bandageSkillAdditionalEffect = bandageSkillAdditionalEffect;
        }

        public void decreaseHp(int damage) {
            this.currentHp -= damage;
        }

        public void increaseHp(int turn) {
            if (turn != 0 && turn % bandageSkillCastingTime == 0) {
                this.currentHp += this.bandageSkillAdditionalEffect;
                this.currentHp += bandageSkillEffectPerSecond;
                if (this.currentHp >= this.maxHp) {
                    this.currentHp = this.maxHp;
                }
                continuousTurn = 0;
            }
            else {
                this.currentHp += bandageSkillEffectPerSecond;
                if (this.currentHp >= this.maxHp) {
                    this.currentHp = this.maxHp;
                }
            }
        }

        public boolean isCharacterAlive() {
            return this.currentHp > 0;
        }


        public int getCurrentHp() {
            return this.currentHp;
        }
    }
}