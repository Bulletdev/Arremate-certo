/*     */ package org.apache.http.entity.mime;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
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
/*     */ public class Header
/*     */   implements Iterable<MinimalField>
/*     */ {
/*  49 */   private final List<MinimalField> fields = new LinkedList<MinimalField>();
/*  50 */   private final Map<String, List<MinimalField>> fieldMap = new HashMap<String, List<MinimalField>>();
/*     */ 
/*     */   
/*     */   public void addField(MinimalField paramMinimalField) {
/*  54 */     if (paramMinimalField == null) {
/*     */       return;
/*     */     }
/*  57 */     String str = paramMinimalField.getName().toLowerCase(Locale.ROOT);
/*  58 */     List<MinimalField> list = this.fieldMap.get(str);
/*  59 */     if (list == null) {
/*  60 */       list = new LinkedList();
/*  61 */       this.fieldMap.put(str, list);
/*     */     } 
/*  63 */     list.add(paramMinimalField);
/*  64 */     this.fields.add(paramMinimalField);
/*     */   }
/*     */   
/*     */   public List<MinimalField> getFields() {
/*  68 */     return new ArrayList<MinimalField>(this.fields);
/*     */   }
/*     */   
/*     */   public MinimalField getField(String paramString) {
/*  72 */     if (paramString == null) {
/*  73 */       return null;
/*     */     }
/*  75 */     String str = paramString.toLowerCase(Locale.ROOT);
/*  76 */     List<MinimalField> list = this.fieldMap.get(str);
/*  77 */     if (list != null && !list.isEmpty()) {
/*  78 */       return list.get(0);
/*     */     }
/*  80 */     return null;
/*     */   }
/*     */   
/*     */   public List<MinimalField> getFields(String paramString) {
/*  84 */     if (paramString == null) {
/*  85 */       return null;
/*     */     }
/*  87 */     String str = paramString.toLowerCase(Locale.ROOT);
/*  88 */     List<? extends MinimalField> list = this.fieldMap.get(str);
/*  89 */     if (list == null || list.isEmpty()) {
/*  90 */       return Collections.emptyList();
/*     */     }
/*  92 */     return new ArrayList<MinimalField>(list);
/*     */   }
/*     */ 
/*     */   
/*     */   public int removeFields(String paramString) {
/*  97 */     if (paramString == null) {
/*  98 */       return 0;
/*     */     }
/* 100 */     String str = paramString.toLowerCase(Locale.ROOT);
/* 101 */     List<?> list = this.fieldMap.remove(str);
/* 102 */     if (list == null || list.isEmpty()) {
/* 103 */       return 0;
/*     */     }
/* 105 */     this.fields.removeAll(list);
/* 106 */     return list.size();
/*     */   }
/*     */   
/*     */   public void setField(MinimalField paramMinimalField) {
/* 110 */     if (paramMinimalField == null) {
/*     */       return;
/*     */     }
/* 113 */     String str = paramMinimalField.getName().toLowerCase(Locale.ROOT);
/* 114 */     List<MinimalField> list = this.fieldMap.get(str);
/* 115 */     if (list == null || list.isEmpty()) {
/* 116 */       addField(paramMinimalField);
/*     */       return;
/*     */     } 
/* 119 */     list.clear();
/* 120 */     list.add(paramMinimalField);
/* 121 */     byte b = -1;
/* 122 */     byte b1 = 0;
/* 123 */     for (Iterator<MinimalField> iterator = this.fields.iterator(); iterator.hasNext(); b1++) {
/* 124 */       MinimalField minimalField = iterator.next();
/* 125 */       if (minimalField.getName().equalsIgnoreCase(paramMinimalField.getName())) {
/* 126 */         iterator.remove();
/* 127 */         if (b == -1) {
/* 128 */           b = b1;
/*     */         }
/*     */       } 
/*     */     } 
/* 132 */     this.fields.add(b, paramMinimalField);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<MinimalField> iterator() {
/* 137 */     return Collections.<MinimalField>unmodifiableList(this.fields).iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     return this.fields.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\mime\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */