package com.company;

import com.company.units.Troop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

      //  String line1 = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
       // String line2 = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";

        //Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
        //Militia#100000;Spearmen#100000;FootArcher#10000000;LightCavalry#1200000;CavalryArcher#1000000
        String[] myInput = line1.split(";");

        Troop[] myTroops = fillArray(line1);
        Troop[] enmeyTroops = fillArray(line2);

        BattleOrderFinder battleOrderFinder = new BattleOrderFinder(myTroops, enmeyTroops);
        System.out.println(battleOrderFinder.printBattleOrder());
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
