package com.company.units;

import com.company.Outcome;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Troop {

    private int count;
    private Set<String> antiUnit = new HashSet<>();
    private Set<String> favUnit = new HashSet<>();

    public Troop(int count) {
        this.count = count;
    }

    abstract public String getName();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<String> getAntiUnit() {
        return antiUnit;
    }

    public boolean isAntiUnit(Troop troop) {
        return antiUnit.contains(troop.getName());
    }

    public Set<String> getFavUnit() {
        return favUnit;
    }

    public Outcome battle(Troop troop) {
        if(isAntiUnit(troop)) {
            if (getCount() == 2 * troop.getCount()) {
                return Outcome.DRAW;
            }
            return getCount() > 2 * troop.getCount() ? Outcome.WIN : Outcome.LOOSE;

        } else if(isFavUnit(troop)) {
            if ( 2 * getCount() == troop.getCount()) {
                return Outcome.DRAW;
            }
            return 2 * getCount() > troop.getCount() ? Outcome.WIN : Outcome.LOOSE;
        } else {
            if(getCount() == troop.getCount()) {
                return Outcome.DRAW;
            }
            return getCount() > troop.getCount() ? Outcome.WIN : Outcome.LOOSE;
        }
    }

    private boolean isFavUnit(Troop troop) {
        return favUnit.contains(troop.getName());
    }

    @Override
    public String toString() {
        return this.getName() + "#" + count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Troop troop = (Troop) o;
        return count == troop.count && Objects.equals(antiUnit, troop.antiUnit) && Objects.equals(favUnit, troop.favUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, antiUnit, favUnit);
    }
}
