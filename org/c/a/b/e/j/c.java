/*    */ package org.c.a.b.e.j;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.StringReader;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.c.a.b.h.d;
/*    */ import org.c.a.b.h.f;
/*    */ import org.c.a.b.h.g;
/*    */ import org.c.a.b.q.a;
/*    */ import org.c.a.b.q.d;
/*    */ import org.c.a.b.q.h;
/*    */ import org.postgresql.copy.CopyManager;
/*    */ import org.postgresql.core.BaseConnection;
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
/*    */   extends a
/*    */ {
/* 40 */   static final d c = new d("\\.", true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   c(List<org.c.a.b.j.c> paramList) {
/* 48 */     super(paramList, c);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public g a(d paramd, h paramh) {
/* 57 */     String str1 = ev();
/* 58 */     int i = str1.indexOf(";");
/*    */     
/* 60 */     String str2 = str1.substring(0, i);
/*    */     
/* 62 */     String str3 = str1.substring(i + 1);
/*    */     
/* 64 */     StringBuilder stringBuilder = new StringBuilder(str3);
/* 65 */     while (stringBuilder.length() > 0 && (stringBuilder.charAt(0) == '\r' || stringBuilder.charAt(0) == '\n')) {
/* 66 */       stringBuilder.deleteCharAt(0);
/*    */     }
/* 68 */     str3 = stringBuilder.toString();
/*    */     
/* 70 */     g g = new g();
/*    */     try {
/* 72 */       CopyManager copyManager = new CopyManager(paramd.getConnection().<BaseConnection>unwrap(BaseConnection.class));
/*    */       try {
/* 74 */         long l = copyManager.copyIn(str2, new StringReader(str3));
/* 75 */         g.a(new f(l));
/*    */ 
/*    */ 
/*    */       
/*    */       }
/* 80 */       catch (IOException iOException) {
/* 81 */         throw new SQLException("Unable to execute COPY operation", iOException);
/*    */       } 
/* 83 */     } catch (SQLException sQLException) {
/* 84 */       paramd.a(g, sQLException);
/*    */     } 
/* 86 */     return g;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\j\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */