/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import java.lang.reflect.Field;
/*     */ import java.security.AccessController;
/*     */ import java.security.PrivilegedActionException;
/*     */ import java.security.PrivilegedExceptionAction;
/*     */ import java.util.Random;
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
/*     */ @c
/*     */ abstract class t
/*     */   extends Number
/*     */ {
/*     */   static final class a
/*     */   {
/*     */     volatile long aw;
/*     */     volatile long ax;
/*     */     volatile long ay;
/*     */     volatile long az;
/*     */     volatile long aA;
/*     */     volatile long aB;
/*     */     volatile long aC;
/*     */     volatile long value;
/*     */     volatile long aD;
/*     */     volatile long aE;
/*     */     volatile long aF;
/*     */     volatile long aG;
/*     */     volatile long aH;
/*     */     volatile long aI;
/*     */     volatile long aJ;
/*     */     private static final Unsafe a;
/*     */     private static final long aK;
/*     */     
/*     */     a(long param1Long) {
/* 101 */       this.value = param1Long;
/*     */     }
/*     */     
/*     */     final boolean b(long param1Long1, long param1Long2) {
/* 105 */       return a.compareAndSwapLong(this, aK, param1Long1, param1Long2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/*     */       try {
/* 114 */         a = t.b();
/* 115 */         Class<a> clazz = a.class;
/* 116 */         aK = a.objectFieldOffset(clazz.getDeclaredField("value"));
/* 117 */       } catch (Exception exception) {
/* 118 */         throw new Error(exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   static final ThreadLocal<int[]> a = new ThreadLocal();
/*     */ 
/*     */   
/* 131 */   static final Random a = new Random();
/*     */ 
/*     */   
/* 134 */   static final int dQ = Runtime.getRuntime().availableProcessors();
/*     */ 
/*     */   
/*     */   volatile transient a[] a;
/*     */ 
/*     */   
/*     */   volatile transient long at;
/*     */ 
/*     */   
/*     */   volatile transient int dR;
/*     */   
/*     */   private static final Unsafe a;
/*     */   
/*     */   private static final long au;
/*     */   
/*     */   private static final long av;
/*     */ 
/*     */   
/*     */   final boolean a(long paramLong1, long paramLong2) {
/* 153 */     return a.compareAndSwapLong(this, au, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean cN() {
/* 158 */     return a.compareAndSwapInt(this, av, 0, 1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(long paramLong, int[] paramArrayOfint, boolean paramBoolean) {
/*     */     int i;
/* 182 */     if (paramArrayOfint == null)
/* 183 */     { a.set(paramArrayOfint = new int[1]);
/* 184 */       int j = a.nextInt();
/* 185 */       i = paramArrayOfint[0] = (j == 0) ? 1 : j; }
/* 186 */     else { i = paramArrayOfint[0]; }
/* 187 */      boolean bool = false;
/*     */     
/*     */     while (true) {
/*     */       Unsafe unsafe;
/*     */       
/*     */       int j;
/* 193 */       if ((unsafe = this.a) != null && (j = unsafe.length) > 0) {
/* 194 */         Unsafe unsafe1; if ((unsafe1 = unsafe[j - 1 & i]) == null)
/* 195 */         { if (this.dR == 0) {
/* 196 */             a a1 = new a(paramLong);
/* 197 */             if (this.dR == 0 && cN()) {
/* 198 */               boolean bool1 = false; try {
/*     */                 Unsafe unsafe2;
/*     */                 int k;
/*     */                 int m;
/* 202 */                 if ((unsafe2 = this.a) != null && (k = unsafe2.length) > 0 && unsafe2[m = k - 1 & i] == null) {
/* 203 */                   unsafe2[m] = (Unsafe)a1;
/* 204 */                   bool1 = true;
/*     */                 } 
/*     */               } finally {
/* 207 */                 this.dR = 0;
/*     */               } 
/* 209 */               if (bool1)
/*     */                 break;  continue;
/*     */             } 
/*     */           } 
/* 213 */           bool = false; }
/* 214 */         else if (!paramBoolean)
/* 215 */         { paramBoolean = true; }
/* 216 */         else { long l1; if (unsafe1.b(l1 = ((a)unsafe1).value, a(l1, paramLong)))
/* 217 */             break;  if (j >= dQ || this.a != unsafe) { bool = false; }
/* 218 */           else if (!bool) { bool = true; }
/* 219 */           else if (this.dR == 0 && cN())
/*     */           { try {
/* 221 */               if (this.a == unsafe) {
/* 222 */                 a[] arrayOfA = new a[j << 1];
/* 223 */                 for (byte b = 0; b < j; ) { arrayOfA[b] = (a)unsafe[b]; b++; }
/* 224 */                  this.a = (Unsafe)arrayOfA;
/*     */               } 
/*     */             } finally {
/* 227 */               this.dR = 0;
/*     */             } 
/* 229 */             bool = false; continue; }
/*     */            }
/*     */         
/* 232 */         i ^= i << 13;
/* 233 */         i ^= i >>> 17;
/* 234 */         i ^= i << 5;
/* 235 */         paramArrayOfint[0] = i; continue;
/* 236 */       }  if (this.dR == 0 && this.a == unsafe && cN())
/* 237 */       { boolean bool1 = false;
/*     */         try {
/* 239 */           if (this.a == unsafe) {
/* 240 */             a[] arrayOfA = new a[2];
/* 241 */             arrayOfA[i & 0x1] = new a(paramLong);
/* 242 */             this.a = (Unsafe)arrayOfA;
/* 243 */             bool1 = true;
/*     */           } 
/*     */         } finally {
/* 246 */           this.dR = 0;
/*     */         } 
/* 248 */         if (bool1)
/* 249 */           break;  continue; }  long l; if (a(l = this.at, a(l, paramLong)))
/*     */         break; 
/*     */     } 
/*     */   }
/*     */   
/*     */   final void M(long paramLong) {
/* 255 */     Unsafe unsafe = this.a;
/* 256 */     this.at = paramLong;
/* 257 */     if (unsafe != null) {
/* 258 */       int i = unsafe.length;
/* 259 */       for (byte b = 0; b < i; b++) {
/* 260 */         Unsafe unsafe1 = unsafe[b];
/* 261 */         if (unsafe1 != null) ((a)unsafe1).value = paramLong;
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/* 273 */       a = a();
/* 274 */       Class<t> clazz = t.class;
/* 275 */       au = a.objectFieldOffset(clazz.getDeclaredField("base"));
/* 276 */       av = a.objectFieldOffset(clazz.getDeclaredField("busy"));
/* 277 */     } catch (Exception exception) {
/* 278 */       throw new Error(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Unsafe a() {
/*     */     try {
/* 290 */       return Unsafe.getUnsafe();
/* 291 */     } catch (SecurityException securityException) {
/*     */       
/*     */       try {
/* 294 */         return AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>()
/*     */             {
/*     */               public Unsafe c() throws Exception
/*     */               {
/* 298 */                 Class<Unsafe> clazz = Unsafe.class;
/* 299 */                 for (Field field : clazz.getDeclaredFields()) {
/* 300 */                   field.setAccessible(true);
/* 301 */                   Object object = field.get((Object)null);
/* 302 */                   if (clazz.isInstance(object)) return clazz.cast(object); 
/*     */                 } 
/* 304 */                 throw new NoSuchFieldError("the Unsafe");
/*     */               }
/*     */             });
/* 307 */       } catch (PrivilegedActionException privilegedActionException) {
/* 308 */         throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract long a(long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */