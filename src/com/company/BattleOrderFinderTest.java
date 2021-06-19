package com.company;

import com.company.exception.InvalidInputException;
import com.company.units.Troop;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BattleOrderFinderTest {

    @Test
    public void testBattleOrderWin() throws InvalidInputException {
        String line1 = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
        String line2 = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
        Troop[] myTroops = fillArray(line1);
        Troop[] enmeyTroops = fillArray(line2);

        BattleOrderFinder battleOrderFinder = new BattleOrderFinder(myTroops, enmeyTroops);
        Assert.assertNotEquals(BattleOrderFinder.THERE_IS_NO_CHANCE_OF_WINNING, battleOrderFinder.printBattleOrder());
    }

    @Test
    public void testBattleOrderLose() throws InvalidInputException {
        String line1 = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
        String line2 = "Militia#40;HeavyCavalry#160;FootArcher#21;LightCavalry#120;CavalryArcher#100";
        Troop[] myTroops = fillArray(line1);
        Troop[] enmeyTroops = fillArray(line2);

        BattleOrderFinder battleOrderFinder = new BattleOrderFinder(myTroops, enmeyTroops);
        Assert.assertEquals(BattleOrderFinder.THERE_IS_NO_CHANCE_OF_WINNING, battleOrderFinder.printBattleOrder());
    }

    private static Troop[] fillArray(String line) {
        String[] myInput = line.split(";");
        Troop[] troops = new Troop[myInput.length];
        int i = 0;
        for (String troop : myInput) {
            String[] s = troop.split("#");
            troops[i++] = ObjectFactory.getTroop(s[0], Integer.parseInt(s[1]));
        }
        return troops;
    }
}