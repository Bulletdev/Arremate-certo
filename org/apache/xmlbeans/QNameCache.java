/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class QNameCache
/*     */ {
/*     */   private static final float DEFAULT_LOAD = 0.7F;
/*     */   private final float loadFactor;
/*  27 */   private int numEntries = 0;
/*     */ 
/*     */   
/*     */   private int threshold;
/*     */   
/*     */   private int hashmask;
/*     */   
/*     */   private b[] table;
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */ 
/*     */   
/*     */   public QNameCache(int paramInt, float paramFloat) {
/*  40 */     assert paramInt > 0;
/*  41 */     assert paramFloat > 0.0F && paramFloat < 1.0F;
/*     */ 
/*     */     
/*  44 */     int i = 16;
/*  45 */     while (i < paramInt) {
/*  46 */       i <<= 1;
/*     */     }
/*  48 */     this.loadFactor = paramFloat;
/*  49 */     this.hashmask = i - 1;
/*  50 */     this.threshold = (int)(i * paramFloat);
/*  51 */     this.table = new b[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameCache(int paramInt) {
/*  61 */     this(paramInt, 0.7F);
/*     */   }
/*     */ 
/*     */   
/*     */   public b getName(String paramString1, String paramString2) {
/*  66 */     return getName(paramString1, paramString2, "");
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
/*     */   public b getName(String paramString1, String paramString2, String paramString3) {
/*  83 */     assert paramString2 != null;
/*     */     
/*  85 */     if (paramString1 == null) paramString1 = ""; 
/*  86 */     if (paramString3 == null) paramString3 = "";
/*     */     
/*  88 */     int i = hash(paramString1, paramString2, paramString3) & this.hashmask;
/*     */     while (true) {
/*  90 */       b b1 = this.table[i];
/*  91 */       if (b1 == null) {
/*     */         
/*  93 */         this.numEntries++;
/*  94 */         if (this.numEntries >= this.threshold) {
/*  95 */           rehash();
/*     */         }
/*  97 */         this.table[i] = new b(paramString1, paramString2, paramString3); return new b(paramString1, paramString2, paramString3);
/*     */       } 
/*  99 */       if (equals(b1, paramString1, paramString2, paramString3)) {
/* 100 */         return b1;
/*     */       }
/* 102 */       i = i - 1 & this.hashmask;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rehash() {
/* 108 */     int i = this.table.length * 2;
/* 109 */     b[] arrayOfB = new b[i];
/* 110 */     int j = i - 1;
/*     */     
/* 112 */     for (byte b1 = 0; b1 < this.table.length; b1++) {
/*     */       
/* 114 */       b b2 = this.table[b1];
/* 115 */       if (b2 != null) {
/*     */         
/* 117 */         int k = hash(b2.getNamespaceURI(), b2.dT(), b2.getPrefix()) & j;
/*     */ 
/*     */         
/* 120 */         while (arrayOfB[k] != null) {
/* 121 */           k = k - 1 & j;
/*     */         }
/* 123 */         arrayOfB[k] = b2;
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     this.table = arrayOfB;
/* 128 */     this.hashmask = j;
/* 129 */     this.threshold = (int)(i * this.loadFactor);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int hash(String paramString1, String paramString2, String paramString3) {
/* 134 */     int i = 0;
/*     */     
/* 136 */     i += paramString3.hashCode() << 10;
/* 137 */     i += paramString1.hashCode() << 5;
/* 138 */     i += paramString2.hashCode();
/*     */     
/* 140 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean equals(b paramb, String paramString1, String paramString2, String paramString3) {
/* 145 */     return (paramb.dT().equals(paramString2) && paramb.getNamespaceURI().equals(paramString1) && paramb.getPrefix().equals(paramString3));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\QNameCache.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */