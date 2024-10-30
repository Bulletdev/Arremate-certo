/*    */ package org.c.a.b.e.b;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.f.a;
/*    */ import org.c.a.a.f.c;
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
/*    */ public class e
/*    */   extends f<b, c>
/*    */ {
/* 29 */   private static final a a = c.b(e.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   e(d paramd, b paramb, c paramc, String paramString) {
/* 40 */     super(paramd, paramb, paramc, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/* 45 */     this.a.a("DROP TABLE " + ((b)this.a).d(new String[] { ((c)this.a).getName(), this.name }, ) + " CASCADE", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 50 */     if (((c)this.a).cB) {
/* 51 */       return this.a.b("SELECT EXISTS (\n   SELECT 1\n   FROM   information_schema.tables \n   WHERE  table_schema = ?\n   AND    table_name = ?\n)", new String[] { ((c)this.a)
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 56 */             .getName(), this.name });
/*    */     }
/*    */     
/* 59 */     return this.a.b("SELECT EXISTS (\n   SELECT 1\n   FROM   information_schema.tables \n   WHERE  table_catalog = ?\n   AND    table_schema = 'public'\n   AND    table_name = ?\n)", new String[] { ((c)this.a)
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 65 */           .getName(), this.name });
/*    */   }
/*    */ 
/*    */   
/*    */   protected void ib() {
/* 70 */     a.debug("Unable to lock " + this + " as CockroachDB does not support locking. No concurrent migration supported.");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */