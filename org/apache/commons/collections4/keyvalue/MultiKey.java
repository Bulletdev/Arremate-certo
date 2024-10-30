/*     */ package org.apache.commons.collections4.keyvalue;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
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
/*     */ public class MultiKey<K>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 4465448607415788805L;
/*     */   private final K[] keys;
/*     */   private transient int hashCode;
/*     */   
/*     */   public MultiKey(K paramK1, K paramK2) {
/*  67 */     this((K[])new Object[] { paramK1, paramK2 }, false);
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
/*     */   public MultiKey(K paramK1, K paramK2, K paramK3) {
/*  82 */     this((K[])new Object[] { paramK1, paramK2, paramK3 }, false);
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
/*     */   public MultiKey(K paramK1, K paramK2, K paramK3, K paramK4) {
/*  98 */     this((K[])new Object[] { paramK1, paramK2, paramK3, paramK4 }, false);
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
/*     */   public MultiKey(K paramK1, K paramK2, K paramK3, K paramK4, K paramK5) {
/* 115 */     this((K[])new Object[] { paramK1, paramK2, paramK3, paramK4, paramK5 }, false);
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
/*     */   public MultiKey(K[] paramArrayOfK) {
/* 130 */     this(paramArrayOfK, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultiKey(K[] paramArrayOfK, boolean paramBoolean) {
/* 159 */     if (paramArrayOfK == null) {
/* 160 */       throw new IllegalArgumentException("The array of keys must not be null");
/*     */     }
/* 162 */     if (paramBoolean) {
/* 163 */       this.keys = (K[])paramArrayOfK.clone();
/*     */     } else {
/* 165 */       this.keys = paramArrayOfK;
/*     */     } 
/*     */     
/* 168 */     calculateHashCode((Object[])paramArrayOfK);
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
/*     */   public K[] getKeys() {
/* 181 */     return (K[])this.keys.clone();
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
/*     */   public K getKey(int paramInt) {
/* 196 */     return this.keys[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 206 */     return this.keys.length;
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
/*     */   public boolean equals(Object paramObject) {
/* 221 */     if (paramObject == this) {
/* 222 */       return true;
/*     */     }
/* 224 */     if (paramObject instanceof MultiKey) {
/* 225 */       MultiKey multiKey = (MultiKey)paramObject;
/* 226 */       return Arrays.equals((Object[])this.keys, (Object[])multiKey.keys);
/*     */     } 
/* 228 */     return false;
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
/*     */   public int hashCode() {
/* 243 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 253 */     return "MultiKey" + Arrays.toString((Object[])this.keys);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void calculateHashCode(Object[] paramArrayOfObject) {
/* 262 */     int i = 0;
/* 263 */     for (Object object : paramArrayOfObject) {
/* 264 */       if (object != null) {
/* 265 */         i ^= object.hashCode();
/*     */       }
/*     */     } 
/* 268 */     this.hashCode = i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 278 */     calculateHashCode((Object[])this.keys);
/* 279 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\MultiKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */