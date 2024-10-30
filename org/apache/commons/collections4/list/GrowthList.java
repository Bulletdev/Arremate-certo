/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GrowthList<E>
/*     */   extends AbstractSerializableListDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -3620001881672L;
/*     */   
/*     */   public static <E> GrowthList<E> growthList(List<E> paramList) {
/*  70 */     return new GrowthList<E>(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GrowthList() {
/*  78 */     super(new ArrayList<E>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GrowthList(int paramInt) {
/*  88 */     super(new ArrayList<E>(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected GrowthList(List<E> paramList) {
/*  98 */     super(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/* 122 */     int i = decorated().size();
/* 123 */     if (paramInt > i) {
/* 124 */       decorated().addAll(Collections.nCopies(paramInt - i, null));
/*     */     }
/* 126 */     decorated().add(paramInt, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 151 */     int i = decorated().size();
/* 152 */     boolean bool = false;
/* 153 */     if (paramInt > i) {
/* 154 */       decorated().addAll(Collections.nCopies(paramInt - i, null));
/* 155 */       bool = true;
/*     */     } 
/* 157 */     return decorated().addAll(paramInt, paramCollection) | bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 182 */     int i = decorated().size();
/* 183 */     if (paramInt >= i) {
/* 184 */       decorated().addAll(Collections.nCopies(paramInt - i + 1, null));
/*     */     }
/* 186 */     return decorated().set(paramInt, paramE);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\GrowthList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */