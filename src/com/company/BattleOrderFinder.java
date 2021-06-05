package com.company;

import com.company.units.Troop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 05/06/21
 */
public class BattleOrderFinder {

    private static final String THERE_IS_NO_CHANCE_OF_WINNING = "There is no chance of winning";
    private Troop[] myTroops;
    private Troop[] enemyTroops;
    private int winsNeeded;

    public BattleOrderFinder(Troop[] myTroops, Troop[] enemeyTroops) {
        this.myTroops = myTroops;
        this.enemyTroops = enemeyTroops;
        this.winsNeeded = myTroops.length / 2 + 1;
    }

    public String printBattleOrder() {

        boolean[] enAvail = new boolean[myTroops.length];
        Arrays.fill(enAvail, true);

        Map<Troop, Troop> result = new LinkedHashMap<>();

        Set<Troop> myTroopsSet = new HashSet<>();

        for (Troop myTroop : myTroops) {
            myTroopsSet.add(myTroop);
        }

        browsePlatoons(myTroops, 0, enemyTroops, enAvail, result, winsNeeded);

        if(result.size() < winsNeeded) {
            return THERE_IS_NO_CHANCE_OF_WINNING;
        }

        StringBuilder ans = new StringBuilder();

        for (Map.Entry<Troop, Troop> entry : result.entrySet()) {
            final Troop enemy = entry.getKey();
            final Troop me = entry.getValue();
            ans.append(me).append(";");
            myTroopsSet.remove(me);
        }

        final Iterator<Troop> iterator = myTroopsSet.iterator();

        while (iterator.hasNext()) {
            ans.append(iterator.next()).append(";");
        }

        return ans.toString();
    }

    private void browsePlatoons(Troop[] myTroops, int index, Troop[] enemyTroops, boolean[] enemyAvail, Map<Troop, Troop> result, int winsNeeded) {

        if (index >= myTroops.length) {
            return;
        }

        Troop myTroop = myTroops[index];
        for(int j =0;j < enemyTroops.length; j++) {
            Troop enemyTroop = enemyTroops[j];
            if(enemyAvail[j]) {
                if(myTroop.battle(enemyTroop) == Outcome.WIN) {
                    enemyAvail[j] = false;
                    result.put(enemyTroop, myTroop);
                }
                if(result.size() >= winsNeeded) {
                    return;
                }
                browsePlatoons(myTroops, index + 1, enemyTroops, enemyAvail, result, winsNeeded);
            }
        }
    }
}
