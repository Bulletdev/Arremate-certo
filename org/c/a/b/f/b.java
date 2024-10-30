/*    */ package org.c.a.b.f;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.a;
/*    */ import org.c.a.b.r.f;
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
/*    */ public class b
/*    */   extends a
/*    */ {
/*    */   public b(String paramString, SQLException paramSQLException) {
/* 34 */     super(paramString, paramSQLException);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 39 */     String str1 = super.getMessage();
/* 40 */     String str2 = n.c("", str1.length(), '-');
/*    */     
/* 42 */     return "\n" + str1 + "\n" + str2 + "\n" + f.a((SQLException)getCause());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\f\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */