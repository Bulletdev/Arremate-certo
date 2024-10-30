/*    */ package org.c.a.b.e.o;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.c.a.b.q.j;
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
/* 31 */   private static final Pattern g = Pattern.compile("^(ELSE)('.*)");
/*    */   
/*    */   d() {
/* 34 */     super(org.c.a.b.q.d.f);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String aT(String paramString) {
/* 39 */     char c = paramString.charAt(2);
/* 40 */     switch (c) {
/*    */       case '(':
/* 42 */         return ")'";
/*    */     } 
/* 44 */     return c + "'";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String aP(String paramString) {
/* 50 */     Matcher matcher = g.matcher(paramString);
/* 51 */     if (matcher.find()) {
/* 52 */       paramString = matcher.group(2);
/*    */     }
/*    */     
/* 55 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\o\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */