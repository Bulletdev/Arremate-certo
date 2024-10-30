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
/*     */ public class OrFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable, ConditionalFileFilter
/*     */ {
/*     */   private static final long serialVersionUID = 5767770777065432721L;
/*     */   private final List<IOFileFilter> fileFilters;
/*     */   
/*     */   public OrFileFilter() {
/*  50 */     this.fileFilters = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrFileFilter(List<IOFileFilter> paramList) {
/*  61 */     if (paramList == null) {
/*  62 */       this.fileFilters = new ArrayList<>();
/*     */     } else {
/*  64 */       this.fileFilters = new ArrayList<>(paramList);
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
/*     */   public OrFileFilter(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2) {
/*  76 */     if (paramIOFileFilter1 == null || paramIOFileFilter2 == null) {
/*  77 */       throw new IllegalArgumentException("The filters must not be null");
/*     */     }
/*  79 */     this.fileFilters = new ArrayList<>(2);
/*  80 */     addFileFilter(paramIOFileFilter1);
/*  81 */     addFileFilter(paramIOFileFilter2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFileFilter(IOFileFilter paramIOFileFilter) {
/*  89 */     this.fileFilters.add(paramIOFileFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IOFileFilter> getFileFilters() {
/*  97 */     return Collections.unmodifiableList(this.fileFilters);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFileFilter(IOFileFilter paramIOFileFilter) {
/* 105 */     return this.fileFilters.remove(paramIOFileFilter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFileFilters(List<IOFileFilter> paramList) {
/* 113 */     this.fileFilters.clear();
/* 114 */     this.fileFilters.addAll(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile) {
/* 122 */     for (IOFileFilter iOFileFilter : this.fileFilters) {
/* 123 */       if (iOFileFilter.accept(paramFile)) {
/* 124 */         return true;
/*     */       }
/*     */     } 
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile, String paramString) {
/* 135 */     for (IOFileFilter iOFileFilter : this.fileFilters) {
/* 136 */       if (iOFileFilter.accept(paramFile, paramString)) {
/* 137 */         return true;
/*     */       }
/*     */     } 
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 150 */     StringBuilder stringBuilder = new StringBuilder();
/* 151 */     stringBuilder.append(super.toString());
/* 152 */     stringBuilder.append("(");
/* 153 */     if (this.fileFilters != null) {
/* 154 */       for (byte b = 0; b < this.fileFilters.size(); b++) {
/* 155 */         if (b > 0) {
/* 156 */           stringBuilder.append(",");
/*     */         }
/* 158 */         Object object = this.fileFilters.get(b);
/* 159 */         stringBuilder.append((object == null) ? "null" : object.toString());
/*     */       } 
/*     */     }
/* 162 */     stringBuilder.append(")");
/* 163 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\OrFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */