/*    */ package br.com.arremate.d.e;
/*    */ 
/*    */ import br.com.arremate.j.c.e;
/*    */ import br.com.arremate.k.b.a;
/*    */ import br.com.arremate.k.b.e;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import org.e.g;
/*    */ import org.e.i;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class k
/*    */   extends j
/*    */ {
/*    */   public k(e parame, e parame1, p paramp) {
/* 16 */     super(parame, parame1, paramp);
/* 17 */     a((a)new e());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void aD() throws g {
/* 22 */     if (i().has("melhorValorGeral") && !i().isNull("melhorValorGeral")) {
/* 23 */       i i = i().j("melhorValorGeral");
/*    */       
/* 25 */       if (!i.isNull("valorInformado")) {
/* 26 */         a().l(i.getDouble("valorInformado"));
/*    */       }
/*    */     } 
/*    */     
/* 30 */     if (i().has("melhorValorFornecedor")) {
/* 31 */       a().h(i().j("melhorValorFornecedor").getDouble("valorInformado"));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean B() {
/* 37 */     return (a().l() > a().f());
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean C() {
/* 42 */     return (a().f().m() >= a().f());
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean a(double paramDouble) {
/* 47 */     return (a() != null) ? ((paramDouble < a().l())) : false;
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
/*    */   protected boolean b(double paramDouble) {
/* 59 */     return (a() != null) ? ((paramDouble <= a().l())) : false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */