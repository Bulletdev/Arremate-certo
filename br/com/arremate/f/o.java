/*    */ package br.com.arremate.f;
/*    */ 
/*    */ public enum o {
/*  4 */   a(1, "CN"),
/*  5 */   b(2, "BB"),
/*  6 */   c(22222, "LicitacoesE"),
/*  7 */   d(3, "CP"),
/*  8 */   e(5, "BEC"),
/*  9 */   f(6, "RJ"),
/* 10 */   g(7, "ES"),
/* 11 */   h(9, "MG"),
/* 12 */   i(11, "SC"),
/* 13 */   j(24, "BLL"),
/* 14 */   k(25, "CNCot"),
/* 15 */   l(28, "Licitanet"),
/* 16 */   m(35, "MT"),
/* 17 */   n(58, "PEInt"),
/* 18 */   o(77, "PMB"),
/* 19 */   p(160, "CEMIG"),
/* 20 */   q(769, "CNSim"),
/* 21 */   r(1362, "BNC"),
/* 22 */   s(26, "PBN");
/*    */   
/*    */   private final int id;
/*    */   private final String aK;
/*    */   
/*    */   o(int paramInt1, String paramString1) {
/* 28 */     this.id = paramInt1;
/* 29 */     this.aK = paramString1;
/*    */   }
/*    */   
/*    */   public String N() {
/* 33 */     return this.aK;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 37 */     return this.id;
/*    */   }
/*    */   
/*    */   public static o a(int paramInt) {
/* 41 */     for (o o1 : values()) {
/* 42 */       if (o1.getId() == paramInt) {
/* 43 */         return o1;
/*    */       }
/*    */     } 
/*    */     
/* 47 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */