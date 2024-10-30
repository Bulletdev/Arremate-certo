/*     */ package ch.qos.logback.core.joran.spi;
/*     */ 
/*     */ import java.util.ArrayList;
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
/*     */ public class ElementPath
/*     */ {
/*  27 */   ArrayList<String> partList = new ArrayList<String>();
/*     */ 
/*     */   
/*     */   public ElementPath() {}
/*     */   
/*     */   public ElementPath(List<String> paramList) {
/*  33 */     this.partList.addAll(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ElementPath(String paramString) {
/*  42 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/*  46 */     String[] arrayOfString = paramString.split("/");
/*  47 */     if (arrayOfString == null) {
/*     */       return;
/*     */     }
/*  50 */     for (String str : arrayOfString) {
/*  51 */       if (str.length() > 0) {
/*  52 */         this.partList.add(str);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public ElementPath duplicate() {
/*  58 */     ElementPath elementPath = new ElementPath();
/*  59 */     elementPath.partList.addAll(this.partList);
/*  60 */     return elementPath;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  66 */     if (paramObject == null || !(paramObject instanceof ElementPath)) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     ElementPath elementPath = (ElementPath)paramObject;
/*     */     
/*  72 */     if (elementPath.size() != size()) {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     int i = size();
/*     */     
/*  78 */     for (byte b = 0; b < i; b++) {
/*  79 */       if (!equalityCheck(get(b), elementPath.get(b))) {
/*  80 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   private boolean equalityCheck(String paramString1, String paramString2) {
/*  89 */     return paramString1.equalsIgnoreCase(paramString2);
/*     */   }
/*     */   
/*     */   public List<String> getCopyOfPartList() {
/*  93 */     return new ArrayList<String>(this.partList);
/*     */   }
/*     */   
/*     */   public void push(String paramString) {
/*  97 */     this.partList.add(paramString);
/*     */   }
/*     */   
/*     */   public String get(int paramInt) {
/* 101 */     return this.partList.get(paramInt);
/*     */   }
/*     */   
/*     */   public void pop() {
/* 105 */     if (!this.partList.isEmpty()) {
/* 106 */       this.partList.remove(this.partList.size() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public String peekLast() {
/* 111 */     if (!this.partList.isEmpty()) {
/* 112 */       int i = this.partList.size();
/* 113 */       return this.partList.get(i - 1);
/*     */     } 
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 120 */     return this.partList.size();
/*     */   }
/*     */   
/*     */   protected String toStableString() {
/* 124 */     StringBuilder stringBuilder = new StringBuilder();
/* 125 */     for (String str : this.partList) {
/* 126 */       stringBuilder.append("[").append(str).append("]");
/*     */     }
/* 128 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     return toStableString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\ElementPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */