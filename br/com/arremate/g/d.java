/*    */ package br.com.arremate.g;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends Exception
/*    */ {
/*    */   private final long E;
/*    */   
/*    */   public d(long paramLong) {
/* 12 */     super("Tempo de espera por resposta do portal excedido");
/* 13 */     this.E = paramLong;
/*    */   }
/*    */   
/*    */   public long j() {
/* 17 */     return this.E;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\g\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */