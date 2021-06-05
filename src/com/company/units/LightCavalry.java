package com.company.units;

import java.util.HashSet;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 04/06/21
 */
public class LightCavalry extends Troop {
    public LightCavalry(int count) {
        super(count);
        getAntiUnit().add(Militia.class.getSimpleName());
        getAntiUnit().add(HeavyCavalry.class.getSimpleName());
        getFavUnit().add(FootArcher.class.getSimpleName());
        getFavUnit().add(CavalryArcher.class.getSimpleName());
    }

    @Override
    public String getName() {
        return LightCavalry.class.getSimpleName();
    }
}
