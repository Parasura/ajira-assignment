package com.company.units;

import java.util.HashSet;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 04/06/21
 */
public class HeavyCavalry extends Troop {
    public HeavyCavalry(int count) {
        super(count);
        getAntiUnit().add(Spearmen.class.getSimpleName());
        getAntiUnit().add(CavalryArcher.class.getSimpleName());
        getFavUnit().add(Militia.class.getSimpleName());
        getFavUnit().add(FootArcher.class.getSimpleName());
        getFavUnit().add(LightCavalry.class.getSimpleName());
    }

    @Override
    public String getName() {
        return HeavyCavalry.class.getSimpleName();
    }
}
