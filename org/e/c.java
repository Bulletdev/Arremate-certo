/*    */ package org.e;
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
/*    */ public class c
/*    */ {
/*    */   public static i i(String paramString) throws g {
/* 48 */     i i = new i();
/* 49 */     p p = new p(paramString);
/* 50 */     while (p.ge()) {
/* 51 */       String str = b.unescape(p.d('='));
/* 52 */       p.d('=');
/* 53 */       i.c(str, b.unescape(p.d(';')));
/* 54 */       p.next();
/*    */     } 
/* 56 */     return i;
/*    */   }
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
/*    */   public static String d(i parami) throws g {
/* 69 */     boolean bool = false;
/* 70 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 72 */     for (String str : parami.keySet()) {
/* 73 */       Object object = parami.d(str);
/* 74 */       if (!i.NULL.equals(object)) {
/* 75 */         if (bool) {
/* 76 */           stringBuilder.append(';');
/*    */         }
/* 78 */         stringBuilder.append(b.escape(str));
/* 79 */         stringBuilder.append("=");
/* 80 */         stringBuilder.append(b.escape(object.toString()));
/* 81 */         bool = true;
/*    */       } 
/*    */     } 
/* 84 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */