/*    */ package org.c.a.b.e.f;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.c.b;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.h.d;
/*    */ import org.c.a.b.h.e;
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
/* 36 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 45 */     ResultSet resultSet = null;
/* 46 */     String str = null;
/*    */     
/*    */     try {
/* 49 */       resultSet = ((b)this.a).a().getSchemas();
/* 50 */       while (resultSet.next()) {
/* 51 */         if (resultSet.getBoolean("IS_DEFAULT")) {
/* 52 */           str = resultSet.getString("TABLE_SCHEM");
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } finally {
/* 57 */       e.a(resultSet);
/*    */     } 
/*    */     
/* 60 */     return str;
/*    */   }
/*    */ 
/*    */   
/*    */   public void bB(String paramString) throws SQLException {
/* 65 */     this.a.a("SET SCHEMA " + ((b)this.a).d(new String[] { paramString }, ), new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 70 */     return new c((d)this.a, (b)this.a, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\f\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */