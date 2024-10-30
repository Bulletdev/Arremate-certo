/*    */ package org.c.a.b.e.n;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.c.a.b.q.d;
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
/*    */ public class e
/*    */   extends j
/*    */ {
/* 32 */   private static final Pattern g = Pattern.compile("^(LIKE|AS)('.*)");
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   private static final Pattern e = Pattern.compile("(.*')(LIKE|AS)$");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   private static final Pattern z = Pattern.compile("^((BACKUP|RESTORE|RECONFIGURE|(CREATE|DROP|ALTER) (DATABASE|FULLTEXT INDEX))|(EXEC SP_ADDSUBSCRIPTION));?( .*)?");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 52 */   private String kV = "";
/*    */   
/*    */   public e() {
/* 55 */     super(d.f);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void bD(String paramString) {
/* 60 */     super.bD(paramString);
/*    */     
/* 62 */     if (!this.da || !fV()) {
/*    */       return;
/*    */     }
/*    */     
/* 66 */     if (n.c(this.kV, " ") < 3) {
/* 67 */       this.kV += paramString;
/* 68 */       this.kV += " ";
/* 69 */       this.kV = n.bg(this.kV);
/*    */     } 
/*    */     
/* 72 */     if (z.matcher(this.kV).matches() || (!this.cW && !this.cX && !this.cZ && z
/*    */ 
/*    */       
/* 75 */       .matcher(paramString).matches())) {
/* 76 */       this.da = false;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aP(String paramString) {
/* 82 */     if (paramString.startsWith("N'")) {
/* 83 */       return paramString.substring(paramString.indexOf("'"));
/*    */     }
/*    */     
/* 86 */     Matcher matcher1 = g.matcher(paramString);
/* 87 */     if (matcher1.find()) {
/* 88 */       paramString = matcher1.group(2);
/*    */     }
/*    */     
/* 91 */     Matcher matcher2 = e.matcher(paramString);
/* 92 */     if (matcher2.find()) {
/* 93 */       paramString = matcher2.group(1);
/*    */     }
/*    */     
/* 96 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\n\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */