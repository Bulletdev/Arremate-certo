/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
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
/*     */ public final class QNameSet
/*     */   implements Serializable, QNameSetSpecification
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final boolean _inverted;
/*     */   private final Set _includedURIs;
/*     */   private final Set _excludedQNames;
/*     */   private final Set _includedQNames;
/*  81 */   public static final QNameSet EMPTY = new QNameSet(null, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.EMPTY_SET);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public static final QNameSet ALL = new QNameSet(Collections.EMPTY_SET, null, Collections.EMPTY_SET, Collections.EMPTY_SET);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   public static final QNameSet LOCAL = new QNameSet(null, Collections.singleton(""), Collections.EMPTY_SET, Collections.EMPTY_SET);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   public static final QNameSet NONLOCAL = new QNameSet(Collections.singleton(""), null, Collections.EMPTY_SET, Collections.EMPTY_SET);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set minSetCopy(Set paramSet) {
/* 103 */     if (paramSet == null)
/* 104 */       return null; 
/* 105 */     if (paramSet.isEmpty())
/* 106 */       return Collections.EMPTY_SET; 
/* 107 */     if (paramSet.size() == 1)
/* 108 */       return Collections.singleton(paramSet.iterator().next()); 
/* 109 */     return new HashSet(paramSet);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static QNameSet forSets(Set paramSet1, Set paramSet2, Set paramSet3, Set paramSet4) {
/* 126 */     if (((paramSet1 != null) ? true : false) == ((paramSet2 != null) ? true : false)) {
/* 127 */       throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
/*     */     }
/* 129 */     if (paramSet1 == null && paramSet2.isEmpty() && paramSet4.isEmpty())
/* 130 */       return EMPTY; 
/* 131 */     if (paramSet2 == null && paramSet1.isEmpty() && paramSet3.isEmpty())
/* 132 */       return ALL; 
/* 133 */     if (paramSet1 == null && paramSet2.size() == 1 && paramSet2.contains("") && paramSet4.isEmpty() && paramSet3.isEmpty())
/*     */     {
/* 135 */       return LOCAL; } 
/* 136 */     if (paramSet2 == null && paramSet1.size() == 1 && paramSet1.contains("") && paramSet3.isEmpty() && paramSet4.isEmpty())
/*     */     {
/* 138 */       return NONLOCAL;
/*     */     }
/* 140 */     return new QNameSet(minSetCopy(paramSet1), minSetCopy(paramSet2), minSetCopy(paramSet3), minSetCopy(paramSet4));
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
/*     */   public static QNameSet forArray(b[] paramArrayOfb) {
/* 154 */     if (paramArrayOfb == null) {
/* 155 */       throw new IllegalArgumentException("includedQNames cannot be null");
/*     */     }
/* 157 */     return new QNameSet(null, Collections.EMPTY_SET, Collections.EMPTY_SET, new HashSet(Arrays.asList((Object[])paramArrayOfb)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static QNameSet forSpecification(QNameSetSpecification paramQNameSetSpecification) {
/* 167 */     if (paramQNameSetSpecification instanceof QNameSet)
/* 168 */       return (QNameSet)paramQNameSetSpecification; 
/* 169 */     return forSets(paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static QNameSet forWildcardNamespaceString(String paramString1, String paramString2) {
/* 180 */     return forSpecification(new QNameSetBuilder(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static QNameSet singleton(b paramb) {
/* 189 */     return new QNameSet(null, Collections.EMPTY_SET, Collections.EMPTY_SET, Collections.singleton(paramb));
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
/*     */   private QNameSet(Set paramSet1, Set paramSet2, Set paramSet3, Set paramSet4) {
/* 203 */     if (paramSet2 != null && paramSet1 == null) {
/*     */       
/* 205 */       this._inverted = false;
/* 206 */       this._includedURIs = paramSet2;
/* 207 */       this._excludedQNames = paramSet3;
/* 208 */       this._includedQNames = paramSet4;
/*     */     }
/* 210 */     else if (paramSet1 != null && paramSet2 == null) {
/*     */       
/* 212 */       this._inverted = true;
/* 213 */       this._includedURIs = paramSet1;
/* 214 */       this._excludedQNames = paramSet4;
/* 215 */       this._includedQNames = paramSet3;
/*     */     } else {
/*     */       
/* 218 */       throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String nsFromName(b paramb) {
/* 226 */     String str = paramb.getNamespaceURI();
/* 227 */     return (str == null) ? "" : str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(b paramb) {
/* 235 */     boolean bool = this._includedURIs.contains(nsFromName(paramb)) ? (!this._excludedQNames.contains(paramb)) : this._includedQNames.contains(paramb);
/*     */ 
/*     */     
/* 238 */     return this._inverted ^ bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAll() {
/* 246 */     return (this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 254 */     return (!this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet intersect(QNameSetSpecification paramQNameSetSpecification) {
/* 264 */     QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
/* 265 */     qNameSetBuilder.restrict(paramQNameSetSpecification);
/* 266 */     return qNameSetBuilder.toQNameSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet union(QNameSetSpecification paramQNameSetSpecification) {
/* 276 */     QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
/* 277 */     qNameSetBuilder.addAll(paramQNameSetSpecification);
/* 278 */     return qNameSetBuilder.toQNameSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet inverse() {
/* 286 */     if (this == EMPTY)
/* 287 */       return ALL; 
/* 288 */     if (this == ALL)
/* 289 */       return EMPTY; 
/* 290 */     if (this == LOCAL)
/* 291 */       return NONLOCAL; 
/* 292 */     if (this == NONLOCAL)
/* 293 */       return LOCAL; 
/* 294 */     return new QNameSet(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(QNameSetSpecification paramQNameSetSpecification) {
/* 305 */     if (!this._inverted && paramQNameSetSpecification.excludedURIs() != null) {
/* 306 */       return false;
/*     */     }
/* 308 */     return inverse().isDisjoint(paramQNameSetSpecification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDisjoint(QNameSetSpecification paramQNameSetSpecification) {
/* 318 */     if (this._inverted && paramQNameSetSpecification.excludedURIs() != null) {
/* 319 */       return false;
/*     */     }
/* 321 */     if (this._inverted) {
/* 322 */       return isDisjointImpl(paramQNameSetSpecification, this);
/*     */     }
/* 324 */     return isDisjointImpl(this, paramQNameSetSpecification);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isDisjointImpl(QNameSetSpecification paramQNameSetSpecification1, QNameSetSpecification paramQNameSetSpecification2) {
/* 329 */     Set set1 = paramQNameSetSpecification1.includedURIs();
/* 330 */     Set set2 = paramQNameSetSpecification2.includedURIs();
/* 331 */     if (set2 != null) {
/*     */       
/* 333 */       for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();) {
/*     */         
/* 335 */         if (set2.contains(iterator1.next())) {
/* 336 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 341 */       Set set = paramQNameSetSpecification2.excludedURIs();
/* 342 */       for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();) {
/*     */         
/* 344 */         if (!set.contains(iterator1.next()))
/* 345 */           return false; 
/*     */       } 
/*     */     } 
/*     */     Iterator iterator;
/* 349 */     for (iterator = paramQNameSetSpecification1.includedQNamesInExcludedURIs().iterator(); iterator.hasNext();) {
/*     */       
/* 351 */       if (paramQNameSetSpecification2.contains(iterator.next())) {
/* 352 */         return false;
/*     */       }
/*     */     } 
/* 355 */     if (set1.size() > 0)
/* 356 */       for (iterator = paramQNameSetSpecification2.includedQNamesInExcludedURIs().iterator(); iterator.hasNext();) {
/*     */         
/* 358 */         if (paramQNameSetSpecification1.contains(iterator.next())) {
/* 359 */           return false;
/*     */         }
/*     */       }  
/* 362 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set excludedURIs() {
/* 373 */     if (this._inverted) return Collections.unmodifiableSet(this._includedURIs); 
/* 374 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set includedURIs() {
/* 384 */     if (!this._inverted) return this._includedURIs; 
/* 385 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set excludedQNamesInIncludedURIs() {
/* 395 */     return Collections.unmodifiableSet(this._inverted ? this._includedQNames : this._excludedQNames);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set includedQNamesInExcludedURIs() {
/* 405 */     return Collections.unmodifiableSet(this._inverted ? this._excludedQNames : this._includedQNames);
/*     */   }
/*     */ 
/*     */   
/*     */   private String prettyQName(b paramb) {
/* 410 */     if (paramb.getNamespaceURI() == null)
/* 411 */       return paramb.dT(); 
/* 412 */     return paramb.dT() + "@" + paramb.getNamespaceURI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 420 */     StringBuffer stringBuffer = new StringBuffer();
/* 421 */     stringBuffer.append("QNameSet");
/* 422 */     stringBuffer.append(this._inverted ? "-(" : "+("); Iterator iterator;
/* 423 */     for (iterator = this._includedURIs.iterator(); iterator.hasNext(); ) {
/*     */       
/* 425 */       stringBuffer.append("+*@");
/* 426 */       stringBuffer.append(iterator.next());
/* 427 */       stringBuffer.append(", ");
/*     */     } 
/* 429 */     for (iterator = this._excludedQNames.iterator(); iterator.hasNext(); ) {
/*     */       
/* 431 */       stringBuffer.append("-");
/* 432 */       stringBuffer.append(prettyQName(iterator.next()));
/* 433 */       stringBuffer.append(", ");
/*     */     } 
/* 435 */     for (iterator = this._includedQNames.iterator(); iterator.hasNext(); ) {
/*     */       
/* 437 */       stringBuffer.append("+");
/* 438 */       stringBuffer.append(prettyQName(iterator.next()));
/* 439 */       stringBuffer.append(", ");
/*     */     } 
/* 441 */     int i = stringBuffer.lastIndexOf(", ");
/* 442 */     if (i > 0)
/* 443 */       stringBuffer.setLength(i); 
/* 444 */     stringBuffer.append(')');
/* 445 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\QNameSet.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */