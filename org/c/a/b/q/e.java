/*    */ package org.c.a.b.q;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.b.f.b;
/*    */ import org.c.a.b.n.d;
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
/*    */   extends b
/*    */ {
/*    */   private final d a;
/*    */   private final i a;
/*    */   
/*    */   public e(d paramd, i parami, SQLException paramSQLException) {
/* 38 */     super((paramd == null) ? "Script failed" : ("Migration " + paramd.getFilename() + " failed"), paramSQLException);
/* 39 */     this.a = (i)paramd;
/* 40 */     this.a = parami;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public d a() {
/* 47 */     return (d)this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLineNumber() {
/* 56 */     return (this.a == null) ? -1 : this.a.getLineNumber();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String eM() {
/* 65 */     return (this.a == null) ? "" : this.a.ev();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public i a() {
/* 74 */     return this.a;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 79 */     String str = super.getMessage();
/* 80 */     if (this.a != null) {
/* 81 */       str = str + "Location   : " + this.a.eI() + " (" + this.a.eJ() + ")\n";
/*    */     }
/* 83 */     if (this.a != null) {
/* 84 */       str = str + "Line       : " + getLineNumber() + "\n";
/* 85 */       str = str + "Statement  : " + eM() + "\n";
/*    */     } 
/* 87 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\q\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */