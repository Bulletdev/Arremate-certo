/*    */ package org.c.a.b.e.i;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.c.b;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.d;
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
/*    */   extends a<b>
/*    */ {
/*    */   a(b paramb, b paramb1, Connection paramConnection, boolean paramBoolean) {
/* 34 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 43 */     return this.a.b("SELECT SYS_CONTEXT('USERENV', 'CURRENT_SCHEMA') FROM DUAL", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void bB(String paramString) throws SQLException {
/* 48 */     this.a.a("ALTER SESSION SET CURRENT_SCHEMA=" + ((b)this.a).d(new String[] { paramString }, ), new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 53 */     return new d(this.a, (b)this.a, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\i\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */