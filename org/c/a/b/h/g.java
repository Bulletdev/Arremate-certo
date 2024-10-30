/*    */ package org.c.a.b.h;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.c.a.a.b.d;
/*    */ import org.c.a.a.b.h;
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
/*    */ {
/* 29 */   private final List<f> an = new ArrayList<>();
/* 30 */   private final List<h> aj = new ArrayList<>();
/* 31 */   private final List<d> ak = new ArrayList<>();
/*    */   private SQLException a;
/*    */   
/*    */   public void a(f paramf) {
/* 35 */     this.an.add(paramf);
/*    */   }
/*    */   
/*    */   public void a(h paramh) {
/* 39 */     this.aj.add(paramh);
/*    */   }
/*    */   
/*    */   public void a(d paramd) {
/* 43 */     this.ak.add(paramd);
/*    */   }
/*    */   
/*    */   public List<h> aG() {
/* 47 */     return this.aj;
/*    */   }
/*    */   
/*    */   public List<d> getErrors() {
/* 51 */     return this.ak;
/*    */   }
/*    */   
/*    */   public List<f> aZ() {
/* 55 */     return this.an;
/*    */   }
/*    */   
/*    */   public SQLException a() {
/* 59 */     return this.a;
/*    */   }
/*    */   
/*    */   public void a(SQLException paramSQLException) {
/* 63 */     this.a = paramSQLException;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\h\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */