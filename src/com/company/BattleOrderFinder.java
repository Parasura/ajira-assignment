package com.company;

import com.company.exception.InvalidInputException;
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

    public static final String THERE_IS_NO_CHANCE_OF_WINNING = "There is no chance of winning";
    private Troop[] myTroops;
    private Troop[] enemyTroops;
    private int winsNeeded;

    public BattleOrderFinder(Troop[] myTroops, Troop[] enemeyTroops) {
        this.myTroops = myTroops;
        this.enemyTroops = enemeyTroops;
        this.winsNeeded = myTroops.length / 2 + 1;
    }

    public String printBattleOrder() throws InvalidInputException {

        validate();

        boolean[] enemyTroopAvailablity = new boolean[myTroops.length];
        Arrays.fill(enemyTroopAvailablity, true);
        boolean[] myTroopAvailability = new boolean[myTroops.length];
        Arrays.fill(myTroopAvailability, true);

        Map<Troop, Troop> combination = new LinkedHashMap<>();

        browsePlatoons(0, enemyTroopAvailablity, myTroopAvailability, combination);

        if(combination.size() < winsNeeded) {
            return THERE_IS_NO_CHANCE_OF_WINNING;
        }

        StringBuilder troopsBattleOrder = buildBattleOrder(combination);

        return troopsBattleOrder.toString();
    }

    private void validate() throws InvalidInputException {
        if(myTroops == null || enemyTroops == null || myTroops.length == 0 || enemyTroops.length == 0) {
            throw new InvalidInputException();
        }
    }

    private StringBuilder buildBattleOrder(Map<Troop, Troop> result) {

        System.out.println(result);
        Set<Troop> myTroopsSet = new HashSet<>();

        for (Troop myTroop : myTroops) {
            myTroopsSet.add(myTroop);
        }

        StringBuilder troopOrder = new StringBuilder();

        for (Map.Entry<Troop, Troop> entry : result.entrySet()) {
            final Troop enemy = entry.getKey();
            final Troop me = entry.getValue();
            troopOrder.append(me).append(";");
            myTroopsSet.remove(me);
        }

        final Iterator<Troop> iterator = myTroopsSet.iterator();

        while (iterator.hasNext()) {
            troopOrder.append(iterator.next()).append(";");
        }
        return troopOrder;
    }

    private void browsePlatoons(int index, boolean[] enemyTroopAvailablity, boolean[] myTroopAvailability, Map<Troop, Troop> combination) {

        if (index >= myTroops.length) {
            return;
        }

        Troop myTroop = myTroops[index];

        for (int j = 0; j < enemyTroops.length; j++) {
            Troop enemyTroop = enemyTroops[j];
            // Taking the enemy troop which is free
            if (enemyTroopAvailablity[j] && myTroopAvailability[index]) {
                if (myTroop.battle(enemyTroop) == Outcome.WIN) {
                    enemyTroopAvailablity[j] = false;
                    myTroopAvailability[index] = false;
                    combination.put(enemyTroop, myTroop);
                }
                browsePlatoons(index + 1, enemyTroopAvailablity, myTroopAvailability, combination);
            }
        }
    }
}
