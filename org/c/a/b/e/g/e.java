/*    */ package org.c.a.b.e.g;
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
/* 43 */     this.a.a("DROP TABLE " + this.name, new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 48 */     return a(null, (d)this.a, this.name, new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void ib() throws SQLException {
/* 53 */     this.a.b("lock table " + this + " in exclusive mode", new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\g\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */