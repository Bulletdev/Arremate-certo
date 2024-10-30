/*      */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlBoolean;
/*      */ import org.apache.xmlbeans.XmlNCName;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.All;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*      */ 
/*      */ public class ComplexTypeImpl extends AnnotatedImpl implements ComplexType {
/*      */   public ComplexTypeImpl(SchemaType paramSchemaType) {
/*   19 */     super(paramSchemaType);
/*      */   }
/*      */   
/*   22 */   private static final b SIMPLECONTENT$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleContent");
/*      */   
/*   24 */   private static final b COMPLEXCONTENT$2 = new b("http://www.w3.org/2001/XMLSchema", "complexContent");
/*      */   
/*   26 */   private static final b GROUP$4 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*      */   
/*   28 */   private static final b ALL$6 = new b("http://www.w3.org/2001/XMLSchema", "all");
/*      */   
/*   30 */   private static final b CHOICE$8 = new b("http://www.w3.org/2001/XMLSchema", "choice");
/*      */   
/*   32 */   private static final b SEQUENCE$10 = new b("http://www.w3.org/2001/XMLSchema", "sequence");
/*      */   
/*   34 */   private static final b ATTRIBUTE$12 = new b("http://www.w3.org/2001/XMLSchema", "attribute");
/*      */   
/*   36 */   private static final b ATTRIBUTEGROUP$14 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*      */   
/*   38 */   private static final b ANYATTRIBUTE$16 = new b("http://www.w3.org/2001/XMLSchema", "anyAttribute");
/*      */   
/*   40 */   private static final b NAME$18 = new b("", "name");
/*      */   
/*   42 */   private static final b MIXED$20 = new b("", "mixed");
/*      */   
/*   44 */   private static final b ABSTRACT$22 = new b("", "abstract");
/*      */   
/*   46 */   private static final b FINAL$24 = new b("", "final");
/*      */   
/*   48 */   private static final b BLOCK$26 = new b("", "block");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SimpleContentDocument.SimpleContent getSimpleContent() {
/*   57 */     synchronized (monitor()) {
/*      */       
/*   59 */       check_orphaned();
/*   60 */       SimpleContentDocument.SimpleContent simpleContent = null;
/*   61 */       simpleContent = (SimpleContentDocument.SimpleContent)get_store().find_element_user(SIMPLECONTENT$0, 0);
/*   62 */       if (simpleContent == null)
/*      */       {
/*   64 */         return null;
/*      */       }
/*   66 */       return simpleContent;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetSimpleContent() {
/*   75 */     synchronized (monitor()) {
/*      */       
/*   77 */       check_orphaned();
/*   78 */       return (get_store().count_elements(SIMPLECONTENT$0) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSimpleContent(SimpleContentDocument.SimpleContent paramSimpleContent) {
/*   87 */     synchronized (monitor()) {
/*      */       
/*   89 */       check_orphaned();
/*   90 */       SimpleContentDocument.SimpleContent simpleContent = null;
/*   91 */       simpleContent = (SimpleContentDocument.SimpleContent)get_store().find_element_user(SIMPLECONTENT$0, 0);
/*   92 */       if (simpleContent == null)
/*      */       {
/*   94 */         simpleContent = (SimpleContentDocument.SimpleContent)get_store().add_element_user(SIMPLECONTENT$0);
/*      */       }
/*   96 */       simpleContent.set((XmlObject)paramSimpleContent);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SimpleContentDocument.SimpleContent addNewSimpleContent() {
/*  105 */     synchronized (monitor()) {
/*      */       
/*  107 */       check_orphaned();
/*  108 */       SimpleContentDocument.SimpleContent simpleContent = null;
/*  109 */       simpleContent = (SimpleContentDocument.SimpleContent)get_store().add_element_user(SIMPLECONTENT$0);
/*  110 */       return simpleContent;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetSimpleContent() {
/*  119 */     synchronized (monitor()) {
/*      */       
/*  121 */       check_orphaned();
/*  122 */       get_store().remove_element(SIMPLECONTENT$0, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ComplexContentDocument.ComplexContent getComplexContent() {
/*  131 */     synchronized (monitor()) {
/*      */       
/*  133 */       check_orphaned();
/*  134 */       ComplexContentDocument.ComplexContent complexContent = null;
/*  135 */       complexContent = (ComplexContentDocument.ComplexContent)get_store().find_element_user(COMPLEXCONTENT$2, 0);
/*  136 */       if (complexContent == null)
/*      */       {
/*  138 */         return null;
/*      */       }
/*  140 */       return complexContent;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetComplexContent() {
/*  149 */     synchronized (monitor()) {
/*      */       
/*  151 */       check_orphaned();
/*  152 */       return (get_store().count_elements(COMPLEXCONTENT$2) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setComplexContent(ComplexContentDocument.ComplexContent paramComplexContent) {
/*  161 */     synchronized (monitor()) {
/*      */       
/*  163 */       check_orphaned();
/*  164 */       ComplexContentDocument.ComplexContent complexContent = null;
/*  165 */       complexContent = (ComplexContentDocument.ComplexContent)get_store().find_element_user(COMPLEXCONTENT$2, 0);
/*  166 */       if (complexContent == null)
/*      */       {
/*  168 */         complexContent = (ComplexContentDocument.ComplexContent)get_store().add_element_user(COMPLEXCONTENT$2);
/*      */       }
/*  170 */       complexContent.set((XmlObject)paramComplexContent);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ComplexContentDocument.ComplexContent addNewComplexContent() {
/*  179 */     synchronized (monitor()) {
/*      */       
/*  181 */       check_orphaned();
/*  182 */       ComplexContentDocument.ComplexContent complexContent = null;
/*  183 */       complexContent = (ComplexContentDocument.ComplexContent)get_store().add_element_user(COMPLEXCONTENT$2);
/*  184 */       return complexContent;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetComplexContent() {
/*  193 */     synchronized (monitor()) {
/*      */       
/*  195 */       check_orphaned();
/*  196 */       get_store().remove_element(COMPLEXCONTENT$2, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef getGroup() {
/*  205 */     synchronized (monitor()) {
/*      */       
/*  207 */       check_orphaned();
/*  208 */       GroupRef groupRef = null;
/*  209 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$4, 0);
/*  210 */       if (groupRef == null)
/*      */       {
/*  212 */         return null;
/*      */       }
/*  214 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetGroup() {
/*  223 */     synchronized (monitor()) {
/*      */       
/*  225 */       check_orphaned();
/*  226 */       return (get_store().count_elements(GROUP$4) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGroup(GroupRef paramGroupRef) {
/*  235 */     synchronized (monitor()) {
/*      */       
/*  237 */       check_orphaned();
/*  238 */       GroupRef groupRef = null;
/*  239 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$4, 0);
/*  240 */       if (groupRef == null)
/*      */       {
/*  242 */         groupRef = (GroupRef)get_store().add_element_user(GROUP$4);
/*      */       }
/*  244 */       groupRef.set((XmlObject)paramGroupRef);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GroupRef addNewGroup() {
/*  253 */     synchronized (monitor()) {
/*      */       
/*  255 */       check_orphaned();
/*  256 */       GroupRef groupRef = null;
/*  257 */       groupRef = (GroupRef)get_store().add_element_user(GROUP$4);
/*  258 */       return groupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetGroup() {
/*  267 */     synchronized (monitor()) {
/*      */       
/*  269 */       check_orphaned();
/*  270 */       get_store().remove_element(GROUP$4, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All getAll() {
/*  279 */     synchronized (monitor()) {
/*      */       
/*  281 */       check_orphaned();
/*  282 */       All all = null;
/*  283 */       all = (All)get_store().find_element_user(ALL$6, 0);
/*  284 */       if (all == null)
/*      */       {
/*  286 */         return null;
/*      */       }
/*  288 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetAll() {
/*  297 */     synchronized (monitor()) {
/*      */       
/*  299 */       check_orphaned();
/*  300 */       return (get_store().count_elements(ALL$6) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAll(All paramAll) {
/*  309 */     synchronized (monitor()) {
/*      */       
/*  311 */       check_orphaned();
/*  312 */       All all = null;
/*  313 */       all = (All)get_store().find_element_user(ALL$6, 0);
/*  314 */       if (all == null)
/*      */       {
/*  316 */         all = (All)get_store().add_element_user(ALL$6);
/*      */       }
/*  318 */       all.set((XmlObject)paramAll);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public All addNewAll() {
/*  327 */     synchronized (monitor()) {
/*      */       
/*  329 */       check_orphaned();
/*  330 */       All all = null;
/*  331 */       all = (All)get_store().add_element_user(ALL$6);
/*  332 */       return all;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetAll() {
/*  341 */     synchronized (monitor()) {
/*      */       
/*  343 */       check_orphaned();
/*  344 */       get_store().remove_element(ALL$6, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup getChoice() {
/*  353 */     synchronized (monitor()) {
/*      */       
/*  355 */       check_orphaned();
/*  356 */       ExplicitGroup explicitGroup = null;
/*  357 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$8, 0);
/*  358 */       if (explicitGroup == null)
/*      */       {
/*  360 */         return null;
/*      */       }
/*  362 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetChoice() {
/*  371 */     synchronized (monitor()) {
/*      */       
/*  373 */       check_orphaned();
/*  374 */       return (get_store().count_elements(CHOICE$8) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChoice(ExplicitGroup paramExplicitGroup) {
/*  383 */     synchronized (monitor()) {
/*      */       
/*  385 */       check_orphaned();
/*  386 */       ExplicitGroup explicitGroup = null;
/*  387 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$8, 0);
/*  388 */       if (explicitGroup == null)
/*      */       {
/*  390 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$8);
/*      */       }
/*  392 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup addNewChoice() {
/*  401 */     synchronized (monitor()) {
/*      */       
/*  403 */       check_orphaned();
/*  404 */       ExplicitGroup explicitGroup = null;
/*  405 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$8);
/*  406 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetChoice() {
/*  415 */     synchronized (monitor()) {
/*      */       
/*  417 */       check_orphaned();
/*  418 */       get_store().remove_element(CHOICE$8, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup getSequence() {
/*  427 */     synchronized (monitor()) {
/*      */       
/*  429 */       check_orphaned();
/*  430 */       ExplicitGroup explicitGroup = null;
/*  431 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$10, 0);
/*  432 */       if (explicitGroup == null)
/*      */       {
/*  434 */         return null;
/*      */       }
/*  436 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetSequence() {
/*  445 */     synchronized (monitor()) {
/*      */       
/*  447 */       check_orphaned();
/*  448 */       return (get_store().count_elements(SEQUENCE$10) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSequence(ExplicitGroup paramExplicitGroup) {
/*  457 */     synchronized (monitor()) {
/*      */       
/*  459 */       check_orphaned();
/*  460 */       ExplicitGroup explicitGroup = null;
/*  461 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$10, 0);
/*  462 */       if (explicitGroup == null)
/*      */       {
/*  464 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$10);
/*      */       }
/*  466 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExplicitGroup addNewSequence() {
/*  475 */     synchronized (monitor()) {
/*      */       
/*  477 */       check_orphaned();
/*  478 */       ExplicitGroup explicitGroup = null;
/*  479 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$10);
/*  480 */       return explicitGroup;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetSequence() {
/*  489 */     synchronized (monitor()) {
/*      */       
/*  491 */       check_orphaned();
/*  492 */       get_store().remove_element(SEQUENCE$10, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute[] getAttributeArray() {
/*  501 */     synchronized (monitor()) {
/*      */       
/*  503 */       check_orphaned();
/*  504 */       ArrayList arrayList = new ArrayList();
/*  505 */       get_store().find_all_element_users(ATTRIBUTE$12, arrayList);
/*  506 */       Attribute[] arrayOfAttribute = new Attribute[arrayList.size()];
/*  507 */       arrayList.toArray((Object[])arrayOfAttribute);
/*  508 */       return arrayOfAttribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute getAttributeArray(int paramInt) {
/*  517 */     synchronized (monitor()) {
/*      */       
/*  519 */       check_orphaned();
/*  520 */       Attribute attribute = null;
/*  521 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$12, paramInt);
/*  522 */       if (attribute == null)
/*      */       {
/*  524 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  526 */       return attribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfAttributeArray() {
/*  535 */     synchronized (monitor()) {
/*      */       
/*  537 */       check_orphaned();
/*  538 */       return get_store().count_elements(ATTRIBUTE$12);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeArray(Attribute[] paramArrayOfAttribute) {
/*  547 */     synchronized (monitor()) {
/*      */       
/*  549 */       check_orphaned();
/*  550 */       arraySetterHelper((XmlObject[])paramArrayOfAttribute, ATTRIBUTE$12);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeArray(int paramInt, Attribute paramAttribute) {
/*  559 */     synchronized (monitor()) {
/*      */       
/*  561 */       check_orphaned();
/*  562 */       Attribute attribute = null;
/*  563 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$12, paramInt);
/*  564 */       if (attribute == null)
/*      */       {
/*  566 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  568 */       attribute.set((XmlObject)paramAttribute);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute insertNewAttribute(int paramInt) {
/*  577 */     synchronized (monitor()) {
/*      */       
/*  579 */       check_orphaned();
/*  580 */       Attribute attribute = null;
/*  581 */       attribute = (Attribute)get_store().insert_element_user(ATTRIBUTE$12, paramInt);
/*  582 */       return attribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute addNewAttribute() {
/*  591 */     synchronized (monitor()) {
/*      */       
/*  593 */       check_orphaned();
/*  594 */       Attribute attribute = null;
/*  595 */       attribute = (Attribute)get_store().add_element_user(ATTRIBUTE$12);
/*  596 */       return attribute;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAttribute(int paramInt) {
/*  605 */     synchronized (monitor()) {
/*      */       
/*  607 */       check_orphaned();
/*  608 */       get_store().remove_element(ATTRIBUTE$12, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef[] getAttributeGroupArray() {
/*  617 */     synchronized (monitor()) {
/*      */       
/*  619 */       check_orphaned();
/*  620 */       ArrayList arrayList = new ArrayList();
/*  621 */       get_store().find_all_element_users(ATTRIBUTEGROUP$14, arrayList);
/*  622 */       AttributeGroupRef[] arrayOfAttributeGroupRef = new AttributeGroupRef[arrayList.size()];
/*  623 */       arrayList.toArray((Object[])arrayOfAttributeGroupRef);
/*  624 */       return arrayOfAttributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef getAttributeGroupArray(int paramInt) {
/*  633 */     synchronized (monitor()) {
/*      */       
/*  635 */       check_orphaned();
/*  636 */       AttributeGroupRef attributeGroupRef = null;
/*  637 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$14, paramInt);
/*  638 */       if (attributeGroupRef == null)
/*      */       {
/*  640 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  642 */       return attributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfAttributeGroupArray() {
/*  651 */     synchronized (monitor()) {
/*      */       
/*  653 */       check_orphaned();
/*  654 */       return get_store().count_elements(ATTRIBUTEGROUP$14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeGroupArray(AttributeGroupRef[] paramArrayOfAttributeGroupRef) {
/*  663 */     synchronized (monitor()) {
/*      */       
/*  665 */       check_orphaned();
/*  666 */       arraySetterHelper((XmlObject[])paramArrayOfAttributeGroupRef, ATTRIBUTEGROUP$14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAttributeGroupArray(int paramInt, AttributeGroupRef paramAttributeGroupRef) {
/*  675 */     synchronized (monitor()) {
/*      */       
/*  677 */       check_orphaned();
/*  678 */       AttributeGroupRef attributeGroupRef = null;
/*  679 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$14, paramInt);
/*  680 */       if (attributeGroupRef == null)
/*      */       {
/*  682 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  684 */       attributeGroupRef.set((XmlObject)paramAttributeGroupRef);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef insertNewAttributeGroup(int paramInt) {
/*  693 */     synchronized (monitor()) {
/*      */       
/*  695 */       check_orphaned();
/*  696 */       AttributeGroupRef attributeGroupRef = null;
/*  697 */       attributeGroupRef = (AttributeGroupRef)get_store().insert_element_user(ATTRIBUTEGROUP$14, paramInt);
/*  698 */       return attributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AttributeGroupRef addNewAttributeGroup() {
/*  707 */     synchronized (monitor()) {
/*      */       
/*  709 */       check_orphaned();
/*  710 */       AttributeGroupRef attributeGroupRef = null;
/*  711 */       attributeGroupRef = (AttributeGroupRef)get_store().add_element_user(ATTRIBUTEGROUP$14);
/*  712 */       return attributeGroupRef;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeAttributeGroup(int paramInt) {
/*  721 */     synchronized (monitor()) {
/*      */       
/*  723 */       check_orphaned();
/*  724 */       get_store().remove_element(ATTRIBUTEGROUP$14, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Wildcard getAnyAttribute() {
/*  733 */     synchronized (monitor()) {
/*      */       
/*  735 */       check_orphaned();
/*  736 */       Wildcard wildcard = null;
/*  737 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$16, 0);
/*  738 */       if (wildcard == null)
/*      */       {
/*  740 */         return null;
/*      */       }
/*  742 */       return wildcard;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetAnyAttribute() {
/*  751 */     synchronized (monitor()) {
/*      */       
/*  753 */       check_orphaned();
/*  754 */       return (get_store().count_elements(ANYATTRIBUTE$16) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAnyAttribute(Wildcard paramWildcard) {
/*  763 */     synchronized (monitor()) {
/*      */       
/*  765 */       check_orphaned();
/*  766 */       Wildcard wildcard = null;
/*  767 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$16, 0);
/*  768 */       if (wildcard == null)
/*      */       {
/*  770 */         wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$16);
/*      */       }
/*  772 */       wildcard.set((XmlObject)paramWildcard);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Wildcard addNewAnyAttribute() {
/*  781 */     synchronized (monitor()) {
/*      */       
/*  783 */       check_orphaned();
/*  784 */       Wildcard wildcard = null;
/*  785 */       wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$16);
/*  786 */       return wildcard;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetAnyAttribute() {
/*  795 */     synchronized (monitor()) {
/*      */       
/*  797 */       check_orphaned();
/*  798 */       get_store().remove_element(ANYATTRIBUTE$16, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  807 */     synchronized (monitor()) {
/*      */       
/*  809 */       check_orphaned();
/*  810 */       SimpleValue simpleValue = null;
/*  811 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$18);
/*  812 */       if (simpleValue == null)
/*      */       {
/*  814 */         return null;
/*      */       }
/*  816 */       return simpleValue.getStringValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlNCName xgetName() {
/*  825 */     synchronized (monitor()) {
/*      */       
/*  827 */       check_orphaned();
/*  828 */       XmlNCName xmlNCName = null;
/*  829 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$18);
/*  830 */       return xmlNCName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetName() {
/*  839 */     synchronized (monitor()) {
/*      */       
/*  841 */       check_orphaned();
/*  842 */       return (get_store().find_attribute_user(NAME$18) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String paramString) {
/*  851 */     synchronized (monitor()) {
/*      */       
/*  853 */       check_orphaned();
/*  854 */       SimpleValue simpleValue = null;
/*  855 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$18);
/*  856 */       if (simpleValue == null)
/*      */       {
/*  858 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$18);
/*      */       }
/*  860 */       simpleValue.setStringValue(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetName(XmlNCName paramXmlNCName) {
/*  869 */     synchronized (monitor()) {
/*      */       
/*  871 */       check_orphaned();
/*  872 */       XmlNCName xmlNCName = null;
/*  873 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$18);
/*  874 */       if (xmlNCName == null)
/*      */       {
/*  876 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$18);
/*      */       }
/*  878 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetName() {
/*  887 */     synchronized (monitor()) {
/*      */       
/*  889 */       check_orphaned();
/*  890 */       get_store().remove_attribute(NAME$18);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getMixed() {
/*  899 */     synchronized (monitor()) {
/*      */       
/*  901 */       check_orphaned();
/*  902 */       SimpleValue simpleValue = null;
/*  903 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MIXED$20);
/*  904 */       if (simpleValue == null)
/*      */       {
/*  906 */         simpleValue = (SimpleValue)get_default_attribute_value(MIXED$20);
/*      */       }
/*  908 */       if (simpleValue == null)
/*      */       {
/*  910 */         return false;
/*      */       }
/*  912 */       return simpleValue.getBooleanValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlBoolean xgetMixed() {
/*  921 */     synchronized (monitor()) {
/*      */       
/*  923 */       check_orphaned();
/*  924 */       XmlBoolean xmlBoolean = null;
/*  925 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MIXED$20);
/*  926 */       if (xmlBoolean == null)
/*      */       {
/*  928 */         xmlBoolean = (XmlBoolean)get_default_attribute_value(MIXED$20);
/*      */       }
/*  930 */       return xmlBoolean;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetMixed() {
/*  939 */     synchronized (monitor()) {
/*      */       
/*  941 */       check_orphaned();
/*  942 */       return (get_store().find_attribute_user(MIXED$20) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMixed(boolean paramBoolean) {
/*  951 */     synchronized (monitor()) {
/*      */       
/*  953 */       check_orphaned();
/*  954 */       SimpleValue simpleValue = null;
/*  955 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MIXED$20);
/*  956 */       if (simpleValue == null)
/*      */       {
/*  958 */         simpleValue = (SimpleValue)get_store().add_attribute_user(MIXED$20);
/*      */       }
/*  960 */       simpleValue.setBooleanValue(paramBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetMixed(XmlBoolean paramXmlBoolean) {
/*  969 */     synchronized (monitor()) {
/*      */       
/*  971 */       check_orphaned();
/*  972 */       XmlBoolean xmlBoolean = null;
/*  973 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MIXED$20);
/*  974 */       if (xmlBoolean == null)
/*      */       {
/*  976 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MIXED$20);
/*      */       }
/*  978 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetMixed() {
/*  987 */     synchronized (monitor()) {
/*      */       
/*  989 */       check_orphaned();
/*  990 */       get_store().remove_attribute(MIXED$20);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAbstract() {
/*  999 */     synchronized (monitor()) {
/*      */       
/* 1001 */       check_orphaned();
/* 1002 */       SimpleValue simpleValue = null;
/* 1003 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ABSTRACT$22);
/* 1004 */       if (simpleValue == null)
/*      */       {
/* 1006 */         simpleValue = (SimpleValue)get_default_attribute_value(ABSTRACT$22);
/*      */       }
/* 1008 */       if (simpleValue == null)
/*      */       {
/* 1010 */         return false;
/*      */       }
/* 1012 */       return simpleValue.getBooleanValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlBoolean xgetAbstract() {
/* 1021 */     synchronized (monitor()) {
/*      */       
/* 1023 */       check_orphaned();
/* 1024 */       XmlBoolean xmlBoolean = null;
/* 1025 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ABSTRACT$22);
/* 1026 */       if (xmlBoolean == null)
/*      */       {
/* 1028 */         xmlBoolean = (XmlBoolean)get_default_attribute_value(ABSTRACT$22);
/*      */       }
/* 1030 */       return xmlBoolean;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetAbstract() {
/* 1039 */     synchronized (monitor()) {
/*      */       
/* 1041 */       check_orphaned();
/* 1042 */       return (get_store().find_attribute_user(ABSTRACT$22) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAbstract(boolean paramBoolean) {
/* 1051 */     synchronized (monitor()) {
/*      */       
/* 1053 */       check_orphaned();
/* 1054 */       SimpleValue simpleValue = null;
/* 1055 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ABSTRACT$22);
/* 1056 */       if (simpleValue == null)
/*      */       {
/* 1058 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ABSTRACT$22);
/*      */       }
/* 1060 */       simpleValue.setBooleanValue(paramBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetAbstract(XmlBoolean paramXmlBoolean) {
/* 1069 */     synchronized (monitor()) {
/*      */       
/* 1071 */       check_orphaned();
/* 1072 */       XmlBoolean xmlBoolean = null;
/* 1073 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ABSTRACT$22);
/* 1074 */       if (xmlBoolean == null)
/*      */       {
/* 1076 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ABSTRACT$22);
/*      */       }
/* 1078 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetAbstract() {
/* 1087 */     synchronized (monitor()) {
/*      */       
/* 1089 */       check_orphaned();
/* 1090 */       get_store().remove_attribute(ABSTRACT$22);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getFinal() {
/* 1099 */     synchronized (monitor()) {
/*      */       
/* 1101 */       check_orphaned();
/* 1102 */       SimpleValue simpleValue = null;
/* 1103 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FINAL$24);
/* 1104 */       if (simpleValue == null)
/*      */       {
/* 1106 */         return null;
/*      */       }
/* 1108 */       return simpleValue.getObjectValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DerivationSet xgetFinal() {
/* 1117 */     synchronized (monitor()) {
/*      */       
/* 1119 */       check_orphaned();
/* 1120 */       DerivationSet derivationSet = null;
/* 1121 */       derivationSet = (DerivationSet)get_store().find_attribute_user(FINAL$24);
/* 1122 */       return derivationSet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetFinal() {
/* 1131 */     synchronized (monitor()) {
/*      */       
/* 1133 */       check_orphaned();
/* 1134 */       return (get_store().find_attribute_user(FINAL$24) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFinal(Object paramObject) {
/* 1143 */     synchronized (monitor()) {
/*      */       
/* 1145 */       check_orphaned();
/* 1146 */       SimpleValue simpleValue = null;
/* 1147 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FINAL$24);
/* 1148 */       if (simpleValue == null)
/*      */       {
/* 1150 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FINAL$24);
/*      */       }
/* 1152 */       simpleValue.setObjectValue(paramObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetFinal(DerivationSet paramDerivationSet) {
/* 1161 */     synchronized (monitor()) {
/*      */       
/* 1163 */       check_orphaned();
/* 1164 */       DerivationSet derivationSet = null;
/* 1165 */       derivationSet = (DerivationSet)get_store().find_attribute_user(FINAL$24);
/* 1166 */       if (derivationSet == null)
/*      */       {
/* 1168 */         derivationSet = (DerivationSet)get_store().add_attribute_user(FINAL$24);
/*      */       }
/* 1170 */       derivationSet.set((XmlObject)paramDerivationSet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetFinal() {
/* 1179 */     synchronized (monitor()) {
/*      */       
/* 1181 */       check_orphaned();
/* 1182 */       get_store().remove_attribute(FINAL$24);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getBlock() {
/* 1191 */     synchronized (monitor()) {
/*      */       
/* 1193 */       check_orphaned();
/* 1194 */       SimpleValue simpleValue = null;
/* 1195 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCK$26);
/* 1196 */       if (simpleValue == null)
/*      */       {
/* 1198 */         return null;
/*      */       }
/* 1200 */       return simpleValue.getObjectValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DerivationSet xgetBlock() {
/* 1209 */     synchronized (monitor()) {
/*      */       
/* 1211 */       check_orphaned();
/* 1212 */       DerivationSet derivationSet = null;
/* 1213 */       derivationSet = (DerivationSet)get_store().find_attribute_user(BLOCK$26);
/* 1214 */       return derivationSet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetBlock() {
/* 1223 */     synchronized (monitor()) {
/*      */       
/* 1225 */       check_orphaned();
/* 1226 */       return (get_store().find_attribute_user(BLOCK$26) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBlock(Object paramObject) {
/* 1235 */     synchronized (monitor()) {
/*      */       
/* 1237 */       check_orphaned();
/* 1238 */       SimpleValue simpleValue = null;
/* 1239 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCK$26);
/* 1240 */       if (simpleValue == null)
/*      */       {
/* 1242 */         simpleValue = (SimpleValue)get_store().add_attribute_user(BLOCK$26);
/*      */       }
/* 1244 */       simpleValue.setObjectValue(paramObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetBlock(DerivationSet paramDerivationSet) {
/* 1253 */     synchronized (monitor()) {
/*      */       
/* 1255 */       check_orphaned();
/* 1256 */       DerivationSet derivationSet = null;
/* 1257 */       derivationSet = (DerivationSet)get_store().find_attribute_user(BLOCK$26);
/* 1258 */       if (derivationSet == null)
/*      */       {
/* 1260 */         derivationSet = (DerivationSet)get_store().add_attribute_user(BLOCK$26);
/*      */       }
/* 1262 */       derivationSet.set((XmlObject)paramDerivationSet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetBlock() {
/* 1271 */     synchronized (monitor()) {
/*      */       
/* 1273 */       check_orphaned();
/* 1274 */       get_store().remove_attribute(BLOCK$26);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ComplexTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */