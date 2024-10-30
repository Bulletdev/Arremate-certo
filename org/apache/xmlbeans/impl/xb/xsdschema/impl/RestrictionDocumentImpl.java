/*      */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*      */ import java.util.ArrayList;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlQName;
/*      */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
/*      */ 
/*      */ public class RestrictionDocumentImpl extends XmlComplexContentImpl implements RestrictionDocument {
/*      */   public RestrictionDocumentImpl(SchemaType paramSchemaType) {
/*   20 */     super(paramSchemaType);
/*      */   }
/*      */   
/*   23 */   private static final b RESTRICTION$0 = new b("http://www.w3.org/2001/XMLSchema", "restriction");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RestrictionDocument.Restriction getRestriction() {
/*   32 */     synchronized (monitor()) {
/*      */       
/*   34 */       check_orphaned();
/*   35 */       RestrictionDocument.Restriction restriction = null;
/*   36 */       restriction = (RestrictionDocument.Restriction)get_store().find_element_user(RESTRICTION$0, 0);
/*   37 */       if (restriction == null)
/*      */       {
/*   39 */         return null;
/*      */       }
/*   41 */       return restriction;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRestriction(RestrictionDocument.Restriction paramRestriction) {
/*   50 */     synchronized (monitor()) {
/*      */       
/*   52 */       check_orphaned();
/*   53 */       RestrictionDocument.Restriction restriction = null;
/*   54 */       restriction = (RestrictionDocument.Restriction)get_store().find_element_user(RESTRICTION$0, 0);
/*   55 */       if (restriction == null)
/*      */       {
/*   57 */         restriction = (RestrictionDocument.Restriction)get_store().add_element_user(RESTRICTION$0);
/*      */       }
/*   59 */       restriction.set((XmlObject)paramRestriction);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RestrictionDocument.Restriction addNewRestriction() {
/*   68 */     synchronized (monitor()) {
/*      */       
/*   70 */       check_orphaned();
/*   71 */       RestrictionDocument.Restriction restriction = null;
/*   72 */       restriction = (RestrictionDocument.Restriction)get_store().add_element_user(RESTRICTION$0);
/*   73 */       return restriction;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class RestrictionImpl
/*      */     extends AnnotatedImpl
/*      */     implements RestrictionDocument.Restriction
/*      */   {
/*      */     public RestrictionImpl(SchemaType param1SchemaType) {
/*   86 */       super(param1SchemaType);
/*      */     }
/*      */     
/*   89 */     private static final b SIMPLETYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*      */     
/*   91 */     private static final b MINEXCLUSIVE$2 = new b("http://www.w3.org/2001/XMLSchema", "minExclusive");
/*      */     
/*   93 */     private static final b MININCLUSIVE$4 = new b("http://www.w3.org/2001/XMLSchema", "minInclusive");
/*      */     
/*   95 */     private static final b MAXEXCLUSIVE$6 = new b("http://www.w3.org/2001/XMLSchema", "maxExclusive");
/*      */     
/*   97 */     private static final b MAXINCLUSIVE$8 = new b("http://www.w3.org/2001/XMLSchema", "maxInclusive");
/*      */     
/*   99 */     private static final b TOTALDIGITS$10 = new b("http://www.w3.org/2001/XMLSchema", "totalDigits");
/*      */     
/*  101 */     private static final b FRACTIONDIGITS$12 = new b("http://www.w3.org/2001/XMLSchema", "fractionDigits");
/*      */     
/*  103 */     private static final b LENGTH$14 = new b("http://www.w3.org/2001/XMLSchema", "length");
/*      */     
/*  105 */     private static final b MINLENGTH$16 = new b("http://www.w3.org/2001/XMLSchema", "minLength");
/*      */     
/*  107 */     private static final b MAXLENGTH$18 = new b("http://www.w3.org/2001/XMLSchema", "maxLength");
/*      */     
/*  109 */     private static final b ENUMERATION$20 = new b("http://www.w3.org/2001/XMLSchema", "enumeration");
/*      */     
/*  111 */     private static final b WHITESPACE$22 = new b("http://www.w3.org/2001/XMLSchema", "whiteSpace");
/*      */     
/*  113 */     private static final b PATTERN$24 = new b("http://www.w3.org/2001/XMLSchema", "pattern");
/*      */     
/*  115 */     private static final b BASE$26 = new b("", "base");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LocalSimpleType getSimpleType() {
/*  124 */       synchronized (monitor()) {
/*      */         
/*  126 */         check_orphaned();
/*  127 */         LocalSimpleType localSimpleType = null;
/*  128 */         localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/*  129 */         if (localSimpleType == null)
/*      */         {
/*  131 */           return null;
/*      */         }
/*  133 */         return localSimpleType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetSimpleType() {
/*  142 */       synchronized (monitor()) {
/*      */         
/*  144 */         check_orphaned();
/*  145 */         return (get_store().count_elements(SIMPLETYPE$0) != 0);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setSimpleType(LocalSimpleType param1LocalSimpleType) {
/*  154 */       synchronized (monitor()) {
/*      */         
/*  156 */         check_orphaned();
/*  157 */         LocalSimpleType localSimpleType = null;
/*  158 */         localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/*  159 */         if (localSimpleType == null)
/*      */         {
/*  161 */           localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*      */         }
/*  163 */         localSimpleType.set((XmlObject)param1LocalSimpleType);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public LocalSimpleType addNewSimpleType() {
/*  172 */       synchronized (monitor()) {
/*      */         
/*  174 */         check_orphaned();
/*  175 */         LocalSimpleType localSimpleType = null;
/*  176 */         localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*  177 */         return localSimpleType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetSimpleType() {
/*  186 */       synchronized (monitor()) {
/*      */         
/*  188 */         check_orphaned();
/*  189 */         get_store().remove_element(SIMPLETYPE$0, 0);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet[] getMinExclusiveArray() {
/*  198 */       synchronized (monitor()) {
/*      */         
/*  200 */         check_orphaned();
/*  201 */         ArrayList arrayList = new ArrayList();
/*  202 */         get_store().find_all_element_users(MINEXCLUSIVE$2, arrayList);
/*  203 */         Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  204 */         arrayList.toArray((Object[])arrayOfFacet);
/*  205 */         return arrayOfFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet getMinExclusiveArray(int param1Int) {
/*  214 */       synchronized (monitor()) {
/*      */         
/*  216 */         check_orphaned();
/*  217 */         Facet facet = null;
/*  218 */         facet = (Facet)get_store().find_element_user(MINEXCLUSIVE$2, param1Int);
/*  219 */         if (facet == null)
/*      */         {
/*  221 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  223 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfMinExclusiveArray() {
/*  232 */       synchronized (monitor()) {
/*      */         
/*  234 */         check_orphaned();
/*  235 */         return get_store().count_elements(MINEXCLUSIVE$2);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMinExclusiveArray(Facet[] param1ArrayOfFacet) {
/*  244 */       synchronized (monitor()) {
/*      */         
/*  246 */         check_orphaned();
/*  247 */         arraySetterHelper((XmlObject[])param1ArrayOfFacet, MINEXCLUSIVE$2);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMinExclusiveArray(int param1Int, Facet param1Facet) {
/*  256 */       synchronized (monitor()) {
/*      */         
/*  258 */         check_orphaned();
/*  259 */         Facet facet = null;
/*  260 */         facet = (Facet)get_store().find_element_user(MINEXCLUSIVE$2, param1Int);
/*  261 */         if (facet == null)
/*      */         {
/*  263 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  265 */         facet.set((XmlObject)param1Facet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet insertNewMinExclusive(int param1Int) {
/*  274 */       synchronized (monitor()) {
/*      */         
/*  276 */         check_orphaned();
/*  277 */         Facet facet = null;
/*  278 */         facet = (Facet)get_store().insert_element_user(MINEXCLUSIVE$2, param1Int);
/*  279 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet addNewMinExclusive() {
/*  288 */       synchronized (monitor()) {
/*      */         
/*  290 */         check_orphaned();
/*  291 */         Facet facet = null;
/*  292 */         facet = (Facet)get_store().add_element_user(MINEXCLUSIVE$2);
/*  293 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeMinExclusive(int param1Int) {
/*  302 */       synchronized (monitor()) {
/*      */         
/*  304 */         check_orphaned();
/*  305 */         get_store().remove_element(MINEXCLUSIVE$2, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet[] getMinInclusiveArray() {
/*  314 */       synchronized (monitor()) {
/*      */         
/*  316 */         check_orphaned();
/*  317 */         ArrayList arrayList = new ArrayList();
/*  318 */         get_store().find_all_element_users(MININCLUSIVE$4, arrayList);
/*  319 */         Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  320 */         arrayList.toArray((Object[])arrayOfFacet);
/*  321 */         return arrayOfFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet getMinInclusiveArray(int param1Int) {
/*  330 */       synchronized (monitor()) {
/*      */         
/*  332 */         check_orphaned();
/*  333 */         Facet facet = null;
/*  334 */         facet = (Facet)get_store().find_element_user(MININCLUSIVE$4, param1Int);
/*  335 */         if (facet == null)
/*      */         {
/*  337 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  339 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfMinInclusiveArray() {
/*  348 */       synchronized (monitor()) {
/*      */         
/*  350 */         check_orphaned();
/*  351 */         return get_store().count_elements(MININCLUSIVE$4);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMinInclusiveArray(Facet[] param1ArrayOfFacet) {
/*  360 */       synchronized (monitor()) {
/*      */         
/*  362 */         check_orphaned();
/*  363 */         arraySetterHelper((XmlObject[])param1ArrayOfFacet, MININCLUSIVE$4);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMinInclusiveArray(int param1Int, Facet param1Facet) {
/*  372 */       synchronized (monitor()) {
/*      */         
/*  374 */         check_orphaned();
/*  375 */         Facet facet = null;
/*  376 */         facet = (Facet)get_store().find_element_user(MININCLUSIVE$4, param1Int);
/*  377 */         if (facet == null)
/*      */         {
/*  379 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  381 */         facet.set((XmlObject)param1Facet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet insertNewMinInclusive(int param1Int) {
/*  390 */       synchronized (monitor()) {
/*      */         
/*  392 */         check_orphaned();
/*  393 */         Facet facet = null;
/*  394 */         facet = (Facet)get_store().insert_element_user(MININCLUSIVE$4, param1Int);
/*  395 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet addNewMinInclusive() {
/*  404 */       synchronized (monitor()) {
/*      */         
/*  406 */         check_orphaned();
/*  407 */         Facet facet = null;
/*  408 */         facet = (Facet)get_store().add_element_user(MININCLUSIVE$4);
/*  409 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeMinInclusive(int param1Int) {
/*  418 */       synchronized (monitor()) {
/*      */         
/*  420 */         check_orphaned();
/*  421 */         get_store().remove_element(MININCLUSIVE$4, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet[] getMaxExclusiveArray() {
/*  430 */       synchronized (monitor()) {
/*      */         
/*  432 */         check_orphaned();
/*  433 */         ArrayList arrayList = new ArrayList();
/*  434 */         get_store().find_all_element_users(MAXEXCLUSIVE$6, arrayList);
/*  435 */         Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  436 */         arrayList.toArray((Object[])arrayOfFacet);
/*  437 */         return arrayOfFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet getMaxExclusiveArray(int param1Int) {
/*  446 */       synchronized (monitor()) {
/*      */         
/*  448 */         check_orphaned();
/*  449 */         Facet facet = null;
/*  450 */         facet = (Facet)get_store().find_element_user(MAXEXCLUSIVE$6, param1Int);
/*  451 */         if (facet == null)
/*      */         {
/*  453 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  455 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfMaxExclusiveArray() {
/*  464 */       synchronized (monitor()) {
/*      */         
/*  466 */         check_orphaned();
/*  467 */         return get_store().count_elements(MAXEXCLUSIVE$6);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMaxExclusiveArray(Facet[] param1ArrayOfFacet) {
/*  476 */       synchronized (monitor()) {
/*      */         
/*  478 */         check_orphaned();
/*  479 */         arraySetterHelper((XmlObject[])param1ArrayOfFacet, MAXEXCLUSIVE$6);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMaxExclusiveArray(int param1Int, Facet param1Facet) {
/*  488 */       synchronized (monitor()) {
/*      */         
/*  490 */         check_orphaned();
/*  491 */         Facet facet = null;
/*  492 */         facet = (Facet)get_store().find_element_user(MAXEXCLUSIVE$6, param1Int);
/*  493 */         if (facet == null)
/*      */         {
/*  495 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  497 */         facet.set((XmlObject)param1Facet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet insertNewMaxExclusive(int param1Int) {
/*  506 */       synchronized (monitor()) {
/*      */         
/*  508 */         check_orphaned();
/*  509 */         Facet facet = null;
/*  510 */         facet = (Facet)get_store().insert_element_user(MAXEXCLUSIVE$6, param1Int);
/*  511 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet addNewMaxExclusive() {
/*  520 */       synchronized (monitor()) {
/*      */         
/*  522 */         check_orphaned();
/*  523 */         Facet facet = null;
/*  524 */         facet = (Facet)get_store().add_element_user(MAXEXCLUSIVE$6);
/*  525 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeMaxExclusive(int param1Int) {
/*  534 */       synchronized (monitor()) {
/*      */         
/*  536 */         check_orphaned();
/*  537 */         get_store().remove_element(MAXEXCLUSIVE$6, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet[] getMaxInclusiveArray() {
/*  546 */       synchronized (monitor()) {
/*      */         
/*  548 */         check_orphaned();
/*  549 */         ArrayList arrayList = new ArrayList();
/*  550 */         get_store().find_all_element_users(MAXINCLUSIVE$8, arrayList);
/*  551 */         Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  552 */         arrayList.toArray((Object[])arrayOfFacet);
/*  553 */         return arrayOfFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet getMaxInclusiveArray(int param1Int) {
/*  562 */       synchronized (monitor()) {
/*      */         
/*  564 */         check_orphaned();
/*  565 */         Facet facet = null;
/*  566 */         facet = (Facet)get_store().find_element_user(MAXINCLUSIVE$8, param1Int);
/*  567 */         if (facet == null)
/*      */         {
/*  569 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  571 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfMaxInclusiveArray() {
/*  580 */       synchronized (monitor()) {
/*      */         
/*  582 */         check_orphaned();
/*  583 */         return get_store().count_elements(MAXINCLUSIVE$8);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMaxInclusiveArray(Facet[] param1ArrayOfFacet) {
/*  592 */       synchronized (monitor()) {
/*      */         
/*  594 */         check_orphaned();
/*  595 */         arraySetterHelper((XmlObject[])param1ArrayOfFacet, MAXINCLUSIVE$8);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMaxInclusiveArray(int param1Int, Facet param1Facet) {
/*  604 */       synchronized (monitor()) {
/*      */         
/*  606 */         check_orphaned();
/*  607 */         Facet facet = null;
/*  608 */         facet = (Facet)get_store().find_element_user(MAXINCLUSIVE$8, param1Int);
/*  609 */         if (facet == null)
/*      */         {
/*  611 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  613 */         facet.set((XmlObject)param1Facet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet insertNewMaxInclusive(int param1Int) {
/*  622 */       synchronized (monitor()) {
/*      */         
/*  624 */         check_orphaned();
/*  625 */         Facet facet = null;
/*  626 */         facet = (Facet)get_store().insert_element_user(MAXINCLUSIVE$8, param1Int);
/*  627 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Facet addNewMaxInclusive() {
/*  636 */       synchronized (monitor()) {
/*      */         
/*  638 */         check_orphaned();
/*  639 */         Facet facet = null;
/*  640 */         facet = (Facet)get_store().add_element_user(MAXINCLUSIVE$8);
/*  641 */         return facet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeMaxInclusive(int param1Int) {
/*  650 */       synchronized (monitor()) {
/*      */         
/*  652 */         check_orphaned();
/*  653 */         get_store().remove_element(MAXINCLUSIVE$8, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
/*  662 */       synchronized (monitor()) {
/*      */         
/*  664 */         check_orphaned();
/*  665 */         ArrayList arrayList = new ArrayList();
/*  666 */         get_store().find_all_element_users(TOTALDIGITS$10, arrayList);
/*  667 */         TotalDigitsDocument.TotalDigits[] arrayOfTotalDigits = new TotalDigitsDocument.TotalDigits[arrayList.size()];
/*  668 */         arrayList.toArray((Object[])arrayOfTotalDigits);
/*  669 */         return arrayOfTotalDigits;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int param1Int) {
/*  678 */       synchronized (monitor()) {
/*      */         
/*  680 */         check_orphaned();
/*  681 */         TotalDigitsDocument.TotalDigits totalDigits = null;
/*  682 */         totalDigits = (TotalDigitsDocument.TotalDigits)get_store().find_element_user(TOTALDIGITS$10, param1Int);
/*  683 */         if (totalDigits == null)
/*      */         {
/*  685 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  687 */         return totalDigits;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfTotalDigitsArray() {
/*  696 */       synchronized (monitor()) {
/*      */         
/*  698 */         check_orphaned();
/*  699 */         return get_store().count_elements(TOTALDIGITS$10);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] param1ArrayOfTotalDigits) {
/*  708 */       synchronized (monitor()) {
/*      */         
/*  710 */         check_orphaned();
/*  711 */         arraySetterHelper((XmlObject[])param1ArrayOfTotalDigits, TOTALDIGITS$10);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setTotalDigitsArray(int param1Int, TotalDigitsDocument.TotalDigits param1TotalDigits) {
/*  720 */       synchronized (monitor()) {
/*      */         
/*  722 */         check_orphaned();
/*  723 */         TotalDigitsDocument.TotalDigits totalDigits = null;
/*  724 */         totalDigits = (TotalDigitsDocument.TotalDigits)get_store().find_element_user(TOTALDIGITS$10, param1Int);
/*  725 */         if (totalDigits == null)
/*      */         {
/*  727 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  729 */         totalDigits.set((XmlObject)param1TotalDigits);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int param1Int) {
/*  738 */       synchronized (monitor()) {
/*      */         
/*  740 */         check_orphaned();
/*  741 */         TotalDigitsDocument.TotalDigits totalDigits = null;
/*  742 */         totalDigits = (TotalDigitsDocument.TotalDigits)get_store().insert_element_user(TOTALDIGITS$10, param1Int);
/*  743 */         return totalDigits;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
/*  752 */       synchronized (monitor()) {
/*      */         
/*  754 */         check_orphaned();
/*  755 */         TotalDigitsDocument.TotalDigits totalDigits = null;
/*  756 */         totalDigits = (TotalDigitsDocument.TotalDigits)get_store().add_element_user(TOTALDIGITS$10);
/*  757 */         return totalDigits;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeTotalDigits(int param1Int) {
/*  766 */       synchronized (monitor()) {
/*      */         
/*  768 */         check_orphaned();
/*  769 */         get_store().remove_element(TOTALDIGITS$10, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet[] getFractionDigitsArray() {
/*  778 */       synchronized (monitor()) {
/*      */         
/*  780 */         check_orphaned();
/*  781 */         ArrayList arrayList = new ArrayList();
/*  782 */         get_store().find_all_element_users(FRACTIONDIGITS$12, arrayList);
/*  783 */         NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/*  784 */         arrayList.toArray((Object[])arrayOfNumFacet);
/*  785 */         return arrayOfNumFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet getFractionDigitsArray(int param1Int) {
/*  794 */       synchronized (monitor()) {
/*      */         
/*  796 */         check_orphaned();
/*  797 */         NumFacet numFacet = null;
/*  798 */         numFacet = (NumFacet)get_store().find_element_user(FRACTIONDIGITS$12, param1Int);
/*  799 */         if (numFacet == null)
/*      */         {
/*  801 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  803 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfFractionDigitsArray() {
/*  812 */       synchronized (monitor()) {
/*      */         
/*  814 */         check_orphaned();
/*  815 */         return get_store().count_elements(FRACTIONDIGITS$12);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setFractionDigitsArray(NumFacet[] param1ArrayOfNumFacet) {
/*  824 */       synchronized (monitor()) {
/*      */         
/*  826 */         check_orphaned();
/*  827 */         arraySetterHelper((XmlObject[])param1ArrayOfNumFacet, FRACTIONDIGITS$12);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setFractionDigitsArray(int param1Int, NumFacet param1NumFacet) {
/*  836 */       synchronized (monitor()) {
/*      */         
/*  838 */         check_orphaned();
/*  839 */         NumFacet numFacet = null;
/*  840 */         numFacet = (NumFacet)get_store().find_element_user(FRACTIONDIGITS$12, param1Int);
/*  841 */         if (numFacet == null)
/*      */         {
/*  843 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  845 */         numFacet.set((XmlObject)param1NumFacet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet insertNewFractionDigits(int param1Int) {
/*  854 */       synchronized (monitor()) {
/*      */         
/*  856 */         check_orphaned();
/*  857 */         NumFacet numFacet = null;
/*  858 */         numFacet = (NumFacet)get_store().insert_element_user(FRACTIONDIGITS$12, param1Int);
/*  859 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet addNewFractionDigits() {
/*  868 */       synchronized (monitor()) {
/*      */         
/*  870 */         check_orphaned();
/*  871 */         NumFacet numFacet = null;
/*  872 */         numFacet = (NumFacet)get_store().add_element_user(FRACTIONDIGITS$12);
/*  873 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeFractionDigits(int param1Int) {
/*  882 */       synchronized (monitor()) {
/*      */         
/*  884 */         check_orphaned();
/*  885 */         get_store().remove_element(FRACTIONDIGITS$12, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet[] getLengthArray() {
/*  894 */       synchronized (monitor()) {
/*      */         
/*  896 */         check_orphaned();
/*  897 */         ArrayList arrayList = new ArrayList();
/*  898 */         get_store().find_all_element_users(LENGTH$14, arrayList);
/*  899 */         NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/*  900 */         arrayList.toArray((Object[])arrayOfNumFacet);
/*  901 */         return arrayOfNumFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet getLengthArray(int param1Int) {
/*  910 */       synchronized (monitor()) {
/*      */         
/*  912 */         check_orphaned();
/*  913 */         NumFacet numFacet = null;
/*  914 */         numFacet = (NumFacet)get_store().find_element_user(LENGTH$14, param1Int);
/*  915 */         if (numFacet == null)
/*      */         {
/*  917 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  919 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfLengthArray() {
/*  928 */       synchronized (monitor()) {
/*      */         
/*  930 */         check_orphaned();
/*  931 */         return get_store().count_elements(LENGTH$14);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setLengthArray(NumFacet[] param1ArrayOfNumFacet) {
/*  940 */       synchronized (monitor()) {
/*      */         
/*  942 */         check_orphaned();
/*  943 */         arraySetterHelper((XmlObject[])param1ArrayOfNumFacet, LENGTH$14);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setLengthArray(int param1Int, NumFacet param1NumFacet) {
/*  952 */       synchronized (monitor()) {
/*      */         
/*  954 */         check_orphaned();
/*  955 */         NumFacet numFacet = null;
/*  956 */         numFacet = (NumFacet)get_store().find_element_user(LENGTH$14, param1Int);
/*  957 */         if (numFacet == null)
/*      */         {
/*  959 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  961 */         numFacet.set((XmlObject)param1NumFacet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet insertNewLength(int param1Int) {
/*  970 */       synchronized (monitor()) {
/*      */         
/*  972 */         check_orphaned();
/*  973 */         NumFacet numFacet = null;
/*  974 */         numFacet = (NumFacet)get_store().insert_element_user(LENGTH$14, param1Int);
/*  975 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet addNewLength() {
/*  984 */       synchronized (monitor()) {
/*      */         
/*  986 */         check_orphaned();
/*  987 */         NumFacet numFacet = null;
/*  988 */         numFacet = (NumFacet)get_store().add_element_user(LENGTH$14);
/*  989 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeLength(int param1Int) {
/*  998 */       synchronized (monitor()) {
/*      */         
/* 1000 */         check_orphaned();
/* 1001 */         get_store().remove_element(LENGTH$14, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet[] getMinLengthArray() {
/* 1010 */       synchronized (monitor()) {
/*      */         
/* 1012 */         check_orphaned();
/* 1013 */         ArrayList arrayList = new ArrayList();
/* 1014 */         get_store().find_all_element_users(MINLENGTH$16, arrayList);
/* 1015 */         NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/* 1016 */         arrayList.toArray((Object[])arrayOfNumFacet);
/* 1017 */         return arrayOfNumFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet getMinLengthArray(int param1Int) {
/* 1026 */       synchronized (monitor()) {
/*      */         
/* 1028 */         check_orphaned();
/* 1029 */         NumFacet numFacet = null;
/* 1030 */         numFacet = (NumFacet)get_store().find_element_user(MINLENGTH$16, param1Int);
/* 1031 */         if (numFacet == null)
/*      */         {
/* 1033 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1035 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfMinLengthArray() {
/* 1044 */       synchronized (monitor()) {
/*      */         
/* 1046 */         check_orphaned();
/* 1047 */         return get_store().count_elements(MINLENGTH$16);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMinLengthArray(NumFacet[] param1ArrayOfNumFacet) {
/* 1056 */       synchronized (monitor()) {
/*      */         
/* 1058 */         check_orphaned();
/* 1059 */         arraySetterHelper((XmlObject[])param1ArrayOfNumFacet, MINLENGTH$16);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMinLengthArray(int param1Int, NumFacet param1NumFacet) {
/* 1068 */       synchronized (monitor()) {
/*      */         
/* 1070 */         check_orphaned();
/* 1071 */         NumFacet numFacet = null;
/* 1072 */         numFacet = (NumFacet)get_store().find_element_user(MINLENGTH$16, param1Int);
/* 1073 */         if (numFacet == null)
/*      */         {
/* 1075 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1077 */         numFacet.set((XmlObject)param1NumFacet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet insertNewMinLength(int param1Int) {
/* 1086 */       synchronized (monitor()) {
/*      */         
/* 1088 */         check_orphaned();
/* 1089 */         NumFacet numFacet = null;
/* 1090 */         numFacet = (NumFacet)get_store().insert_element_user(MINLENGTH$16, param1Int);
/* 1091 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet addNewMinLength() {
/* 1100 */       synchronized (monitor()) {
/*      */         
/* 1102 */         check_orphaned();
/* 1103 */         NumFacet numFacet = null;
/* 1104 */         numFacet = (NumFacet)get_store().add_element_user(MINLENGTH$16);
/* 1105 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeMinLength(int param1Int) {
/* 1114 */       synchronized (monitor()) {
/*      */         
/* 1116 */         check_orphaned();
/* 1117 */         get_store().remove_element(MINLENGTH$16, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet[] getMaxLengthArray() {
/* 1126 */       synchronized (monitor()) {
/*      */         
/* 1128 */         check_orphaned();
/* 1129 */         ArrayList arrayList = new ArrayList();
/* 1130 */         get_store().find_all_element_users(MAXLENGTH$18, arrayList);
/* 1131 */         NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/* 1132 */         arrayList.toArray((Object[])arrayOfNumFacet);
/* 1133 */         return arrayOfNumFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet getMaxLengthArray(int param1Int) {
/* 1142 */       synchronized (monitor()) {
/*      */         
/* 1144 */         check_orphaned();
/* 1145 */         NumFacet numFacet = null;
/* 1146 */         numFacet = (NumFacet)get_store().find_element_user(MAXLENGTH$18, param1Int);
/* 1147 */         if (numFacet == null)
/*      */         {
/* 1149 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1151 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfMaxLengthArray() {
/* 1160 */       synchronized (monitor()) {
/*      */         
/* 1162 */         check_orphaned();
/* 1163 */         return get_store().count_elements(MAXLENGTH$18);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMaxLengthArray(NumFacet[] param1ArrayOfNumFacet) {
/* 1172 */       synchronized (monitor()) {
/*      */         
/* 1174 */         check_orphaned();
/* 1175 */         arraySetterHelper((XmlObject[])param1ArrayOfNumFacet, MAXLENGTH$18);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setMaxLengthArray(int param1Int, NumFacet param1NumFacet) {
/* 1184 */       synchronized (monitor()) {
/*      */         
/* 1186 */         check_orphaned();
/* 1187 */         NumFacet numFacet = null;
/* 1188 */         numFacet = (NumFacet)get_store().find_element_user(MAXLENGTH$18, param1Int);
/* 1189 */         if (numFacet == null)
/*      */         {
/* 1191 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1193 */         numFacet.set((XmlObject)param1NumFacet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet insertNewMaxLength(int param1Int) {
/* 1202 */       synchronized (monitor()) {
/*      */         
/* 1204 */         check_orphaned();
/* 1205 */         NumFacet numFacet = null;
/* 1206 */         numFacet = (NumFacet)get_store().insert_element_user(MAXLENGTH$18, param1Int);
/* 1207 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NumFacet addNewMaxLength() {
/* 1216 */       synchronized (monitor()) {
/*      */         
/* 1218 */         check_orphaned();
/* 1219 */         NumFacet numFacet = null;
/* 1220 */         numFacet = (NumFacet)get_store().add_element_user(MAXLENGTH$18);
/* 1221 */         return numFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeMaxLength(int param1Int) {
/* 1230 */       synchronized (monitor()) {
/*      */         
/* 1232 */         check_orphaned();
/* 1233 */         get_store().remove_element(MAXLENGTH$18, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NoFixedFacet[] getEnumerationArray() {
/* 1242 */       synchronized (monitor()) {
/*      */         
/* 1244 */         check_orphaned();
/* 1245 */         ArrayList arrayList = new ArrayList();
/* 1246 */         get_store().find_all_element_users(ENUMERATION$20, arrayList);
/* 1247 */         NoFixedFacet[] arrayOfNoFixedFacet = new NoFixedFacet[arrayList.size()];
/* 1248 */         arrayList.toArray((Object[])arrayOfNoFixedFacet);
/* 1249 */         return arrayOfNoFixedFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NoFixedFacet getEnumerationArray(int param1Int) {
/* 1258 */       synchronized (monitor()) {
/*      */         
/* 1260 */         check_orphaned();
/* 1261 */         NoFixedFacet noFixedFacet = null;
/* 1262 */         noFixedFacet = (NoFixedFacet)get_store().find_element_user(ENUMERATION$20, param1Int);
/* 1263 */         if (noFixedFacet == null)
/*      */         {
/* 1265 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1267 */         return noFixedFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfEnumerationArray() {
/* 1276 */       synchronized (monitor()) {
/*      */         
/* 1278 */         check_orphaned();
/* 1279 */         return get_store().count_elements(ENUMERATION$20);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setEnumerationArray(NoFixedFacet[] param1ArrayOfNoFixedFacet) {
/* 1288 */       synchronized (monitor()) {
/*      */         
/* 1290 */         check_orphaned();
/* 1291 */         arraySetterHelper((XmlObject[])param1ArrayOfNoFixedFacet, ENUMERATION$20);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setEnumerationArray(int param1Int, NoFixedFacet param1NoFixedFacet) {
/* 1300 */       synchronized (monitor()) {
/*      */         
/* 1302 */         check_orphaned();
/* 1303 */         NoFixedFacet noFixedFacet = null;
/* 1304 */         noFixedFacet = (NoFixedFacet)get_store().find_element_user(ENUMERATION$20, param1Int);
/* 1305 */         if (noFixedFacet == null)
/*      */         {
/* 1307 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1309 */         noFixedFacet.set((XmlObject)param1NoFixedFacet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NoFixedFacet insertNewEnumeration(int param1Int) {
/* 1318 */       synchronized (monitor()) {
/*      */         
/* 1320 */         check_orphaned();
/* 1321 */         NoFixedFacet noFixedFacet = null;
/* 1322 */         noFixedFacet = (NoFixedFacet)get_store().insert_element_user(ENUMERATION$20, param1Int);
/* 1323 */         return noFixedFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NoFixedFacet addNewEnumeration() {
/* 1332 */       synchronized (monitor()) {
/*      */         
/* 1334 */         check_orphaned();
/* 1335 */         NoFixedFacet noFixedFacet = null;
/* 1336 */         noFixedFacet = (NoFixedFacet)get_store().add_element_user(ENUMERATION$20);
/* 1337 */         return noFixedFacet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeEnumeration(int param1Int) {
/* 1346 */       synchronized (monitor()) {
/*      */         
/* 1348 */         check_orphaned();
/* 1349 */         get_store().remove_element(ENUMERATION$20, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
/* 1358 */       synchronized (monitor()) {
/*      */         
/* 1360 */         check_orphaned();
/* 1361 */         ArrayList arrayList = new ArrayList();
/* 1362 */         get_store().find_all_element_users(WHITESPACE$22, arrayList);
/* 1363 */         WhiteSpaceDocument.WhiteSpace[] arrayOfWhiteSpace = new WhiteSpaceDocument.WhiteSpace[arrayList.size()];
/* 1364 */         arrayList.toArray((Object[])arrayOfWhiteSpace);
/* 1365 */         return arrayOfWhiteSpace;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int param1Int) {
/* 1374 */       synchronized (monitor()) {
/*      */         
/* 1376 */         check_orphaned();
/* 1377 */         WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1378 */         whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().find_element_user(WHITESPACE$22, param1Int);
/* 1379 */         if (whiteSpace == null)
/*      */         {
/* 1381 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1383 */         return whiteSpace;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfWhiteSpaceArray() {
/* 1392 */       synchronized (monitor()) {
/*      */         
/* 1394 */         check_orphaned();
/* 1395 */         return get_store().count_elements(WHITESPACE$22);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] param1ArrayOfWhiteSpace) {
/* 1404 */       synchronized (monitor()) {
/*      */         
/* 1406 */         check_orphaned();
/* 1407 */         arraySetterHelper((XmlObject[])param1ArrayOfWhiteSpace, WHITESPACE$22);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWhiteSpaceArray(int param1Int, WhiteSpaceDocument.WhiteSpace param1WhiteSpace) {
/* 1416 */       synchronized (monitor()) {
/*      */         
/* 1418 */         check_orphaned();
/* 1419 */         WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1420 */         whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().find_element_user(WHITESPACE$22, param1Int);
/* 1421 */         if (whiteSpace == null)
/*      */         {
/* 1423 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1425 */         whiteSpace.set((XmlObject)param1WhiteSpace);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int param1Int) {
/* 1434 */       synchronized (monitor()) {
/*      */         
/* 1436 */         check_orphaned();
/* 1437 */         WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1438 */         whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().insert_element_user(WHITESPACE$22, param1Int);
/* 1439 */         return whiteSpace;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
/* 1448 */       synchronized (monitor()) {
/*      */         
/* 1450 */         check_orphaned();
/* 1451 */         WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1452 */         whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().add_element_user(WHITESPACE$22);
/* 1453 */         return whiteSpace;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeWhiteSpace(int param1Int) {
/* 1462 */       synchronized (monitor()) {
/*      */         
/* 1464 */         check_orphaned();
/* 1465 */         get_store().remove_element(WHITESPACE$22, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PatternDocument.Pattern[] getPatternArray() {
/* 1474 */       synchronized (monitor()) {
/*      */         
/* 1476 */         check_orphaned();
/* 1477 */         ArrayList arrayList = new ArrayList();
/* 1478 */         get_store().find_all_element_users(PATTERN$24, arrayList);
/* 1479 */         PatternDocument.Pattern[] arrayOfPattern = new PatternDocument.Pattern[arrayList.size()];
/* 1480 */         arrayList.toArray((Object[])arrayOfPattern);
/* 1481 */         return arrayOfPattern;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PatternDocument.Pattern getPatternArray(int param1Int) {
/* 1490 */       synchronized (monitor()) {
/*      */         
/* 1492 */         check_orphaned();
/* 1493 */         PatternDocument.Pattern pattern = null;
/* 1494 */         pattern = (PatternDocument.Pattern)get_store().find_element_user(PATTERN$24, param1Int);
/* 1495 */         if (pattern == null)
/*      */         {
/* 1497 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1499 */         return pattern;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfPatternArray() {
/* 1508 */       synchronized (monitor()) {
/*      */         
/* 1510 */         check_orphaned();
/* 1511 */         return get_store().count_elements(PATTERN$24);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setPatternArray(PatternDocument.Pattern[] param1ArrayOfPattern) {
/* 1520 */       synchronized (monitor()) {
/*      */         
/* 1522 */         check_orphaned();
/* 1523 */         arraySetterHelper((XmlObject[])param1ArrayOfPattern, PATTERN$24);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setPatternArray(int param1Int, PatternDocument.Pattern param1Pattern) {
/* 1532 */       synchronized (monitor()) {
/*      */         
/* 1534 */         check_orphaned();
/* 1535 */         PatternDocument.Pattern pattern = null;
/* 1536 */         pattern = (PatternDocument.Pattern)get_store().find_element_user(PATTERN$24, param1Int);
/* 1537 */         if (pattern == null)
/*      */         {
/* 1539 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1541 */         pattern.set((XmlObject)param1Pattern);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PatternDocument.Pattern insertNewPattern(int param1Int) {
/* 1550 */       synchronized (monitor()) {
/*      */         
/* 1552 */         check_orphaned();
/* 1553 */         PatternDocument.Pattern pattern = null;
/* 1554 */         pattern = (PatternDocument.Pattern)get_store().insert_element_user(PATTERN$24, param1Int);
/* 1555 */         return pattern;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PatternDocument.Pattern addNewPattern() {
/* 1564 */       synchronized (monitor()) {
/*      */         
/* 1566 */         check_orphaned();
/* 1567 */         PatternDocument.Pattern pattern = null;
/* 1568 */         pattern = (PatternDocument.Pattern)get_store().add_element_user(PATTERN$24);
/* 1569 */         return pattern;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removePattern(int param1Int) {
/* 1578 */       synchronized (monitor()) {
/*      */         
/* 1580 */         check_orphaned();
/* 1581 */         get_store().remove_element(PATTERN$24, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public b getBase() {
/* 1590 */       synchronized (monitor()) {
/*      */         
/* 1592 */         check_orphaned();
/* 1593 */         SimpleValue simpleValue = null;
/* 1594 */         simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$26);
/* 1595 */         if (simpleValue == null)
/*      */         {
/* 1597 */           return null;
/*      */         }
/* 1599 */         return simpleValue.getQNameValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlQName xgetBase() {
/* 1608 */       synchronized (monitor()) {
/*      */         
/* 1610 */         check_orphaned();
/* 1611 */         XmlQName xmlQName = null;
/* 1612 */         xmlQName = (XmlQName)get_store().find_attribute_user(BASE$26);
/* 1613 */         return xmlQName;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetBase() {
/* 1622 */       synchronized (monitor()) {
/*      */         
/* 1624 */         check_orphaned();
/* 1625 */         return (get_store().find_attribute_user(BASE$26) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setBase(b param1b) {
/* 1634 */       synchronized (monitor()) {
/*      */         
/* 1636 */         check_orphaned();
/* 1637 */         SimpleValue simpleValue = null;
/* 1638 */         simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$26);
/* 1639 */         if (simpleValue == null)
/*      */         {
/* 1641 */           simpleValue = (SimpleValue)get_store().add_attribute_user(BASE$26);
/*      */         }
/* 1643 */         simpleValue.setQNameValue(param1b);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetBase(XmlQName param1XmlQName) {
/* 1652 */       synchronized (monitor()) {
/*      */         
/* 1654 */         check_orphaned();
/* 1655 */         XmlQName xmlQName = null;
/* 1656 */         xmlQName = (XmlQName)get_store().find_attribute_user(BASE$26);
/* 1657 */         if (xmlQName == null)
/*      */         {
/* 1659 */           xmlQName = (XmlQName)get_store().add_attribute_user(BASE$26);
/*      */         }
/* 1661 */         xmlQName.set((XmlObject)param1XmlQName);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetBase() {
/* 1670 */       synchronized (monitor()) {
/*      */         
/* 1672 */         check_orphaned();
/* 1673 */         get_store().remove_attribute(BASE$26);
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\RestrictionDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */