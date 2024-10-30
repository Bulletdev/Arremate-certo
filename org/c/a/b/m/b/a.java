/*    */ package org.c.a.b.m.b;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.e.b;
/*    */ import org.c.a.a.g.a.b;
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
/*    */ public class a
/*    */   implements b
/*    */ {
/*    */   private final b a;
/*    */   
/*    */   a(b paramb) {
/* 40 */     this.a = paramb;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(org.c.a.a.e.a parama) throws SQLException {
/*    */     try {
/* 46 */       this.a.o(parama.getConnection());
/* 47 */     } catch (SQLException sQLException) {
/* 48 */       throw sQLException;
/* 49 */     } catch (Exception exception) {
/* 50 */       throw new org.c.a.a.a("Migration failed !", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean fv() {
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */