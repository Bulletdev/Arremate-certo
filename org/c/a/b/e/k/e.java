/*    */ package org.c.a.b.e.k;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.b.e.a.b;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.e.a.f;
/*    */ import org.c.a.b.h.d;
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
/*    */   extends f
/*    */ {
/*    */   e(d paramd, b paramb, d paramd1, String paramString) {
/* 38 */     super(paramd, paramb, paramd1, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/* 43 */     this.a.a("DROP TABLE " + this.a.d(new String[] { this.a.getName(), this.name }, ) + " CASCADE", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 48 */     return this.a.b("SELECT EXISTS (\n  SELECT 1\n  FROM   pg_catalog.pg_class c\n  JOIN   pg_catalog.pg_namespace n ON n.oid = c.relnamespace\n  WHERE  n.nspname = ?\n  AND    c.relname = ?\n  AND    c.relkind = 'r'\n)", new String[] { this.a
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 55 */           .getName(), this.name
/* 56 */           .toLowerCase() });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void ib() throws SQLException {
/* 62 */     this.a.a("DELETE FROM " + this + " WHERE FALSE", new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\k\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */