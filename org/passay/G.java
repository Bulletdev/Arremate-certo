/*     */ package org.passay;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   implements D
/*     */ {
/*     */   protected final f a;
/*  19 */   protected int iU = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(f paramf) {
/*  29 */     this(paramf, 1);
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
/*     */   public g(f paramf, int paramInt) {
/*  41 */     bw(paramInt);
/*  42 */     this.a = paramf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bw(int paramInt) {
/*  53 */     if (paramInt > 0) {
/*  54 */       this.iU = paramInt;
/*     */     } else {
/*  56 */       throw new IllegalArgumentException("argument must be greater than zero");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int ca() {
/*  68 */     return this.iU;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f a() {
/*  79 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ff() {
/*  90 */     return this.a.fe();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/*  97 */     String str = z.a(
/*  98 */         String.valueOf(this.a.fe()), paramx
/*  99 */         .getPassword(), this.iU);
/*     */     
/* 101 */     if (str.length() < this.iU) {
/* 102 */       return new E(false, new F(this.a
/*     */             
/* 104 */             .getErrorCode(), c(str)), 
/* 105 */           a(paramx));
/*     */     }
/* 107 */     return new E(true, a(paramx));
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
/*     */   protected Map<String, Object> c(String paramString) {
/* 120 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 121 */     linkedHashMap.put("minimumRequired", Integer.valueOf(this.iU));
/* 122 */     linkedHashMap.put("matchingCharacterCount", Integer.valueOf(paramString.length()));
/* 123 */     linkedHashMap.put("validCharacters", String.valueOf(this.a.fe()));
/* 124 */     linkedHashMap.put("matchingCharacters", paramString);
/* 125 */     return (Map)linkedHashMap;
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
/*     */   protected G a(x paramx) {
/* 138 */     if (G.a.exists(this.a.toString())) {
/* 139 */       return new G(
/* 140 */           G.a.valueOf(this.a.toString()), 
/* 141 */           z.d(this.a.fe(), paramx.getPassword()));
/*     */     }
/* 143 */     return new G();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     return String.format("%s@%h::characterData=%s,numberOfCharacters=%s", new Object[] {
/*     */           
/* 152 */           getClass().getName(), 
/* 153 */           Integer.valueOf(hashCode()), this.a, 
/*     */           
/* 155 */           Integer.valueOf(this.iU)
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */