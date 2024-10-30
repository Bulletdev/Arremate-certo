/*    */ package org.c.a.b.m.c;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import javax.sql.DataSource;
/*    */ import org.c.a.a.e.b;
/*    */ import org.c.a.a.g.b.b;
/*    */ import org.springframework.jdbc.core.JdbcTemplate;
/*    */ import org.springframework.jdbc.datasource.SingleConnectionDataSource;
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
/* 41 */     this.a = paramb;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(org.c.a.a.e.a parama) throws SQLException {
/*    */     try {
/* 47 */       this.a.a(new JdbcTemplate((DataSource)new SingleConnectionDataSource(parama
/* 48 */               .getConnection(), true)));
/* 49 */     } catch (SQLException sQLException) {
/* 50 */       throw sQLException;
/* 51 */     } catch (Exception exception) {
/* 52 */       throw new org.c.a.a.a("Migration failed !", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean fv() {
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */