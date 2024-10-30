/*     */ package com.sun.jna;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IntegerType
/*     */   extends Number
/*     */   implements NativeMapped
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private int size;
/*     */   private Number number;
/*     */   private boolean unsigned;
/*     */   private long value;
/*     */   
/*     */   public IntegerType(int paramInt) {
/*  52 */     this(paramInt, 0L, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntegerType(int paramInt, boolean paramBoolean) {
/*  57 */     this(paramInt, 0L, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntegerType(int paramInt, long paramLong) {
/*  62 */     this(paramInt, paramLong, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntegerType(int paramInt, long paramLong, boolean paramBoolean) {
/*  67 */     this.size = paramInt;
/*  68 */     this.unsigned = paramBoolean;
/*  69 */     setValue(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(long paramLong) {
/*  76 */     long l = paramLong;
/*  77 */     this.value = paramLong;
/*  78 */     switch (this.size) {
/*     */       case 1:
/*  80 */         if (this.unsigned) {
/*  81 */           this.value = paramLong & 0xFFL;
/*     */         }
/*  83 */         l = (byte)(int)paramLong;
/*  84 */         this.number = Byte.valueOf((byte)(int)paramLong);
/*     */         break;
/*     */       case 2:
/*  87 */         if (this.unsigned) {
/*  88 */           this.value = paramLong & 0xFFFFL;
/*     */         }
/*  90 */         l = (short)(int)paramLong;
/*  91 */         this.number = Short.valueOf((short)(int)paramLong);
/*     */         break;
/*     */       case 4:
/*  94 */         if (this.unsigned) {
/*  95 */           this.value = paramLong & 0xFFFFFFFFL;
/*     */         }
/*  97 */         l = (int)paramLong;
/*  98 */         this.number = Integer.valueOf((int)paramLong);
/*     */         break;
/*     */       case 8:
/* 101 */         this.number = Long.valueOf(paramLong);
/*     */         break;
/*     */       default:
/* 104 */         throw new IllegalArgumentException("Unsupported size: " + this.size);
/*     */     } 
/* 106 */     if (this.size < 8) {
/* 107 */       long l1 = (1L << this.size * 8) - 1L ^ 0xFFFFFFFFFFFFFFFFL;
/* 108 */       if ((paramLong < 0L && l != paramLong) || (paramLong >= 0L && (l1 & paramLong) != 0L))
/*     */       {
/* 110 */         throw new IllegalArgumentException("Argument value 0x" + 
/* 111 */             Long.toHexString(paramLong) + " exceeds native capacity (" + this.size + " bytes) mask=0x" + 
/* 112 */             Long.toHexString(l1));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object toNative() {
/* 119 */     return this.number;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object fromNative(Object paramObject, FromNativeContext paramFromNativeContext) {
/* 126 */     long l = (paramObject == null) ? 0L : ((Number)paramObject).longValue();
/* 127 */     IntegerType integerType = (IntegerType)Klass.newInstance(getClass());
/* 128 */     integerType.setValue(l);
/* 129 */     return integerType;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> nativeType() {
/* 134 */     return this.number.getClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public int intValue() {
/* 139 */     return (int)this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 144 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 149 */     return this.number.floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 154 */     return this.number.doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 159 */     return (paramObject instanceof IntegerType && this.number
/* 160 */       .equals(((IntegerType)paramObject).number));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     return this.number.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 170 */     return this.number.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends IntegerType> int compare(T paramT1, T paramT2) {
/* 188 */     if (paramT1 == paramT2)
/* 189 */       return 0; 
/* 190 */     if (paramT1 == null)
/* 191 */       return 1; 
/* 192 */     if (paramT2 == null) {
/* 193 */       return -1;
/*     */     }
/* 195 */     return compare(paramT1.longValue(), paramT2.longValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int compare(IntegerType paramIntegerType, long paramLong) {
/* 211 */     if (paramIntegerType == null) {
/* 212 */       return 1;
/*     */     }
/* 214 */     return compare(paramIntegerType.longValue(), paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int compare(long paramLong1, long paramLong2) {
/* 220 */     if (paramLong1 == paramLong2)
/* 221 */       return 0; 
/* 222 */     if (paramLong1 < paramLong2) {
/* 223 */       return -1;
/*     */     }
/* 225 */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\IntegerType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */