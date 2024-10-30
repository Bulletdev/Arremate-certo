/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class SchemaDependencies
/*     */ {
/*     */   private Map _dependencies;
/*     */   private Map _contributions;
/*     */   
/*     */   void registerDependency(String paramString1, String paramString2) {
/*  32 */     Set set = (Set)this._dependencies.get(paramString2);
/*  33 */     if (set == null) {
/*     */       
/*  35 */       set = new HashSet();
/*  36 */       this._dependencies.put(paramString2, set);
/*     */     } 
/*  38 */     set.add(paramString1);
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
/*     */   Set computeTransitiveClosure(List paramList) {
/*  51 */     ArrayList arrayList = new ArrayList(paramList);
/*  52 */     HashSet hashSet = new HashSet(paramList);
/*  53 */     for (byte b = 0; b < arrayList.size(); b++) {
/*     */       
/*  55 */       Set set = (Set)this._dependencies.get(arrayList.get(b));
/*  56 */       if (set != null)
/*     */       {
/*  58 */         for (String str : set) {
/*     */ 
/*     */           
/*  61 */           if (!hashSet.contains(str)) {
/*     */             
/*  63 */             arrayList.add(str);
/*  64 */             hashSet.add(str);
/*     */           } 
/*     */         }  } 
/*     */     } 
/*  68 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaDependencies() {
/*  73 */     this._dependencies = new HashMap();
/*  74 */     this._contributions = new HashMap();
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaDependencies(SchemaDependencies paramSchemaDependencies, Set paramSet) {
/*  79 */     this._dependencies = new HashMap();
/*  80 */     this._contributions = new HashMap();
/*  81 */     for (String str : paramSchemaDependencies._dependencies.keySet()) {
/*     */ 
/*     */       
/*  84 */       if (paramSet.contains(str))
/*     */         continue; 
/*  86 */       HashSet hashSet = new HashSet();
/*  87 */       this._dependencies.put(str, hashSet);
/*  88 */       Set set = (Set)paramSchemaDependencies._dependencies.get(str);
/*  89 */       for (String str1 : set) {
/*     */ 
/*     */         
/*  92 */         if (paramSet.contains(str1))
/*     */           continue; 
/*  94 */         hashSet.add(str1);
/*     */       } 
/*     */     } 
/*  97 */     for (String str : paramSchemaDependencies._contributions.keySet()) {
/*     */ 
/*     */       
/* 100 */       if (paramSet.contains(str))
/*     */         continue; 
/* 102 */       ArrayList arrayList = new ArrayList();
/* 103 */       this._contributions.put(str, arrayList);
/* 104 */       List list = (List)paramSchemaDependencies._contributions.get(str);
/* 105 */       for (Iterator iterator = list.iterator(); iterator.hasNext();) {
/* 106 */         arrayList.add(iterator.next());
/*     */       }
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
/*     */   void registerContribution(String paramString1, String paramString2) {
/* 119 */     List list = (List)this._contributions.get(paramString1);
/* 120 */     if (list == null) {
/*     */       
/* 122 */       list = new ArrayList();
/* 123 */       this._contributions.put(paramString1, list);
/*     */     } 
/* 125 */     list.add(paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isFileRepresented(String paramString) {
/* 130 */     for (List list : this._contributions.values()) {
/*     */ 
/*     */       
/* 133 */       if (list.contains(paramString))
/* 134 */         return true; 
/*     */     } 
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   List getFilesTouched(Set paramSet) {
/* 141 */     ArrayList arrayList = new ArrayList();
/* 142 */     for (Iterator iterator = paramSet.iterator(); iterator.hasNext();)
/*     */     {
/* 144 */       arrayList.addAll((List)this._contributions.get(iterator.next()));
/*     */     }
/* 146 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   List getNamespacesTouched(Set paramSet) {
/* 151 */     ArrayList arrayList = new ArrayList();
/* 152 */     for (String str : this._contributions.keySet()) {
/*     */ 
/*     */       
/* 155 */       List list = (List)this._contributions.get(str);
/* 156 */       for (byte b = 0; b < list.size(); b++) {
/* 157 */         if (paramSet.contains(list.get(b)))
/* 158 */           arrayList.add(str); 
/*     */       } 
/* 160 */     }  return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaDependencies.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */