/*    */ package org.c.a.b.e.k;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.c.a.b.q.j;
/*    */ import org.c.a.b.r.n;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends j
/*    */ {
/*    */   static final String kT = "(\\$[A-Za-z0-9_]*\\$).*";
/* 39 */   private String kV = "";
/*    */   
/*    */   d() {
/* 42 */     super(org.c.a.b.q.d.e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void bD(String paramString) {
/* 47 */     super.bD(paramString);
/*    */     
/* 49 */     if (!this.da || !fV()) {
/*    */       return;
/*    */     }
/*    */     
/* 53 */     if (n.c(this.kV, " ") < 8) {
/* 54 */       this.kV += paramString;
/* 55 */       this.kV += " ";
/* 56 */       this.kV = n.bg(this.kV);
/*    */     } 
/*    */     
/* 59 */     if (this.kV.matches("^(CREATE|DROP) LIBRARY .*") || this.kV
/* 60 */       .matches("^CREATE EXTERNAL TABLE .*") || this.kV
/* 61 */       .matches("^ALTER TABLE .* APPEND FROM .*") || this.kV
/* 62 */       .matches("^VACUUM .*"))
/*    */     {
/* 64 */       this.da = false;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected Collection<String> a(String paramString) {
/* 70 */     return n.f(paramString, " @<>;:=|(),+{}[]");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aO(String paramString) {
/* 75 */     Matcher matcher = Pattern.compile("(\\$[A-Za-z0-9_]*\\$).*").matcher(paramString);
/* 76 */     if (matcher.find()) {
/* 77 */       return matcher.group(1);
/*    */     }
/* 79 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aP(String paramString) {
/* 84 */     if (paramString.startsWith("E'")) {
/* 85 */       return paramString.substring(paramString.indexOf("'"));
/*    */     }
/*    */     
/* 88 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\k\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */