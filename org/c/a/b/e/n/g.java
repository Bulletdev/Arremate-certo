/*    */ package org.c.a.b.e.n;
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
/*    */ 
/*    */ public class g
/*    */   extends f
/*    */ {
/*    */   private final String databaseName;
/*    */   
/*    */   g(d paramd, b paramb, String paramString1, d paramd1, String paramString2) {
/* 41 */     super(paramd, paramb, paramd1, paramString2);
/* 42 */     this.databaseName = paramString1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/* 47 */     this.a.a("DROP TABLE " + this, new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 52 */     return this.a.b("SELECT CAST(CASE WHEN EXISTS(  SELECT 1 FROM [" + this.databaseName + "].INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA=? AND TABLE_NAME=?) THEN 1 ELSE 0 END AS BIT)", new String[] { this.a
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 60 */           .getName(), this.name });
/*    */   }
/*    */ 
/*    */   
/*    */   protected void ib() throws SQLException {
/* 65 */     this.a.a("select * from " + this + " WITH (TABLOCKX)", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     return this.a.d(new String[] { this.databaseName, this.a.getName(), this.name });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\n\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */