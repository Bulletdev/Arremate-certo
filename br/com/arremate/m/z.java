/*     */ package br.com.arremate.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class z
/*     */ {
/*     */   public enum d
/*     */   {
/*   9 */     a(1, "Melhoria", "melhoria"),
/*  10 */     b(2, "Correção", "correcao");
/*     */     
/*     */     private final int ah;
/*     */     private final String aH;
/*     */     private final String fF;
/*     */     
/*     */     d(int param1Int1, String param1String1, String param1String2) {
/*  17 */       this.ah = param1Int1;
/*  18 */       this.aH = param1String1;
/*  19 */       this.fF = param1String2;
/*     */     }
/*     */     
/*     */     public int v() {
/*  23 */       return this.ah;
/*     */     }
/*     */     
/*     */     public String K() {
/*  27 */       return this.aH;
/*     */     }
/*     */     
/*     */     public String cz() {
/*  31 */       return this.fF;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static d a(int param1Int) {
/*  43 */       d d1 = null;
/*  44 */       for (d d2 : values()) {
/*  45 */         if (d2.v() == param1Int) {
/*  46 */           d1 = d2;
/*     */           break;
/*     */         } 
/*     */       } 
/*  50 */       return d1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum b
/*     */   {
/*  59 */     a(0, 0),
/*  60 */     b(0, 40),
/*  61 */     c(1, 150),
/*  62 */     d(2, 150),
/*  63 */     e(3, 2000);
/*     */     
/*     */     private final int index;
/*     */     private final int cM;
/*     */     
/*     */     b(int param1Int1, int param1Int2) {
/*  69 */       this.index = param1Int1;
/*  70 */       this.cM = param1Int2;
/*     */     }
/*     */     
/*     */     public int getIndex() {
/*  74 */       return this.index;
/*     */     }
/*     */     
/*     */     public int aa() {
/*  78 */       return this.cM;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum c
/*     */   {
/*  87 */     a(0, 150),
/*  88 */     b(1, 0),
/*  89 */     c(2, 0);
/*     */     
/*     */     private final int index;
/*     */     private final int cM;
/*     */     
/*     */     c(int param1Int1, int param1Int2) {
/*  95 */       this.index = param1Int1;
/*  96 */       this.cM = param1Int2;
/*     */     }
/*     */     
/*     */     public int getIndex() {
/* 100 */       return this.index;
/*     */     }
/*     */     
/*     */     public int aa() {
/* 104 */       return this.cM;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum a
/*     */   {
/* 115 */     a("temp");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String fE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(String param1String1) {
/* 128 */       this.fE = param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String cy() {
/* 137 */       return this.fE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */