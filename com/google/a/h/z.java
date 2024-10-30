/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.j;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.security.InvalidKeyException;
/*     */ import java.security.Key;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import javax.crypto.Mac;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @j
/*     */ final class z
/*     */   extends c
/*     */ {
/*     */   private final Mac a;
/*     */   private final Key a;
/*     */   private final String toString;
/*     */   private final int fx;
/*     */   private final boolean aX;
/*     */   
/*     */   z(String paramString1, Key paramKey, String paramString2) {
/*  46 */     this.a = (Key)a(paramString1, paramKey);
/*  47 */     this.a = (Key)D.checkNotNull(paramKey);
/*  48 */     this.toString = (String)D.checkNotNull(paramString2);
/*  49 */     this.fx = this.a.getMacLength() * 8;
/*  50 */     this.aX = a((Mac)this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public int av() {
/*  55 */     return this.fx;
/*     */   }
/*     */   
/*     */   private static boolean a(Mac paramMac) {
/*     */     try {
/*  60 */       paramMac.clone();
/*  61 */       return true;
/*  62 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/*  63 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Mac a(String paramString, Key paramKey) {
/*     */     try {
/*  69 */       Mac mac = Mac.getInstance(paramString);
/*  70 */       mac.init(paramKey);
/*  71 */       return mac;
/*  72 */     } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*  73 */       throw new IllegalStateException(noSuchAlgorithmException);
/*  74 */     } catch (InvalidKeyException invalidKeyException) {
/*  75 */       throw new IllegalArgumentException(invalidKeyException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public p a() {
/*  81 */     if (this.aX) {
/*     */       try {
/*  83 */         return new a((Mac)this.a.clone());
/*  84 */       } catch (CloneNotSupportedException cloneNotSupportedException) {}
/*     */     }
/*     */ 
/*     */     
/*  88 */     return new a(a(this.a.getAlgorithm(), this.a));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     return this.toString;
/*     */   }
/*     */   
/*     */   private static final class a
/*     */     extends a {
/*     */     private final Mac mac;
/*     */     private boolean aO;
/*     */     
/*     */     private a(Mac param1Mac) {
/* 102 */       this.mac = param1Mac;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void a(byte param1Byte) {
/* 107 */       fv();
/* 108 */       this.mac.update(param1Byte);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void update(byte[] param1ArrayOfbyte) {
/* 113 */       fv();
/* 114 */       this.mac.update(param1ArrayOfbyte);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void update(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 119 */       fv();
/* 120 */       this.mac.update(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void a(ByteBuffer param1ByteBuffer) {
/* 125 */       fv();
/* 126 */       D.checkNotNull(param1ByteBuffer);
/* 127 */       this.mac.update(param1ByteBuffer);
/*     */     }
/*     */     
/*     */     private void fv() {
/* 131 */       D.b(!this.aO, "Cannot re-use a Hasher after calling hash() on it");
/*     */     }
/*     */ 
/*     */     
/*     */     public n a() {
/* 136 */       fv();
/* 137 */       this.aO = true;
/* 138 */       return n.c(this.mac.doFinal());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */