package com.company;

import com.company.exception.InvalidInputException;
import com.company.units.LightCavalry;
import com.company.units.Spearmen;
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

    public static void main(String[] args) throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

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
