/*    */ package org.c.a.b.e.l;
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
/*    */ public class a
/*    */   extends a<b>
/*    */ {
/*    */   a(b paramb, b paramb1, Connection paramConnection, boolean paramBoolean) {
/* 31 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 40 */     return this.a.b("SELECT CURRENT_SCHEMA FROM DUMMY", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void bB(String paramString) throws SQLException {
/* 45 */     this.a.a("SET SCHEMA " + ((b)this.a).aN(paramString), new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 50 */     return new c(this.a, (b)this.a, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */