/*      */ package com.sun.jna;
/*      */ 
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringWriter;
/*      */ import java.lang.reflect.Array;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.util.ArrayList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Pointer
/*      */ {
/*   51 */   public static final Pointer NULL = null;
/*      */   protected long peer;
/*      */   
/*      */   public static final Pointer createConstant(long paramLong) {
/*   55 */     return new Opaque(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final Pointer createConstant(int paramInt) {
/*   63 */     return new Opaque(paramInt & 0xFFFFFFFFFFFFFFFFL);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Pointer() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Pointer(long paramLong) {
/*   79 */     this.peer = paramLong;
/*      */   }
/*      */ 
/*      */   
/*      */   public Pointer share(long paramLong) {
/*   84 */     return share(paramLong, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Pointer share(long paramLong1, long paramLong2) {
/*   91 */     if (paramLong1 == 0L) {
/*   92 */       return this;
/*      */     }
/*   94 */     return new Pointer(this.peer + paramLong1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void clear(long paramLong) {
/*   99 */     setMemory(0L, paramLong, (byte)0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  104 */     if (paramObject == this) {
/*  105 */       return true;
/*      */     }
/*  107 */     if (paramObject == null) {
/*  108 */       return false;
/*      */     }
/*  110 */     return (paramObject instanceof Pointer && ((Pointer)paramObject).peer == this.peer);
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  115 */     return (int)((this.peer >>> 32L) + (this.peer & 0xFFFFFFFFFFFFFFFFL));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long indexOf(long paramLong, byte paramByte) {
/*  127 */     return Native.indexOf(this, this.peer, paramLong, paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  140 */     Native.read(this, this.peer, paramLong, paramArrayOfbyte, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  153 */     Native.read(this, this.peer, paramLong, paramArrayOfshort, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  166 */     Native.read(this, this.peer, paramLong, paramArrayOfchar, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  179 */     Native.read(this, this.peer, paramLong, paramArrayOfint, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, long[] paramArrayOflong, int paramInt1, int paramInt2) {
/*  192 */     Native.read(this, this.peer, paramLong, paramArrayOflong, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  205 */     Native.read(this, this.peer, paramLong, paramArrayOffloat, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/*  218 */     Native.read(this, this.peer, paramLong, paramArrayOfdouble, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void read(long paramLong, Pointer[] paramArrayOfPointer, int paramInt1, int paramInt2) {
/*  231 */     for (byte b = 0; b < paramInt2; b++) {
/*  232 */       Pointer pointer1 = getPointer(paramLong + (b * Native.POINTER_SIZE));
/*  233 */       Pointer pointer2 = paramArrayOfPointer[b + paramInt1];
/*      */       
/*  235 */       if (pointer2 == null || pointer1 == null || pointer1.peer != pointer2.peer) {
/*  236 */         paramArrayOfPointer[b + paramInt1] = pointer1;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  257 */     Native.write(this, this.peer, paramLong, paramArrayOfbyte, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, short[] paramArrayOfshort, int paramInt1, int paramInt2) {
/*  271 */     Native.write(this, this.peer, paramLong, paramArrayOfshort, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  285 */     Native.write(this, this.peer, paramLong, paramArrayOfchar, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*  299 */     Native.write(this, this.peer, paramLong, paramArrayOfint, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, long[] paramArrayOflong, int paramInt1, int paramInt2) {
/*  313 */     Native.write(this, this.peer, paramLong, paramArrayOflong, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, float[] paramArrayOffloat, int paramInt1, int paramInt2) {
/*  327 */     Native.write(this, this.peer, paramLong, paramArrayOffloat, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/*  341 */     Native.write(this, this.peer, paramLong, paramArrayOfdouble, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void write(long paramLong, Pointer[] paramArrayOfPointer, int paramInt1, int paramInt2) {
/*  352 */     for (byte b = 0; b < paramInt2; b++) {
/*  353 */       setPointer(paramLong + (b * Native.POINTER_SIZE), paramArrayOfPointer[paramInt1 + b]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Object getValue(long paramLong, Class<?> paramClass, Object paramObject) {
/*  363 */     Object object = null;
/*  364 */     if (Structure.class.isAssignableFrom(paramClass)) {
/*  365 */       Structure structure = (Structure)paramObject;
/*  366 */       if (Structure.ByReference.class.isAssignableFrom(paramClass)) {
/*  367 */         structure = Structure.updateStructureByReference(paramClass, structure, getPointer(paramLong));
/*      */       } else {
/*  369 */         structure.useMemory(this, (int)paramLong, true);
/*  370 */         structure.read();
/*      */       } 
/*  372 */       object = structure;
/*  373 */     } else if (paramClass == boolean.class || paramClass == Boolean.class) {
/*  374 */       Boolean bool = Function.valueOf((getInt(paramLong) != 0));
/*  375 */     } else if (paramClass == byte.class || paramClass == Byte.class) {
/*  376 */       Byte byte_ = Byte.valueOf(getByte(paramLong));
/*  377 */     } else if (paramClass == short.class || paramClass == Short.class) {
/*  378 */       Short short_ = Short.valueOf(getShort(paramLong));
/*  379 */     } else if (paramClass == char.class || paramClass == Character.class) {
/*  380 */       Character character = Character.valueOf(getChar(paramLong));
/*  381 */     } else if (paramClass == int.class || paramClass == Integer.class) {
/*  382 */       Integer integer = Integer.valueOf(getInt(paramLong));
/*  383 */     } else if (paramClass == long.class || paramClass == Long.class) {
/*  384 */       Long long_ = Long.valueOf(getLong(paramLong));
/*  385 */     } else if (paramClass == float.class || paramClass == Float.class) {
/*  386 */       Float float_ = Float.valueOf(getFloat(paramLong));
/*  387 */     } else if (paramClass == double.class || paramClass == Double.class) {
/*  388 */       Double double_ = Double.valueOf(getDouble(paramLong));
/*  389 */     } else if (Pointer.class.isAssignableFrom(paramClass)) {
/*  390 */       Pointer pointer = getPointer(paramLong);
/*  391 */       if (pointer != null) {
/*  392 */         Pointer pointer1 = (paramObject instanceof Pointer) ? (Pointer)paramObject : null;
/*      */         
/*  394 */         if (pointer1 == null || pointer.peer != pointer1.peer) {
/*  395 */           Pointer pointer2 = pointer;
/*      */         } else {
/*  397 */           Pointer pointer2 = pointer1;
/*      */         } 
/*      */       } 
/*  400 */     } else if (paramClass == String.class) {
/*  401 */       Pointer pointer = getPointer(paramLong);
/*  402 */       String str = (pointer != null) ? pointer.getString(0L) : null;
/*  403 */     } else if (paramClass == WString.class) {
/*  404 */       Pointer pointer = getPointer(paramLong);
/*  405 */       WString wString = (pointer != null) ? new WString(pointer.getWideString(0L)) : null;
/*  406 */     } else if (Callback.class.isAssignableFrom(paramClass)) {
/*      */ 
/*      */       
/*  409 */       Pointer pointer = getPointer(paramLong);
/*  410 */       if (pointer == null) {
/*  411 */         object = null;
/*      */       } else {
/*  413 */         Callback callback2 = (Callback)paramObject;
/*  414 */         Pointer pointer1 = CallbackReference.getFunctionPointer(callback2);
/*  415 */         if (!pointer.equals(pointer1)) {
/*  416 */           callback2 = CallbackReference.getCallback(paramClass, pointer);
/*      */         }
/*  418 */         Callback callback1 = callback2;
/*      */       } 
/*  420 */     } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(paramClass)) {
/*  421 */       Pointer pointer = getPointer(paramLong);
/*  422 */       if (pointer == null) {
/*  423 */         object = null;
/*      */       } else {
/*      */         
/*  426 */         Pointer pointer1 = (paramObject == null) ? null : Native.getDirectBufferPointer((Buffer)paramObject);
/*  427 */         if (pointer1 == null || !pointer1.equals(pointer)) {
/*  428 */           throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
/*      */         }
/*  430 */         Object object1 = paramObject;
/*      */       } 
/*  432 */     } else if (NativeMapped.class.isAssignableFrom(paramClass)) {
/*  433 */       NativeMapped nativeMapped = (NativeMapped)paramObject;
/*  434 */       if (nativeMapped != null) {
/*  435 */         Object object2 = getValue(paramLong, nativeMapped.nativeType(), null);
/*  436 */         Object object1 = nativeMapped.fromNative(object2, new FromNativeContext(paramClass));
/*  437 */         if (nativeMapped.equals(object1)) {
/*  438 */           object1 = nativeMapped;
/*      */         }
/*      */       } else {
/*  441 */         NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/*  442 */         Object object2 = getValue(paramLong, nativeMappedConverter.nativeType(), null);
/*  443 */         Object object1 = nativeMappedConverter.fromNative(object2, new FromNativeContext(paramClass));
/*      */       } 
/*  445 */     } else if (paramClass.isArray()) {
/*  446 */       object = paramObject;
/*  447 */       if (object == null) {
/*  448 */         throw new IllegalStateException("Need an initialized array");
/*      */       }
/*  450 */       readArray(paramLong, object, paramClass.getComponentType());
/*      */     } else {
/*  452 */       throw new IllegalArgumentException("Reading \"" + paramClass + "\" from memory is not supported");
/*      */     } 
/*  454 */     return object;
/*      */   }
/*      */ 
/*      */   
/*      */   private void readArray(long paramLong, Object paramObject, Class<?> paramClass) {
/*  459 */     int i = 0;
/*  460 */     i = Array.getLength(paramObject);
/*  461 */     Object object = paramObject;
/*      */     
/*  463 */     if (paramClass == byte.class) {
/*  464 */       read(paramLong, (byte[])object, 0, i);
/*      */     }
/*  466 */     else if (paramClass == short.class) {
/*  467 */       read(paramLong, (short[])object, 0, i);
/*      */     }
/*  469 */     else if (paramClass == char.class) {
/*  470 */       read(paramLong, (char[])object, 0, i);
/*      */     }
/*  472 */     else if (paramClass == int.class) {
/*  473 */       read(paramLong, (int[])object, 0, i);
/*      */     }
/*  475 */     else if (paramClass == long.class) {
/*  476 */       read(paramLong, (long[])object, 0, i);
/*      */     }
/*  478 */     else if (paramClass == float.class) {
/*  479 */       read(paramLong, (float[])object, 0, i);
/*      */     }
/*  481 */     else if (paramClass == double.class) {
/*  482 */       read(paramLong, (double[])object, 0, i);
/*      */     }
/*  484 */     else if (Pointer.class.isAssignableFrom(paramClass)) {
/*  485 */       read(paramLong, (Pointer[])object, 0, i);
/*      */     }
/*  487 */     else if (Structure.class.isAssignableFrom(paramClass)) {
/*  488 */       Structure[] arrayOfStructure = (Structure[])object;
/*  489 */       if (Structure.ByReference.class.isAssignableFrom(paramClass)) {
/*  490 */         Pointer[] arrayOfPointer = getPointerArray(paramLong, arrayOfStructure.length);
/*  491 */         for (byte b = 0; b < arrayOfStructure.length; b++) {
/*  492 */           arrayOfStructure[b] = Structure.updateStructureByReference(paramClass, arrayOfStructure[b], arrayOfPointer[b]);
/*      */         }
/*      */       } else {
/*      */         
/*  496 */         Structure structure = arrayOfStructure[0];
/*  497 */         if (structure == null) {
/*  498 */           structure = Structure.newInstance(paramClass, share(paramLong));
/*  499 */           structure.conditionalAutoRead();
/*  500 */           arrayOfStructure[0] = structure;
/*      */         } else {
/*      */           
/*  503 */           structure.useMemory(this, (int)paramLong, true);
/*  504 */           structure.read();
/*      */         } 
/*  506 */         Structure[] arrayOfStructure1 = structure.toArray(arrayOfStructure.length);
/*  507 */         for (byte b = 1; b < arrayOfStructure.length; b++) {
/*  508 */           if (arrayOfStructure[b] == null) {
/*      */             
/*  510 */             arrayOfStructure[b] = arrayOfStructure1[b];
/*      */           } else {
/*      */             
/*  513 */             arrayOfStructure[b].useMemory(this, (int)(paramLong + (b * arrayOfStructure[b].size())), true);
/*  514 */             arrayOfStructure[b].read();
/*      */           }
/*      */         
/*      */         } 
/*      */       } 
/*  519 */     } else if (NativeMapped.class.isAssignableFrom(paramClass)) {
/*  520 */       NativeMapped[] arrayOfNativeMapped = (NativeMapped[])object;
/*  521 */       NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/*  522 */       int j = Native.getNativeSize(object.getClass(), object) / arrayOfNativeMapped.length;
/*  523 */       for (byte b = 0; b < arrayOfNativeMapped.length; b++) {
/*  524 */         Object object1 = getValue(paramLong + (j * b), nativeMappedConverter.nativeType(), arrayOfNativeMapped[b]);
/*  525 */         arrayOfNativeMapped[b] = (NativeMapped)nativeMappedConverter.fromNative(object1, new FromNativeContext(paramClass));
/*      */       } 
/*      */     } else {
/*      */       
/*  529 */       throw new IllegalArgumentException("Reading array of " + paramClass + " from memory not supported");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte getByte(long paramLong) {
/*  544 */     return Native.getByte(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char getChar(long paramLong) {
/*  556 */     return Native.getChar(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getShort(long paramLong) {
/*  568 */     return Native.getShort(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInt(long paramLong) {
/*  580 */     return Native.getInt(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getLong(long paramLong) {
/*  592 */     return Native.getLong(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NativeLong getNativeLong(long paramLong) {
/*  604 */     return new NativeLong((NativeLong.SIZE == 8) ? getLong(paramLong) : getInt(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getFloat(long paramLong) {
/*  616 */     return Native.getFloat(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDouble(long paramLong) {
/*  628 */     return Native.getDouble(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Pointer getPointer(long paramLong) {
/*  642 */     return Native.getPointer(this.peer + paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer getByteBuffer(long paramLong1, long paramLong2) {
/*  654 */     return Native.getDirectByteBuffer(this, this.peer, paramLong1, paramLong2).order(ByteOrder.nativeOrder());
/*      */   }
/*      */ 
/*      */   
/*      */   public String getWideString(long paramLong) {
/*  659 */     return Native.getWideString(this, this.peer, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(long paramLong) {
/*  670 */     return getString(paramLong, Native.getDefaultStringEncoding());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getString(long paramLong, String paramString) {
/*  681 */     return Native.getString(this, paramLong, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] getByteArray(long paramLong, int paramInt) {
/*  688 */     byte[] arrayOfByte = new byte[paramInt];
/*  689 */     read(paramLong, arrayOfByte, 0, paramInt);
/*  690 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char[] getCharArray(long paramLong, int paramInt) {
/*  697 */     char[] arrayOfChar = new char[paramInt];
/*  698 */     read(paramLong, arrayOfChar, 0, paramInt);
/*  699 */     return arrayOfChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short[] getShortArray(long paramLong, int paramInt) {
/*  706 */     short[] arrayOfShort = new short[paramInt];
/*  707 */     read(paramLong, arrayOfShort, 0, paramInt);
/*  708 */     return arrayOfShort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getIntArray(long paramLong, int paramInt) {
/*  715 */     int[] arrayOfInt = new int[paramInt];
/*  716 */     read(paramLong, arrayOfInt, 0, paramInt);
/*  717 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long[] getLongArray(long paramLong, int paramInt) {
/*  724 */     long[] arrayOfLong = new long[paramInt];
/*  725 */     read(paramLong, arrayOfLong, 0, paramInt);
/*  726 */     return arrayOfLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float[] getFloatArray(long paramLong, int paramInt) {
/*  733 */     float[] arrayOfFloat = new float[paramInt];
/*  734 */     read(paramLong, arrayOfFloat, 0, paramInt);
/*  735 */     return arrayOfFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double[] getDoubleArray(long paramLong, int paramInt) {
/*  742 */     double[] arrayOfDouble = new double[paramInt];
/*  743 */     read(paramLong, arrayOfDouble, 0, paramInt);
/*  744 */     return arrayOfDouble;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Pointer[] getPointerArray(long paramLong) {
/*  751 */     ArrayList<Pointer> arrayList = new ArrayList();
/*  752 */     int i = 0;
/*  753 */     Pointer pointer = getPointer(paramLong);
/*  754 */     while (pointer != null) {
/*  755 */       arrayList.add(pointer);
/*  756 */       i += Native.POINTER_SIZE;
/*  757 */       pointer = getPointer(paramLong + i);
/*      */     } 
/*  759 */     return arrayList.<Pointer>toArray(new Pointer[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public Pointer[] getPointerArray(long paramLong, int paramInt) {
/*  764 */     Pointer[] arrayOfPointer = new Pointer[paramInt];
/*  765 */     read(paramLong, arrayOfPointer, 0, paramInt);
/*  766 */     return arrayOfPointer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getStringArray(long paramLong) {
/*  777 */     return getStringArray(paramLong, -1, Native.getDefaultStringEncoding());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getStringArray(long paramLong, String paramString) {
/*  785 */     return getStringArray(paramLong, -1, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getStringArray(long paramLong, int paramInt) {
/*  795 */     return getStringArray(paramLong, paramInt, Native.getDefaultStringEncoding());
/*      */   }
/*      */   
/*      */   public String[] getWideStringArray(long paramLong) {
/*  799 */     return getWideStringArray(paramLong, -1);
/*      */   }
/*      */   
/*      */   public String[] getWideStringArray(long paramLong, int paramInt) {
/*  803 */     return getStringArray(paramLong, paramInt, "--WIDE-STRING--");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] getStringArray(long paramLong, int paramInt, String paramString) {
/*  814 */     ArrayList<String> arrayList = new ArrayList();
/*      */     
/*  816 */     int i = 0;
/*  817 */     if (paramInt != -1) {
/*  818 */       Pointer pointer = getPointer(paramLong + i);
/*  819 */       byte b = 0;
/*  820 */       while (b++ < paramInt) {
/*      */ 
/*      */ 
/*      */         
/*  824 */         String str = (pointer == null) ? null : ("--WIDE-STRING--".equals(paramString) ? pointer.getWideString(0L) : pointer.getString(0L, paramString));
/*  825 */         arrayList.add(str);
/*  826 */         if (b < paramInt) {
/*  827 */           i += Native.POINTER_SIZE;
/*  828 */           pointer = getPointer(paramLong + i);
/*      */         } 
/*      */       } 
/*      */     } else {
/*  832 */       Pointer pointer; while ((pointer = getPointer(paramLong + i)) != null) {
/*      */ 
/*      */         
/*  835 */         String str = "--WIDE-STRING--".equals(paramString) ? pointer.getWideString(0L) : pointer.getString(0L, paramString);
/*  836 */         arrayList.add(str);
/*  837 */         i += Native.POINTER_SIZE;
/*      */       } 
/*      */     } 
/*  840 */     return arrayList.<String>toArray(new String[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setValue(long paramLong, Object paramObject, Class<?> paramClass) {
/*  850 */     if (paramClass == boolean.class || paramClass == Boolean.class) {
/*  851 */       setInt(paramLong, Boolean.TRUE.equals(paramObject) ? -1 : 0);
/*  852 */     } else if (paramClass == byte.class || paramClass == Byte.class) {
/*  853 */       setByte(paramLong, (paramObject == null) ? 0 : ((Byte)paramObject).byteValue());
/*  854 */     } else if (paramClass == short.class || paramClass == Short.class) {
/*  855 */       setShort(paramLong, (paramObject == null) ? 0 : ((Short)paramObject).shortValue());
/*  856 */     } else if (paramClass == char.class || paramClass == Character.class) {
/*  857 */       setChar(paramLong, (paramObject == null) ? Character.MIN_VALUE : ((Character)paramObject).charValue());
/*  858 */     } else if (paramClass == int.class || paramClass == Integer.class) {
/*  859 */       setInt(paramLong, (paramObject == null) ? 0 : ((Integer)paramObject).intValue());
/*  860 */     } else if (paramClass == long.class || paramClass == Long.class) {
/*  861 */       setLong(paramLong, (paramObject == null) ? 0L : ((Long)paramObject).longValue());
/*  862 */     } else if (paramClass == float.class || paramClass == Float.class) {
/*  863 */       setFloat(paramLong, (paramObject == null) ? 0.0F : ((Float)paramObject).floatValue());
/*  864 */     } else if (paramClass == double.class || paramClass == Double.class) {
/*  865 */       setDouble(paramLong, (paramObject == null) ? 0.0D : ((Double)paramObject).doubleValue());
/*  866 */     } else if (paramClass == Pointer.class) {
/*  867 */       setPointer(paramLong, (Pointer)paramObject);
/*  868 */     } else if (paramClass == String.class) {
/*  869 */       setPointer(paramLong, (Pointer)paramObject);
/*  870 */     } else if (paramClass == WString.class) {
/*  871 */       setPointer(paramLong, (Pointer)paramObject);
/*  872 */     } else if (Structure.class.isAssignableFrom(paramClass)) {
/*  873 */       Structure structure = (Structure)paramObject;
/*  874 */       if (Structure.ByReference.class.isAssignableFrom(paramClass)) {
/*  875 */         setPointer(paramLong, (structure == null) ? null : structure.getPointer());
/*  876 */         if (structure != null) {
/*  877 */           structure.autoWrite();
/*      */         }
/*      */       } else {
/*      */         
/*  881 */         structure.useMemory(this, (int)paramLong, true);
/*  882 */         structure.write();
/*      */       } 
/*  884 */     } else if (Callback.class.isAssignableFrom(paramClass)) {
/*  885 */       setPointer(paramLong, CallbackReference.getFunctionPointer((Callback)paramObject));
/*  886 */     } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(paramClass)) {
/*      */       
/*  888 */       Pointer pointer = (paramObject == null) ? null : Native.getDirectBufferPointer((Buffer)paramObject);
/*  889 */       setPointer(paramLong, pointer);
/*  890 */     } else if (NativeMapped.class.isAssignableFrom(paramClass)) {
/*  891 */       NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/*  892 */       Class<?> clazz = nativeMappedConverter.nativeType();
/*  893 */       setValue(paramLong, nativeMappedConverter.toNative(paramObject, new ToNativeContext()), clazz);
/*  894 */     } else if (paramClass.isArray()) {
/*  895 */       writeArray(paramLong, paramObject, paramClass.getComponentType());
/*      */     } else {
/*  897 */       throw new IllegalArgumentException("Writing " + paramClass + " to memory is not supported");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void writeArray(long paramLong, Object paramObject, Class<?> paramClass) {
/*  903 */     if (paramClass == byte.class) {
/*  904 */       byte[] arrayOfByte = (byte[])paramObject;
/*  905 */       write(paramLong, arrayOfByte, 0, arrayOfByte.length);
/*  906 */     } else if (paramClass == short.class) {
/*  907 */       short[] arrayOfShort = (short[])paramObject;
/*  908 */       write(paramLong, arrayOfShort, 0, arrayOfShort.length);
/*  909 */     } else if (paramClass == char.class) {
/*  910 */       char[] arrayOfChar = (char[])paramObject;
/*  911 */       write(paramLong, arrayOfChar, 0, arrayOfChar.length);
/*  912 */     } else if (paramClass == int.class) {
/*  913 */       int[] arrayOfInt = (int[])paramObject;
/*  914 */       write(paramLong, arrayOfInt, 0, arrayOfInt.length);
/*  915 */     } else if (paramClass == long.class) {
/*  916 */       long[] arrayOfLong = (long[])paramObject;
/*  917 */       write(paramLong, arrayOfLong, 0, arrayOfLong.length);
/*  918 */     } else if (paramClass == float.class) {
/*  919 */       float[] arrayOfFloat = (float[])paramObject;
/*  920 */       write(paramLong, arrayOfFloat, 0, arrayOfFloat.length);
/*  921 */     } else if (paramClass == double.class) {
/*  922 */       double[] arrayOfDouble = (double[])paramObject;
/*  923 */       write(paramLong, arrayOfDouble, 0, arrayOfDouble.length);
/*  924 */     } else if (Pointer.class.isAssignableFrom(paramClass)) {
/*  925 */       Pointer[] arrayOfPointer = (Pointer[])paramObject;
/*  926 */       write(paramLong, arrayOfPointer, 0, arrayOfPointer.length);
/*  927 */     } else if (Structure.class.isAssignableFrom(paramClass)) {
/*  928 */       Structure[] arrayOfStructure = (Structure[])paramObject;
/*  929 */       if (Structure.ByReference.class.isAssignableFrom(paramClass)) {
/*  930 */         Pointer[] arrayOfPointer = new Pointer[arrayOfStructure.length];
/*  931 */         for (byte b = 0; b < arrayOfStructure.length; b++) {
/*  932 */           if (arrayOfStructure[b] == null) {
/*  933 */             arrayOfPointer[b] = null;
/*      */           } else {
/*  935 */             arrayOfPointer[b] = arrayOfStructure[b].getPointer();
/*  936 */             arrayOfStructure[b].write();
/*      */           } 
/*      */         } 
/*  939 */         write(paramLong, arrayOfPointer, 0, arrayOfPointer.length);
/*      */       } else {
/*  941 */         Structure structure = arrayOfStructure[0];
/*  942 */         if (structure == null) {
/*  943 */           structure = Structure.newInstance(paramClass, share(paramLong));
/*  944 */           arrayOfStructure[0] = structure;
/*      */         } else {
/*  946 */           structure.useMemory(this, (int)paramLong, true);
/*      */         } 
/*  948 */         structure.write();
/*  949 */         Structure[] arrayOfStructure1 = structure.toArray(arrayOfStructure.length);
/*  950 */         for (byte b = 1; b < arrayOfStructure.length; b++) {
/*  951 */           if (arrayOfStructure[b] == null) {
/*  952 */             arrayOfStructure[b] = arrayOfStructure1[b];
/*      */           } else {
/*  954 */             arrayOfStructure[b].useMemory(this, (int)(paramLong + (b * arrayOfStructure[b].size())), true);
/*      */           } 
/*  956 */           arrayOfStructure[b].write();
/*      */         } 
/*      */       } 
/*  959 */     } else if (NativeMapped.class.isAssignableFrom(paramClass)) {
/*  960 */       NativeMapped[] arrayOfNativeMapped = (NativeMapped[])paramObject;
/*  961 */       NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(paramClass);
/*  962 */       Class<?> clazz = nativeMappedConverter.nativeType();
/*  963 */       int i = Native.getNativeSize(paramObject.getClass(), paramObject) / arrayOfNativeMapped.length;
/*  964 */       for (byte b = 0; b < arrayOfNativeMapped.length; b++) {
/*  965 */         Object object = nativeMappedConverter.toNative(arrayOfNativeMapped[b], new ToNativeContext());
/*  966 */         setValue(paramLong + (b * i), object, clazz);
/*      */       } 
/*      */     } else {
/*  969 */       throw new IllegalArgumentException("Writing array of " + paramClass + " to memory not supported");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMemory(long paramLong1, long paramLong2, byte paramByte) {
/*  980 */     Native.setMemory(this, this.peer, paramLong1, paramLong2, paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setByte(long paramLong, byte paramByte) {
/*  993 */     Native.setByte(this, this.peer, paramLong, paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setShort(long paramLong, short paramShort) {
/* 1006 */     Native.setShort(this, this.peer, paramLong, paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChar(long paramLong, char paramChar) {
/* 1019 */     Native.setChar(this, this.peer, paramLong, paramChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInt(long paramLong, int paramInt) {
/* 1032 */     Native.setInt(this, this.peer, paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLong(long paramLong1, long paramLong2) {
/* 1045 */     Native.setLong(this, this.peer, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNativeLong(long paramLong, NativeLong paramNativeLong) {
/* 1058 */     if (NativeLong.SIZE == 8) {
/* 1059 */       setLong(paramLong, paramNativeLong.longValue());
/*      */     } else {
/* 1061 */       setInt(paramLong, paramNativeLong.intValue());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFloat(long paramLong, float paramFloat) {
/* 1075 */     Native.setFloat(this, this.peer, paramLong, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDouble(long paramLong, double paramDouble) {
/* 1088 */     Native.setDouble(this, this.peer, paramLong, paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPointer(long paramLong, Pointer paramPointer) {
/* 1103 */     Native.setPointer(this, this.peer, paramLong, (paramPointer != null) ? paramPointer.peer : 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWideString(long paramLong, String paramString) {
/* 1115 */     Native.setWideString(this, this.peer, paramLong, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setString(long paramLong, WString paramWString) {
/* 1127 */     setWideString(paramLong, (paramWString == null) ? null : paramWString.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setString(long paramLong, String paramString) {
/* 1140 */     setString(paramLong, paramString, Native.getDefaultStringEncoding());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setString(long paramLong, String paramString1, String paramString2) {
/* 1153 */     byte[] arrayOfByte = Native.getBytes(paramString1, paramString2);
/* 1154 */     write(paramLong, arrayOfByte, 0, arrayOfByte.length);
/* 1155 */     setByte(paramLong + arrayOfByte.length, (byte)0);
/*      */   }
/*      */ 
/*      */   
/*      */   public String dump(long paramLong, int paramInt) {
/* 1160 */     byte b1 = 4;
/* 1161 */     String str = "memory dump";
/*      */     
/* 1163 */     StringWriter stringWriter = new StringWriter("memory dump".length() + 2 + paramInt * 2 + paramInt / 4 * 4);
/* 1164 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/* 1165 */     printWriter.println("memory dump");
/*      */     
/* 1167 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/*      */       
/* 1169 */       byte b = getByte(paramLong + b2);
/* 1170 */       if (b2 % 4 == 0) printWriter.print("["); 
/* 1171 */       if (b >= 0 && b < 16)
/* 1172 */         printWriter.print("0"); 
/* 1173 */       printWriter.print(Integer.toHexString(b & 0xFF));
/* 1174 */       if (b2 % 4 == 3 && b2 < paramInt - 1)
/* 1175 */         printWriter.println("]"); 
/*      */     } 
/* 1177 */     if (stringWriter.getBuffer().charAt(stringWriter.getBuffer().length() - 2) != ']') {
/* 1178 */       printWriter.println("]");
/*      */     }
/* 1180 */     return stringWriter.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1185 */     return "native@0x" + Long.toHexString(this.peer);
/*      */   }
/*      */ 
/*      */   
/*      */   public static long nativeValue(Pointer paramPointer) {
/* 1190 */     return (paramPointer == null) ? 0L : paramPointer.peer;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void nativeValue(Pointer paramPointer, long paramLong) {
/* 1195 */     paramPointer.peer = paramLong;
/*      */   }
/*      */   
/*      */   private static class Opaque extends Pointer {
/*      */     private Opaque(long param1Long) {
/* 1200 */       super(param1Long);
/* 1201 */       this.MSG = "This pointer is opaque: " + this;
/*      */     } private final String MSG;
/*      */     public Pointer share(long param1Long1, long param1Long2) {
/* 1204 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void clear(long param1Long) {
/* 1208 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public long indexOf(long param1Long, byte param1Byte) {
/* 1212 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 1216 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 1220 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, short[] param1ArrayOfshort, int param1Int1, int param1Int2) {
/* 1224 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, int[] param1ArrayOfint, int param1Int1, int param1Int2) {
/* 1228 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, long[] param1ArrayOflong, int param1Int1, int param1Int2) {
/* 1232 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, float[] param1ArrayOffloat, int param1Int1, int param1Int2) {
/* 1236 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, double[] param1ArrayOfdouble, int param1Int1, int param1Int2) {
/* 1240 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void read(long param1Long, Pointer[] param1ArrayOfPointer, int param1Int1, int param1Int2) {
/* 1244 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 1248 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 1252 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, short[] param1ArrayOfshort, int param1Int1, int param1Int2) {
/* 1256 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, int[] param1ArrayOfint, int param1Int1, int param1Int2) {
/* 1260 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, long[] param1ArrayOflong, int param1Int1, int param1Int2) {
/* 1264 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, float[] param1ArrayOffloat, int param1Int1, int param1Int2) {
/* 1268 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, double[] param1ArrayOfdouble, int param1Int1, int param1Int2) {
/* 1272 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void write(long param1Long, Pointer[] param1ArrayOfPointer, int param1Int1, int param1Int2) {
/* 1276 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public ByteBuffer getByteBuffer(long param1Long1, long param1Long2) {
/* 1280 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public byte getByte(long param1Long) {
/* 1284 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public char getChar(long param1Long) {
/* 1288 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public short getShort(long param1Long) {
/* 1292 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public int getInt(long param1Long) {
/* 1296 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public long getLong(long param1Long) {
/* 1300 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public float getFloat(long param1Long) {
/* 1304 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public double getDouble(long param1Long) {
/* 1308 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public Pointer getPointer(long param1Long) {
/* 1312 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public String getString(long param1Long, String param1String) {
/* 1316 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public String getWideString(long param1Long) {
/* 1320 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setByte(long param1Long, byte param1Byte) {
/* 1324 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setChar(long param1Long, char param1Char) {
/* 1328 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setShort(long param1Long, short param1Short) {
/* 1332 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setInt(long param1Long, int param1Int) {
/* 1336 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setLong(long param1Long1, long param1Long2) {
/* 1340 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setFloat(long param1Long, float param1Float) {
/* 1344 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setDouble(long param1Long, double param1Double) {
/* 1348 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setPointer(long param1Long, Pointer param1Pointer) {
/* 1352 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setString(long param1Long, String param1String1, String param1String2) {
/* 1356 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setWideString(long param1Long, String param1String) {
/* 1360 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public void setMemory(long param1Long1, long param1Long2, byte param1Byte) {
/* 1364 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public String dump(long param1Long, int param1Int) {
/* 1368 */       throw new UnsupportedOperationException(this.MSG);
/*      */     }
/*      */     
/*      */     public String toString() {
/* 1372 */       return "const@0x" + Long.toHexString(this.peer);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Pointer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */