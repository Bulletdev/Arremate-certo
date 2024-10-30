/*    */ package org.junit.runner.a;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class g
/*    */ {
/*    */   private final h a;
/*    */   
/*    */   g(h paramh) {
/* 20 */     this.a = paramh;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<c> b(Collection<c> paramCollection) throws d {
/* 30 */     List<c> list = this.a.c(Collections.unmodifiableCollection(paramCollection));
/*    */     
/* 32 */     if (!this.a.gu()) {
/* 33 */       return list;
/*    */     }
/*    */     
/* 36 */     HashSet<c> hashSet1 = new HashSet<c>(paramCollection);
/* 37 */     if (!hashSet1.containsAll(list)) {
/* 38 */       throw new d("Ordering added items");
/*    */     }
/* 40 */     HashSet<c> hashSet2 = new HashSet<c>(list);
/* 41 */     if (hashSet2.size() != list.size())
/* 42 */       throw new d("Ordering duplicated items"); 
/* 43 */     if (!hashSet2.containsAll(hashSet1)) {
/* 44 */       throw new d("Ordering removed items");
/*    */     }
/*    */     
/* 47 */     return list;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void I(Object paramObject) throws d {
/* 57 */     if (paramObject instanceof f) {
/* 58 */       f f = (f)paramObject;
/* 59 */       f.a(this);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\a\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */