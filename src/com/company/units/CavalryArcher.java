package com.company.units;

import com.company.Outcome;

import java.util.HashSet;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 04/06/21
 */
public class CavalryArcher extends Troop {

    public CavalryArcher(int count) {
        super(count);
        getAntiUnit().add(LightCavalry.class.getSimpleName());
        getAntiUnit().add(FootArcher.class.getSimpleName());
        getFavUnit().add(Spearmen.class.getSimpleName());
        getFavUnit().add(HeavyCavalry.class.getSimpleName());
    }

    @Override
    public String getName() {
        return CavalryArcher.class.getSimpleName();
    }

}
