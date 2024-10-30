/*    */ package org.c.a.b.e.m;
/*    */ 
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
/*    */ public class d
/*    */   extends j
/*    */ {
/* 28 */   private static final Pattern x = Pattern.compile("^PRAGMA FOREIGN_KEYS=.*");
/* 29 */   private static final Pattern y = Pattern.compile("^CREATE( (TEMP|TEMPORARY))? TRIGGER.*");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   private String kV = "";
/*    */   
/*    */   d() {
/* 37 */     super(org.c.a.b.q.d.e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected org.c.a.b.q.d a(String paramString, org.c.a.b.q.d paramd) {
/* 42 */     boolean bool = y.matcher(this.kV).matches();
/*    */     
/* 44 */     if (bool && !paramString.endsWith("END;")) {
/* 45 */       return null;
/*    */     }
/* 47 */     return this.g;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void bD(String paramString) {
/* 52 */     super.bD(paramString);
/*    */     
/* 54 */     if (!this.da || !fV()) {
/*    */       return;
/*    */     }
/*    */     
/* 58 */     if (n.c(this.kV, " ") < 8) {
/* 59 */       this.kV += paramString;
/* 60 */       this.kV += " ";
/* 61 */       this.kV = n.bg(this.kV);
/*    */     } 
/*    */     
/* 64 */     if (x.matcher(this.kV).matches()) {
/* 65 */       this.da = false;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aP(String paramString) {
/* 71 */     if (paramString.startsWith("X'"))
/*    */     {
/* 73 */       return paramString.substring(paramString.indexOf("'"));
/*    */     }
/* 75 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */