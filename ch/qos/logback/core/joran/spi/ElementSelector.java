/*     */ package ch.qos.logback.core.joran.spi;
/*     */ 
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
/*     */ public class ElementSelector
/*     */   extends ElementPath
/*     */ {
/*     */   public ElementSelector() {}
/*     */   
/*     */   public ElementSelector(List<String> paramList) {
/*  35 */     super(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ElementSelector(String paramString) {
/*  45 */     super(paramString);
/*     */   }
/*     */   
/*     */   public boolean fullPathMatch(ElementPath paramElementPath) {
/*  49 */     if (paramElementPath.size() != size()) {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     int i = size();
/*  54 */     for (byte b = 0; b < i; b++) {
/*  55 */       if (!equalityCheck(get(b), paramElementPath.get(b))) {
/*  56 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTailMatchLength(ElementPath paramElementPath) {
/*  69 */     if (paramElementPath == null) {
/*  70 */       return 0;
/*     */     }
/*     */     
/*  73 */     int i = this.partList.size();
/*  74 */     int j = paramElementPath.partList.size();
/*     */ 
/*     */     
/*  77 */     if (i == 0 || j == 0) {
/*  78 */       return 0;
/*     */     }
/*     */     
/*  81 */     int k = (i <= j) ? i : j;
/*  82 */     byte b1 = 0;
/*     */ 
/*     */     
/*  85 */     for (byte b2 = 1; b2 <= k; ) {
/*  86 */       String str1 = this.partList.get(i - b2);
/*  87 */       String str2 = paramElementPath.partList.get(j - b2);
/*     */       
/*  89 */       if (equalityCheck(str1, str2)) {
/*  90 */         b1++;
/*     */         
/*     */         b2++;
/*     */       } 
/*     */     } 
/*  95 */     return b1;
/*     */   }
/*     */   
/*     */   public boolean isContainedIn(ElementPath paramElementPath) {
/*  99 */     if (paramElementPath == null) {
/* 100 */       return false;
/*     */     }
/* 102 */     return paramElementPath.toStableString().contains(toStableString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPrefixMatchLength(ElementPath paramElementPath) {
/* 111 */     if (paramElementPath == null) {
/* 112 */       return 0;
/*     */     }
/*     */     
/* 115 */     int i = this.partList.size();
/* 116 */     int j = paramElementPath.partList.size();
/*     */ 
/*     */     
/* 119 */     if (i == 0 || j == 0) {
/* 120 */       return 0;
/*     */     }
/*     */     
/* 123 */     int k = (i <= j) ? i : j;
/* 124 */     byte b1 = 0;
/*     */     
/* 126 */     for (byte b2 = 0; b2 < k; ) {
/* 127 */       String str1 = this.partList.get(b2);
/* 128 */       String str2 = paramElementPath.partList.get(b2);
/*     */       
/* 130 */       if (equalityCheck(str1, str2)) {
/* 131 */         b1++;
/*     */         
/*     */         b2++;
/*     */       } 
/*     */     } 
/*     */     
/* 137 */     return b1;
/*     */   }
/*     */   
/*     */   private boolean equalityCheck(String paramString1, String paramString2) {
/* 141 */     return paramString1.equalsIgnoreCase(paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 146 */     if (paramObject == null || !(paramObject instanceof ElementSelector)) {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     ElementSelector elementSelector = (ElementSelector)paramObject;
/*     */     
/* 152 */     if (elementSelector.size() != size()) {
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     int i = size();
/*     */     
/* 158 */     for (byte b = 0; b < i; b++) {
/* 159 */       if (!equalityCheck(get(b), elementSelector.get(b))) {
/* 160 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 165 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 170 */     int i = 0;
/* 171 */     int j = size();
/*     */     
/* 173 */     for (byte b = 0; b < j; b++)
/*     */     {
/*     */       
/* 176 */       i ^= get(b).toLowerCase().hashCode();
/*     */     }
/* 178 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\ElementSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */