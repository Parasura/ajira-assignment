package com.company.units;

import java.util.HashSet;
import java.util.Set;

/* @author parasuramanramachandran
 * created on 04/06/21
 */
public class FootArcher extends Troop {

    public FootArcher(int count) {
        super(count);
        getAntiUnit().add(LightCavalry.class.getSimpleName());
        getFavUnit().add(Militia.class.getSimpleName());
        getFavUnit().add(CavalryArcher.class.getSimpleName());
    }

    @Override
    public String getName() {
        return FootArcher.class.getSimpleName();
    }

}
