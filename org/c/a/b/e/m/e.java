/*    */ package org.c.a.b.e.m;
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
/*    */   static final String lf = "sqlite_sequence";
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean cK;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e(d paramd, b paramb, d paramd1, String paramString) {
/* 46 */     super(paramd, paramb, paramd1, paramString);
/* 47 */     this.cK = "sqlite_sequence".equals(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/* 52 */     if (this.cK) {
/* 53 */       a.debug("SQLite system table " + this + " cannot be dropped. Ignoring.");
/*    */     } else {
/* 55 */       this.a.a("DROP TABLE " + this.a.d(new String[] { this.a.getName(), this.name }, ), new Object[0]);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean fB() throws SQLException {
/* 61 */     return (this.a.b("SELECT count(tbl_name) FROM " + this.a
/* 62 */         .d(new String[] { this.a.getName() }, ) + ".sqlite_master WHERE type='table' AND tbl_name='" + this.name + "'", new String[0]) > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void ib() throws SQLException {
/* 67 */     a.debug("Unable to lock " + this + " as SQLite does not support locking. No concurrent migration supported.");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\m\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */