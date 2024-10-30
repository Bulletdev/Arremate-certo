/*    */ package br.com.arremate.d.a;
/*    */ 
/*    */ import br.com.arremate.d.g;
/*    */ import br.com.arremate.f.g;
/*    */ import br.com.arremate.j.i;
/*    */ import br.com.arremate.l.g;
/*    */ import br.com.arremate.l.h;
/*    */ import br.com.arremate.n.n;
/*    */ import java.util.Comparator;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */   extends d
/*    */ {
/*    */   public e(br.com.arremate.l.q.b.e parame, i parami, g paramg) {
/* 24 */     super(parame, parami, paramg);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void P() {
/*    */     try {
/* 30 */       super.P();
/*    */       
/* 32 */       g g = a().a();
/* 33 */       if (g.z() <= TimeUnit.MINUTES.toMillis(2L) && a().bt()) {
/* 34 */         a().N(g.I.getValue());
/*    */       }
/*    */       
/* 37 */       if (g.as()) {
/* 38 */         long l = TimeUnit.MINUTES.toMillis(a().a().D());
/* 39 */         List<h> list = e();
/*    */         
/* 41 */         if (list != null) {
/* 42 */           List list1 = (List)list.stream().map(paramh -> paramh.b()).collect(Collectors.toList());
/* 43 */           Optional<Date> optional = list1.stream().max(Comparator.comparing(Date::getTime));
/*    */           
/* 45 */           if (optional.isPresent()) {
/* 46 */             long l1 = ((Date)optional.get()).getTime();
/*    */             
/* 48 */             long l2 = n.a().longValue() - l1;
/* 49 */             l2 = l - l2;
/*    */             
/* 51 */             if (l2 > g.z() && l2 <= l) {
/* 52 */               g.x(l2);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/* 57 */     } catch (Exception exception) {
/* 58 */       a.warn("#020");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */