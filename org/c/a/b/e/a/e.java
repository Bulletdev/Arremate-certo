/*    */ package org.c.a.b.e.a;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.b.f.b;
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
/*    */ public abstract class e<D extends b, S extends d>
/*    */ {
/*    */   protected final d a;
/*    */   protected final D a;
/*    */   protected final S a;
/*    */   protected final String name;
/*    */   
/*    */   e(d paramd, D paramD, S paramS, String paramString) {
/* 56 */     this.name = paramString;
/* 57 */     this.a = (S)paramd;
/* 58 */     this.a = (S)paramD;
/* 59 */     this.a = paramS;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final d c() {
/* 66 */     return (d)this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String getName() {
/* 73 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void drop() {
/*    */     try {
/* 81 */       hZ();
/* 82 */     } catch (SQLException sQLException) {
/* 83 */       throw new b("Unable to drop " + this, sQLException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract void hZ() throws SQLException;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 96 */     return this.a.d(new String[] { this.a.getName(), this.name });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */