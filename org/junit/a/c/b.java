/*    */ package org.junit.a.c;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import org.junit.c.k;
/*    */ import org.junit.runner.JUnitCore;
/*    */ import org.junit.runner.b.a;
/*    */ import org.junit.runner.j;
/*    */ import org.junit.runner.k;
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
/*    */ public class b
/*    */ {
/*    */   private k a;
/*    */   
/*    */   public static b a(Class<?> paramClass) {
/* 29 */     return a(j.a(paramClass));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static b a(j paramj) {
/* 36 */     return new b((new JUnitCore()).a(paramj));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public b(List<a> paramList) {
/* 43 */     this((new a(paramList)).a());
/*    */   }
/*    */   
/*    */   private b(k paramk) {
/* 47 */     this.a = paramk;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int be() {
/* 54 */     return this.a.bq().size();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<a> bd() {
/* 63 */     return this.a.bq();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 69 */     (new k(new PrintStream(byteArrayOutputStream))).a(this.a);
/* 70 */     return byteArrayOutputStream.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\c\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */