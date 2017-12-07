/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.zhn.Remax.event.ArrayHelper;
import com.zhn.Remax.event.Data;
import com.zhn.Remax.event.Event;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.Priority;

public class EventManager {
    private static final Map<Class<? extends Event>, ArrayHelper<Data>> REGISTRY_MAP = new HashMap<Class<? extends Event>, ArrayHelper<Data>>();

    public static void register(Object o) {
        Method[] arrmethod = o.getClass().getDeclaredMethods();
        int n = arrmethod.length;
        int n2 = 0;
        while (n2 < n) {
            Method method = arrmethod[n2];
            if (!EventManager.isMethodBad(method)) {
                EventManager.register(method, o);
            }
            ++n2;
        }
    }

    public static void register(Object o, Class<? extends Event> clazz) {
        Method[] arrmethod = o.getClass().getDeclaredMethods();
        int n = arrmethod.length;
        int n2 = 0;
        while (n2 < n) {
            Method method = arrmethod[n2];
            if (!EventManager.isMethodBad(method, clazz)) {
                EventManager.register(method, o);
            }
            ++n2;
        }
    }

    private static void register(Method method, Object o)
    {
      Class<?> clazz = method.getParameterTypes()[0];
      Data methodData = new Data(o, method, ((EventTarget)method.getAnnotation(EventTarget.class)).value());
      if (!methodData.target.isAccessible()) {
        methodData.target.setAccessible(true);
      }
      if (REGISTRY_MAP.containsKey(clazz))
      {
        if (!((ArrayHelper)REGISTRY_MAP.get(clazz)).contains(methodData))
        {
          ((ArrayHelper)REGISTRY_MAP.get(clazz)).add(methodData);
          sortListValue((Class<? extends Event>) clazz);
        }
      }
      else {
        REGISTRY_MAP.put((Class<? extends Event>) clazz, new ArrayHelper() {});
      }
    }

    public static void unregister(Object o) {
        for (ArrayHelper<Data> flexibalArray : REGISTRY_MAP.values()) {
            for (Data methodData : flexibalArray) {
                if (!methodData.source.equals(o)) continue;
                flexibalArray.remove(methodData);
            }
        }
        EventManager.cleanMap(true);
    }

    public static void unregister(Object o, Class<? extends Event> clazz) {
        if (REGISTRY_MAP.containsKey(clazz)) {
            for (Data methodData : REGISTRY_MAP.get(clazz)) {
                if (!methodData.source.equals(o)) continue;
                REGISTRY_MAP.get(clazz).remove(methodData);
            }
            EventManager.cleanMap(true);
        }
    }

    public static void cleanMap(boolean b) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> iterator = REGISTRY_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            if (b && !iterator.next().getValue().isEmpty()) continue;
            iterator.remove();
        }
    }

    public static void removeEnty(Class<? extends Event> clazz) {
        Iterator<Map.Entry<Class<? extends Event>, ArrayHelper<Data>>> iterator = REGISTRY_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getKey().equals(clazz)) continue;
            iterator.remove();
            break;
        }
    }

    private static void sortListValue(Class<? extends Event> clazz) {
        ArrayHelper<Data> flexibleArray = new ArrayHelper<Data>();
        byte[] arrby = Priority.VALUE_ARRAY;
        int n = arrby.length;
        int n2 = 0;
        while (n2 < n) {
            byte b = arrby[n2];
            for (Data methodData : REGISTRY_MAP.get(clazz)) {
                if (methodData.priority != b) continue;
                flexibleArray.add(methodData);
            }
            ++n2;
        }
        REGISTRY_MAP.put(clazz, flexibleArray);
    }

    private static boolean isMethodBad(Method method) {
        if (method.getParameterTypes().length == 1 && method.isAnnotationPresent(EventTarget.class)) {
            return false;
        }
        return true;
    }

    private static boolean isMethodBad(Method method, Class<? extends Event> clazz) {
        if (!EventManager.isMethodBad(method) && !method.getParameterTypes()[0].equals(clazz)) {
            return false;
        }
        return true;
    }

    public static ArrayHelper<Data> get(Class<? extends Event> clazz) {
        return REGISTRY_MAP.get(clazz);
    }

    public static void shutdown() {
        REGISTRY_MAP.clear();
    }

}

