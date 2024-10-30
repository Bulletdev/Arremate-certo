/*     */ package org.apache.commons.text;
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
/*     */ public enum CharacterPredicates
/*     */   implements CharacterPredicate
/*     */ {
/*  34 */   LETTERS
/*     */   {
/*     */     public boolean test(int param1Int) {
/*  37 */       return Character.isLetter(param1Int);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   DIGITS
/*     */   {
/*     */     public boolean test(int param1Int) {
/*  49 */       return Character.isDigit(param1Int);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   ARABIC_NUMERALS
/*     */   {
/*     */     public boolean test(int param1Int) {
/*  61 */       return (param1Int >= 48 && param1Int <= 57);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   ASCII_LOWERCASE_LETTERS
/*     */   {
/*     */     public boolean test(int param1Int) {
/*  73 */       return (param1Int >= 97 && param1Int <= 122);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   ASCII_UPPERCASE_LETTERS
/*     */   {
/*     */     public boolean test(int param1Int) {
/*  85 */       return (param1Int >= 65 && param1Int <= 90);
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   ASCII_LETTERS
/*     */   {
/*     */     public boolean test(int param1Int) {
/*  97 */       return (ASCII_LOWERCASE_LETTERS.test(param1Int) || ASCII_UPPERCASE_LETTERS.test(param1Int));
/*     */     }
/*     */   },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   ASCII_ALPHA_NUMERALS
/*     */   {
/*     */     public boolean test(int param1Int) {
/* 109 */       return (ASCII_LOWERCASE_LETTERS.test(param1Int) || ASCII_UPPERCASE_LETTERS.test(param1Int) || ARABIC_NUMERALS
/* 110 */         .test(param1Int));
/*     */     }
/*     */   };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\CharacterPredicates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */