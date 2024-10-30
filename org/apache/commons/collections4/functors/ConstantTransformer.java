/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.collections4.Transformer;
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
/*     */ public class ConstantTransformer<I, O>
/*     */   implements Serializable, Transformer<I, O>
/*     */ {
/*     */   private static final long serialVersionUID = 6374440726369055124L;
/*  40 */   public static final Transformer NULL_INSTANCE = new ConstantTransformer(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final O iConstant;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <I, O> Transformer<I, O> nullTransformer() {
/*  54 */     return NULL_INSTANCE;
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
/*     */   public static <I, O> Transformer<I, O> constantTransformer(O paramO) {
/*  66 */     if (paramO == null) {
/*  67 */       return nullTransformer();
/*     */     }
/*  69 */     return new ConstantTransformer<I, O>(paramO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConstantTransformer(O paramO) {
/*  80 */     this.iConstant = paramO;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public O transform(I paramI) {
/*  90 */     return this.iConstant;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public O getConstant() {
/* 100 */     return this.iConstant;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 108 */     if (paramObject == this) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(paramObject instanceof ConstantTransformer)) {
/* 112 */       return false;
/*     */     }
/* 114 */     Object object = ((ConstantTransformer)paramObject).getConstant();
/* 115 */     return (object == getConstant() || (object != null && object.equals(getConstant())));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 123 */     int i = "ConstantTransformer".hashCode() << 2;
/* 124 */     if (getConstant() != null) {
/* 125 */       i |= getConstant().hashCode();
/*     */     }
/* 127 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ConstantTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */