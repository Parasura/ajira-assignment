package com.company;

import com.company.units.CavalryArcher;
import com.company.units.FootArcher;
import com.company.units.HeavyCavalry;
import com.company.units.LightCavalry;
import com.company.units.Militia;
import com.company.units.Spearmen;
import com.company.units.Troop;

/* @author parasuramanramachandran
 * created on 05/06/21
 */
public class ObjectFactory {
    public static Troop getTroop(String name, int count) {

        switch (name) {
            case "Militia":
                return new Militia(count);

            case "FootArcher" :
                return new FootArcher(count);

            case "HeavyCavalry" :
                return new HeavyCavalry(count);

            case "LightCavalry" :
                return new LightCavalry(count);

            case "CavalryArcher" :
                return new CavalryArcher(count);

            case "Spearmen" :
                return new Spearmen(count);

        }

        return null;
    }
}
