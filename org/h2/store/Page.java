/*     */ package org.h2.store;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.util.CacheObject;
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
/*     */ public abstract class Page
/*     */   extends CacheObject
/*     */ {
/*     */   public static final int FLAG_LAST = 16;
/*     */   public static final int TYPE_EMPTY = 0;
/*     */   public static final int TYPE_DATA_LEAF = 1;
/*     */   public static final int TYPE_DATA_NODE = 2;
/*     */   public static final int TYPE_DATA_OVERFLOW = 3;
/*     */   public static final int TYPE_BTREE_LEAF = 4;
/*     */   public static final int TYPE_BTREE_NODE = 5;
/*     */   public static final int TYPE_FREE_LIST = 6;
/*     */   public static final int TYPE_STREAM_TRUNK = 7;
/*     */   public static final int TYPE_STREAM_DATA = 8;
/*     */   private static final int COPY_THRESHOLD = 4;
/*     */   protected long changeCount;
/*     */   
/*     */   public abstract void moveTo(Session paramSession, int paramInt);
/*     */   
/*     */   public abstract void write();
/*     */   
/*     */   public static <T> T[] insert(T[] paramArrayOfT, int paramInt1, int paramInt2, T paramT) {
/*     */     Object[] arrayOfObject;
/* 104 */     if (paramArrayOfT.length > paramInt1) {
/* 105 */       T[] arrayOfT = paramArrayOfT;
/*     */     } else {
/*     */       
/* 108 */       arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt1 + 1 + 4);
/*     */       
/* 110 */       if (paramInt2 > 0) {
/* 111 */         System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramInt2);
/*     */       }
/*     */     } 
/* 114 */     if (paramInt1 - paramInt2 > 0) {
/* 115 */       System.arraycopy(paramArrayOfT, paramInt2, arrayOfObject, paramInt2 + 1, paramInt1 - paramInt2);
/*     */     }
/* 117 */     arrayOfObject[paramInt2] = paramT;
/* 118 */     return (T[])arrayOfObject;
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
/*     */   public static <T> T[] remove(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/*     */     Object[] arrayOfObject;
/* 133 */     if (paramArrayOfT.length - paramInt1 < 4) {
/* 134 */       T[] arrayOfT = paramArrayOfT;
/*     */     } else {
/*     */       
/* 137 */       arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt1 - 1);
/*     */       
/* 139 */       System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, Math.min(paramInt1 - 1, paramInt2));
/*     */     } 
/* 141 */     if (paramInt2 < paramInt1) {
/* 142 */       System.arraycopy(paramArrayOfT, paramInt2 + 1, arrayOfObject, paramInt2, paramInt1 - paramInt2 - 1);
/*     */     }
/* 144 */     return (T[])arrayOfObject;
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
/*     */   protected static long[] insert(long[] paramArrayOflong, int paramInt1, int paramInt2, long paramLong) {
/*     */     long[] arrayOfLong;
/* 158 */     if (paramArrayOflong != null && paramArrayOflong.length > paramInt1) {
/* 159 */       arrayOfLong = paramArrayOflong;
/*     */     } else {
/* 161 */       arrayOfLong = new long[paramInt1 + 1 + 4];
/* 162 */       if (paramInt2 > 0) {
/* 163 */         System.arraycopy(paramArrayOflong, 0, arrayOfLong, 0, paramInt2);
/*     */       }
/*     */     } 
/* 166 */     if (paramArrayOflong != null && paramInt1 - paramInt2 > 0) {
/* 167 */       System.arraycopy(paramArrayOflong, paramInt2, arrayOfLong, paramInt2 + 1, paramInt1 - paramInt2);
/*     */     }
/* 169 */     arrayOfLong[paramInt2] = paramLong;
/* 170 */     return arrayOfLong;
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
/*     */   protected static long[] remove(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/*     */     long[] arrayOfLong;
/* 183 */     if (paramArrayOflong.length - paramInt1 < 4) {
/* 184 */       arrayOfLong = paramArrayOflong;
/*     */     } else {
/* 186 */       arrayOfLong = new long[paramInt1 - 1];
/* 187 */       System.arraycopy(paramArrayOflong, 0, arrayOfLong, 0, paramInt2);
/*     */     } 
/* 189 */     System.arraycopy(paramArrayOflong, paramInt2 + 1, arrayOfLong, paramInt2, paramInt1 - paramInt2 - 1);
/* 190 */     return arrayOfLong;
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
/*     */   protected static int[] insert(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/*     */     int[] arrayOfInt;
/* 204 */     if (paramArrayOfint != null && paramArrayOfint.length > paramInt1) {
/* 205 */       arrayOfInt = paramArrayOfint;
/*     */     } else {
/* 207 */       arrayOfInt = new int[paramInt1 + 1 + 4];
/* 208 */       if (paramInt2 > 0 && paramArrayOfint != null) {
/* 209 */         System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, paramInt2);
/*     */       }
/*     */     } 
/* 212 */     if (paramArrayOfint != null && paramInt1 - paramInt2 > 0) {
/* 213 */       System.arraycopy(paramArrayOfint, paramInt2, arrayOfInt, paramInt2 + 1, paramInt1 - paramInt2);
/*     */     }
/* 215 */     arrayOfInt[paramInt2] = paramInt3;
/* 216 */     return arrayOfInt;
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
/*     */   protected static int[] remove(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/*     */     int[] arrayOfInt;
/* 229 */     if (paramArrayOfint.length - paramInt1 < 4) {
/* 230 */       arrayOfInt = paramArrayOfint;
/*     */     } else {
/* 232 */       arrayOfInt = new int[paramInt1 - 1];
/* 233 */       System.arraycopy(paramArrayOfint, 0, arrayOfInt, 0, Math.min(paramInt1 - 1, paramInt2));
/*     */     } 
/* 235 */     if (paramInt2 < paramInt1) {
/* 236 */       System.arraycopy(paramArrayOfint, paramInt2 + 1, arrayOfInt, paramInt2, paramInt1 - paramInt2 - 1);
/*     */     }
/* 238 */     return arrayOfInt;
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
/*     */   protected static void add(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
/* 250 */     for (int i = paramInt1; i < paramInt2; i++) {
/* 251 */       paramArrayOfint[i] = paramArrayOfint[i] + paramInt3;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMove() {
/* 261 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\Page.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */