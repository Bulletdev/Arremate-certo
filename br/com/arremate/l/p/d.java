/*    */ package br.com.arremate.l.p;
/*    */ 
/*    */ import br.com.arremate.l.g;
/*    */ import br.com.arremate.m.y;
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.List;
/*    */ import org.e.f;
/*    */ import org.e.i;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */ {
/*    */   private final List<g> A;
/*    */   
/*    */   public d(List<g> paramList) {
/* 20 */     this.A = paramList;
/*    */   }
/*    */   
/*    */   public f f() {
/* 24 */     f f = new f();
/*    */ 
/*    */ 
/*    */     
/* 28 */     DecimalFormat decimalFormat = y.a("###,###,##0.00");
/*    */     
/* 30 */     for (g g : this.A) {
/* 31 */       i i = new i();
/* 32 */       i.a("itecodigo", g.v());
/* 33 */       i.c("itenumero", g.bo());
/* 34 */       i.c("valorTotal", decimalFormat.format(g.k()));
/* 35 */       i.c("valorMinimo", decimalFormat.format(g.l()));
/* 36 */       i.c("lanceFechado", decimalFormat.format(g.t()));
/* 37 */       i.a("tipo", g.w());
/* 38 */       i.a("posicao", g.j());
/* 39 */       i.c("situacao", g.bB());
/* 40 */       i.c("ultimoLance", decimalFormat.format(g.f()));
/* 41 */       i.c("melhorLance", decimalFormat.format(g.f().m()));
/* 42 */       i.c("variacaoInicial", decimalFormat.format(g.b().f()));
/* 43 */       i.c("variacaoFinal", decimalFormat.format(g.b().g()));
/* 44 */       i.a("tipoReducao", g.b().a().y());
/* 45 */       i.b("disputaMEEPP", g.aU());
/*    */       
/* 47 */       f.a(i);
/*    */     } 
/*    */     
/* 50 */     return f;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */