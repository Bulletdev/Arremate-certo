/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class m
/*     */   implements Comparable<m>
/*     */ {
/*     */   private String dJ;
/*     */   private String eq;
/*     */   private String E;
/*     */   private Date b;
/*     */   
/*     */   public m() {}
/*     */   
/*     */   public m(String paramString1, Date paramDate, String paramString2) {
/*  21 */     this("", paramString1, paramDate, paramString2);
/*     */   }
/*     */   
/*     */   public m(String paramString1, String paramString2, Date paramDate, String paramString3) {
/*  25 */     this.dJ = paramString1;
/*  26 */     this.E = paramString2;
/*  27 */     this.b = paramDate;
/*  28 */     this.eq = paramString3;
/*     */   }
/*     */   
/*     */   public String bo() {
/*  32 */     return (this.dJ != null) ? this.dJ : "";
/*     */   }
/*     */   
/*     */   public void T(String paramString) {
/*  36 */     this.dJ = paramString;
/*     */   }
/*     */   
/*     */   public String cd() {
/*  40 */     return this.eq;
/*     */   }
/*     */   
/*     */   public void aE(String paramString) {
/*  44 */     this.eq = paramString;
/*     */   }
/*     */   
/*     */   public String j() {
/*  48 */     return this.E;
/*     */   }
/*     */   
/*     */   public void f(String paramString) {
/*  52 */     this.E = paramString;
/*     */   }
/*     */   
/*     */   public Date b() {
/*  56 */     return this.b;
/*     */   }
/*     */   
/*     */   public void c(Date paramDate) {
/*  60 */     this.b = paramDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  65 */     int i = 7;
/*  66 */     i = 47 * i + Objects.hashCode(this.dJ);
/*  67 */     i = 47 * i + Objects.hashCode(this.eq);
/*  68 */     i = 47 * i + Objects.hashCode(this.E);
/*  69 */     i = 47 * i + Objects.hashCode(this.b);
/*  70 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  75 */     if (this == paramObject) {
/*  76 */       return true;
/*     */     }
/*     */     
/*  79 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     m m1 = (m)paramObject;
/*  84 */     String str1 = ce().trim();
/*  85 */     String str2 = m1.ce().trim();
/*     */     
/*  87 */     return (Objects.equals(this.dJ, m1.dJ) && 
/*  88 */       Objects.equals(this.eq, m1.eq) && 
/*  89 */       Objects.equals(str1, str2) && 
/*  90 */       Objects.equals(this.b, m1.b));
/*     */   }
/*     */   
/*     */   public boolean a(Object paramObject) {
/*  94 */     if (this == paramObject) {
/*  95 */       return true;
/*     */     }
/*     */     
/*  98 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     m m1 = (m)paramObject;
/* 103 */     String str1 = ce().trim();
/* 104 */     String str2 = m1.ce().trim();
/*     */     
/* 106 */     return (Objects.equals(this.eq, m1.eq) && 
/* 107 */       Objects.equals(str1, str2) && 
/* 108 */       Objects.equals(this.b, m1.b));
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(m paramm) {
/* 113 */     Date date = b();
/*     */ 
/*     */     
/* 116 */     int i = date.compareTo(paramm.b());
/*     */     
/* 118 */     if (i == 0) {
/* 119 */       return equals(paramm) ? 0 : -1;
/*     */     }
/* 121 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private String ce() {
/* 126 */     String str = this.E;
/* 127 */     str = str.replaceAll("\\<[^\\>]*\\>", "");
/* 128 */     return str;
/*     */   }
/*     */   
/*     */   public String cf() {
/* 132 */     return this.E.replace("<html><!--ARREMATELINHA-->", "")
/* 133 */       .replace("</html>", "")
/* 134 */       .replace("<br>", "").trim();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */