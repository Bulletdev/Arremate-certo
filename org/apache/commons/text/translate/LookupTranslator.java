/*    */ package org.apache.commons.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.security.InvalidParameterException;
/*    */ import java.util.BitSet;
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
/*    */ public class LookupTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/*    */   private final Map<String, String> lookupMap;
/*    */   private final BitSet prefixSet;
/*    */   private final int shortest;
/*    */   private final int longest;
/*    */   
/*    */   public LookupTranslator(Map<CharSequence, CharSequence> paramMap) {
/* 54 */     if (paramMap == null) {
/* 55 */       throw new InvalidParameterException("lookupMap cannot be null");
/*    */     }
/* 57 */     this.lookupMap = new HashMap<>();
/* 58 */     this.prefixSet = new BitSet();
/* 59 */     int i = Integer.MAX_VALUE;
/* 60 */     int j = 0;
/*    */     
/* 62 */     for (Map.Entry<CharSequence, CharSequence> entry : paramMap.entrySet()) {
/* 63 */       this.lookupMap.put(((CharSequence)entry.getKey()).toString(), ((CharSequence)entry.getValue()).toString());
/* 64 */       this.prefixSet.set(((CharSequence)entry.getKey()).charAt(0));
/* 65 */       int k = ((CharSequence)entry.getKey()).length();
/* 66 */       if (k < i) {
/* 67 */         i = k;
/*    */       }
/* 69 */       if (k > j) {
/* 70 */         j = k;
/*    */       }
/*    */     } 
/* 73 */     this.shortest = i;
/* 74 */     this.longest = j;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 83 */     if (this.prefixSet.get(paramCharSequence.charAt(paramInt))) {
/* 84 */       int i = this.longest;
/* 85 */       if (paramInt + this.longest > paramCharSequence.length()) {
/* 86 */         i = paramCharSequence.length() - paramInt;
/*    */       }
/*    */       
/* 89 */       for (int j = i; j >= this.shortest; j--) {
/* 90 */         CharSequence charSequence = paramCharSequence.subSequence(paramInt, paramInt + j);
/* 91 */         String str = this.lookupMap.get(charSequence.toString());
/*    */         
/* 93 */         if (str != null) {
/* 94 */           paramWriter.write(str);
/* 95 */           return j;
/*    */         } 
/*    */       } 
/*    */     } 
/* 99 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\LookupTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */