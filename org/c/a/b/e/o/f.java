/*    */ package org.c.a.b.e.o;
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
/*    */ 
/*    */ public class f
/*    */   extends f
/*    */ {
/*    */   f(d paramd, b paramb, d paramd1, String paramString) {
/* 40 */     super(paramd, paramb, paramd1, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 45 */     return (this.a.b("SELECT object_id('" + this.name + "')", new String[0]) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void ib() throws SQLException {
/* 50 */     this.a.a("LOCK TABLE " + this + " IN EXCLUSIVE MODE", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/* 55 */     this.a.a("DROP TABLE " + getName(), new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     return this.name;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\o\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */