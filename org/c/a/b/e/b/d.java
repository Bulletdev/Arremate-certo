/*    */ package org.c.a.b.e.b;
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
/*    */ public class d
/*    */   extends j
/*    */ {
/*    */   private static final String kT = "(\\$[A-Za-z0-9_]*\\$).*";
/*    */   
/*    */   d() {
/* 36 */     super(org.c.a.b.q.d.e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Collection<String> a(String paramString) {
/* 41 */     return n.f(paramString, " @<>;:=|(),+{}[]");
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aO(String paramString) {
/* 46 */     Matcher matcher = Pattern.compile("(\\$[A-Za-z0-9_]*\\$).*").matcher(paramString);
/* 47 */     if (matcher.find()) {
/* 48 */       return matcher.group(1);
/*    */     }
/* 50 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aP(String paramString) {
/* 55 */     if (paramString.startsWith("E'")) {
/* 56 */       return paramString.substring(paramString.indexOf("'"));
/*    */     }
/*    */     
/* 59 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */