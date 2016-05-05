package com.abc.dsproj.hashset;

import com.abc.ds.set.*;
import com.abc.ds.set.tests.*;
import com.abc.ds.set.tests.gui.*;

public class TestHashDSSet {
    public static void main(String[] args) {
        GuiTestDSSet.runTests(
            "Testing of HashDSSet",
            new DSSetFactory() {
                @Override
                public boolean orderMatters() {
                    return false;
                }

                @Override
                public <T> DSSet<T> create(Class<T> itemType,
                                           int initialCapacity,
                                           int percentToGrowCapacity) {

                    return new HashDSSet<>(itemType, initialCapacity);
                }

                @Override
                public <T> DSSet<T> create(Class<T> itemType) {
                    return new HashDSSet<>(itemType, 11);
                }
            });
    }
}
