package com.company.units;

import java.util.HashSet;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 04/06/21
 */
public class Militia extends Troop {

    public Militia(int count) {
        super(count);
        getAntiUnit().add(HeavyCavalry.class.getSimpleName());
        getAntiUnit().add(FootArcher.class.getSimpleName());
        getFavUnit().add(Spearmen.class.getSimpleName());
        getFavUnit().add(LightCavalry.class.getSimpleName());
    }

    public String getName() {
        return Militia.class.getSimpleName();
    }
}
