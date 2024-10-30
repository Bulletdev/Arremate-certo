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
/*     */ public class NameFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 176844364689077340L;
/*     */   private final String[] names;
/*     */   private final IOCase caseSensitivity;
/*     */   
/*     */   public NameFileFilter(String paramString) {
/*  59 */     this(paramString, (IOCase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameFileFilter(String paramString, IOCase paramIOCase) {
/*  70 */     if (paramString == null) {
/*  71 */       throw new IllegalArgumentException("The wildcard must not be null");
/*     */     }
/*  73 */     this.names = new String[] { paramString };
/*  74 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/*     */   public NameFileFilter(String... paramVarArgs) {
/*  87 */     this(paramVarArgs, (IOCase)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameFileFilter(String[] paramArrayOfString, IOCase paramIOCase) {
/*  98 */     if (paramArrayOfString == null) {
/*  99 */       throw new IllegalArgumentException("The array of names must not be null");
/*     */     }
/* 101 */     this.names = new String[paramArrayOfString.length];
/* 102 */     System.arraycopy(paramArrayOfString, 0, this.names, 0, paramArrayOfString.length);
/* 103 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameFileFilter(List<String> paramList) {
/* 114 */     this(paramList, (IOCase)null);
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
/*     */   public NameFileFilter(List<String> paramList, IOCase paramIOCase) {
/* 126 */     if (paramList == null) {
/* 127 */       throw new IllegalArgumentException("The list of names must not be null");
/*     */     }
/* 129 */     this.names = paramList.<String>toArray(EMPTY_STRING_ARRAY);
/* 130 */     this.caseSensitivity = (paramIOCase == null) ? IOCase.SENSITIVE : paramIOCase;
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
/*     */   public boolean accept(File paramFile) {
/* 142 */     String str = paramFile.getName();
/* 143 */     for (String str1 : this.names) {
/* 144 */       if (this.caseSensitivity.checkEquals(str, str1)) {
/* 145 */         return true;
/*     */       }
/*     */     } 
/* 148 */     return false;
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
/* 160 */     for (String str : this.names) {
/* 161 */       if (this.caseSensitivity.checkEquals(paramString, str)) {
/* 162 */         return true;
/*     */       }
/*     */     } 
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder stringBuilder = new StringBuilder();
/* 176 */     stringBuilder.append(super.toString());
/* 177 */     stringBuilder.append("(");
/* 178 */     if (this.names != null) {
/* 179 */       for (byte b = 0; b < this.names.length; b++) {
/* 180 */         if (b > 0) {
/* 181 */           stringBuilder.append(",");
/*     */         }
/* 183 */         stringBuilder.append(this.names[b]);
/*     */       } 
/*     */     }
/* 186 */     stringBuilder.append(")");
/* 187 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\NameFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */