/*    */ package br.com.arremate.l;
/*    */ 
/*    */ import br.com.arremate.f.o;
/*    */ import br.com.arremate.f.q;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class n
/*    */ {
/* 14 */   public static int aW = 0;
/* 15 */   public static int aX = 1;
/* 16 */   public static int aY = 2;
/*    */   
/*    */   private final o t;
/*    */   private final int ah;
/*    */   private final String aH;
/*    */   private int status;
/*    */   
/*    */   public n(int paramInt, String paramString) {
/* 24 */     this(o.a(paramInt), paramInt, paramString);
/*    */   }
/*    */   
/*    */   public n(o paramo, int paramInt, String paramString) {
/* 28 */     this.t = paramo;
/* 29 */     this.ah = paramInt;
/* 30 */     this.aH = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public o a() {
/* 39 */     return this.t;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int v() {
/* 48 */     return this.ah;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setStatus(int paramInt) {
/* 57 */     this.status = paramInt;
/*    */   }
/*    */   
/*    */   public int getStatus() {
/* 61 */     return this.status;
/*    */   }
/*    */   
/*    */   public String K() {
/* 65 */     return this.aH;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean bk() {
/* 74 */     return bl();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static boolean bl() {
/* 83 */     return br.com.arremate.m.n.a().a(q.i);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 88 */     return v() + " -> " + K();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */