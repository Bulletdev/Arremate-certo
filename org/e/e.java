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
/*    */ public class e
/*    */   extends p
/*    */ {
/*    */   public e(String paramString) {
/* 40 */     super(paramString);
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
/*    */   public String nextToken() throws g {
/* 52 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     while (true) {
/* 54 */       char c = next();
/* 55 */       if (!Character.isWhitespace(c)) {
/* 56 */         if (c == '"' || c == '\'') {
/* 57 */           char c1 = c;
/*    */           while (true) {
/* 59 */             c = next();
/* 60 */             if (c < ' ') {
/* 61 */               throw a("Unterminated string.");
/*    */             }
/* 63 */             if (c == c1) {
/* 64 */               return stringBuilder.toString();
/*    */             }
/* 66 */             stringBuilder.append(c);
/*    */           }  break;
/*    */         } 
/*    */         while (true) {
/* 70 */           if (c == '\000' || Character.isWhitespace(c)) {
/* 71 */             return stringBuilder.toString();
/*    */           }
/* 73 */           stringBuilder.append(c);
/* 74 */           c = next();
/*    */         } 
/*    */         break;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */