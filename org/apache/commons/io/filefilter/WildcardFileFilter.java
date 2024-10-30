/*     */ package org.apache.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.FilenameUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WildcardFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7426486598995782105L;
/*     */   private final String[] wildcards;
/*     */   private final IOCase caseSensitivity;
/*     */   
/*     */   public WildcardFileFilter(String paramString) {
/*  68 */     this(paramString, IOCase.SENSITIVE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFileFilter(String paramString, IOCase paramIOCase) {
/*  79 */     if (paramString == null) {
/*  80 */       throw new IllegalArgumentException("The wildcard must not be null");
/*     */     }
/*  82 */     this.wildcards = new String[] { paramString };
/*  83 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFileFilter(String... paramVarArgs) {
/*  94 */     this(paramVarArgs, IOCase.SENSITIVE);
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
/*     */   public WildcardFileFilter(String[] paramArrayOfString, IOCase paramIOCase) {
/* 106 */     if (paramArrayOfString == null) {
/* 107 */       throw new IllegalArgumentException("The wildcard array must not be null");
/*     */     }
/* 109 */     this.wildcards = new String[paramArrayOfString.length];
/* 110 */     System.arraycopy(paramArrayOfString, 0, this.wildcards, 0, paramArrayOfString.length);
/* 111 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WildcardFileFilter(List<String> paramList) {
/* 122 */     this(paramList, IOCase.SENSITIVE);
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
/*     */   public WildcardFileFilter(List<String> paramList, IOCase paramIOCase) {
/* 134 */     if (paramList == null) {
/* 135 */       throw new IllegalArgumentException("The wildcard list must not be null");
/*     */     }
/* 137 */     this.wildcards = paramList.<String>toArray(EMPTY_STRING_ARRAY);
/* 138 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/*     */   public boolean accept(File paramFile, String paramString) {
/* 151 */     for (String str : this.wildcards) {
/* 152 */       if (FilenameUtils.wildcardMatch(paramString, str, this.caseSensitivity)) {
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
/*     */   public boolean accept(File paramFile) {
/* 167 */     String str = paramFile.getName();
/* 168 */     for (String str1 : this.wildcards) {
/* 169 */       if (FilenameUtils.wildcardMatch(str, str1, this.caseSensitivity)) {
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
/* 186 */     if (this.wildcards != null) {
/* 187 */       for (byte b = 0; b < this.wildcards.length; b++) {
/* 188 */         if (b > 0) {
/* 189 */           stringBuilder.append(",");
/*     */         }
/* 191 */         stringBuilder.append(this.wildcards[b]);
/*     */       } 
/*     */     }
/* 194 */     stringBuilder.append(")");
/* 195 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\WildcardFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */