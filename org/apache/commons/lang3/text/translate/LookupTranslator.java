/*    */ package org.apache.commons.lang3.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
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
/*    */ @Deprecated
/*    */ public class LookupTranslator
/*    */   extends CharSequenceTranslator
/*    */ {
/* 50 */   private final HashMap<String, String> lookupMap = new HashMap<>();
/* 51 */   private final HashSet<Character> prefixSet = new HashSet<>(); public LookupTranslator(CharSequence[]... paramVarArgs) {
/* 52 */     int i = Integer.MAX_VALUE;
/* 53 */     int j = 0;
/* 54 */     if (paramVarArgs != null) {
/* 55 */       for (CharSequence[] arrayOfCharSequence : paramVarArgs) {
/* 56 */         this.lookupMap.put(arrayOfCharSequence[0].toString(), arrayOfCharSequence[1].toString());
/* 57 */         this.prefixSet.add(Character.valueOf(arrayOfCharSequence[0].charAt(0)));
/* 58 */         int k = arrayOfCharSequence[0].length();
/* 59 */         if (k < i) {
/* 60 */           i = k;
/*    */         }
/* 62 */         if (k > j) {
/* 63 */           j = k;
/*    */         }
/*    */       } 
/*    */     }
/* 67 */     this.shortest = i;
/* 68 */     this.longest = j;
/*    */   }
/*    */ 
/*    */   
/*    */   private final int shortest;
/*    */   
/*    */   private final int longest;
/*    */   
/*    */   public int translate(CharSequence paramCharSequence, int paramInt, Writer paramWriter) throws IOException {
/* 77 */     if (this.prefixSet.contains(Character.valueOf(paramCharSequence.charAt(paramInt)))) {
/* 78 */       int i = this.longest;
/* 79 */       if (paramInt + this.longest > paramCharSequence.length()) {
/* 80 */         i = paramCharSequence.length() - paramInt;
/*    */       }
/*    */       
/* 83 */       for (int j = i; j >= this.shortest; j--) {
/* 84 */         CharSequence charSequence = paramCharSequence.subSequence(paramInt, paramInt + j);
/* 85 */         String str = this.lookupMap.get(charSequence.toString());
/*    */         
/* 87 */         if (str != null) {
/* 88 */           paramWriter.write(str);
/* 89 */           return j;
/*    */         } 
/*    */       } 
/*    */     } 
/* 93 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\text\translate\LookupTranslator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */