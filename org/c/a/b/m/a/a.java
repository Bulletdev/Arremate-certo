/*    */ package org.c.a.b.m.a;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.c.b;
/*    */ import org.c.a.a.e.b;
/*    */ import org.c.a.a.g.b;
/*    */ import org.c.a.a.g.c;
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
/*    */   private final c a;
/*    */   
/*    */   a(c paramc) {
/* 42 */     this.a = paramc;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(org.c.a.a.e.a parama) throws SQLException {
/*    */     try {
/* 48 */       this.a.a(new b(this, parama)
/*    */           {
/*    */             public b a() {
/* 51 */               return this.a.a();
/*    */             }
/*    */ 
/*    */             
/*    */             public Connection getConnection() {
/* 56 */               return this.a.getConnection();
/*    */             }
/*    */           });
/* 59 */     } catch (SQLException sQLException) {
/* 60 */       throw sQLException;
/* 61 */     } catch (Exception exception) {
/* 62 */       throw new org.c.a.a.a("Migration failed !", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean fv() {
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */