/*    */ package org.c.a.b.e.b;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.c.b;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.f.b;
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
/*    */ public class a
/*    */   extends a<b>
/*    */ {
/*    */   a(b paramb, b paramb1, Connection paramConnection, boolean paramBoolean) {
/* 36 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 45 */     return new c(this.a, (b)this.a, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 50 */     return this.a.b("SHOW database", new String[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void c(d paramd) {
/*    */     try {
/* 57 */       if (paramd.getName().equals(this.kS) || !paramd.exists()) {
/*    */         return;
/*    */       }
/* 60 */       bB(paramd.getName());
/* 61 */     } catch (SQLException sQLException) {
/* 62 */       throw new b("Error setting current database to " + paramd, sQLException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void bB(String paramString) throws SQLException {
/* 68 */     if (!n.W(paramString)) {
/* 69 */       paramString = "DEFAULT";
/*    */     }
/* 71 */     this.a.a("SET database = " + paramString, new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */