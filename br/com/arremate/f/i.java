/*    */ package br.com.arremate.f;
/*    */ 
/*    */ import br.com.arremate.l.j;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum i
/*    */ {
/* 11 */   a(0, "Aberto"),
/* 12 */   b(1, "Iminência"),
/* 13 */   c(2, "Aleatório"),
/* 14 */   d(1, "Pré Iminência"),
/* 15 */   e(2, "Iminência");
/*    */   
/*    */   private final int ah;
/*    */   private final String aH;
/*    */   
/*    */   i(int paramInt1, String paramString1) {
/* 21 */     this.ah = paramInt1;
/* 22 */     this.aH = paramString1;
/*    */   }
/*    */   
/*    */   public int v() {
/* 26 */     return this.ah;
/*    */   }
/*    */   
/*    */   public String K() {
/* 30 */     return this.aH;
/*    */   }
/*    */   
/*    */   public static i a(int paramInt, j paramj) {
/* 34 */     switch (null.e[paramj.a().ordinal()]) {
/*    */       case 1:
/* 36 */         switch (paramInt) {
/*    */           case 0:
/* 38 */             return (i)a;
/*    */         } 
/* 40 */         return b;
/*    */       
/*    */       case 2:
/* 43 */         switch (paramInt) {
/*    */           case 0:
/* 45 */             return (i)a;
/*    */         } 
/* 47 */         return c;
/*    */       
/*    */       case 3:
/* 50 */         switch (paramInt) {
/*    */           case 1:
/* 52 */             return d;
/*    */           case 2:
/* 54 */             return e;
/*    */         } 
/* 56 */         return (i)a;
/*    */       
/*    */       case 4:
/* 59 */         return (i)a;
/*    */     } 
/*    */     
/* 62 */     return a(paramInt, paramj.b().a());
/*    */   }
/*    */ 
/*    */   
/*    */   private static i a(int paramInt, o paramo) {
/* 67 */     switch (null.g[paramo.ordinal()]) {
/*    */       case 1:
/*    */       case 2:
/*    */       case 3:
/*    */       case 4:
/*    */       case 5:
/* 73 */         switch (paramInt) {
/*    */           case 1:
/* 75 */             return b;
/*    */           case 2:
/* 77 */             return c;
/*    */         } 
/* 79 */         return (i)a;
/*    */       
/*    */       case 6:
/*    */       case 7:
/* 83 */         switch (paramInt) {
/*    */           case 0:
/* 85 */             return (i)a;
/*    */         } 
/* 87 */         return b;
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 93 */     switch (paramInt) {
/*    */       case 0:
/* 95 */         return (i)a;
/*    */     } 
/*    */ 
/*    */     
/* 99 */     return c;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */