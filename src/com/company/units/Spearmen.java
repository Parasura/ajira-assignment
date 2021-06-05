package com.company.units;

import com.company.Outcome;

import java.util.HashSet;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 04/06/21
 */
public class Spearmen extends Troop {

    public Spearmen(int count) {
        super(count);
        getAntiUnit().add(Militia.class.getSimpleName());
        getAntiUnit().add(CavalryArcher.class.getSimpleName());
        getFavUnit().add(LightCavalry.class.getSimpleName());
        getFavUnit().add(HeavyCavalry.class.getSimpleName());
    }

    @Override
    public String getName() {
        return Spearmen.class.getSimpleName();
    }
}
