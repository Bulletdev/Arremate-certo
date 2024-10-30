/*    */ package br.com.arremate.l.p;
/*    */ 
/*    */ import br.com.arremate.a.k;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.function.Predicate;
/*    */ import java.util.stream.Collectors;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class g
/*    */ {
/* 17 */   private final List<h> B = Collections.synchronizedList(new ArrayList<>());
/*    */ 
/*    */   
/*    */   public void d(h paramh) {
/* 21 */     this.B.add(0, paramh);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<h> E() {
/* 30 */     synchronized (this.B) {
/* 31 */       return (List)this.B.stream()
/* 32 */         .filter(paramh -> 
/* 33 */           (paramh != null && !paramh.bq()))
/*    */         
/* 35 */         .collect(Collectors.toList());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 41 */     return this.B.size();
/*    */   }
/*    */   
/*    */   public h a(int paramInt) {
/* 45 */     return F().get(paramInt);
/*    */   }
/*    */   
/*    */   public void clear() {
/* 49 */     this.B.clear();
/*    */   }
/*    */   
/*    */   public List<e> F() {
/* 53 */     ArrayList<?> arrayList = new ArrayList();
/*    */     
/* 55 */     synchronized (this.B) {
/* 56 */       Predicate predicate = k.b() ? (paramh -> 
/* 57 */         (paramh instanceof e && paramh.bp())) : (paramh -> paramh instanceof e);
/*    */       
/* 59 */       this.B.stream().filter(predicate)
/* 60 */         .forEachOrdered(paramh -> paramList.add((e)paramh));
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 66 */     Collections.sort(arrayList, (parame1, parame2) -> parame1.b().before(parame2.b()) ? 1 : (parame1.b().after(parame2.b()) ? -1 : 0));
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
/* 78 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */