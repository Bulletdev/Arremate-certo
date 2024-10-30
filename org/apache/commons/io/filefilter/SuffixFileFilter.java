/*     */ package org.apache.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.IOCase;
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
/*     */ public class SuffixFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3389157631240246157L;
/*     */   private final String[] suffixes;
/*     */   private final IOCase caseSensitivity;
/*     */   
/*     */   public SuffixFileFilter(String paramString) {
/*  62 */     this(paramString, IOCase.SENSITIVE);
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
/*     */   public SuffixFileFilter(String paramString, IOCase paramIOCase) {
/*  75 */     if (paramString == null) {
/*  76 */       throw new IllegalArgumentException("The suffix must not be null");
/*     */     }
/*  78 */     this.suffixes = new String[] { paramString };
/*  79 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/*     */   public SuffixFileFilter(String... paramVarArgs) {
/*  92 */     this(paramVarArgs, IOCase.SENSITIVE);
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
/*     */   public SuffixFileFilter(String[] paramArrayOfString, IOCase paramIOCase) {
/* 105 */     if (paramArrayOfString == null) {
/* 106 */       throw new IllegalArgumentException("The array of suffixes must not be null");
/*     */     }
/* 108 */     this.suffixes = new String[paramArrayOfString.length];
/* 109 */     System.arraycopy(paramArrayOfString, 0, this.suffixes, 0, paramArrayOfString.length);
/* 110 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SuffixFileFilter(List<String> paramList) {
/* 121 */     this(paramList, IOCase.SENSITIVE);
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
/*     */   public SuffixFileFilter(List<String> paramList, IOCase paramIOCase) {
/* 135 */     if (paramList == null) {
/* 136 */       throw new IllegalArgumentException("The list of suffixes must not be null");
/*     */     }
/* 138 */     this.suffixes = paramList.<String>toArray(EMPTY_STRING_ARRAY);
/* 139 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile) {
/* 150 */     String str = paramFile.getName();
/* 151 */     for (String str1 : this.suffixes) {
/* 152 */       if (this.caseSensitivity.checkEndsWith(str, str1)) {
/* 153 */         return true;
/*     */       }
/*     */     } 
/* 156 */     return false;
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
/*     */   public boolean accept(File paramFile, String paramString) {
/* 168 */     for (String str : this.suffixes) {
/* 169 */       if (this.caseSensitivity.checkEndsWith(paramString, str)) {
/* 170 */         return true;
/*     */       }
/*     */     } 
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 183 */     StringBuilder stringBuilder = new StringBuilder();
/* 184 */     stringBuilder.append(super.toString());
/* 185 */     stringBuilder.append("(");
/* 186 */     if (this.suffixes != null) {
/* 187 */       for (byte b = 0; b < this.suffixes.length; b++) {
/* 188 */         if (b > 0) {
/* 189 */           stringBuilder.append(",");
/*     */         }
/* 191 */         stringBuilder.append(this.suffixes[b]);
/*     */       } 
/*     */     }
/* 194 */     stringBuilder.append(")");
/* 195 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\SuffixFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */