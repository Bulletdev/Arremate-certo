/*    */ package org.c.a.b.e.f;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.f.a;
/*    */ import org.c.a.a.f.c;
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
/*    */ public class e
/*    */   extends f
/*    */ {
/* 31 */   private static final a a = c.b(e.class);
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
/*    */   e(d paramd, b paramb, d paramd1, String paramString) {
/* 49 */     super(paramd, paramb, paramd1, paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/* 58 */     this.a.a("DROP TABLE " + this.a.d(new String[] { this.a.getName(), this.name }, ) + " CASCADE", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 63 */     return a(null, (d)this.a, this.name, new String[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void ib() throws SQLException {
/* 74 */     this.a.a("LOCK TABLE " + this + " WRITE", new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\f\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */