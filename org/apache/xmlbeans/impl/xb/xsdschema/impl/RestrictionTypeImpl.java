/*      */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*      */ import java.util.ArrayList;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*      */ 
/*      */ public class RestrictionTypeImpl extends AnnotatedImpl implements RestrictionType {
/*      */   public RestrictionTypeImpl(SchemaType paramSchemaType) {
/*   19 */     super(paramSchemaType);
/*      */   }
/*      */   
/*   22 */   private static final b GROUP$0 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*      */   
/*   24 */   private static final b ALL$2 = new b("http://www.w3.org/2001/XMLSchema", "all");
/*      */   
/*   26 */   private static final b CHOICE$4 = new b("http://www.w3.org/2001/XMLSchema", "choice");
/*      */   
/*   28 */   private static final b SEQUENCE$6 = new b("http://www.w3.org/2001/XMLSchema", "sequence");
/*      */   
/*   30 */   private static final b SIMPLETYPE$8 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*      */   
/*   32 */   private static final b MINEXCLUSIVE$10 = new b("http://www.w3.org/2001/XMLSchema", "minExclusive");
/*      */   
/*   34 */   private static final b MININCLUSIVE$12 = new b("http://www.w3.org/2001/XMLSchema", "minInclusive");
/*      */   
/*   36 */   private static final b MAXEXCLUSIVE$14 = new b("http://www.w3.org/2001/XMLSchema", "maxExclusive");
/*      */   
/*   38 */   private static final b MAXINCLUSIVE$16 = new b("http://www.w3.org/2001/XMLSchema", "maxInclusive");
/*      */   
/*   40 */   private static final b TOTALDIGITS$18 = new b("http://www.w3.org/2001/XMLSchema", "totalDigits");
/*      */   
/*   42 */   private static final b FRACTIONDIGITS$20 = new b("http://www.w3.org/2001/XMLSchema", "fractionDigits");
/*      */   
/*   44 */   private static final b LENGTH$22 = new b("http://www.w3.org/2001/XMLSchema", "length");
/*      */   
/*   46 */   private static final b MINLENGTH$24 = new b("http://www.w3.org/2001/XMLSchema", "minLength");
/*      */   
/*   48 */   private static final b MAXLENGTH$26 = new b("http://www.w3.org/2001/XMLSchema", "maxLength");
/*      */   
/*   50 */   private static final b ENUMERATION$28 = new b("http://www.w3.org/2001/XMLSchema", "enumeration");
/*      */   
/*   52 */   private static final b WHITESPACE$30 = new b("http://www.w3.org/2001/XMLSchema", "whiteSpace");
/*      */   
/*   54 */   private static final b PATTERN$32 = new b("http://www.w3.org/2001/XMLSchema", "pattern");
/*      */   
/*   56 */   private static final b ATTRIBUTE$34 = new b("http://www.w3.org/2001/XMLSchema", "attribute");
/*      */   
/*   58 */   private static final b ATTRIBUTEGROUP$36 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*      */   
/*   60 */   private static final b ANYATTRIBUTE$38 = new b("http://www.w3.org/2001/XMLSchema", "anyAttribute");
/*      */   
/*   62 */   private static final b BASE$40 = new b("", "base");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef getGroup() {
/*   71 */     synchronized (monitor()) {
/*      */       
/*   73 */       check_orphaned();
/*   74 */       GroupRef groupRef = null;
/*   75 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$0, 0);
/*   76 */       if (groupRef == null)
/*      */       {
/*   78 */         return null;
/*      */       }
/*   80 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetGroup() {
/*   89 */     synchronized (monitor()) {
/*      */       
/*   91 */       check_orphaned();
/*   92 */       return (get_store().count_elements(GROUP$0) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroup(GroupRef paramGroupRef) {
/*  101 */     synchronized (monitor()) {
/*      */       
/*  103 */       check_orphaned();
/*  104 */       GroupRef groupRef = null;
/*  105 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$0, 0);
/*  106 */       if (groupRef == null)
/*      */       {
/*  108 */         groupRef = (GroupRef)get_store().add_element_user(GROUP$0);
/*      */       }
/*  110 */       groupRef.set((XmlObject)paramGroupRef);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef addNewGroup() {
/*  119 */     synchronized (monitor()) {
/*      */       
/*  121 */       check_orphaned();
/*  122 */       GroupRef groupRef = null;
/*  123 */       groupRef = (GroupRef)get_store().add_element_user(GROUP$0);
/*  124 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetGroup() {
/*  133 */     synchronized (monitor()) {
/*      */       
/*  135 */       check_orphaned();
/*  136 */       get_store().remove_element(GROUP$0, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All getAll() {
/*  145 */     synchronized (monitor()) {
/*      */       
/*  147 */       check_orphaned();
/*  148 */       All all = null;
/*  149 */       all = (All)get_store().find_element_user(ALL$2, 0);
/*  150 */       if (all == null)
/*      */       {
/*  152 */         return null;
/*      */       }
/*  154 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetAll() {
/*  163 */     synchronized (monitor()) {
/*      */       
/*  165 */       check_orphaned();
/*  166 */       return (get_store().count_elements(ALL$2) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAll(All paramAll) {
/*  175 */     synchronized (monitor()) {
/*      */       
/*  177 */       check_orphaned();
/*  178 */       All all = null;
/*  179 */       all = (All)get_store().find_element_user(ALL$2, 0);
/*  180 */       if (all == null)
/*      */       {
/*  182 */         all = (All)get_store().add_element_user(ALL$2);
/*      */       }
/*  184 */       all.set((XmlObject)paramAll);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All addNewAll() {
/*  193 */     synchronized (monitor()) {
/*      */       
/*  195 */       check_orphaned();
/*  196 */       All all = null;
/*  197 */       all = (All)get_store().add_element_user(ALL$2);
/*  198 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetAll() {
/*  207 */     synchronized (monitor()) {
/*      */       
/*  209 */       check_orphaned();
/*  210 */       get_store().remove_element(ALL$2, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup getChoice() {
/*  219 */     synchronized (monitor()) {
/*      */       
/*  221 */       check_orphaned();
/*  222 */       ExplicitGroup explicitGroup = null;
/*  223 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$4, 0);
/*  224 */       if (explicitGroup == null)
/*      */       {
/*  226 */         return null;
/*      */       }
/*  228 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetChoice() {
/*  237 */     synchronized (monitor()) {
/*      */       
/*  239 */       check_orphaned();
/*  240 */       return (get_store().count_elements(CHOICE$4) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChoice(ExplicitGroup paramExplicitGroup) {
/*  249 */     synchronized (monitor()) {
/*      */       
/*  251 */       check_orphaned();
/*  252 */       ExplicitGroup explicitGroup = null;
/*  253 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$4, 0);
/*  254 */       if (explicitGroup == null)
/*      */       {
/*  256 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$4);
/*      */       }
/*  258 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup addNewChoice() {
/*  267 */     synchronized (monitor()) {
/*      */       
/*  269 */       check_orphaned();
/*  270 */       ExplicitGroup explicitGroup = null;
/*  271 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$4);
/*  272 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetChoice() {
/*  281 */     synchronized (monitor()) {
/*      */       
/*  283 */       check_orphaned();
/*  284 */       get_store().remove_element(CHOICE$4, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup getSequence() {
/*  293 */     synchronized (monitor()) {
/*      */       
/*  295 */       check_orphaned();
/*  296 */       ExplicitGroup explicitGroup = null;
/*  297 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$6, 0);
/*  298 */       if (explicitGroup == null)
/*      */       {
/*  300 */         return null;
/*      */       }
/*  302 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetSequence() {
/*  311 */     synchronized (monitor()) {
/*      */       
/*  313 */       check_orphaned();
/*  314 */       return (get_store().count_elements(SEQUENCE$6) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequence(ExplicitGroup paramExplicitGroup) {
/*  323 */     synchronized (monitor()) {
/*      */       
/*  325 */       check_orphaned();
/*  326 */       ExplicitGroup explicitGroup = null;
/*  327 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$6, 0);
/*  328 */       if (explicitGroup == null)
/*      */       {
/*  330 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$6);
/*      */       }
/*  332 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup addNewSequence() {
/*  341 */     synchronized (monitor()) {
/*      */       
/*  343 */       check_orphaned();
/*  344 */       ExplicitGroup explicitGroup = null;
/*  345 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$6);
/*  346 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetSequence() {
/*  355 */     synchronized (monitor()) {
/*      */       
/*  357 */       check_orphaned();
/*  358 */       get_store().remove_element(SEQUENCE$6, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalSimpleType getSimpleType() {
/*  367 */     synchronized (monitor()) {
/*      */       
/*  369 */       check_orphaned();
/*  370 */       LocalSimpleType localSimpleType = null;
/*  371 */       localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$8, 0);
/*  372 */       if (localSimpleType == null)
/*      */       {
/*  374 */         return null;
/*      */       }
/*  376 */       return localSimpleType;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetSimpleType() {
/*  385 */     synchronized (monitor()) {
/*      */       
/*  387 */       check_orphaned();
/*  388 */       return (get_store().count_elements(SIMPLETYPE$8) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSimpleType(LocalSimpleType paramLocalSimpleType) {
/*  397 */     synchronized (monitor()) {
/*      */       
/*  399 */       check_orphaned();
/*  400 */       LocalSimpleType localSimpleType = null;
/*  401 */       localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$8, 0);
/*  402 */       if (localSimpleType == null)
/*      */       {
/*  404 */         localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$8);
/*      */       }
/*  406 */       localSimpleType.set((XmlObject)paramLocalSimpleType);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalSimpleType addNewSimpleType() {
/*  415 */     synchronized (monitor()) {
/*      */       
/*  417 */       check_orphaned();
/*  418 */       LocalSimpleType localSimpleType = null;
/*  419 */       localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$8);
/*  420 */       return localSimpleType;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetSimpleType() {
/*  429 */     synchronized (monitor()) {
/*      */       
/*  431 */       check_orphaned();
/*  432 */       get_store().remove_element(SIMPLETYPE$8, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet[] getMinExclusiveArray() {
/*  441 */     synchronized (monitor()) {
/*      */       
/*  443 */       check_orphaned();
/*  444 */       ArrayList arrayList = new ArrayList();
/*  445 */       get_store().find_all_element_users(MINEXCLUSIVE$10, arrayList);
/*  446 */       Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  447 */       arrayList.toArray((Object[])arrayOfFacet);
/*  448 */       return arrayOfFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet getMinExclusiveArray(int paramInt) {
/*  457 */     synchronized (monitor()) {
/*      */       
/*  459 */       check_orphaned();
/*  460 */       Facet facet = null;
/*  461 */       facet = (Facet)get_store().find_element_user(MINEXCLUSIVE$10, paramInt);
/*  462 */       if (facet == null)
/*      */       {
/*  464 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  466 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfMinExclusiveArray() {
/*  475 */     synchronized (monitor()) {
/*      */       
/*  477 */       check_orphaned();
/*  478 */       return get_store().count_elements(MINEXCLUSIVE$10);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinExclusiveArray(Facet[] paramArrayOfFacet) {
/*  487 */     synchronized (monitor()) {
/*      */       
/*  489 */       check_orphaned();
/*  490 */       arraySetterHelper((XmlObject[])paramArrayOfFacet, MINEXCLUSIVE$10);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinExclusiveArray(int paramInt, Facet paramFacet) {
/*  499 */     synchronized (monitor()) {
/*      */       
/*  501 */       check_orphaned();
/*  502 */       Facet facet = null;
/*  503 */       facet = (Facet)get_store().find_element_user(MINEXCLUSIVE$10, paramInt);
/*  504 */       if (facet == null)
/*      */       {
/*  506 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  508 */       facet.set((XmlObject)paramFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet insertNewMinExclusive(int paramInt) {
/*  517 */     synchronized (monitor()) {
/*      */       
/*  519 */       check_orphaned();
/*  520 */       Facet facet = null;
/*  521 */       facet = (Facet)get_store().insert_element_user(MINEXCLUSIVE$10, paramInt);
/*  522 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet addNewMinExclusive() {
/*  531 */     synchronized (monitor()) {
/*      */       
/*  533 */       check_orphaned();
/*  534 */       Facet facet = null;
/*  535 */       facet = (Facet)get_store().add_element_user(MINEXCLUSIVE$10);
/*  536 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMinExclusive(int paramInt) {
/*  545 */     synchronized (monitor()) {
/*      */       
/*  547 */       check_orphaned();
/*  548 */       get_store().remove_element(MINEXCLUSIVE$10, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet[] getMinInclusiveArray() {
/*  557 */     synchronized (monitor()) {
/*      */       
/*  559 */       check_orphaned();
/*  560 */       ArrayList arrayList = new ArrayList();
/*  561 */       get_store().find_all_element_users(MININCLUSIVE$12, arrayList);
/*  562 */       Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  563 */       arrayList.toArray((Object[])arrayOfFacet);
/*  564 */       return arrayOfFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet getMinInclusiveArray(int paramInt) {
/*  573 */     synchronized (monitor()) {
/*      */       
/*  575 */       check_orphaned();
/*  576 */       Facet facet = null;
/*  577 */       facet = (Facet)get_store().find_element_user(MININCLUSIVE$12, paramInt);
/*  578 */       if (facet == null)
/*      */       {
/*  580 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  582 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfMinInclusiveArray() {
/*  591 */     synchronized (monitor()) {
/*      */       
/*  593 */       check_orphaned();
/*  594 */       return get_store().count_elements(MININCLUSIVE$12);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinInclusiveArray(Facet[] paramArrayOfFacet) {
/*  603 */     synchronized (monitor()) {
/*      */       
/*  605 */       check_orphaned();
/*  606 */       arraySetterHelper((XmlObject[])paramArrayOfFacet, MININCLUSIVE$12);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinInclusiveArray(int paramInt, Facet paramFacet) {
/*  615 */     synchronized (monitor()) {
/*      */       
/*  617 */       check_orphaned();
/*  618 */       Facet facet = null;
/*  619 */       facet = (Facet)get_store().find_element_user(MININCLUSIVE$12, paramInt);
/*  620 */       if (facet == null)
/*      */       {
/*  622 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  624 */       facet.set((XmlObject)paramFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet insertNewMinInclusive(int paramInt) {
/*  633 */     synchronized (monitor()) {
/*      */       
/*  635 */       check_orphaned();
/*  636 */       Facet facet = null;
/*  637 */       facet = (Facet)get_store().insert_element_user(MININCLUSIVE$12, paramInt);
/*  638 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet addNewMinInclusive() {
/*  647 */     synchronized (monitor()) {
/*      */       
/*  649 */       check_orphaned();
/*  650 */       Facet facet = null;
/*  651 */       facet = (Facet)get_store().add_element_user(MININCLUSIVE$12);
/*  652 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMinInclusive(int paramInt) {
/*  661 */     synchronized (monitor()) {
/*      */       
/*  663 */       check_orphaned();
/*  664 */       get_store().remove_element(MININCLUSIVE$12, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet[] getMaxExclusiveArray() {
/*  673 */     synchronized (monitor()) {
/*      */       
/*  675 */       check_orphaned();
/*  676 */       ArrayList arrayList = new ArrayList();
/*  677 */       get_store().find_all_element_users(MAXEXCLUSIVE$14, arrayList);
/*  678 */       Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  679 */       arrayList.toArray((Object[])arrayOfFacet);
/*  680 */       return arrayOfFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet getMaxExclusiveArray(int paramInt) {
/*  689 */     synchronized (monitor()) {
/*      */       
/*  691 */       check_orphaned();
/*  692 */       Facet facet = null;
/*  693 */       facet = (Facet)get_store().find_element_user(MAXEXCLUSIVE$14, paramInt);
/*  694 */       if (facet == null)
/*      */       {
/*  696 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  698 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfMaxExclusiveArray() {
/*  707 */     synchronized (monitor()) {
/*      */       
/*  709 */       check_orphaned();
/*  710 */       return get_store().count_elements(MAXEXCLUSIVE$14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxExclusiveArray(Facet[] paramArrayOfFacet) {
/*  719 */     synchronized (monitor()) {
/*      */       
/*  721 */       check_orphaned();
/*  722 */       arraySetterHelper((XmlObject[])paramArrayOfFacet, MAXEXCLUSIVE$14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxExclusiveArray(int paramInt, Facet paramFacet) {
/*  731 */     synchronized (monitor()) {
/*      */       
/*  733 */       check_orphaned();
/*  734 */       Facet facet = null;
/*  735 */       facet = (Facet)get_store().find_element_user(MAXEXCLUSIVE$14, paramInt);
/*  736 */       if (facet == null)
/*      */       {
/*  738 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  740 */       facet.set((XmlObject)paramFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet insertNewMaxExclusive(int paramInt) {
/*  749 */     synchronized (monitor()) {
/*      */       
/*  751 */       check_orphaned();
/*  752 */       Facet facet = null;
/*  753 */       facet = (Facet)get_store().insert_element_user(MAXEXCLUSIVE$14, paramInt);
/*  754 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet addNewMaxExclusive() {
/*  763 */     synchronized (monitor()) {
/*      */       
/*  765 */       check_orphaned();
/*  766 */       Facet facet = null;
/*  767 */       facet = (Facet)get_store().add_element_user(MAXEXCLUSIVE$14);
/*  768 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMaxExclusive(int paramInt) {
/*  777 */     synchronized (monitor()) {
/*      */       
/*  779 */       check_orphaned();
/*  780 */       get_store().remove_element(MAXEXCLUSIVE$14, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet[] getMaxInclusiveArray() {
/*  789 */     synchronized (monitor()) {
/*      */       
/*  791 */       check_orphaned();
/*  792 */       ArrayList arrayList = new ArrayList();
/*  793 */       get_store().find_all_element_users(MAXINCLUSIVE$16, arrayList);
/*  794 */       Facet[] arrayOfFacet = new Facet[arrayList.size()];
/*  795 */       arrayList.toArray((Object[])arrayOfFacet);
/*  796 */       return arrayOfFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet getMaxInclusiveArray(int paramInt) {
/*  805 */     synchronized (monitor()) {
/*      */       
/*  807 */       check_orphaned();
/*  808 */       Facet facet = null;
/*  809 */       facet = (Facet)get_store().find_element_user(MAXINCLUSIVE$16, paramInt);
/*  810 */       if (facet == null)
/*      */       {
/*  812 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  814 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfMaxInclusiveArray() {
/*  823 */     synchronized (monitor()) {
/*      */       
/*  825 */       check_orphaned();
/*  826 */       return get_store().count_elements(MAXINCLUSIVE$16);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxInclusiveArray(Facet[] paramArrayOfFacet) {
/*  835 */     synchronized (monitor()) {
/*      */       
/*  837 */       check_orphaned();
/*  838 */       arraySetterHelper((XmlObject[])paramArrayOfFacet, MAXINCLUSIVE$16);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxInclusiveArray(int paramInt, Facet paramFacet) {
/*  847 */     synchronized (monitor()) {
/*      */       
/*  849 */       check_orphaned();
/*  850 */       Facet facet = null;
/*  851 */       facet = (Facet)get_store().find_element_user(MAXINCLUSIVE$16, paramInt);
/*  852 */       if (facet == null)
/*      */       {
/*  854 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  856 */       facet.set((XmlObject)paramFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet insertNewMaxInclusive(int paramInt) {
/*  865 */     synchronized (monitor()) {
/*      */       
/*  867 */       check_orphaned();
/*  868 */       Facet facet = null;
/*  869 */       facet = (Facet)get_store().insert_element_user(MAXINCLUSIVE$16, paramInt);
/*  870 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Facet addNewMaxInclusive() {
/*  879 */     synchronized (monitor()) {
/*      */       
/*  881 */       check_orphaned();
/*  882 */       Facet facet = null;
/*  883 */       facet = (Facet)get_store().add_element_user(MAXINCLUSIVE$16);
/*  884 */       return facet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMaxInclusive(int paramInt) {
/*  893 */     synchronized (monitor()) {
/*      */       
/*  895 */       check_orphaned();
/*  896 */       get_store().remove_element(MAXINCLUSIVE$16, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TotalDigitsDocument.TotalDigits[] getTotalDigitsArray() {
/*  905 */     synchronized (monitor()) {
/*      */       
/*  907 */       check_orphaned();
/*  908 */       ArrayList arrayList = new ArrayList();
/*  909 */       get_store().find_all_element_users(TOTALDIGITS$18, arrayList);
/*  910 */       TotalDigitsDocument.TotalDigits[] arrayOfTotalDigits = new TotalDigitsDocument.TotalDigits[arrayList.size()];
/*  911 */       arrayList.toArray((Object[])arrayOfTotalDigits);
/*  912 */       return arrayOfTotalDigits;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TotalDigitsDocument.TotalDigits getTotalDigitsArray(int paramInt) {
/*  921 */     synchronized (monitor()) {
/*      */       
/*  923 */       check_orphaned();
/*  924 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/*  925 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().find_element_user(TOTALDIGITS$18, paramInt);
/*  926 */       if (totalDigits == null)
/*      */       {
/*  928 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  930 */       return totalDigits;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfTotalDigitsArray() {
/*  939 */     synchronized (monitor()) {
/*      */       
/*  941 */       check_orphaned();
/*  942 */       return get_store().count_elements(TOTALDIGITS$18);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTotalDigitsArray(TotalDigitsDocument.TotalDigits[] paramArrayOfTotalDigits) {
/*  951 */     synchronized (monitor()) {
/*      */       
/*  953 */       check_orphaned();
/*  954 */       arraySetterHelper((XmlObject[])paramArrayOfTotalDigits, TOTALDIGITS$18);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTotalDigitsArray(int paramInt, TotalDigitsDocument.TotalDigits paramTotalDigits) {
/*  963 */     synchronized (monitor()) {
/*      */       
/*  965 */       check_orphaned();
/*  966 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/*  967 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().find_element_user(TOTALDIGITS$18, paramInt);
/*  968 */       if (totalDigits == null)
/*      */       {
/*  970 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  972 */       totalDigits.set((XmlObject)paramTotalDigits);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TotalDigitsDocument.TotalDigits insertNewTotalDigits(int paramInt) {
/*  981 */     synchronized (monitor()) {
/*      */       
/*  983 */       check_orphaned();
/*  984 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/*  985 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().insert_element_user(TOTALDIGITS$18, paramInt);
/*  986 */       return totalDigits;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TotalDigitsDocument.TotalDigits addNewTotalDigits() {
/*  995 */     synchronized (monitor()) {
/*      */       
/*  997 */       check_orphaned();
/*  998 */       TotalDigitsDocument.TotalDigits totalDigits = null;
/*  999 */       totalDigits = (TotalDigitsDocument.TotalDigits)get_store().add_element_user(TOTALDIGITS$18);
/* 1000 */       return totalDigits;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeTotalDigits(int paramInt) {
/* 1009 */     synchronized (monitor()) {
/*      */       
/* 1011 */       check_orphaned();
/* 1012 */       get_store().remove_element(TOTALDIGITS$18, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet[] getFractionDigitsArray() {
/* 1021 */     synchronized (monitor()) {
/*      */       
/* 1023 */       check_orphaned();
/* 1024 */       ArrayList arrayList = new ArrayList();
/* 1025 */       get_store().find_all_element_users(FRACTIONDIGITS$20, arrayList);
/* 1026 */       NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/* 1027 */       arrayList.toArray((Object[])arrayOfNumFacet);
/* 1028 */       return arrayOfNumFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet getFractionDigitsArray(int paramInt) {
/* 1037 */     synchronized (monitor()) {
/*      */       
/* 1039 */       check_orphaned();
/* 1040 */       NumFacet numFacet = null;
/* 1041 */       numFacet = (NumFacet)get_store().find_element_user(FRACTIONDIGITS$20, paramInt);
/* 1042 */       if (numFacet == null)
/*      */       {
/* 1044 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1046 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfFractionDigitsArray() {
/* 1055 */     synchronized (monitor()) {
/*      */       
/* 1057 */       check_orphaned();
/* 1058 */       return get_store().count_elements(FRACTIONDIGITS$20);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFractionDigitsArray(NumFacet[] paramArrayOfNumFacet) {
/* 1067 */     synchronized (monitor()) {
/*      */       
/* 1069 */       check_orphaned();
/* 1070 */       arraySetterHelper((XmlObject[])paramArrayOfNumFacet, FRACTIONDIGITS$20);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFractionDigitsArray(int paramInt, NumFacet paramNumFacet) {
/* 1079 */     synchronized (monitor()) {
/*      */       
/* 1081 */       check_orphaned();
/* 1082 */       NumFacet numFacet = null;
/* 1083 */       numFacet = (NumFacet)get_store().find_element_user(FRACTIONDIGITS$20, paramInt);
/* 1084 */       if (numFacet == null)
/*      */       {
/* 1086 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1088 */       numFacet.set((XmlObject)paramNumFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet insertNewFractionDigits(int paramInt) {
/* 1097 */     synchronized (monitor()) {
/*      */       
/* 1099 */       check_orphaned();
/* 1100 */       NumFacet numFacet = null;
/* 1101 */       numFacet = (NumFacet)get_store().insert_element_user(FRACTIONDIGITS$20, paramInt);
/* 1102 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet addNewFractionDigits() {
/* 1111 */     synchronized (monitor()) {
/*      */       
/* 1113 */       check_orphaned();
/* 1114 */       NumFacet numFacet = null;
/* 1115 */       numFacet = (NumFacet)get_store().add_element_user(FRACTIONDIGITS$20);
/* 1116 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeFractionDigits(int paramInt) {
/* 1125 */     synchronized (monitor()) {
/*      */       
/* 1127 */       check_orphaned();
/* 1128 */       get_store().remove_element(FRACTIONDIGITS$20, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet[] getLengthArray() {
/* 1137 */     synchronized (monitor()) {
/*      */       
/* 1139 */       check_orphaned();
/* 1140 */       ArrayList arrayList = new ArrayList();
/* 1141 */       get_store().find_all_element_users(LENGTH$22, arrayList);
/* 1142 */       NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/* 1143 */       arrayList.toArray((Object[])arrayOfNumFacet);
/* 1144 */       return arrayOfNumFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet getLengthArray(int paramInt) {
/* 1153 */     synchronized (monitor()) {
/*      */       
/* 1155 */       check_orphaned();
/* 1156 */       NumFacet numFacet = null;
/* 1157 */       numFacet = (NumFacet)get_store().find_element_user(LENGTH$22, paramInt);
/* 1158 */       if (numFacet == null)
/*      */       {
/* 1160 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1162 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfLengthArray() {
/* 1171 */     synchronized (monitor()) {
/*      */       
/* 1173 */       check_orphaned();
/* 1174 */       return get_store().count_elements(LENGTH$22);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLengthArray(NumFacet[] paramArrayOfNumFacet) {
/* 1183 */     synchronized (monitor()) {
/*      */       
/* 1185 */       check_orphaned();
/* 1186 */       arraySetterHelper((XmlObject[])paramArrayOfNumFacet, LENGTH$22);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLengthArray(int paramInt, NumFacet paramNumFacet) {
/* 1195 */     synchronized (monitor()) {
/*      */       
/* 1197 */       check_orphaned();
/* 1198 */       NumFacet numFacet = null;
/* 1199 */       numFacet = (NumFacet)get_store().find_element_user(LENGTH$22, paramInt);
/* 1200 */       if (numFacet == null)
/*      */       {
/* 1202 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1204 */       numFacet.set((XmlObject)paramNumFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet insertNewLength(int paramInt) {
/* 1213 */     synchronized (monitor()) {
/*      */       
/* 1215 */       check_orphaned();
/* 1216 */       NumFacet numFacet = null;
/* 1217 */       numFacet = (NumFacet)get_store().insert_element_user(LENGTH$22, paramInt);
/* 1218 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet addNewLength() {
/* 1227 */     synchronized (monitor()) {
/*      */       
/* 1229 */       check_orphaned();
/* 1230 */       NumFacet numFacet = null;
/* 1231 */       numFacet = (NumFacet)get_store().add_element_user(LENGTH$22);
/* 1232 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeLength(int paramInt) {
/* 1241 */     synchronized (monitor()) {
/*      */       
/* 1243 */       check_orphaned();
/* 1244 */       get_store().remove_element(LENGTH$22, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet[] getMinLengthArray() {
/* 1253 */     synchronized (monitor()) {
/*      */       
/* 1255 */       check_orphaned();
/* 1256 */       ArrayList arrayList = new ArrayList();
/* 1257 */       get_store().find_all_element_users(MINLENGTH$24, arrayList);
/* 1258 */       NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/* 1259 */       arrayList.toArray((Object[])arrayOfNumFacet);
/* 1260 */       return arrayOfNumFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet getMinLengthArray(int paramInt) {
/* 1269 */     synchronized (monitor()) {
/*      */       
/* 1271 */       check_orphaned();
/* 1272 */       NumFacet numFacet = null;
/* 1273 */       numFacet = (NumFacet)get_store().find_element_user(MINLENGTH$24, paramInt);
/* 1274 */       if (numFacet == null)
/*      */       {
/* 1276 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1278 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfMinLengthArray() {
/* 1287 */     synchronized (monitor()) {
/*      */       
/* 1289 */       check_orphaned();
/* 1290 */       return get_store().count_elements(MINLENGTH$24);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinLengthArray(NumFacet[] paramArrayOfNumFacet) {
/* 1299 */     synchronized (monitor()) {
/*      */       
/* 1301 */       check_orphaned();
/* 1302 */       arraySetterHelper((XmlObject[])paramArrayOfNumFacet, MINLENGTH$24);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinLengthArray(int paramInt, NumFacet paramNumFacet) {
/* 1311 */     synchronized (monitor()) {
/*      */       
/* 1313 */       check_orphaned();
/* 1314 */       NumFacet numFacet = null;
/* 1315 */       numFacet = (NumFacet)get_store().find_element_user(MINLENGTH$24, paramInt);
/* 1316 */       if (numFacet == null)
/*      */       {
/* 1318 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1320 */       numFacet.set((XmlObject)paramNumFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet insertNewMinLength(int paramInt) {
/* 1329 */     synchronized (monitor()) {
/*      */       
/* 1331 */       check_orphaned();
/* 1332 */       NumFacet numFacet = null;
/* 1333 */       numFacet = (NumFacet)get_store().insert_element_user(MINLENGTH$24, paramInt);
/* 1334 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet addNewMinLength() {
/* 1343 */     synchronized (monitor()) {
/*      */       
/* 1345 */       check_orphaned();
/* 1346 */       NumFacet numFacet = null;
/* 1347 */       numFacet = (NumFacet)get_store().add_element_user(MINLENGTH$24);
/* 1348 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMinLength(int paramInt) {
/* 1357 */     synchronized (monitor()) {
/*      */       
/* 1359 */       check_orphaned();
/* 1360 */       get_store().remove_element(MINLENGTH$24, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet[] getMaxLengthArray() {
/* 1369 */     synchronized (monitor()) {
/*      */       
/* 1371 */       check_orphaned();
/* 1372 */       ArrayList arrayList = new ArrayList();
/* 1373 */       get_store().find_all_element_users(MAXLENGTH$26, arrayList);
/* 1374 */       NumFacet[] arrayOfNumFacet = new NumFacet[arrayList.size()];
/* 1375 */       arrayList.toArray((Object[])arrayOfNumFacet);
/* 1376 */       return arrayOfNumFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet getMaxLengthArray(int paramInt) {
/* 1385 */     synchronized (monitor()) {
/*      */       
/* 1387 */       check_orphaned();
/* 1388 */       NumFacet numFacet = null;
/* 1389 */       numFacet = (NumFacet)get_store().find_element_user(MAXLENGTH$26, paramInt);
/* 1390 */       if (numFacet == null)
/*      */       {
/* 1392 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1394 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfMaxLengthArray() {
/* 1403 */     synchronized (monitor()) {
/*      */       
/* 1405 */       check_orphaned();
/* 1406 */       return get_store().count_elements(MAXLENGTH$26);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxLengthArray(NumFacet[] paramArrayOfNumFacet) {
/* 1415 */     synchronized (monitor()) {
/*      */       
/* 1417 */       check_orphaned();
/* 1418 */       arraySetterHelper((XmlObject[])paramArrayOfNumFacet, MAXLENGTH$26);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxLengthArray(int paramInt, NumFacet paramNumFacet) {
/* 1427 */     synchronized (monitor()) {
/*      */       
/* 1429 */       check_orphaned();
/* 1430 */       NumFacet numFacet = null;
/* 1431 */       numFacet = (NumFacet)get_store().find_element_user(MAXLENGTH$26, paramInt);
/* 1432 */       if (numFacet == null)
/*      */       {
/* 1434 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1436 */       numFacet.set((XmlObject)paramNumFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet insertNewMaxLength(int paramInt) {
/* 1445 */     synchronized (monitor()) {
/*      */       
/* 1447 */       check_orphaned();
/* 1448 */       NumFacet numFacet = null;
/* 1449 */       numFacet = (NumFacet)get_store().insert_element_user(MAXLENGTH$26, paramInt);
/* 1450 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NumFacet addNewMaxLength() {
/* 1459 */     synchronized (monitor()) {
/*      */       
/* 1461 */       check_orphaned();
/* 1462 */       NumFacet numFacet = null;
/* 1463 */       numFacet = (NumFacet)get_store().add_element_user(MAXLENGTH$26);
/* 1464 */       return numFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMaxLength(int paramInt) {
/* 1473 */     synchronized (monitor()) {
/*      */       
/* 1475 */       check_orphaned();
/* 1476 */       get_store().remove_element(MAXLENGTH$26, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NoFixedFacet[] getEnumerationArray() {
/* 1485 */     synchronized (monitor()) {
/*      */       
/* 1487 */       check_orphaned();
/* 1488 */       ArrayList arrayList = new ArrayList();
/* 1489 */       get_store().find_all_element_users(ENUMERATION$28, arrayList);
/* 1490 */       NoFixedFacet[] arrayOfNoFixedFacet = new NoFixedFacet[arrayList.size()];
/* 1491 */       arrayList.toArray((Object[])arrayOfNoFixedFacet);
/* 1492 */       return arrayOfNoFixedFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NoFixedFacet getEnumerationArray(int paramInt) {
/* 1501 */     synchronized (monitor()) {
/*      */       
/* 1503 */       check_orphaned();
/* 1504 */       NoFixedFacet noFixedFacet = null;
/* 1505 */       noFixedFacet = (NoFixedFacet)get_store().find_element_user(ENUMERATION$28, paramInt);
/* 1506 */       if (noFixedFacet == null)
/*      */       {
/* 1508 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1510 */       return noFixedFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfEnumerationArray() {
/* 1519 */     synchronized (monitor()) {
/*      */       
/* 1521 */       check_orphaned();
/* 1522 */       return get_store().count_elements(ENUMERATION$28);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnumerationArray(NoFixedFacet[] paramArrayOfNoFixedFacet) {
/* 1531 */     synchronized (monitor()) {
/*      */       
/* 1533 */       check_orphaned();
/* 1534 */       arraySetterHelper((XmlObject[])paramArrayOfNoFixedFacet, ENUMERATION$28);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEnumerationArray(int paramInt, NoFixedFacet paramNoFixedFacet) {
/* 1543 */     synchronized (monitor()) {
/*      */       
/* 1545 */       check_orphaned();
/* 1546 */       NoFixedFacet noFixedFacet = null;
/* 1547 */       noFixedFacet = (NoFixedFacet)get_store().find_element_user(ENUMERATION$28, paramInt);
/* 1548 */       if (noFixedFacet == null)
/*      */       {
/* 1550 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1552 */       noFixedFacet.set((XmlObject)paramNoFixedFacet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NoFixedFacet insertNewEnumeration(int paramInt) {
/* 1561 */     synchronized (monitor()) {
/*      */       
/* 1563 */       check_orphaned();
/* 1564 */       NoFixedFacet noFixedFacet = null;
/* 1565 */       noFixedFacet = (NoFixedFacet)get_store().insert_element_user(ENUMERATION$28, paramInt);
/* 1566 */       return noFixedFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NoFixedFacet addNewEnumeration() {
/* 1575 */     synchronized (monitor()) {
/*      */       
/* 1577 */       check_orphaned();
/* 1578 */       NoFixedFacet noFixedFacet = null;
/* 1579 */       noFixedFacet = (NoFixedFacet)get_store().add_element_user(ENUMERATION$28);
/* 1580 */       return noFixedFacet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeEnumeration(int paramInt) {
/* 1589 */     synchronized (monitor()) {
/*      */       
/* 1591 */       check_orphaned();
/* 1592 */       get_store().remove_element(ENUMERATION$28, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WhiteSpaceDocument.WhiteSpace[] getWhiteSpaceArray() {
/* 1601 */     synchronized (monitor()) {
/*      */       
/* 1603 */       check_orphaned();
/* 1604 */       ArrayList arrayList = new ArrayList();
/* 1605 */       get_store().find_all_element_users(WHITESPACE$30, arrayList);
/* 1606 */       WhiteSpaceDocument.WhiteSpace[] arrayOfWhiteSpace = new WhiteSpaceDocument.WhiteSpace[arrayList.size()];
/* 1607 */       arrayList.toArray((Object[])arrayOfWhiteSpace);
/* 1608 */       return arrayOfWhiteSpace;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WhiteSpaceDocument.WhiteSpace getWhiteSpaceArray(int paramInt) {
/* 1617 */     synchronized (monitor()) {
/*      */       
/* 1619 */       check_orphaned();
/* 1620 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1621 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().find_element_user(WHITESPACE$30, paramInt);
/* 1622 */       if (whiteSpace == null)
/*      */       {
/* 1624 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1626 */       return whiteSpace;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfWhiteSpaceArray() {
/* 1635 */     synchronized (monitor()) {
/*      */       
/* 1637 */       check_orphaned();
/* 1638 */       return get_store().count_elements(WHITESPACE$30);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWhiteSpaceArray(WhiteSpaceDocument.WhiteSpace[] paramArrayOfWhiteSpace) {
/* 1647 */     synchronized (monitor()) {
/*      */       
/* 1649 */       check_orphaned();
/* 1650 */       arraySetterHelper((XmlObject[])paramArrayOfWhiteSpace, WHITESPACE$30);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWhiteSpaceArray(int paramInt, WhiteSpaceDocument.WhiteSpace paramWhiteSpace) {
/* 1659 */     synchronized (monitor()) {
/*      */       
/* 1661 */       check_orphaned();
/* 1662 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1663 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().find_element_user(WHITESPACE$30, paramInt);
/* 1664 */       if (whiteSpace == null)
/*      */       {
/* 1666 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1668 */       whiteSpace.set((XmlObject)paramWhiteSpace);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WhiteSpaceDocument.WhiteSpace insertNewWhiteSpace(int paramInt) {
/* 1677 */     synchronized (monitor()) {
/*      */       
/* 1679 */       check_orphaned();
/* 1680 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1681 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().insert_element_user(WHITESPACE$30, paramInt);
/* 1682 */       return whiteSpace;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
/* 1691 */     synchronized (monitor()) {
/*      */       
/* 1693 */       check_orphaned();
/* 1694 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/* 1695 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().add_element_user(WHITESPACE$30);
/* 1696 */       return whiteSpace;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeWhiteSpace(int paramInt) {
/* 1705 */     synchronized (monitor()) {
/*      */       
/* 1707 */       check_orphaned();
/* 1708 */       get_store().remove_element(WHITESPACE$30, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PatternDocument.Pattern[] getPatternArray() {
/* 1717 */     synchronized (monitor()) {
/*      */       
/* 1719 */       check_orphaned();
/* 1720 */       ArrayList arrayList = new ArrayList();
/* 1721 */       get_store().find_all_element_users(PATTERN$32, arrayList);
/* 1722 */       PatternDocument.Pattern[] arrayOfPattern = new PatternDocument.Pattern[arrayList.size()];
/* 1723 */       arrayList.toArray((Object[])arrayOfPattern);
/* 1724 */       return arrayOfPattern;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PatternDocument.Pattern getPatternArray(int paramInt) {
/* 1733 */     synchronized (monitor()) {
/*      */       
/* 1735 */       check_orphaned();
/* 1736 */       PatternDocument.Pattern pattern = null;
/* 1737 */       pattern = (PatternDocument.Pattern)get_store().find_element_user(PATTERN$32, paramInt);
/* 1738 */       if (pattern == null)
/*      */       {
/* 1740 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1742 */       return pattern;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfPatternArray() {
/* 1751 */     synchronized (monitor()) {
/*      */       
/* 1753 */       check_orphaned();
/* 1754 */       return get_store().count_elements(PATTERN$32);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPatternArray(PatternDocument.Pattern[] paramArrayOfPattern) {
/* 1763 */     synchronized (monitor()) {
/*      */       
/* 1765 */       check_orphaned();
/* 1766 */       arraySetterHelper((XmlObject[])paramArrayOfPattern, PATTERN$32);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPatternArray(int paramInt, PatternDocument.Pattern paramPattern) {
/* 1775 */     synchronized (monitor()) {
/*      */       
/* 1777 */       check_orphaned();
/* 1778 */       PatternDocument.Pattern pattern = null;
/* 1779 */       pattern = (PatternDocument.Pattern)get_store().find_element_user(PATTERN$32, paramInt);
/* 1780 */       if (pattern == null)
/*      */       {
/* 1782 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1784 */       pattern.set((XmlObject)paramPattern);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PatternDocument.Pattern insertNewPattern(int paramInt) {
/* 1793 */     synchronized (monitor()) {
/*      */       
/* 1795 */       check_orphaned();
/* 1796 */       PatternDocument.Pattern pattern = null;
/* 1797 */       pattern = (PatternDocument.Pattern)get_store().insert_element_user(PATTERN$32, paramInt);
/* 1798 */       return pattern;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PatternDocument.Pattern addNewPattern() {
/* 1807 */     synchronized (monitor()) {
/*      */       
/* 1809 */       check_orphaned();
/* 1810 */       PatternDocument.Pattern pattern = null;
/* 1811 */       pattern = (PatternDocument.Pattern)get_store().add_element_user(PATTERN$32);
/* 1812 */       return pattern;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePattern(int paramInt) {
/* 1821 */     synchronized (monitor()) {
/*      */       
/* 1823 */       check_orphaned();
/* 1824 */       get_store().remove_element(PATTERN$32, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute[] getAttributeArray() {
/* 1833 */     synchronized (monitor()) {
/*      */       
/* 1835 */       check_orphaned();
/* 1836 */       ArrayList arrayList = new ArrayList();
/* 1837 */       get_store().find_all_element_users(ATTRIBUTE$34, arrayList);
/* 1838 */       Attribute[] arrayOfAttribute = new Attribute[arrayList.size()];
/* 1839 */       arrayList.toArray((Object[])arrayOfAttribute);
/* 1840 */       return arrayOfAttribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute getAttributeArray(int paramInt) {
/* 1849 */     synchronized (monitor()) {
/*      */       
/* 1851 */       check_orphaned();
/* 1852 */       Attribute attribute = null;
/* 1853 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$34, paramInt);
/* 1854 */       if (attribute == null)
/*      */       {
/* 1856 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1858 */       return attribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfAttributeArray() {
/* 1867 */     synchronized (monitor()) {
/*      */       
/* 1869 */       check_orphaned();
/* 1870 */       return get_store().count_elements(ATTRIBUTE$34);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeArray(Attribute[] paramArrayOfAttribute) {
/* 1879 */     synchronized (monitor()) {
/*      */       
/* 1881 */       check_orphaned();
/* 1882 */       arraySetterHelper((XmlObject[])paramArrayOfAttribute, ATTRIBUTE$34);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeArray(int paramInt, Attribute paramAttribute) {
/* 1891 */     synchronized (monitor()) {
/*      */       
/* 1893 */       check_orphaned();
/* 1894 */       Attribute attribute = null;
/* 1895 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$34, paramInt);
/* 1896 */       if (attribute == null)
/*      */       {
/* 1898 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1900 */       attribute.set((XmlObject)paramAttribute);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute insertNewAttribute(int paramInt) {
/* 1909 */     synchronized (monitor()) {
/*      */       
/* 1911 */       check_orphaned();
/* 1912 */       Attribute attribute = null;
/* 1913 */       attribute = (Attribute)get_store().insert_element_user(ATTRIBUTE$34, paramInt);
/* 1914 */       return attribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute addNewAttribute() {
/* 1923 */     synchronized (monitor()) {
/*      */       
/* 1925 */       check_orphaned();
/* 1926 */       Attribute attribute = null;
/* 1927 */       attribute = (Attribute)get_store().add_element_user(ATTRIBUTE$34);
/* 1928 */       return attribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAttribute(int paramInt) {
/* 1937 */     synchronized (monitor()) {
/*      */       
/* 1939 */       check_orphaned();
/* 1940 */       get_store().remove_element(ATTRIBUTE$34, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef[] getAttributeGroupArray() {
/* 1949 */     synchronized (monitor()) {
/*      */       
/* 1951 */       check_orphaned();
/* 1952 */       ArrayList arrayList = new ArrayList();
/* 1953 */       get_store().find_all_element_users(ATTRIBUTEGROUP$36, arrayList);
/* 1954 */       AttributeGroupRef[] arrayOfAttributeGroupRef = new AttributeGroupRef[arrayList.size()];
/* 1955 */       arrayList.toArray((Object[])arrayOfAttributeGroupRef);
/* 1956 */       return arrayOfAttributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef getAttributeGroupArray(int paramInt) {
/* 1965 */     synchronized (monitor()) {
/*      */       
/* 1967 */       check_orphaned();
/* 1968 */       AttributeGroupRef attributeGroupRef = null;
/* 1969 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$36, paramInt);
/* 1970 */       if (attributeGroupRef == null)
/*      */       {
/* 1972 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1974 */       return attributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfAttributeGroupArray() {
/* 1983 */     synchronized (monitor()) {
/*      */       
/* 1985 */       check_orphaned();
/* 1986 */       return get_store().count_elements(ATTRIBUTEGROUP$36);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeGroupArray(AttributeGroupRef[] paramArrayOfAttributeGroupRef) {
/* 1995 */     synchronized (monitor()) {
/*      */       
/* 1997 */       check_orphaned();
/* 1998 */       arraySetterHelper((XmlObject[])paramArrayOfAttributeGroupRef, ATTRIBUTEGROUP$36);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeGroupArray(int paramInt, AttributeGroupRef paramAttributeGroupRef) {
/* 2007 */     synchronized (monitor()) {
/*      */       
/* 2009 */       check_orphaned();
/* 2010 */       AttributeGroupRef attributeGroupRef = null;
/* 2011 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$36, paramInt);
/* 2012 */       if (attributeGroupRef == null)
/*      */       {
/* 2014 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2016 */       attributeGroupRef.set((XmlObject)paramAttributeGroupRef);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef insertNewAttributeGroup(int paramInt) {
/* 2025 */     synchronized (monitor()) {
/*      */       
/* 2027 */       check_orphaned();
/* 2028 */       AttributeGroupRef attributeGroupRef = null;
/* 2029 */       attributeGroupRef = (AttributeGroupRef)get_store().insert_element_user(ATTRIBUTEGROUP$36, paramInt);
/* 2030 */       return attributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef addNewAttributeGroup() {
/* 2039 */     synchronized (monitor()) {
/*      */       
/* 2041 */       check_orphaned();
/* 2042 */       AttributeGroupRef attributeGroupRef = null;
/* 2043 */       attributeGroupRef = (AttributeGroupRef)get_store().add_element_user(ATTRIBUTEGROUP$36);
/* 2044 */       return attributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAttributeGroup(int paramInt) {
/* 2053 */     synchronized (monitor()) {
/*      */       
/* 2055 */       check_orphaned();
/* 2056 */       get_store().remove_element(ATTRIBUTEGROUP$36, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Wildcard getAnyAttribute() {
/* 2065 */     synchronized (monitor()) {
/*      */       
/* 2067 */       check_orphaned();
/* 2068 */       Wildcard wildcard = null;
/* 2069 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$38, 0);
/* 2070 */       if (wildcard == null)
/*      */       {
/* 2072 */         return null;
/*      */       }
/* 2074 */       return wildcard;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetAnyAttribute() {
/* 2083 */     synchronized (monitor()) {
/*      */       
/* 2085 */       check_orphaned();
/* 2086 */       return (get_store().count_elements(ANYATTRIBUTE$38) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnyAttribute(Wildcard paramWildcard) {
/* 2095 */     synchronized (monitor()) {
/*      */       
/* 2097 */       check_orphaned();
/* 2098 */       Wildcard wildcard = null;
/* 2099 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$38, 0);
/* 2100 */       if (wildcard == null)
/*      */       {
/* 2102 */         wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$38);
/*      */       }
/* 2104 */       wildcard.set((XmlObject)paramWildcard);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Wildcard addNewAnyAttribute() {
/* 2113 */     synchronized (monitor()) {
/*      */       
/* 2115 */       check_orphaned();
/* 2116 */       Wildcard wildcard = null;
/* 2117 */       wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$38);
/* 2118 */       return wildcard;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetAnyAttribute() {
/* 2127 */     synchronized (monitor()) {
/*      */       
/* 2129 */       check_orphaned();
/* 2130 */       get_store().remove_element(ANYATTRIBUTE$38, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b getBase() {
/* 2139 */     synchronized (monitor()) {
/*      */       
/* 2141 */       check_orphaned();
/* 2142 */       SimpleValue simpleValue = null;
/* 2143 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$40);
/* 2144 */       if (simpleValue == null)
/*      */       {
/* 2146 */         return null;
/*      */       }
/* 2148 */       return simpleValue.getQNameValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlQName xgetBase() {
/* 2157 */     synchronized (monitor()) {
/*      */       
/* 2159 */       check_orphaned();
/* 2160 */       XmlQName xmlQName = null;
/* 2161 */       xmlQName = (XmlQName)get_store().find_attribute_user(BASE$40);
/* 2162 */       return xmlQName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBase(b paramb) {
/* 2171 */     synchronized (monitor()) {
/*      */       
/* 2173 */       check_orphaned();
/* 2174 */       SimpleValue simpleValue = null;
/* 2175 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$40);
/* 2176 */       if (simpleValue == null)
/*      */       {
/* 2178 */         simpleValue = (SimpleValue)get_store().add_attribute_user(BASE$40);
/*      */       }
/* 2180 */       simpleValue.setQNameValue(paramb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetBase(XmlQName paramXmlQName) {
/* 2189 */     synchronized (monitor()) {
/*      */       
/* 2191 */       check_orphaned();
/* 2192 */       XmlQName xmlQName = null;
/* 2193 */       xmlQName = (XmlQName)get_store().find_attribute_user(BASE$40);
/* 2194 */       if (xmlQName == null)
/*      */       {
/* 2196 */         xmlQName = (XmlQName)get_store().add_attribute_user(BASE$40);
/*      */       }
/* 2198 */       xmlQName.set((XmlObject)paramXmlQName);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\RestrictionTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */