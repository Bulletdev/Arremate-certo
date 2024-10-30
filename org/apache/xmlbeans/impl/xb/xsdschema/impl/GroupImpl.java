/*      */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlNCName;
/*      */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlQName;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.All;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
/*      */ 
/*      */ public class GroupImpl extends AnnotatedImpl implements Group {
/*      */   public GroupImpl(SchemaType paramSchemaType) {
/*   19 */     super(paramSchemaType);
/*      */   }
/*      */   
/*   22 */   private static final b ELEMENT$0 = new b("http://www.w3.org/2001/XMLSchema", "element");
/*      */   
/*   24 */   private static final b GROUP$2 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*      */   
/*   26 */   private static final b ALL$4 = new b("http://www.w3.org/2001/XMLSchema", "all");
/*      */   
/*   28 */   private static final b CHOICE$6 = new b("http://www.w3.org/2001/XMLSchema", "choice");
/*      */   
/*   30 */   private static final b SEQUENCE$8 = new b("http://www.w3.org/2001/XMLSchema", "sequence");
/*      */   
/*   32 */   private static final b ANY$10 = new b("http://www.w3.org/2001/XMLSchema", "any");
/*      */   
/*   34 */   private static final b NAME$12 = new b("", "name");
/*      */   
/*   36 */   private static final b REF$14 = new b("", "ref");
/*      */   
/*   38 */   private static final b MINOCCURS$16 = new b("", "minOccurs");
/*      */   
/*   40 */   private static final b MAXOCCURS$18 = new b("", "maxOccurs");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalElement[] getElementArray() {
/*   49 */     synchronized (monitor()) {
/*      */       
/*   51 */       check_orphaned();
/*   52 */       ArrayList arrayList = new ArrayList();
/*   53 */       get_store().find_all_element_users(ELEMENT$0, arrayList);
/*   54 */       LocalElement[] arrayOfLocalElement = new LocalElement[arrayList.size()];
/*   55 */       arrayList.toArray((Object[])arrayOfLocalElement);
/*   56 */       return arrayOfLocalElement;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalElement getElementArray(int paramInt) {
/*   65 */     synchronized (monitor()) {
/*      */       
/*   67 */       check_orphaned();
/*   68 */       LocalElement localElement = null;
/*   69 */       localElement = (LocalElement)get_store().find_element_user(ELEMENT$0, paramInt);
/*   70 */       if (localElement == null)
/*      */       {
/*   72 */         throw new IndexOutOfBoundsException();
/*      */       }
/*   74 */       return localElement;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfElementArray() {
/*   83 */     synchronized (monitor()) {
/*      */       
/*   85 */       check_orphaned();
/*   86 */       return get_store().count_elements(ELEMENT$0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setElementArray(LocalElement[] paramArrayOfLocalElement) {
/*   95 */     synchronized (monitor()) {
/*      */       
/*   97 */       check_orphaned();
/*   98 */       arraySetterHelper((XmlObject[])paramArrayOfLocalElement, ELEMENT$0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setElementArray(int paramInt, LocalElement paramLocalElement) {
/*  107 */     synchronized (monitor()) {
/*      */       
/*  109 */       check_orphaned();
/*  110 */       LocalElement localElement = null;
/*  111 */       localElement = (LocalElement)get_store().find_element_user(ELEMENT$0, paramInt);
/*  112 */       if (localElement == null)
/*      */       {
/*  114 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  116 */       localElement.set((XmlObject)paramLocalElement);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalElement insertNewElement(int paramInt) {
/*  125 */     synchronized (monitor()) {
/*      */       
/*  127 */       check_orphaned();
/*  128 */       LocalElement localElement = null;
/*  129 */       localElement = (LocalElement)get_store().insert_element_user(ELEMENT$0, paramInt);
/*  130 */       return localElement;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalElement addNewElement() {
/*  139 */     synchronized (monitor()) {
/*      */       
/*  141 */       check_orphaned();
/*  142 */       LocalElement localElement = null;
/*  143 */       localElement = (LocalElement)get_store().add_element_user(ELEMENT$0);
/*  144 */       return localElement;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeElement(int paramInt) {
/*  153 */     synchronized (monitor()) {
/*      */       
/*  155 */       check_orphaned();
/*  156 */       get_store().remove_element(ELEMENT$0, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef[] getGroupArray() {
/*  165 */     synchronized (monitor()) {
/*      */       
/*  167 */       check_orphaned();
/*  168 */       ArrayList arrayList = new ArrayList();
/*  169 */       get_store().find_all_element_users(GROUP$2, arrayList);
/*  170 */       GroupRef[] arrayOfGroupRef = new GroupRef[arrayList.size()];
/*  171 */       arrayList.toArray((Object[])arrayOfGroupRef);
/*  172 */       return arrayOfGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef getGroupArray(int paramInt) {
/*  181 */     synchronized (monitor()) {
/*      */       
/*  183 */       check_orphaned();
/*  184 */       GroupRef groupRef = null;
/*  185 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$2, paramInt);
/*  186 */       if (groupRef == null)
/*      */       {
/*  188 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  190 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfGroupArray() {
/*  199 */     synchronized (monitor()) {
/*      */       
/*  201 */       check_orphaned();
/*  202 */       return get_store().count_elements(GROUP$2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroupArray(GroupRef[] paramArrayOfGroupRef) {
/*  211 */     synchronized (monitor()) {
/*      */       
/*  213 */       check_orphaned();
/*  214 */       arraySetterHelper((XmlObject[])paramArrayOfGroupRef, GROUP$2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroupArray(int paramInt, GroupRef paramGroupRef) {
/*  223 */     synchronized (monitor()) {
/*      */       
/*  225 */       check_orphaned();
/*  226 */       GroupRef groupRef = null;
/*  227 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$2, paramInt);
/*  228 */       if (groupRef == null)
/*      */       {
/*  230 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  232 */       groupRef.set((XmlObject)paramGroupRef);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef insertNewGroup(int paramInt) {
/*  241 */     synchronized (monitor()) {
/*      */       
/*  243 */       check_orphaned();
/*  244 */       GroupRef groupRef = null;
/*  245 */       groupRef = (GroupRef)get_store().insert_element_user(GROUP$2, paramInt);
/*  246 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef addNewGroup() {
/*  255 */     synchronized (monitor()) {
/*      */       
/*  257 */       check_orphaned();
/*  258 */       GroupRef groupRef = null;
/*  259 */       groupRef = (GroupRef)get_store().add_element_user(GROUP$2);
/*  260 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeGroup(int paramInt) {
/*  269 */     synchronized (monitor()) {
/*      */       
/*  271 */       check_orphaned();
/*  272 */       get_store().remove_element(GROUP$2, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All[] getAllArray() {
/*  281 */     synchronized (monitor()) {
/*      */       
/*  283 */       check_orphaned();
/*  284 */       ArrayList arrayList = new ArrayList();
/*  285 */       get_store().find_all_element_users(ALL$4, arrayList);
/*  286 */       All[] arrayOfAll = new All[arrayList.size()];
/*  287 */       arrayList.toArray((Object[])arrayOfAll);
/*  288 */       return arrayOfAll;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All getAllArray(int paramInt) {
/*  297 */     synchronized (monitor()) {
/*      */       
/*  299 */       check_orphaned();
/*  300 */       All all = null;
/*  301 */       all = (All)get_store().find_element_user(ALL$4, paramInt);
/*  302 */       if (all == null)
/*      */       {
/*  304 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  306 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfAllArray() {
/*  315 */     synchronized (monitor()) {
/*      */       
/*  317 */       check_orphaned();
/*  318 */       return get_store().count_elements(ALL$4);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAllArray(All[] paramArrayOfAll) {
/*  327 */     synchronized (monitor()) {
/*      */       
/*  329 */       check_orphaned();
/*  330 */       arraySetterHelper((XmlObject[])paramArrayOfAll, ALL$4);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAllArray(int paramInt, All paramAll) {
/*  339 */     synchronized (monitor()) {
/*      */       
/*  341 */       check_orphaned();
/*  342 */       All all = null;
/*  343 */       all = (All)get_store().find_element_user(ALL$4, paramInt);
/*  344 */       if (all == null)
/*      */       {
/*  346 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  348 */       all.set((XmlObject)paramAll);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All insertNewAll(int paramInt) {
/*  357 */     synchronized (monitor()) {
/*      */       
/*  359 */       check_orphaned();
/*  360 */       All all = null;
/*  361 */       all = (All)get_store().insert_element_user(ALL$4, paramInt);
/*  362 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All addNewAll() {
/*  371 */     synchronized (monitor()) {
/*      */       
/*  373 */       check_orphaned();
/*  374 */       All all = null;
/*  375 */       all = (All)get_store().add_element_user(ALL$4);
/*  376 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAll(int paramInt) {
/*  385 */     synchronized (monitor()) {
/*      */       
/*  387 */       check_orphaned();
/*  388 */       get_store().remove_element(ALL$4, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup[] getChoiceArray() {
/*  397 */     synchronized (monitor()) {
/*      */       
/*  399 */       check_orphaned();
/*  400 */       ArrayList arrayList = new ArrayList();
/*  401 */       get_store().find_all_element_users(CHOICE$6, arrayList);
/*  402 */       ExplicitGroup[] arrayOfExplicitGroup = new ExplicitGroup[arrayList.size()];
/*  403 */       arrayList.toArray((Object[])arrayOfExplicitGroup);
/*  404 */       return arrayOfExplicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup getChoiceArray(int paramInt) {
/*  413 */     synchronized (monitor()) {
/*      */       
/*  415 */       check_orphaned();
/*  416 */       ExplicitGroup explicitGroup = null;
/*  417 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$6, paramInt);
/*  418 */       if (explicitGroup == null)
/*      */       {
/*  420 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  422 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfChoiceArray() {
/*  431 */     synchronized (monitor()) {
/*      */       
/*  433 */       check_orphaned();
/*  434 */       return get_store().count_elements(CHOICE$6);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChoiceArray(ExplicitGroup[] paramArrayOfExplicitGroup) {
/*  443 */     synchronized (monitor()) {
/*      */       
/*  445 */       check_orphaned();
/*  446 */       arraySetterHelper((XmlObject[])paramArrayOfExplicitGroup, CHOICE$6);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChoiceArray(int paramInt, ExplicitGroup paramExplicitGroup) {
/*  455 */     synchronized (monitor()) {
/*      */       
/*  457 */       check_orphaned();
/*  458 */       ExplicitGroup explicitGroup = null;
/*  459 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$6, paramInt);
/*  460 */       if (explicitGroup == null)
/*      */       {
/*  462 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  464 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup insertNewChoice(int paramInt) {
/*  473 */     synchronized (monitor()) {
/*      */       
/*  475 */       check_orphaned();
/*  476 */       ExplicitGroup explicitGroup = null;
/*  477 */       explicitGroup = (ExplicitGroup)get_store().insert_element_user(CHOICE$6, paramInt);
/*  478 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup addNewChoice() {
/*  487 */     synchronized (monitor()) {
/*      */       
/*  489 */       check_orphaned();
/*  490 */       ExplicitGroup explicitGroup = null;
/*  491 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$6);
/*  492 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeChoice(int paramInt) {
/*  501 */     synchronized (monitor()) {
/*      */       
/*  503 */       check_orphaned();
/*  504 */       get_store().remove_element(CHOICE$6, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup[] getSequenceArray() {
/*  513 */     synchronized (monitor()) {
/*      */       
/*  515 */       check_orphaned();
/*  516 */       ArrayList arrayList = new ArrayList();
/*  517 */       get_store().find_all_element_users(SEQUENCE$8, arrayList);
/*  518 */       ExplicitGroup[] arrayOfExplicitGroup = new ExplicitGroup[arrayList.size()];
/*  519 */       arrayList.toArray((Object[])arrayOfExplicitGroup);
/*  520 */       return arrayOfExplicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup getSequenceArray(int paramInt) {
/*  529 */     synchronized (monitor()) {
/*      */       
/*  531 */       check_orphaned();
/*  532 */       ExplicitGroup explicitGroup = null;
/*  533 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$8, paramInt);
/*  534 */       if (explicitGroup == null)
/*      */       {
/*  536 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  538 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfSequenceArray() {
/*  547 */     synchronized (monitor()) {
/*      */       
/*  549 */       check_orphaned();
/*  550 */       return get_store().count_elements(SEQUENCE$8);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequenceArray(ExplicitGroup[] paramArrayOfExplicitGroup) {
/*  559 */     synchronized (monitor()) {
/*      */       
/*  561 */       check_orphaned();
/*  562 */       arraySetterHelper((XmlObject[])paramArrayOfExplicitGroup, SEQUENCE$8);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequenceArray(int paramInt, ExplicitGroup paramExplicitGroup) {
/*  571 */     synchronized (monitor()) {
/*      */       
/*  573 */       check_orphaned();
/*  574 */       ExplicitGroup explicitGroup = null;
/*  575 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$8, paramInt);
/*  576 */       if (explicitGroup == null)
/*      */       {
/*  578 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  580 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup insertNewSequence(int paramInt) {
/*  589 */     synchronized (monitor()) {
/*      */       
/*  591 */       check_orphaned();
/*  592 */       ExplicitGroup explicitGroup = null;
/*  593 */       explicitGroup = (ExplicitGroup)get_store().insert_element_user(SEQUENCE$8, paramInt);
/*  594 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup addNewSequence() {
/*  603 */     synchronized (monitor()) {
/*      */       
/*  605 */       check_orphaned();
/*  606 */       ExplicitGroup explicitGroup = null;
/*  607 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$8);
/*  608 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeSequence(int paramInt) {
/*  617 */     synchronized (monitor()) {
/*      */       
/*  619 */       check_orphaned();
/*  620 */       get_store().remove_element(SEQUENCE$8, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AnyDocument.Any[] getAnyArray() {
/*  629 */     synchronized (monitor()) {
/*      */       
/*  631 */       check_orphaned();
/*  632 */       ArrayList arrayList = new ArrayList();
/*  633 */       get_store().find_all_element_users(ANY$10, arrayList);
/*  634 */       AnyDocument.Any[] arrayOfAny = new AnyDocument.Any[arrayList.size()];
/*  635 */       arrayList.toArray((Object[])arrayOfAny);
/*  636 */       return arrayOfAny;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AnyDocument.Any getAnyArray(int paramInt) {
/*  645 */     synchronized (monitor()) {
/*      */       
/*  647 */       check_orphaned();
/*  648 */       AnyDocument.Any any = null;
/*  649 */       any = (AnyDocument.Any)get_store().find_element_user(ANY$10, paramInt);
/*  650 */       if (any == null)
/*      */       {
/*  652 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  654 */       return any;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfAnyArray() {
/*  663 */     synchronized (monitor()) {
/*      */       
/*  665 */       check_orphaned();
/*  666 */       return get_store().count_elements(ANY$10);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnyArray(AnyDocument.Any[] paramArrayOfAny) {
/*  675 */     synchronized (monitor()) {
/*      */       
/*  677 */       check_orphaned();
/*  678 */       arraySetterHelper((XmlObject[])paramArrayOfAny, ANY$10);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnyArray(int paramInt, AnyDocument.Any paramAny) {
/*  687 */     synchronized (monitor()) {
/*      */       
/*  689 */       check_orphaned();
/*  690 */       AnyDocument.Any any = null;
/*  691 */       any = (AnyDocument.Any)get_store().find_element_user(ANY$10, paramInt);
/*  692 */       if (any == null)
/*      */       {
/*  694 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  696 */       any.set((XmlObject)paramAny);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AnyDocument.Any insertNewAny(int paramInt) {
/*  705 */     synchronized (monitor()) {
/*      */       
/*  707 */       check_orphaned();
/*  708 */       AnyDocument.Any any = null;
/*  709 */       any = (AnyDocument.Any)get_store().insert_element_user(ANY$10, paramInt);
/*  710 */       return any;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AnyDocument.Any addNewAny() {
/*  719 */     synchronized (monitor()) {
/*      */       
/*  721 */       check_orphaned();
/*  722 */       AnyDocument.Any any = null;
/*  723 */       any = (AnyDocument.Any)get_store().add_element_user(ANY$10);
/*  724 */       return any;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAny(int paramInt) {
/*  733 */     synchronized (monitor()) {
/*      */       
/*  735 */       check_orphaned();
/*  736 */       get_store().remove_element(ANY$10, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  745 */     synchronized (monitor()) {
/*      */       
/*  747 */       check_orphaned();
/*  748 */       SimpleValue simpleValue = null;
/*  749 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$12);
/*  750 */       if (simpleValue == null)
/*      */       {
/*  752 */         return null;
/*      */       }
/*  754 */       return simpleValue.getStringValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlNCName xgetName() {
/*  763 */     synchronized (monitor()) {
/*      */       
/*  765 */       check_orphaned();
/*  766 */       XmlNCName xmlNCName = null;
/*  767 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$12);
/*  768 */       return xmlNCName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetName() {
/*  777 */     synchronized (monitor()) {
/*      */       
/*  779 */       check_orphaned();
/*  780 */       return (get_store().find_attribute_user(NAME$12) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String paramString) {
/*  789 */     synchronized (monitor()) {
/*      */       
/*  791 */       check_orphaned();
/*  792 */       SimpleValue simpleValue = null;
/*  793 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$12);
/*  794 */       if (simpleValue == null)
/*      */       {
/*  796 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$12);
/*      */       }
/*  798 */       simpleValue.setStringValue(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetName(XmlNCName paramXmlNCName) {
/*  807 */     synchronized (monitor()) {
/*      */       
/*  809 */       check_orphaned();
/*  810 */       XmlNCName xmlNCName = null;
/*  811 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$12);
/*  812 */       if (xmlNCName == null)
/*      */       {
/*  814 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$12);
/*      */       }
/*  816 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetName() {
/*  825 */     synchronized (monitor()) {
/*      */       
/*  827 */       check_orphaned();
/*  828 */       get_store().remove_attribute(NAME$12);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b getRef() {
/*  837 */     synchronized (monitor()) {
/*      */       
/*  839 */       check_orphaned();
/*  840 */       SimpleValue simpleValue = null;
/*  841 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$14);
/*  842 */       if (simpleValue == null)
/*      */       {
/*  844 */         return null;
/*      */       }
/*  846 */       return simpleValue.getQNameValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlQName xgetRef() {
/*  855 */     synchronized (monitor()) {
/*      */       
/*  857 */       check_orphaned();
/*  858 */       XmlQName xmlQName = null;
/*  859 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$14);
/*  860 */       return xmlQName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetRef() {
/*  869 */     synchronized (monitor()) {
/*      */       
/*  871 */       check_orphaned();
/*  872 */       return (get_store().find_attribute_user(REF$14) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRef(b paramb) {
/*  881 */     synchronized (monitor()) {
/*      */       
/*  883 */       check_orphaned();
/*  884 */       SimpleValue simpleValue = null;
/*  885 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$14);
/*  886 */       if (simpleValue == null)
/*      */       {
/*  888 */         simpleValue = (SimpleValue)get_store().add_attribute_user(REF$14);
/*      */       }
/*  890 */       simpleValue.setQNameValue(paramb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetRef(XmlQName paramXmlQName) {
/*  899 */     synchronized (monitor()) {
/*      */       
/*  901 */       check_orphaned();
/*  902 */       XmlQName xmlQName = null;
/*  903 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$14);
/*  904 */       if (xmlQName == null)
/*      */       {
/*  906 */         xmlQName = (XmlQName)get_store().add_attribute_user(REF$14);
/*      */       }
/*  908 */       xmlQName.set((XmlObject)paramXmlQName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetRef() {
/*  917 */     synchronized (monitor()) {
/*      */       
/*  919 */       check_orphaned();
/*  920 */       get_store().remove_attribute(REF$14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getMinOccurs() {
/*  929 */     synchronized (monitor()) {
/*      */       
/*  931 */       check_orphaned();
/*  932 */       SimpleValue simpleValue = null;
/*  933 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MINOCCURS$16);
/*  934 */       if (simpleValue == null)
/*      */       {
/*  936 */         simpleValue = (SimpleValue)get_default_attribute_value(MINOCCURS$16);
/*      */       }
/*  938 */       if (simpleValue == null)
/*      */       {
/*  940 */         return null;
/*      */       }
/*  942 */       return simpleValue.getBigIntegerValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlNonNegativeInteger xgetMinOccurs() {
/*  951 */     synchronized (monitor()) {
/*      */       
/*  953 */       check_orphaned();
/*  954 */       XmlNonNegativeInteger xmlNonNegativeInteger = null;
/*  955 */       xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$16);
/*  956 */       if (xmlNonNegativeInteger == null)
/*      */       {
/*  958 */         xmlNonNegativeInteger = (XmlNonNegativeInteger)get_default_attribute_value(MINOCCURS$16);
/*      */       }
/*  960 */       return xmlNonNegativeInteger;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetMinOccurs() {
/*  969 */     synchronized (monitor()) {
/*      */       
/*  971 */       check_orphaned();
/*  972 */       return (get_store().find_attribute_user(MINOCCURS$16) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinOccurs(BigInteger paramBigInteger) {
/*  981 */     synchronized (monitor()) {
/*      */       
/*  983 */       check_orphaned();
/*  984 */       SimpleValue simpleValue = null;
/*  985 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MINOCCURS$16);
/*  986 */       if (simpleValue == null)
/*      */       {
/*  988 */         simpleValue = (SimpleValue)get_store().add_attribute_user(MINOCCURS$16);
/*      */       }
/*  990 */       simpleValue.setBigIntegerValue(paramBigInteger);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetMinOccurs(XmlNonNegativeInteger paramXmlNonNegativeInteger) {
/*  999 */     synchronized (monitor()) {
/*      */       
/* 1001 */       check_orphaned();
/* 1002 */       XmlNonNegativeInteger xmlNonNegativeInteger = null;
/* 1003 */       xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$16);
/* 1004 */       if (xmlNonNegativeInteger == null)
/*      */       {
/* 1006 */         xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().add_attribute_user(MINOCCURS$16);
/*      */       }
/* 1008 */       xmlNonNegativeInteger.set((XmlObject)paramXmlNonNegativeInteger);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetMinOccurs() {
/* 1017 */     synchronized (monitor()) {
/*      */       
/* 1019 */       check_orphaned();
/* 1020 */       get_store().remove_attribute(MINOCCURS$16);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getMaxOccurs() {
/* 1029 */     synchronized (monitor()) {
/*      */       
/* 1031 */       check_orphaned();
/* 1032 */       SimpleValue simpleValue = null;
/* 1033 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MAXOCCURS$18);
/* 1034 */       if (simpleValue == null)
/*      */       {
/* 1036 */         simpleValue = (SimpleValue)get_default_attribute_value(MAXOCCURS$18);
/*      */       }
/* 1038 */       if (simpleValue == null)
/*      */       {
/* 1040 */         return null;
/*      */       }
/* 1042 */       return simpleValue.getObjectValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AllNNI xgetMaxOccurs() {
/* 1051 */     synchronized (monitor()) {
/*      */       
/* 1053 */       check_orphaned();
/* 1054 */       AllNNI allNNI = null;
/* 1055 */       allNNI = (AllNNI)get_store().find_attribute_user(MAXOCCURS$18);
/* 1056 */       if (allNNI == null)
/*      */       {
/* 1058 */         allNNI = (AllNNI)get_default_attribute_value(MAXOCCURS$18);
/*      */       }
/* 1060 */       return allNNI;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetMaxOccurs() {
/* 1069 */     synchronized (monitor()) {
/*      */       
/* 1071 */       check_orphaned();
/* 1072 */       return (get_store().find_attribute_user(MAXOCCURS$18) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxOccurs(Object paramObject) {
/* 1081 */     synchronized (monitor()) {
/*      */       
/* 1083 */       check_orphaned();
/* 1084 */       SimpleValue simpleValue = null;
/* 1085 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MAXOCCURS$18);
/* 1086 */       if (simpleValue == null)
/*      */       {
/* 1088 */         simpleValue = (SimpleValue)get_store().add_attribute_user(MAXOCCURS$18);
/*      */       }
/* 1090 */       simpleValue.setObjectValue(paramObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetMaxOccurs(AllNNI paramAllNNI) {
/* 1099 */     synchronized (monitor()) {
/*      */       
/* 1101 */       check_orphaned();
/* 1102 */       AllNNI allNNI = null;
/* 1103 */       allNNI = (AllNNI)get_store().find_attribute_user(MAXOCCURS$18);
/* 1104 */       if (allNNI == null)
/*      */       {
/* 1106 */         allNNI = (AllNNI)get_store().add_attribute_user(MAXOCCURS$18);
/*      */       }
/* 1108 */       allNNI.set((XmlObject)paramAllNNI);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetMaxOccurs() {
/* 1117 */     synchronized (monitor()) {
/*      */       
/* 1119 */       check_orphaned();
/* 1120 */       get_store().remove_attribute(MAXOCCURS$18);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\GroupImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */