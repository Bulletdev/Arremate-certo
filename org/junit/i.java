/*     */ package org.junit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */   extends AssertionError
/*     */ {
/*     */   private static final int hR = 20;
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String jD;
/*     */   private String jE;
/*     */   
/*     */   public i(String paramString1, String paramString2, String paramString3) {
/*  37 */     super(paramString1);
/*  38 */     this.jD = paramString2;
/*  39 */     this.jE = paramString3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/*  49 */     return (new a(20, this.jD, this.jE)).aD(super.getMessage());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dW() {
/*  58 */     return this.jE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dX() {
/*  67 */     return this.jD;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class a
/*     */   {
/*     */     private static final String ELLIPSIS = "...";
/*     */ 
/*     */     
/*     */     private static final String lT = "]";
/*     */ 
/*     */     
/*     */     private static final String lU = "[";
/*     */     
/*     */     private final int iN;
/*     */     
/*     */     private final String lV;
/*     */     
/*     */     private final String lW;
/*     */ 
/*     */     
/*     */     public a(int param1Int, String param1String1, String param1String2) {
/*  90 */       this.iN = param1Int;
/*  91 */       this.lV = param1String1;
/*  92 */       this.lW = param1String2;
/*     */     }
/*     */     
/*     */     public String aD(String param1String) {
/*  96 */       if (this.lV == null || this.lW == null || this.lV.equals(this.lW)) {
/*  97 */         return c.a(param1String, this.lV, this.lW);
/*     */       }
/*  99 */       a a1 = new a();
/* 100 */       String str1 = a1.eW();
/* 101 */       String str2 = a1.eX();
/* 102 */       return c.a(param1String, str1 + a1.eU() + str2, str1 + a1.eV() + str2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String eT() {
/* 109 */       int i = Math.min(this.lV.length(), this.lW.length());
/* 110 */       for (byte b = 0; b < i; b++) {
/* 111 */         if (this.lV.charAt(b) != this.lW.charAt(b)) {
/* 112 */           return this.lV.substring(0, b);
/*     */         }
/*     */       } 
/* 115 */       return this.lV.substring(0, i);
/*     */     }
/*     */     
/*     */     private String bp(String param1String) {
/* 119 */       byte b = 0;
/* 120 */       int i = Math.min(this.lV.length() - param1String.length(), this.lW.length() - param1String.length()) - 1;
/*     */       
/* 122 */       for (; b <= i && 
/* 123 */         this.lV.charAt(this.lV.length() - 1 - b) == this.lW.charAt(this.lW.length() - 1 - b); b++);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 128 */       return this.lV.substring(this.lV.length() - b);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private class a
/*     */     {
/* 139 */       private final String lX = i.a.a(i.a.this);
/* 140 */       private final String lY = i.a.a(i.a.this, this.lX);
/*     */ 
/*     */       
/*     */       public String eU() {
/* 144 */         return bq(i.a.b(this.a));
/*     */       }
/*     */       
/*     */       public String eV() {
/* 148 */         return bq(i.a.c(this.a));
/*     */       }
/*     */       
/*     */       public String eW() {
/* 152 */         if (this.lX.length() <= i.a.a(this.a)) {
/* 153 */           return this.lX;
/*     */         }
/* 155 */         return "..." + this.lX.substring(this.lX.length() - i.a.a(this.a));
/*     */       }
/*     */       
/*     */       public String eX() {
/* 159 */         if (this.lY.length() <= i.a.a(this.a)) {
/* 160 */           return this.lY;
/*     */         }
/* 162 */         return this.lY.substring(0, i.a.a(this.a)) + "...";
/*     */       }
/*     */       
/*     */       private String bq(String param2String) {
/* 166 */         return "[" + param2String.substring(this.lX.length(), param2String.length() - this.lY.length()) + "]";
/*     */       }
/*     */       
/*     */       private a(i.a this$0) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */