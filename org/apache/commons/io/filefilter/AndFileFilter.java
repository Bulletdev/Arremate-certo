/*     */ package org.apache.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ public class AndFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable, ConditionalFileFilter
/*     */ {
/*     */   private static final long serialVersionUID = 7215974688563965257L;
/*     */   private final List<IOFileFilter> fileFilters;
/*     */   
/*     */   public AndFileFilter() {
/*  52 */     this.fileFilters = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AndFileFilter(List<IOFileFilter> paramList) {
/*  63 */     if (paramList == null) {
/*  64 */       this.fileFilters = new ArrayList<>();
/*     */     } else {
/*  66 */       this.fileFilters = new ArrayList<>(paramList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AndFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/*  78 */     if (paramIOFileFilter1 == null || paramIOFileFilter2 == null) {
/*  79 */       throw new IllegalArgumentException("The filters must not be null");
/*     */     }
/*  81 */     this.fileFilters = new ArrayList<>(2);
/*  82 */     addFileFilter(paramIOFileFilter1);
/*  83 */     addFileFilter(paramIOFileFilter2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFileFilter(IOFileFilter paramIOFileFilter) {
/*  91 */     this.fileFilters.add(paramIOFileFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IOFileFilter> getFileFilters() {
/*  99 */     return Collections.unmodifiableList(this.fileFilters);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFileFilter(IOFileFilter paramIOFileFilter) {
/* 107 */     return this.fileFilters.remove(paramIOFileFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileFilters(List<IOFileFilter> paramList) {
/* 115 */     this.fileFilters.clear();
/* 116 */     this.fileFilters.addAll(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile) {
/* 124 */     if (this.fileFilters.isEmpty()) {
/* 125 */       return false;
/*     */     }
/* 127 */     for (IOFileFilter iOFileFilter : this.fileFilters) {
/* 128 */       if (!iOFileFilter.accept(paramFile)) {
/* 129 */         return false;
/*     */       }
/*     */     } 
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile, String paramString) {
/* 140 */     if (this.fileFilters.isEmpty()) {
/* 141 */       return false;
/*     */     }
/* 143 */     for (IOFileFilter iOFileFilter : this.fileFilters) {
/* 144 */       if (!iOFileFilter.accept(paramFile, paramString)) {
/* 145 */         return false;
/*     */       }
/*     */     } 
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 158 */     StringBuilder stringBuilder = new StringBuilder();
/* 159 */     stringBuilder.append(super.toString());
/* 160 */     stringBuilder.append("(");
/* 161 */     if (this.fileFilters != null) {
/* 162 */       for (byte b = 0; b < this.fileFilters.size(); b++) {
/* 163 */         if (b > 0) {
/* 164 */           stringBuilder.append(",");
/*     */         }
/* 166 */         Object object = this.fileFilters.get(b);
/* 167 */         stringBuilder.append((object == null) ? "null" : object.toString());
/*     */       } 
/*     */     }
/* 170 */     stringBuilder.append(")");
/* 171 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\AndFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */