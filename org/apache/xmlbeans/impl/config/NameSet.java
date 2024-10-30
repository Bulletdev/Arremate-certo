/*     */ package org.apache.xmlbeans.impl.config;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
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
/*     */ public class NameSet
/*     */ {
/*  34 */   public static NameSet EMPTY = new NameSet(true, Collections.EMPTY_SET);
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static NameSet EVERYTHING = new NameSet(false, Collections.EMPTY_SET);
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _isFinite;
/*     */ 
/*     */   
/*     */   private Set _finiteSet;
/*     */ 
/*     */ 
/*     */   
/*     */   private NameSet(boolean paramBoolean, Set paramSet) {
/*  50 */     this._isFinite = paramBoolean;
/*  51 */     this._finiteSet = paramSet;
/*     */   }
/*     */ 
/*     */   
/*     */   static NameSet newInstance(boolean paramBoolean, Set paramSet) {
/*  56 */     if (paramSet.size() == 0) {
/*  57 */       if (paramBoolean) {
/*  58 */         return EMPTY;
/*     */       }
/*  60 */       return EVERYTHING;
/*     */     } 
/*     */     
/*  63 */     HashSet hashSet = new HashSet();
/*  64 */     hashSet.addAll(paramSet);
/*  65 */     return new NameSet(paramBoolean, hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set intersectFiniteSets(Set paramSet1, Set paramSet2) {
/*  71 */     HashSet hashSet = new HashSet();
/*     */     
/*  73 */     while (paramSet1.iterator().hasNext()) {
/*     */       
/*  75 */       String str = paramSet1.iterator().next();
/*  76 */       if (paramSet2.contains(str))
/*  77 */         hashSet.add(str); 
/*     */     } 
/*  79 */     return hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameSet union(NameSet paramNameSet) {
/*  87 */     if (this._isFinite) {
/*     */       
/*  89 */       if (paramNameSet._isFinite) {
/*     */         
/*  91 */         HashSet hashSet1 = new HashSet();
/*  92 */         hashSet1.addAll(this._finiteSet);
/*  93 */         hashSet1.addAll(paramNameSet._finiteSet);
/*  94 */         return newInstance(true, hashSet1);
/*     */       } 
/*     */ 
/*     */       
/*  98 */       HashSet hashSet = new HashSet();
/*  99 */       hashSet.addAll(paramNameSet._finiteSet);
/* 100 */       hashSet.removeAll(this._finiteSet);
/* 101 */       return newInstance(false, hashSet);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 106 */     if (paramNameSet._isFinite) {
/*     */       
/* 108 */       HashSet hashSet = new HashSet();
/* 109 */       hashSet.addAll(this._finiteSet);
/* 110 */       hashSet.removeAll(paramNameSet._finiteSet);
/* 111 */       return newInstance(false, hashSet);
/*     */     } 
/*     */ 
/*     */     
/* 115 */     return newInstance(false, intersectFiniteSets(this._finiteSet, paramNameSet._finiteSet));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameSet intersect(NameSet paramNameSet) {
/* 125 */     if (this._isFinite) {
/*     */       
/* 127 */       if (paramNameSet._isFinite)
/*     */       {
/* 129 */         return newInstance(true, intersectFiniteSets(this._finiteSet, paramNameSet._finiteSet));
/*     */       }
/*     */ 
/*     */       
/* 133 */       HashSet hashSet1 = new HashSet();
/* 134 */       hashSet1.addAll(this._finiteSet);
/* 135 */       hashSet1.removeAll(paramNameSet._finiteSet);
/* 136 */       return newInstance(false, hashSet1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 141 */     if (paramNameSet._isFinite) {
/*     */       
/* 143 */       HashSet hashSet1 = new HashSet();
/* 144 */       hashSet1.addAll(paramNameSet._finiteSet);
/* 145 */       hashSet1.removeAll(this._finiteSet);
/* 146 */       return newInstance(true, hashSet1);
/*     */     } 
/*     */ 
/*     */     
/* 150 */     HashSet hashSet = new HashSet();
/* 151 */     hashSet.addAll(this._finiteSet);
/* 152 */     hashSet.addAll(paramNameSet._finiteSet);
/* 153 */     return newInstance(false, hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameSet substractFrom(NameSet paramNameSet) {
/* 164 */     return paramNameSet.substract(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameSet substract(NameSet paramNameSet) {
/* 173 */     if (this._isFinite) {
/*     */       
/* 175 */       if (paramNameSet._isFinite) {
/*     */ 
/*     */         
/* 178 */         HashSet hashSet1 = new HashSet();
/* 179 */         hashSet1.addAll(this._finiteSet);
/* 180 */         hashSet1.removeAll(paramNameSet._finiteSet);
/* 181 */         return newInstance(true, hashSet1);
/*     */       } 
/*     */ 
/*     */       
/* 185 */       return newInstance(true, intersectFiniteSets(this._finiteSet, paramNameSet._finiteSet));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 190 */     if (paramNameSet._isFinite) {
/*     */ 
/*     */       
/* 193 */       HashSet hashSet1 = new HashSet();
/* 194 */       hashSet1.addAll(this._finiteSet);
/* 195 */       hashSet1.addAll(paramNameSet._finiteSet);
/* 196 */       return newInstance(false, hashSet1);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 201 */     HashSet hashSet = new HashSet();
/* 202 */     hashSet.addAll(paramNameSet._finiteSet);
/* 203 */     hashSet.removeAll(this._finiteSet);
/* 204 */     return newInstance(true, hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameSet invert() {
/* 214 */     return newInstance(!this._isFinite, this._finiteSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/* 219 */     if (this._isFinite) {
/* 220 */       return this._finiteSet.contains(paramString);
/*     */     }
/* 222 */     return !this._finiteSet.contains(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\config\NameSet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */