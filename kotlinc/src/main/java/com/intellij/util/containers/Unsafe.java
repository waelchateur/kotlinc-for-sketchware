// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the
// Apache 2.0 license.
package com.intellij.util.containers;

import com.intellij.util.ReflectionUtil;
import java.lang.reflect.Field;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
public final class Unsafe {
  private static final sun.misc.Unsafe theUnsafe;

  static {
    try {
      theUnsafe = getUnsafe();
    } catch (Throwable t) {
      throw new Error(t);
    }
  }

  public static boolean compareAndSwapInt(Object object, long offset, int expected, int value) {
    try {
      return theUnsafe.compareAndSwapInt(object, offset, expected, value);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static boolean compareAndSwapLong(
      @NotNull Object object, long offset, long expected, long value) {
    try {
      return theUnsafe.compareAndSwapLong(object, offset, expected, value);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static int getAndAddInt(Object object, long offset, int v) {
    try {
      return theUnsafe.getAndAddInt(object, offset, v);
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }
  }

  public static Object getObjectVolatile(Object object, long offset) {
    try {
      return theUnsafe.getObjectVolatile(object, offset);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
    try {
      return theUnsafe.compareAndSwapObject(o, offset, expected, x);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static void putObjectVolatile(Object o, long offset, Object x) {
    try {
      theUnsafe.putObjectVolatile(o, offset, x);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static void putOrderedLong(Object o, long offset, long x) {
    try {
      theUnsafe.putOrderedLong(o, offset, x);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static long objectFieldOffset(Field f) {
    try {
      return theUnsafe.objectFieldOffset(f);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static long getLong(Object o, long offset) {
    try {
      return theUnsafe.getLong(o, offset);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static int arrayIndexScale(Class<?> arrayClass) {
    try {
      return theUnsafe.arrayIndexScale(arrayClass);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static int arrayBaseOffset(Class<?> arrayClass) {
    try {
      return theUnsafe.arrayBaseOffset(arrayClass);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static void putObject(Object o, long offset, Object x) {
    try {
      theUnsafe.putObject(o, offset, x);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static Object getObject(Object o, long offset) {
    try {
      return theUnsafe.getObject(o, offset);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static void putOrderedObject(Object o, long offset, Object x) {
    try {
      theUnsafe.putOrderedObject(o, offset, x);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static void copyMemory(
      Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
    try {
      theUnsafe.copyMemory(srcBase, srcOffset, destBase, destOffset, bytes);
    } catch (Throwable throwable) {
      throw new RuntimeException(throwable);
    }
  }

  public static sun.misc.Unsafe getUnsafe() {
    Object unsafeObj = ReflectionUtil.getUnsafe();
    if (unsafeObj == null) {
      throw new RuntimeException("Unsafe unavailable");
    }

    return (sun.misc.Unsafe) unsafeObj;
  }
}
