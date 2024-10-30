/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.collections4.Transformer;
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
/*    */ public final class MapTransformer<I, O>
/*    */   implements Serializable, Transformer<I, O>
/*    */ {
/*    */   private static final long serialVersionUID = 862391807045468939L;
/*    */   private final Map<? super I, ? extends O> iMap;
/*    */   
/*    */   public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> paramMap) {
/* 50 */     if (paramMap == null) {
/* 51 */       return ConstantTransformer.nullTransformer();
/*    */     }
/* 53 */     return new MapTransformer<I, O>(paramMap);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private MapTransformer(Map<? super I, ? extends O> paramMap) {
/* 64 */     this.iMap = paramMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public O transform(I paramI) {
/* 74 */     return this.iMap.get(paramI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<? super I, ? extends O> getMap() {
/* 84 */     return this.iMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\MapTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */