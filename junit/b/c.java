/*    */ package junit.b;
/*    */ 
/*    */ 
/*    */ public class c
/*    */ {
/*    */   private static final String ELLIPSIS = "...";
/*    */   private static final String jB = "]";
/*    */   private static final String jC = "[";
/*    */   private int hO;
/*    */   private String jD;
/*    */   private String jE;
/*    */   private int hP;
/*    */   private int hQ;
/*    */   
/*    */   public c(int paramInt, String paramString1, String paramString2) {
/* 16 */     this.hO = paramInt;
/* 17 */     this.jD = paramString1;
/* 18 */     this.jE = paramString2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String aD(String paramString) {
/* 23 */     if (this.jD == null || this.jE == null || eo()) {
/* 24 */       return a.a(paramString, this.jD, this.jE);
/*    */     }
/*    */     
/* 27 */     hd();
/* 28 */     he();
/* 29 */     String str1 = aE(this.jD);
/* 30 */     String str2 = aE(this.jE);
/* 31 */     return a.a(paramString, str1, str2);
/*    */   }
/*    */   
/*    */   private String aE(String paramString) {
/* 35 */     String str = "[" + paramString.substring(this.hP, paramString.length() - this.hQ + 1) + "]";
/* 36 */     if (this.hP > 0) {
/* 37 */       str = dU() + str;
/*    */     }
/* 39 */     if (this.hQ > 0) {
/* 40 */       str = str + dV();
/*    */     }
/* 42 */     return str;
/*    */   }
/*    */   
/*    */   private void hd() {
/* 46 */     this.hP = 0;
/* 47 */     int i = Math.min(this.jD.length(), this.jE.length());
/* 48 */     for (; this.hP < i && 
/* 49 */       this.jD.charAt(this.hP) == this.jE.charAt(this.hP); this.hP++);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void he() {
/* 56 */     int i = this.jD.length() - 1;
/* 57 */     int j = this.jE.length() - 1;
/* 58 */     while (j >= this.hP && i >= this.hP && 
/* 59 */       this.jD.charAt(i) == this.jE.charAt(j)) {
/*    */       j--;
/*    */       i--;
/*    */     } 
/* 63 */     this.hQ = this.jD.length() - i;
/*    */   }
/*    */   
/*    */   private String dU() {
/* 67 */     return ((this.hP > this.hO) ? "..." : "") + this.jD.substring(Math.max(0, this.hP - this.hO), this.hP);
/*    */   }
/*    */   
/*    */   private String dV() {
/* 71 */     int i = Math.min(this.jD.length() - this.hQ + 1 + this.hO, this.jD.length());
/* 72 */     return this.jD.substring(this.jD.length() - this.hQ + 1, i) + ((this.jD.length() - this.hQ + 1 < this.jD.length() - this.hO) ? "..." : "");
/*    */   }
/*    */   
/*    */   private boolean eo() {
/* 76 */     return this.jD.equals(this.jE);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */