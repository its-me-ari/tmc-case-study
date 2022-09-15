package com.example.tmc.cqrs.util;

import java.util.Collection;

public class ObjectUtils {

    public static boolean isNotEmpty(final Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }
}
