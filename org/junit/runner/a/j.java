/*    */ package org.junit.runner.a;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class j
/*    */   extends h
/*    */   implements Comparator<c>
/*    */ {
/* 22 */   public static final j b = new j(new Comparator<c>() {
/*    */         public int a(c param1c1, c param1c2) {
/* 24 */           return 0;
/*    */         }
/*    */       });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final Comparator<c> comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public j(Comparator<c> paramComparator) {
/* 38 */     this.comparator = paramComparator;
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
/*    */ 
/*    */ 
/*    */   
/*    */   public void I(Object paramObject) {
/* 53 */     if (paramObject instanceof i) {
/* 54 */       i i = (i)paramObject;
/* 55 */       i.a(this);
/*    */     } 
/*    */   }
/*    */   
/*    */   public int a(c paramc1, c paramc2) {
/* 60 */     return this.comparator.compare(paramc1, paramc2);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected final List<c> c(Collection<c> paramCollection) {
/* 76 */     ArrayList<c> arrayList = new ArrayList<c>(paramCollection);
/* 77 */     Collections.sort(arrayList, this);
/* 78 */     return arrayList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean gu() {
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\a\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */