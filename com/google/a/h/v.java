/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.m.m;
/*     */ import java.lang.reflect.Field;
/*     */ import java.nio.ByteOrder;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedActionException;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import sun.misc.Unsafe;
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
/*     */ final class v
/*     */ {
/*     */   private static final b a;
/*     */   
/*     */   static long a(byte[] paramArrayOfbyte, int paramInt) {
/*  42 */     assert paramArrayOfbyte.length >= paramInt + 8;
/*     */     
/*  44 */     return a.b(paramArrayOfbyte, paramInt);
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
/*     */   static long f(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  58 */     long l = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     int i = Math.min(paramInt2, 8);
/*  64 */     for (byte b1 = 0; b1 < i; b1++)
/*     */     {
/*  66 */       l |= (paramArrayOfbyte[paramInt1 + b1] & 0xFFL) << b1 * 8;
/*     */     }
/*  68 */     return l;
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
/*     */   static void a(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
/*  80 */     assert paramInt >= 0 && paramInt + 8 <= paramArrayOfbyte.length;
/*     */     
/*  82 */     a.b(paramArrayOfbyte, paramInt, paramLong);
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
/*     */   static int a(byte[] paramArrayOfbyte, int paramInt) {
/*  94 */     return paramArrayOfbyte[paramInt] & 0xFF | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24;
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
/*     */   static boolean dc() {
/* 106 */     return a instanceof c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static interface b
/*     */   {
/*     */     long b(byte[] param1ArrayOfbyte, int param1Int);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void b(byte[] param1ArrayOfbyte, int param1Int, long param1Long);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum c
/*     */     implements b
/*     */   {
/* 128 */     a
/*     */     {
/*     */       public long b(byte[] param2ArrayOfbyte, int param2Int) {
/* 131 */         return d().getLong(param2ArrayOfbyte, param2Int + aw());
/*     */       }
/*     */ 
/*     */       
/*     */       public void b(byte[] param2ArrayOfbyte, int param2Int, long param2Long) {
/* 136 */         d().putLong(param2ArrayOfbyte, param2Int + aw(), param2Long);
/*     */       }
/*     */     },
/* 139 */     b
/*     */     {
/*     */       public long b(byte[] param2ArrayOfbyte, int param2Int) {
/* 142 */         long l = d().getLong(param2ArrayOfbyte, param2Int + aw());
/*     */         
/* 144 */         return Long.reverseBytes(l);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void b(byte[] param2ArrayOfbyte, int param2Int, long param2Long) {
/* 150 */         long l = Long.reverseBytes(param2Long);
/* 151 */         d().putLong(param2ArrayOfbyte, param2Int + aw(), l);
/*     */       }
/*     */     };
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
/*     */ 
/*     */     
/* 195 */     private static final Unsafe b = a();
/* 196 */     private static final int fz = b.arrayBaseOffset(byte[].class); private static Unsafe a() { try { return Unsafe.getUnsafe(); } catch (SecurityException securityException) { try { return AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
/*     */                 public Unsafe c() throws Exception { Class<Unsafe> clazz = Unsafe.class; for (Field field : clazz.getDeclaredFields()) { field.setAccessible(true); Object object = field.get((Object)null); if (clazz.isInstance(object))
/*     */                       return clazz.cast(object);  }  throw new NoSuchFieldError("the Unsafe"); }
/* 199 */               }); } catch (PrivilegedActionException privilegedActionException) { throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause()); }  }  } static { if (b.arrayIndexScale(byte[].class) != 1)
/* 200 */         throw new AssertionError();  }
/*     */   
/*     */   }
/*     */   
/*     */   private enum a
/*     */     implements b
/*     */   {
/* 207 */     a
/*     */     {
/*     */       public long b(byte[] param2ArrayOfbyte, int param2Int) {
/* 210 */         return m.a(param2ArrayOfbyte[param2Int + 7], param2ArrayOfbyte[param2Int + 6], param2ArrayOfbyte[param2Int + 5], param2ArrayOfbyte[param2Int + 4], param2ArrayOfbyte[param2Int + 3], param2ArrayOfbyte[param2Int + 2], param2ArrayOfbyte[param2Int + 1], param2ArrayOfbyte[param2Int]);
/*     */       }
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
/*     */       public void b(byte[] param2ArrayOfbyte, int param2Int, long param2Long) {
/* 223 */         long l = 255L;
/* 224 */         for (byte b = 0; b < 8; l <<= 8L, b++) {
/* 225 */           param2ArrayOfbyte[param2Int + b] = (byte)(int)((param2Long & l) >> b * 8);
/*     */         }
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   static {
/* 232 */     a[] arrayOfA = a.a;
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
/*     */     try {
/* 245 */       String str = System.getProperty("os.arch");
/* 246 */       if ("amd64".equals(str))
/*     */       {
/*     */ 
/*     */         
/* 250 */         arrayOfA = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? (a[])c.a : (a[])c.b;
/*     */       }
/* 252 */     } catch (Throwable throwable) {}
/*     */ 
/*     */     
/* 255 */     a = (b)arrayOfA;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */