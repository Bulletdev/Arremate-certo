/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.a.a.c;
/*    */ import br.com.arremate.f.q;
/*    */ import java.util.HashSet;
/*    */ import org.e.f;
/*    */ import org.e.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class n
/*    */ {
/* 15 */   private static final n a = new n();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 20 */   private final HashSet<q> b = new HashSet<>();
/*    */ 
/*    */   
/*    */   public static n a() {
/* 24 */     return a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean bP() {
/* 33 */     return ((a()).b != null);
/*    */   }
/*    */   
/*    */   public static boolean bQ() {
/* 37 */     return a.a(q.c);
/*    */   }
/*    */   
/*    */   public static boolean bR() {
/* 41 */     return a.a(q.e);
/*    */   }
/*    */   
/*    */   public static boolean bS() {
/* 45 */     return a.a(q.b);
/*    */   }
/*    */   
/*    */   public static boolean bT() {
/* 49 */     return a.a(q.d);
/*    */   }
/*    */   
/*    */   public static boolean bU() {
/* 53 */     return a.a(q.j);
/*    */   }
/*    */   
/*    */   public static boolean bV() {
/* 57 */     return a.a(q.k);
/*    */   }
/*    */   
/*    */   public static boolean aE() {
/* 61 */     if (bS()) {
/* 62 */       return true;
/*    */     }
/* 64 */     return a.a(q.a);
/*    */   }
/*    */   
/*    */   public static boolean bW() {
/* 68 */     return a.a(q.g);
/*    */   }
/*    */   
/*    */   public static boolean aF() {
/* 72 */     return (c.a().getCode() == 348);
/*    */   }
/*    */   
/*    */   public void d(f paramf) throws g {
/* 76 */     for (byte b = 0; b < paramf.length(); b++) {
/* 77 */       int i = paramf.getInt(b);
/* 78 */       q q = q.a(i);
/*    */       
/* 80 */       if (q != null) {
/* 81 */         this.b.add(q);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean a(q paramq) {
/* 95 */     if (this.b == null) {
/* 96 */       return false;
/*    */     }
/* 98 */     return this.b.contains(paramq);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */