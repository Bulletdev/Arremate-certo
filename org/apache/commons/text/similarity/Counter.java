/*    */ package org.apache.commons.text.similarity;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Counter
/*    */ {
/*    */   public static Map<CharSequence, Integer> of(CharSequence[] paramArrayOfCharSequence) {
/* 50 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 51 */     for (CharSequence charSequence : paramArrayOfCharSequence) {
/* 52 */       if (hashMap.containsKey(charSequence)) {
/* 53 */         int i = ((Integer)hashMap.get(charSequence)).intValue();
/* 54 */         hashMap.put(charSequence, Integer.valueOf(++i));
/*    */       } else {
/* 56 */         hashMap.put(charSequence, Integer.valueOf(1));
/*    */       } 
/*    */     } 
/* 59 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\similarity\Counter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */