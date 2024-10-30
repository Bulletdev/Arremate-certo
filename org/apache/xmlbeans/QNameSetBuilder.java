/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
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
/*     */ public class QNameSetBuilder
/*     */   implements Serializable, QNameSetSpecification
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private boolean _inverted;
/*     */   private Set _includedURIs;
/*     */   private Set _excludedQNames;
/*     */   private Set _includedQNames;
/*     */   
/*     */   public QNameSetBuilder() {
/*  44 */     this._inverted = false;
/*  45 */     this._includedURIs = new HashSet();
/*  46 */     this._excludedQNames = new HashSet();
/*  47 */     this._includedQNames = new HashSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSetBuilder(QNameSetSpecification paramQNameSetSpecification) {
/*  57 */     Set set = paramQNameSetSpecification.includedURIs();
/*  58 */     if (set != null) {
/*     */       
/*  60 */       this._inverted = false;
/*  61 */       this._includedURIs = new HashSet(set);
/*  62 */       this._excludedQNames = new HashSet(paramQNameSetSpecification.excludedQNamesInIncludedURIs());
/*  63 */       this._includedQNames = new HashSet(paramQNameSetSpecification.includedQNamesInExcludedURIs());
/*     */     }
/*     */     else {
/*     */       
/*  67 */       this._inverted = true;
/*  68 */       this._includedURIs = new HashSet(paramQNameSetSpecification.excludedURIs());
/*  69 */       this._excludedQNames = new HashSet(paramQNameSetSpecification.includedQNamesInExcludedURIs());
/*  70 */       this._includedQNames = new HashSet(paramQNameSetSpecification.excludedQNamesInIncludedURIs());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSetBuilder(Set paramSet1, Set paramSet2, Set paramSet3, Set paramSet4) {
/*  86 */     if (paramSet2 != null && paramSet1 == null) {
/*     */       
/*  88 */       this._inverted = false;
/*  89 */       this._includedURIs = new HashSet(paramSet2);
/*  90 */       this._excludedQNames = new HashSet(paramSet3);
/*  91 */       this._includedQNames = new HashSet(paramSet4);
/*     */     }
/*  93 */     else if (paramSet1 != null && paramSet2 == null) {
/*     */       
/*  95 */       this._inverted = true;
/*  96 */       this._includedURIs = new HashSet(paramSet1);
/*  97 */       this._excludedQNames = new HashSet(paramSet4);
/*  98 */       this._includedQNames = new HashSet(paramSet3);
/*     */     } else {
/*     */       
/* 101 */       throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSetBuilder(String paramString1, String paramString2) {
/* 117 */     this();
/*     */     
/* 119 */     if (paramString1 == null) {
/* 120 */       paramString1 = "##any";
/*     */     }
/* 122 */     String[] arrayOfString = splitList(paramString1);
/* 123 */     byte b = 0; while (true) { String str; if (b < arrayOfString.length)
/*     */       
/* 125 */       { str = arrayOfString[b];
/* 126 */         if (str.startsWith("##"))
/*     */         
/* 128 */         { if (str.equals("##other"))
/*     */           
/* 130 */           { if (paramString2 == null)
/* 131 */               throw new IllegalArgumentException(); 
/* 132 */             QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
/* 133 */             qNameSetBuilder.addNamespace(paramString2);
/* 134 */             qNameSetBuilder.addNamespace("");
/* 135 */             qNameSetBuilder.invert();
/* 136 */             addAll(qNameSetBuilder);
/*     */              }
/*     */           
/* 139 */           else if (str.equals("##any"))
/*     */           
/* 141 */           { clear();
/* 142 */             invert(); }
/*     */           else
/*     */           
/* 145 */           { if (arrayOfString[b].equals("##targetNamespace")) {
/*     */               
/* 147 */               if (paramString2 == null)
/* 148 */                 throw new IllegalArgumentException(); 
/* 149 */               str = paramString2;
/*     */             }
/* 151 */             else if (arrayOfString[b].equals("##local")) {
/*     */               
/* 153 */               str = "";
/*     */             } 
/*     */             
/* 156 */             addNamespace(str); }  continue; }  } else { break; }  addNamespace(str);
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String nsFromName(b paramb) {
/* 165 */     String str = paramb.getNamespaceURI();
/* 166 */     return (str == null) ? "" : str;
/*     */   }
/*     */   
/* 169 */   private static final String[] EMPTY_STRINGARRAY = new String[0];
/*     */ 
/*     */   
/*     */   private static boolean isSpace(char paramChar) {
/* 173 */     switch (paramChar) {
/*     */       
/*     */       case '\t':
/*     */       case '\n':
/*     */       case '\r':
/*     */       case ' ':
/* 179 */         return true;
/*     */     } 
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] splitList(String paramString) {
/* 187 */     if (paramString.length() == 0) {
/* 188 */       return EMPTY_STRINGARRAY;
/*     */     }
/* 190 */     ArrayList arrayList = new ArrayList();
/* 191 */     byte b1 = 0;
/* 192 */     byte b2 = 0;
/*     */     
/*     */     while (true) {
/* 195 */       if (b1 < paramString.length() && isSpace(paramString.charAt(b1))) {
/* 196 */         b1++; continue;
/* 197 */       }  if (b1 >= paramString.length())
/* 198 */         return (String[])arrayList.toArray((Object[])EMPTY_STRINGARRAY); 
/* 199 */       b2 = b1;
/* 200 */       while (b1 < paramString.length() && !isSpace(paramString.charAt(b1)))
/* 201 */         b1++; 
/* 202 */       arrayList.add(paramString.substring(b2, b1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void removeAllMatchingNs(String paramString, Set paramSet) {
/* 211 */     for (Iterator iterator = paramSet.iterator(); iterator.hasNext();) {
/*     */       
/* 213 */       if (paramString.equals(nsFromName(iterator.next()))) {
/* 214 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void removeAllMatchingFirstOnly(Set paramSet1, Set paramSet2, Set paramSet3) {
/* 224 */     for (Iterator iterator = paramSet3.iterator(); iterator.hasNext(); ) {
/*     */       
/* 226 */       String str = nsFromName(iterator.next());
/* 227 */       if (paramSet1.contains(str) && !paramSet2.contains(str)) {
/* 228 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void removeAllMatchingBoth(Set paramSet1, Set paramSet2, Set paramSet3) {
/* 238 */     for (Iterator iterator = paramSet3.iterator(); iterator.hasNext(); ) {
/*     */       
/* 240 */       String str = nsFromName(iterator.next());
/* 241 */       if (paramSet1.contains(str) && paramSet2.contains(str)) {
/* 242 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void removeAllMatchingNeither(Set paramSet1, Set paramSet2, Set paramSet3) {
/* 252 */     for (Iterator iterator = paramSet3.iterator(); iterator.hasNext(); ) {
/*     */       
/* 254 */       String str = nsFromName(iterator.next());
/* 255 */       if (!paramSet1.contains(str) && !paramSet2.contains(str)) {
/* 256 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(b paramb) {
/* 265 */     boolean bool = this._includedURIs.contains(nsFromName(paramb)) ? (!this._excludedQNames.contains(paramb)) : this._includedQNames.contains(paramb);
/*     */ 
/*     */     
/* 268 */     return this._inverted ^ bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAll() {
/* 276 */     return (this._inverted && this._includedURIs.size() == 0 && this._includedQNames.size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 284 */     return (!this._inverted && this._includedURIs.size() == 0 && this._includedQNames.size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet intersect(QNameSetSpecification paramQNameSetSpecification) {
/* 292 */     QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
/* 293 */     qNameSetBuilder.restrict(paramQNameSetSpecification);
/* 294 */     return qNameSetBuilder.toQNameSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet union(QNameSetSpecification paramQNameSetSpecification) {
/* 302 */     QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
/* 303 */     qNameSetBuilder.addAll(paramQNameSetSpecification);
/* 304 */     return qNameSetBuilder.toQNameSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet inverse() {
/* 312 */     return QNameSet.forSets(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(QNameSetSpecification paramQNameSetSpecification) {
/* 320 */     if (!this._inverted && paramQNameSetSpecification.excludedURIs() != null) {
/* 321 */       return false;
/*     */     }
/* 323 */     return inverse().isDisjoint(paramQNameSetSpecification);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDisjoint(QNameSetSpecification paramQNameSetSpecification) {
/* 331 */     if (this._inverted && paramQNameSetSpecification.excludedURIs() != null) {
/* 332 */       return false;
/*     */     }
/* 334 */     if (this._inverted) {
/* 335 */       return isDisjointImpl(paramQNameSetSpecification, this);
/*     */     }
/* 337 */     return isDisjointImpl(this, paramQNameSetSpecification);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isDisjointImpl(QNameSetSpecification paramQNameSetSpecification1, QNameSetSpecification paramQNameSetSpecification2) {
/* 342 */     Set set1 = paramQNameSetSpecification1.includedURIs();
/* 343 */     Set set2 = paramQNameSetSpecification2.includedURIs();
/* 344 */     if (set2 != null) {
/*     */       
/* 346 */       for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();) {
/*     */         
/* 348 */         if (set2.contains(iterator1.next())) {
/* 349 */           return false;
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 354 */       Set set = paramQNameSetSpecification2.excludedURIs();
/* 355 */       for (Iterator iterator1 = set1.iterator(); iterator1.hasNext();) {
/*     */         
/* 357 */         if (!set.contains(iterator1.next()))
/* 358 */           return false; 
/*     */       } 
/*     */     } 
/*     */     Iterator iterator;
/* 362 */     for (iterator = paramQNameSetSpecification1.includedQNamesInExcludedURIs().iterator(); iterator.hasNext();) {
/*     */       
/* 364 */       if (paramQNameSetSpecification2.contains(iterator.next())) {
/* 365 */         return false;
/*     */       }
/*     */     } 
/* 368 */     if (set1.size() > 0)
/* 369 */       for (iterator = paramQNameSetSpecification2.includedQNamesInExcludedURIs().iterator(); iterator.hasNext();) {
/*     */         
/* 371 */         if (paramQNameSetSpecification1.contains(iterator.next())) {
/* 372 */           return false;
/*     */         }
/*     */       }  
/* 375 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 384 */     this._inverted = false;
/* 385 */     this._includedURIs.clear();
/* 386 */     this._excludedQNames.clear();
/* 387 */     this._includedQNames.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void invert() {
/* 395 */     this._inverted = !this._inverted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(b paramb) {
/* 403 */     if (!this._inverted) {
/* 404 */       addImpl(paramb);
/*     */     } else {
/* 406 */       removeImpl(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNamespace(String paramString) {
/* 415 */     if (!this._inverted) {
/* 416 */       addNamespaceImpl(paramString);
/*     */     } else {
/* 418 */       removeNamespaceImpl(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAll(QNameSetSpecification paramQNameSetSpecification) {
/* 426 */     if (this._inverted) {
/* 427 */       removeAllImpl(paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs());
/*     */     } else {
/* 429 */       addAllImpl(paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(b paramb) {
/* 437 */     if (this._inverted) {
/* 438 */       addImpl(paramb);
/*     */     } else {
/* 440 */       removeImpl(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeNamespace(String paramString) {
/* 448 */     if (this._inverted) {
/* 449 */       addNamespaceImpl(paramString);
/*     */     } else {
/* 451 */       removeNamespaceImpl(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAll(QNameSetSpecification paramQNameSetSpecification) {
/* 459 */     if (this._inverted) {
/* 460 */       addAllImpl(paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs());
/*     */     } else {
/* 462 */       removeAllImpl(paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void restrict(QNameSetSpecification paramQNameSetSpecification) {
/* 471 */     if (this._inverted) {
/* 472 */       addAllImpl(paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs());
/*     */     } else {
/* 474 */       removeAllImpl(paramQNameSetSpecification.excludedURIs(), paramQNameSetSpecification.includedURIs(), paramQNameSetSpecification.excludedQNamesInIncludedURIs(), paramQNameSetSpecification.includedQNamesInExcludedURIs());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addImpl(b paramb) {
/* 482 */     if (this._includedURIs.contains(nsFromName(paramb))) {
/* 483 */       this._excludedQNames.remove(paramb);
/*     */     } else {
/* 485 */       this._includedQNames.add(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addNamespaceImpl(String paramString) {
/* 493 */     if (this._includedURIs.contains(paramString)) {
/*     */       
/* 495 */       removeAllMatchingNs(paramString, this._excludedQNames);
/*     */     }
/*     */     else {
/*     */       
/* 499 */       removeAllMatchingNs(paramString, this._includedQNames);
/* 500 */       this._includedURIs.add(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addAllImpl(Set paramSet1, Set paramSet2, Set paramSet3, Set paramSet4) {
/* 509 */     boolean bool = (paramSet2 != null);
/* 510 */     Set set = bool ? paramSet2 : paramSet1;
/*     */     
/* 512 */     for (null = this._excludedQNames.iterator(); null.hasNext(); ) {
/*     */       
/* 514 */       b b = null.next();
/* 515 */       String str = nsFromName(b);
/* 516 */       if (bool ^ set.contains(str) && !paramSet4.contains(b)) {
/* 517 */         null.remove();
/*     */       }
/*     */     } 
/* 520 */     for (b b : paramSet4) {
/*     */ 
/*     */       
/* 523 */       String str = nsFromName(b);
/* 524 */       if (!this._includedURIs.contains(str) && !this._includedQNames.contains(b)) {
/* 525 */         this._excludedQNames.add(b);
/*     */       }
/*     */     } 
/* 528 */     for (b b : paramSet3) {
/*     */ 
/*     */       
/* 531 */       String str = nsFromName(b);
/* 532 */       if (!this._includedURIs.contains(str)) {
/* 533 */         this._includedQNames.add(b); continue;
/*     */       } 
/* 535 */       this._excludedQNames.remove(b);
/*     */     } 
/*     */     
/* 538 */     if (!bool) {
/*     */       
/* 540 */       removeAllMatchingFirstOnly(paramSet1, this._includedURIs, this._includedQNames);
/* 541 */       this._includedURIs.addAll(paramSet1);
/*     */     }
/*     */     else {
/*     */       
/* 545 */       removeAllMatchingNeither(paramSet2, this._includedURIs, this._includedQNames);
/* 546 */       for (null = this._includedURIs.iterator(); null.hasNext(); ) {
/*     */         
/* 548 */         String str = null.next();
/* 549 */         if (!paramSet2.contains(str)) {
/* 550 */           null.remove();
/*     */         }
/*     */       } 
/* 553 */       for (String str : paramSet2) {
/*     */ 
/*     */         
/* 556 */         if (!this._includedURIs.contains(str)) {
/* 557 */           this._includedURIs.add(str); continue;
/*     */         } 
/* 559 */         this._includedURIs.remove(str);
/*     */       } 
/* 561 */       Set set1 = this._excludedQNames;
/* 562 */       this._excludedQNames = this._includedQNames;
/* 563 */       this._includedQNames = set1;
/* 564 */       this._inverted = !this._inverted;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeImpl(b paramb) {
/* 573 */     if (this._includedURIs.contains(nsFromName(paramb))) {
/* 574 */       this._excludedQNames.add(paramb);
/*     */     } else {
/* 576 */       this._includedQNames.remove(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeNamespaceImpl(String paramString) {
/* 584 */     if (this._includedURIs.contains(paramString)) {
/*     */       
/* 586 */       removeAllMatchingNs(paramString, this._excludedQNames);
/* 587 */       this._includedURIs.remove(paramString);
/*     */     }
/*     */     else {
/*     */       
/* 591 */       removeAllMatchingNs(paramString, this._includedQNames);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeAllImpl(Set paramSet1, Set paramSet2, Set paramSet3, Set paramSet4) {
/* 600 */     boolean bool = (paramSet2 != null);
/* 601 */     Set set = bool ? paramSet2 : paramSet1;
/*     */     
/* 603 */     for (null = this._includedQNames.iterator(); null.hasNext(); ) {
/*     */       
/* 605 */       b b = null.next();
/* 606 */       String str = nsFromName(b);
/* 607 */       if (bool ^ set.contains(str)) {
/*     */         
/* 609 */         if (!paramSet4.contains(b)) {
/* 610 */           null.remove();
/*     */         }
/*     */         continue;
/*     */       } 
/* 614 */       if (paramSet3.contains(b)) {
/* 615 */         null.remove();
/*     */       }
/*     */     } 
/*     */     
/* 619 */     for (b b : paramSet3) {
/*     */ 
/*     */       
/* 622 */       String str = nsFromName(b);
/* 623 */       if (this._includedURIs.contains(str)) {
/* 624 */         this._excludedQNames.add(b);
/*     */       }
/*     */     } 
/* 627 */     for (b b : paramSet4) {
/*     */ 
/*     */       
/* 630 */       String str = nsFromName(b);
/* 631 */       if (this._includedURIs.contains(str) && !this._excludedQNames.contains(b)) {
/* 632 */         this._includedQNames.add(b);
/*     */       }
/*     */     } 
/* 635 */     if (bool) {
/*     */       
/* 637 */       removeAllMatchingFirstOnly(this._includedURIs, paramSet2, this._excludedQNames);
/*     */     }
/*     */     else {
/*     */       
/* 641 */       removeAllMatchingBoth(this._includedURIs, paramSet1, this._excludedQNames);
/*     */     } 
/*     */     
/* 644 */     for (Iterator iterator = this._includedURIs.iterator(); iterator.hasNext();) {
/*     */       
/* 646 */       if (bool ^ set.contains(iterator.next())) {
/* 647 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set excludedURIs() {
/* 653 */     if (this._inverted) return Collections.unmodifiableSet(this._includedURIs); 
/* 654 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set includedURIs() {
/* 659 */     if (!this._inverted) return this._includedURIs; 
/* 660 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set excludedQNamesInIncludedURIs() {
/* 665 */     return Collections.unmodifiableSet(this._inverted ? this._includedQNames : this._excludedQNames);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set includedQNamesInExcludedURIs() {
/* 670 */     return Collections.unmodifiableSet(this._inverted ? this._excludedQNames : this._includedQNames);
/*     */   }
/*     */ 
/*     */   
/*     */   private String prettyQName(b paramb) {
/* 675 */     if (paramb.getNamespaceURI() == null)
/* 676 */       return paramb.dT(); 
/* 677 */     return paramb.dT() + "@" + paramb.getNamespaceURI();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 685 */     StringBuffer stringBuffer = new StringBuffer();
/* 686 */     stringBuffer.append("QNameSetBuilder");
/* 687 */     stringBuffer.append(this._inverted ? "-(" : "+("); Iterator iterator;
/* 688 */     for (iterator = this._includedURIs.iterator(); iterator.hasNext(); ) {
/*     */       
/* 690 */       stringBuffer.append("+*@");
/* 691 */       stringBuffer.append(iterator.next());
/* 692 */       stringBuffer.append(", ");
/*     */     } 
/* 694 */     for (iterator = this._excludedQNames.iterator(); iterator.hasNext(); ) {
/*     */       
/* 696 */       stringBuffer.append("-");
/* 697 */       stringBuffer.append(prettyQName(iterator.next()));
/* 698 */       stringBuffer.append(", ");
/*     */     } 
/* 700 */     for (iterator = this._includedQNames.iterator(); iterator.hasNext(); ) {
/*     */       
/* 702 */       stringBuffer.append("+");
/* 703 */       stringBuffer.append(prettyQName(iterator.next()));
/* 704 */       stringBuffer.append(", ");
/*     */     } 
/* 706 */     int i = stringBuffer.lastIndexOf(", ");
/* 707 */     if (i > 0)
/* 708 */       stringBuffer.setLength(i); 
/* 709 */     stringBuffer.append(')');
/* 710 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QNameSet toQNameSet() {
/* 719 */     return QNameSet.forSpecification(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\QNameSetBuilder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */