/*    */ package junit.a;
/*    */ 
/*    */ import junit.b.i;
/*    */ import junit.b.j;
/*    */ import junit.b.m;
/*    */ import junit.b.n;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends n
/*    */ {
/*    */   private volatile int hM;
/*    */   
/*    */   public a() {}
/*    */   
/*    */   public a(Class<? extends j> paramClass) {
/* 21 */     super(paramClass);
/*    */   }
/*    */   
/*    */   public a(String paramString) {
/* 25 */     super(paramString);
/*    */   }
/*    */   
/*    */   public a(Class<? extends j> paramClass, String paramString) {
/* 29 */     super(paramClass, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(m paramm) {
/* 34 */     this.hM = 0;
/* 35 */     super.a(paramm);
/* 36 */     gX();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(i parami, m paramm) {
/* 41 */     Thread thread = new Thread(this, parami, paramm)
/*    */       {
/*    */         
/*    */         public void run()
/*    */         {
/*    */           try {
/* 47 */             this.a.a((m)this.a);
/*    */           } finally {
/* 49 */             this.a.gY();
/*    */           } 
/*    */         }
/*    */       };
/* 53 */     thread.start();
/*    */   }
/*    */   
/*    */   synchronized void gX() {
/* 57 */     while (this.hM < bg()) {
/*    */       try {
/* 59 */         wait();
/* 60 */       } catch (InterruptedException interruptedException) {
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public synchronized void gY() {
/* 67 */     this.hM++;
/* 68 */     notifyAll();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */