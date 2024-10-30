/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.All;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.GroupRef;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*     */ 
/*     */ public class ExtensionTypeImpl extends AnnotatedImpl implements ExtensionType {
/*     */   public ExtensionTypeImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b GROUP$0 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*     */   
/*  24 */   private static final b ALL$2 = new b("http://www.w3.org/2001/XMLSchema", "all");
/*     */   
/*  26 */   private static final b CHOICE$4 = new b("http://www.w3.org/2001/XMLSchema", "choice");
/*     */   
/*  28 */   private static final b SEQUENCE$6 = new b("http://www.w3.org/2001/XMLSchema", "sequence");
/*     */   
/*  30 */   private static final b ATTRIBUTE$8 = new b("http://www.w3.org/2001/XMLSchema", "attribute");
/*     */   
/*  32 */   private static final b ATTRIBUTEGROUP$10 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*     */   
/*  34 */   private static final b ANYATTRIBUTE$12 = new b("http://www.w3.org/2001/XMLSchema", "anyAttribute");
/*     */   
/*  36 */   private static final b BASE$14 = new b("", "base");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GroupRef getGroup() {
/*  45 */     synchronized (monitor()) {
/*     */       
/*  47 */       check_orphaned();
/*  48 */       GroupRef groupRef = null;
/*  49 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$0, 0);
/*  50 */       if (groupRef == null)
/*     */       {
/*  52 */         return null;
/*     */       }
/*  54 */       return groupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetGroup() {
/*  63 */     synchronized (monitor()) {
/*     */       
/*  65 */       check_orphaned();
/*  66 */       return (get_store().count_elements(GROUP$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGroup(GroupRef paramGroupRef) {
/*  75 */     synchronized (monitor()) {
/*     */       
/*  77 */       check_orphaned();
/*  78 */       GroupRef groupRef = null;
/*  79 */       groupRef = (GroupRef)get_store().find_element_user(GROUP$0, 0);
/*  80 */       if (groupRef == null)
/*     */       {
/*  82 */         groupRef = (GroupRef)get_store().add_element_user(GROUP$0);
/*     */       }
/*  84 */       groupRef.set((XmlObject)paramGroupRef);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GroupRef addNewGroup() {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       GroupRef groupRef = null;
/*  97 */       groupRef = (GroupRef)get_store().add_element_user(GROUP$0);
/*  98 */       return groupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetGroup() {
/* 107 */     synchronized (monitor()) {
/*     */       
/* 109 */       check_orphaned();
/* 110 */       get_store().remove_element(GROUP$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public All getAll() {
/* 119 */     synchronized (monitor()) {
/*     */       
/* 121 */       check_orphaned();
/* 122 */       All all = null;
/* 123 */       all = (All)get_store().find_element_user(ALL$2, 0);
/* 124 */       if (all == null)
/*     */       {
/* 126 */         return null;
/*     */       }
/* 128 */       return all;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetAll() {
/* 137 */     synchronized (monitor()) {
/*     */       
/* 139 */       check_orphaned();
/* 140 */       return (get_store().count_elements(ALL$2) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAll(All paramAll) {
/* 149 */     synchronized (monitor()) {
/*     */       
/* 151 */       check_orphaned();
/* 152 */       All all = null;
/* 153 */       all = (All)get_store().find_element_user(ALL$2, 0);
/* 154 */       if (all == null)
/*     */       {
/* 156 */         all = (All)get_store().add_element_user(ALL$2);
/*     */       }
/* 158 */       all.set((XmlObject)paramAll);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public All addNewAll() {
/* 167 */     synchronized (monitor()) {
/*     */       
/* 169 */       check_orphaned();
/* 170 */       All all = null;
/* 171 */       all = (All)get_store().add_element_user(ALL$2);
/* 172 */       return all;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetAll() {
/* 181 */     synchronized (monitor()) {
/*     */       
/* 183 */       check_orphaned();
/* 184 */       get_store().remove_element(ALL$2, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup getChoice() {
/* 193 */     synchronized (monitor()) {
/*     */       
/* 195 */       check_orphaned();
/* 196 */       ExplicitGroup explicitGroup = null;
/* 197 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$4, 0);
/* 198 */       if (explicitGroup == null)
/*     */       {
/* 200 */         return null;
/*     */       }
/* 202 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetChoice() {
/* 211 */     synchronized (monitor()) {
/*     */       
/* 213 */       check_orphaned();
/* 214 */       return (get_store().count_elements(CHOICE$4) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChoice(ExplicitGroup paramExplicitGroup) {
/* 223 */     synchronized (monitor()) {
/*     */       
/* 225 */       check_orphaned();
/* 226 */       ExplicitGroup explicitGroup = null;
/* 227 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$4, 0);
/* 228 */       if (explicitGroup == null)
/*     */       {
/* 230 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$4);
/*     */       }
/* 232 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup addNewChoice() {
/* 241 */     synchronized (monitor()) {
/*     */       
/* 243 */       check_orphaned();
/* 244 */       ExplicitGroup explicitGroup = null;
/* 245 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$4);
/* 246 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetChoice() {
/* 255 */     synchronized (monitor()) {
/*     */       
/* 257 */       check_orphaned();
/* 258 */       get_store().remove_element(CHOICE$4, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup getSequence() {
/* 267 */     synchronized (monitor()) {
/*     */       
/* 269 */       check_orphaned();
/* 270 */       ExplicitGroup explicitGroup = null;
/* 271 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$6, 0);
/* 272 */       if (explicitGroup == null)
/*     */       {
/* 274 */         return null;
/*     */       }
/* 276 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetSequence() {
/* 285 */     synchronized (monitor()) {
/*     */       
/* 287 */       check_orphaned();
/* 288 */       return (get_store().count_elements(SEQUENCE$6) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequence(ExplicitGroup paramExplicitGroup) {
/* 297 */     synchronized (monitor()) {
/*     */       
/* 299 */       check_orphaned();
/* 300 */       ExplicitGroup explicitGroup = null;
/* 301 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$6, 0);
/* 302 */       if (explicitGroup == null)
/*     */       {
/* 304 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$6);
/*     */       }
/* 306 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup addNewSequence() {
/* 315 */     synchronized (monitor()) {
/*     */       
/* 317 */       check_orphaned();
/* 318 */       ExplicitGroup explicitGroup = null;
/* 319 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$6);
/* 320 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetSequence() {
/* 329 */     synchronized (monitor()) {
/*     */       
/* 331 */       check_orphaned();
/* 332 */       get_store().remove_element(SEQUENCE$6, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute[] getAttributeArray() {
/* 341 */     synchronized (monitor()) {
/*     */       
/* 343 */       check_orphaned();
/* 344 */       ArrayList arrayList = new ArrayList();
/* 345 */       get_store().find_all_element_users(ATTRIBUTE$8, arrayList);
/* 346 */       Attribute[] arrayOfAttribute = new Attribute[arrayList.size()];
/* 347 */       arrayList.toArray((Object[])arrayOfAttribute);
/* 348 */       return arrayOfAttribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute getAttributeArray(int paramInt) {
/* 357 */     synchronized (monitor()) {
/*     */       
/* 359 */       check_orphaned();
/* 360 */       Attribute attribute = null;
/* 361 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$8, paramInt);
/* 362 */       if (attribute == null)
/*     */       {
/* 364 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 366 */       return attribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfAttributeArray() {
/* 375 */     synchronized (monitor()) {
/*     */       
/* 377 */       check_orphaned();
/* 378 */       return get_store().count_elements(ATTRIBUTE$8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeArray(Attribute[] paramArrayOfAttribute) {
/* 387 */     synchronized (monitor()) {
/*     */       
/* 389 */       check_orphaned();
/* 390 */       arraySetterHelper((XmlObject[])paramArrayOfAttribute, ATTRIBUTE$8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeArray(int paramInt, Attribute paramAttribute) {
/* 399 */     synchronized (monitor()) {
/*     */       
/* 401 */       check_orphaned();
/* 402 */       Attribute attribute = null;
/* 403 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$8, paramInt);
/* 404 */       if (attribute == null)
/*     */       {
/* 406 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 408 */       attribute.set((XmlObject)paramAttribute);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute insertNewAttribute(int paramInt) {
/* 417 */     synchronized (monitor()) {
/*     */       
/* 419 */       check_orphaned();
/* 420 */       Attribute attribute = null;
/* 421 */       attribute = (Attribute)get_store().insert_element_user(ATTRIBUTE$8, paramInt);
/* 422 */       return attribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute addNewAttribute() {
/* 431 */     synchronized (monitor()) {
/*     */       
/* 433 */       check_orphaned();
/* 434 */       Attribute attribute = null;
/* 435 */       attribute = (Attribute)get_store().add_element_user(ATTRIBUTE$8);
/* 436 */       return attribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAttribute(int paramInt) {
/* 445 */     synchronized (monitor()) {
/*     */       
/* 447 */       check_orphaned();
/* 448 */       get_store().remove_element(ATTRIBUTE$8, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef[] getAttributeGroupArray() {
/* 457 */     synchronized (monitor()) {
/*     */       
/* 459 */       check_orphaned();
/* 460 */       ArrayList arrayList = new ArrayList();
/* 461 */       get_store().find_all_element_users(ATTRIBUTEGROUP$10, arrayList);
/* 462 */       AttributeGroupRef[] arrayOfAttributeGroupRef = new AttributeGroupRef[arrayList.size()];
/* 463 */       arrayList.toArray((Object[])arrayOfAttributeGroupRef);
/* 464 */       return arrayOfAttributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef getAttributeGroupArray(int paramInt) {
/* 473 */     synchronized (monitor()) {
/*     */       
/* 475 */       check_orphaned();
/* 476 */       AttributeGroupRef attributeGroupRef = null;
/* 477 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$10, paramInt);
/* 478 */       if (attributeGroupRef == null)
/*     */       {
/* 480 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 482 */       return attributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfAttributeGroupArray() {
/* 491 */     synchronized (monitor()) {
/*     */       
/* 493 */       check_orphaned();
/* 494 */       return get_store().count_elements(ATTRIBUTEGROUP$10);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeGroupArray(AttributeGroupRef[] paramArrayOfAttributeGroupRef) {
/* 503 */     synchronized (monitor()) {
/*     */       
/* 505 */       check_orphaned();
/* 506 */       arraySetterHelper((XmlObject[])paramArrayOfAttributeGroupRef, ATTRIBUTEGROUP$10);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeGroupArray(int paramInt, AttributeGroupRef paramAttributeGroupRef) {
/* 515 */     synchronized (monitor()) {
/*     */       
/* 517 */       check_orphaned();
/* 518 */       AttributeGroupRef attributeGroupRef = null;
/* 519 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$10, paramInt);
/* 520 */       if (attributeGroupRef == null)
/*     */       {
/* 522 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 524 */       attributeGroupRef.set((XmlObject)paramAttributeGroupRef);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef insertNewAttributeGroup(int paramInt) {
/* 533 */     synchronized (monitor()) {
/*     */       
/* 535 */       check_orphaned();
/* 536 */       AttributeGroupRef attributeGroupRef = null;
/* 537 */       attributeGroupRef = (AttributeGroupRef)get_store().insert_element_user(ATTRIBUTEGROUP$10, paramInt);
/* 538 */       return attributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef addNewAttributeGroup() {
/* 547 */     synchronized (monitor()) {
/*     */       
/* 549 */       check_orphaned();
/* 550 */       AttributeGroupRef attributeGroupRef = null;
/* 551 */       attributeGroupRef = (AttributeGroupRef)get_store().add_element_user(ATTRIBUTEGROUP$10);
/* 552 */       return attributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAttributeGroup(int paramInt) {
/* 561 */     synchronized (monitor()) {
/*     */       
/* 563 */       check_orphaned();
/* 564 */       get_store().remove_element(ATTRIBUTEGROUP$10, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wildcard getAnyAttribute() {
/* 573 */     synchronized (monitor()) {
/*     */       
/* 575 */       check_orphaned();
/* 576 */       Wildcard wildcard = null;
/* 577 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$12, 0);
/* 578 */       if (wildcard == null)
/*     */       {
/* 580 */         return null;
/*     */       }
/* 582 */       return wildcard;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetAnyAttribute() {
/* 591 */     synchronized (monitor()) {
/*     */       
/* 593 */       check_orphaned();
/* 594 */       return (get_store().count_elements(ANYATTRIBUTE$12) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnyAttribute(Wildcard paramWildcard) {
/* 603 */     synchronized (monitor()) {
/*     */       
/* 605 */       check_orphaned();
/* 606 */       Wildcard wildcard = null;
/* 607 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$12, 0);
/* 608 */       if (wildcard == null)
/*     */       {
/* 610 */         wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$12);
/*     */       }
/* 612 */       wildcard.set((XmlObject)paramWildcard);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wildcard addNewAnyAttribute() {
/* 621 */     synchronized (monitor()) {
/*     */       
/* 623 */       check_orphaned();
/* 624 */       Wildcard wildcard = null;
/* 625 */       wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$12);
/* 626 */       return wildcard;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetAnyAttribute() {
/* 635 */     synchronized (monitor()) {
/*     */       
/* 637 */       check_orphaned();
/* 638 */       get_store().remove_element(ANYATTRIBUTE$12, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getBase() {
/* 647 */     synchronized (monitor()) {
/*     */       
/* 649 */       check_orphaned();
/* 650 */       SimpleValue simpleValue = null;
/* 651 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$14);
/* 652 */       if (simpleValue == null)
/*     */       {
/* 654 */         return null;
/*     */       }
/* 656 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetBase() {
/* 665 */     synchronized (monitor()) {
/*     */       
/* 667 */       check_orphaned();
/* 668 */       XmlQName xmlQName = null;
/* 669 */       xmlQName = (XmlQName)get_store().find_attribute_user(BASE$14);
/* 670 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBase(b paramb) {
/* 679 */     synchronized (monitor()) {
/*     */       
/* 681 */       check_orphaned();
/* 682 */       SimpleValue simpleValue = null;
/* 683 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$14);
/* 684 */       if (simpleValue == null)
/*     */       {
/* 686 */         simpleValue = (SimpleValue)get_store().add_attribute_user(BASE$14);
/*     */       }
/* 688 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetBase(XmlQName paramXmlQName) {
/* 697 */     synchronized (monitor()) {
/*     */       
/* 699 */       check_orphaned();
/* 700 */       XmlQName xmlQName = null;
/* 701 */       xmlQName = (XmlQName)get_store().find_attribute_user(BASE$14);
/* 702 */       if (xmlQName == null)
/*     */       {
/* 704 */         xmlQName = (XmlQName)get_store().add_attribute_user(BASE$14);
/*     */       }
/* 706 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ExtensionTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */