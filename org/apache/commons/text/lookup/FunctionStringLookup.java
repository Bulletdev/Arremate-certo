/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ import java.util.function.Function;
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
/*    */ final class FunctionStringLookup<V>
/*    */   extends AbstractStringLookup
/*    */ {
/*    */   private final Function<String, V> function;
/*    */   
/*    */   static <R> FunctionStringLookup<R> on(Function<String, R> paramFunction) {
/* 40 */     return new FunctionStringLookup<>(paramFunction);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <V> FunctionStringLookup<V> on(Map<String, V> paramMap) {
/* 51 */     return on(paramMap::get);
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
/*    */   private FunctionStringLookup(Function<String, V> paramFunction) {
/* 65 */     this.function = paramFunction;
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
/*    */   public String lookup(String paramString) {
/*    */     V v;
/* 80 */     if (this.function == null) {
/* 81 */       return null;
/*    */     }
/*    */     
/*    */     try {
/* 85 */       v = this.function.apply(paramString);
/* 86 */     } catch (SecurityException|NullPointerException|IllegalArgumentException securityException) {
/*    */ 
/*    */       
/* 89 */       return null;
/*    */     } 
/* 91 */     return Objects.toString(v, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 96 */     return super.toString() + " [function=" + this.function + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\FunctionStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */