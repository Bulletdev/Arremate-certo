/*     */ package org.apache.xmlbeans.impl.regex;
/*     */ 
/*     */ import java.text.CharacterIterator;
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
/*     */ public class BMPattern
/*     */ {
/*     */   char[] pattern;
/*     */   int[] shiftTable;
/*     */   boolean ignoreCase;
/*     */   
/*     */   public BMPattern(String paramString, boolean paramBoolean) {
/*  29 */     this(paramString, 256, paramBoolean);
/*     */   }
/*     */   
/*     */   public BMPattern(String paramString, int paramInt, boolean paramBoolean) {
/*  33 */     this.pattern = paramString.toCharArray();
/*  34 */     this.shiftTable = new int[paramInt];
/*  35 */     this.ignoreCase = paramBoolean;
/*     */     
/*  37 */     int i = this.pattern.length; byte b;
/*  38 */     for (b = 0; b < this.shiftTable.length; b++) {
/*  39 */       this.shiftTable[b] = i;
/*     */     }
/*  41 */     for (b = 0; b < i; b++) {
/*  42 */       char c = this.pattern[b];
/*  43 */       int j = i - b - 1;
/*  44 */       int k = c % this.shiftTable.length;
/*  45 */       if (j < this.shiftTable[k])
/*  46 */         this.shiftTable[k] = j; 
/*  47 */       if (this.ignoreCase) {
/*  48 */         c = Character.toUpperCase(c);
/*  49 */         k = c % this.shiftTable.length;
/*  50 */         if (j < this.shiftTable[k])
/*  51 */           this.shiftTable[k] = j; 
/*  52 */         c = Character.toLowerCase(c);
/*  53 */         k = c % this.shiftTable.length;
/*  54 */         if (j < this.shiftTable[k]) {
/*  55 */           this.shiftTable[k] = j;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int matches(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2) {
/*  65 */     if (this.ignoreCase) return matchesIgnoreCase(paramCharacterIterator, paramInt1, paramInt2); 
/*  66 */     int i = this.pattern.length;
/*  67 */     if (i == 0) return paramInt1; 
/*  68 */     int j = paramInt1 + i;
/*  69 */     while (j <= paramInt2) {
/*  70 */       int k = i;
/*  71 */       int m = j + 1;
/*     */       
/*     */       char c;
/*  74 */       while ((c = paramCharacterIterator.setIndex(--j)) == this.pattern[--k])
/*     */       
/*  76 */       { if (k == 0)
/*  77 */           return j; 
/*  78 */         if (k <= 0)
/*  79 */           break;  }  j += this.shiftTable[c % this.shiftTable.length] + 1;
/*  80 */       if (j < m) j = m; 
/*     */     } 
/*  82 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int matches(String paramString, int paramInt1, int paramInt2) {
/*  90 */     if (this.ignoreCase) return matchesIgnoreCase(paramString, paramInt1, paramInt2); 
/*  91 */     int i = this.pattern.length;
/*  92 */     if (i == 0) return paramInt1; 
/*  93 */     int j = paramInt1 + i;
/*  94 */     while (j <= paramInt2) {
/*     */       
/*  96 */       int k = i;
/*  97 */       int m = j + 1;
/*     */       
/*     */       char c;
/* 100 */       while ((c = paramString.charAt(--j)) == this.pattern[--k])
/*     */       
/* 102 */       { if (k == 0)
/* 103 */           return j; 
/* 104 */         if (k <= 0)
/* 105 */           break;  }  j += this.shiftTable[c % this.shiftTable.length] + 1;
/* 106 */       if (j < m) j = m; 
/*     */     } 
/* 108 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int matches(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 115 */     if (this.ignoreCase) return matchesIgnoreCase(paramArrayOfchar, paramInt1, paramInt2); 
/* 116 */     int i = this.pattern.length;
/* 117 */     if (i == 0) return paramInt1; 
/* 118 */     int j = paramInt1 + i;
/* 119 */     while (j <= paramInt2) {
/*     */       
/* 121 */       int k = i;
/* 122 */       int m = j + 1;
/*     */       
/*     */       char c;
/* 125 */       while ((c = paramArrayOfchar[--j]) == this.pattern[--k])
/*     */       
/* 127 */       { if (k == 0)
/* 128 */           return j; 
/* 129 */         if (k <= 0)
/* 130 */           break;  }  j += this.shiftTable[c % this.shiftTable.length] + 1;
/* 131 */       if (j < m) j = m; 
/*     */     } 
/* 133 */     return -1;
/*     */   }
/*     */   
/*     */   int matchesIgnoreCase(CharacterIterator paramCharacterIterator, int paramInt1, int paramInt2) {
/* 137 */     int i = this.pattern.length;
/* 138 */     if (i == 0) return paramInt1; 
/* 139 */     int j = paramInt1 + i;
/* 140 */     while (j <= paramInt2) {
/* 141 */       char c; int k = i;
/* 142 */       int m = j + 1;
/*     */       
/*     */       do {
/* 145 */         char c1 = c = paramCharacterIterator.setIndex(--j);
/* 146 */         char c2 = this.pattern[--k];
/* 147 */         if (c1 != c2) {
/* 148 */           c1 = Character.toUpperCase(c1);
/* 149 */           c2 = Character.toUpperCase(c2);
/* 150 */           if (c1 != c2 && Character.toLowerCase(c1) != Character.toLowerCase(c2))
/*     */             break; 
/*     */         } 
/* 153 */         if (k == 0)
/* 154 */           return j; 
/* 155 */       } while (k > 0);
/* 156 */       j += this.shiftTable[c % this.shiftTable.length] + 1;
/* 157 */       if (j < m) j = m; 
/*     */     } 
/* 159 */     return -1;
/*     */   }
/*     */   
/*     */   int matchesIgnoreCase(String paramString, int paramInt1, int paramInt2) {
/* 163 */     int i = this.pattern.length;
/* 164 */     if (i == 0) return paramInt1; 
/* 165 */     int j = paramInt1 + i;
/* 166 */     while (j <= paramInt2) {
/* 167 */       char c; int k = i;
/* 168 */       int m = j + 1;
/*     */       
/*     */       do {
/* 171 */         char c1 = c = paramString.charAt(--j);
/* 172 */         char c2 = this.pattern[--k];
/* 173 */         if (c1 != c2) {
/* 174 */           c1 = Character.toUpperCase(c1);
/* 175 */           c2 = Character.toUpperCase(c2);
/* 176 */           if (c1 != c2 && Character.toLowerCase(c1) != Character.toLowerCase(c2))
/*     */             break; 
/*     */         } 
/* 179 */         if (k == 0)
/* 180 */           return j; 
/* 181 */       } while (k > 0);
/* 182 */       j += this.shiftTable[c % this.shiftTable.length] + 1;
/* 183 */       if (j < m) j = m; 
/*     */     } 
/* 185 */     return -1;
/*     */   }
/*     */   int matchesIgnoreCase(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 188 */     int i = this.pattern.length;
/* 189 */     if (i == 0) return paramInt1; 
/* 190 */     int j = paramInt1 + i;
/* 191 */     while (j <= paramInt2) {
/* 192 */       char c; int k = i;
/* 193 */       int m = j + 1;
/*     */       
/*     */       do {
/* 196 */         char c1 = c = paramArrayOfchar[--j];
/* 197 */         char c2 = this.pattern[--k];
/* 198 */         if (c1 != c2) {
/* 199 */           c1 = Character.toUpperCase(c1);
/* 200 */           c2 = Character.toUpperCase(c2);
/* 201 */           if (c1 != c2 && Character.toLowerCase(c1) != Character.toLowerCase(c2))
/*     */             break; 
/*     */         } 
/* 204 */         if (k == 0)
/* 205 */           return j; 
/* 206 */       } while (k > 0);
/* 207 */       j += this.shiftTable[c % this.shiftTable.length] + 1;
/* 208 */       if (j < m) j = m; 
/*     */     } 
/* 210 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\BMPattern.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */