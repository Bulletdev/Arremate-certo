/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*     */ 
/*     */ public class AttributeGroupImpl
/*     */   extends AnnotatedImpl
/*     */   implements AttributeGroup {
/*     */   public AttributeGroupImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b ATTRIBUTE$0 = new b("http://www.w3.org/2001/XMLSchema", "attribute");
/*     */   
/*  24 */   private static final b ATTRIBUTEGROUP$2 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*     */   
/*  26 */   private static final b ANYATTRIBUTE$4 = new b("http://www.w3.org/2001/XMLSchema", "anyAttribute");
/*     */   
/*  28 */   private static final b NAME$6 = new b("", "name");
/*     */   
/*  30 */   private static final b REF$8 = new b("", "ref");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute[] getAttributeArray() {
/*  39 */     synchronized (monitor()) {
/*     */       
/*  41 */       check_orphaned();
/*  42 */       ArrayList arrayList = new ArrayList();
/*  43 */       get_store().find_all_element_users(ATTRIBUTE$0, arrayList);
/*  44 */       Attribute[] arrayOfAttribute = new Attribute[arrayList.size()];
/*  45 */       arrayList.toArray((Object[])arrayOfAttribute);
/*  46 */       return arrayOfAttribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute getAttributeArray(int paramInt) {
/*  55 */     synchronized (monitor()) {
/*     */       
/*  57 */       check_orphaned();
/*  58 */       Attribute attribute = null;
/*  59 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$0, paramInt);
/*  60 */       if (attribute == null)
/*     */       {
/*  62 */         throw new IndexOutOfBoundsException();
/*     */       }
/*  64 */       return attribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfAttributeArray() {
/*  73 */     synchronized (monitor()) {
/*     */       
/*  75 */       check_orphaned();
/*  76 */       return get_store().count_elements(ATTRIBUTE$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeArray(Attribute[] paramArrayOfAttribute) {
/*  85 */     synchronized (monitor()) {
/*     */       
/*  87 */       check_orphaned();
/*  88 */       arraySetterHelper((XmlObject[])paramArrayOfAttribute, ATTRIBUTE$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeArray(int paramInt, Attribute paramAttribute) {
/*  97 */     synchronized (monitor()) {
/*     */       
/*  99 */       check_orphaned();
/* 100 */       Attribute attribute = null;
/* 101 */       attribute = (Attribute)get_store().find_element_user(ATTRIBUTE$0, paramInt);
/* 102 */       if (attribute == null)
/*     */       {
/* 104 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 106 */       attribute.set((XmlObject)paramAttribute);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute insertNewAttribute(int paramInt) {
/* 115 */     synchronized (monitor()) {
/*     */       
/* 117 */       check_orphaned();
/* 118 */       Attribute attribute = null;
/* 119 */       attribute = (Attribute)get_store().insert_element_user(ATTRIBUTE$0, paramInt);
/* 120 */       return attribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute addNewAttribute() {
/* 129 */     synchronized (monitor()) {
/*     */       
/* 131 */       check_orphaned();
/* 132 */       Attribute attribute = null;
/* 133 */       attribute = (Attribute)get_store().add_element_user(ATTRIBUTE$0);
/* 134 */       return attribute;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAttribute(int paramInt) {
/* 143 */     synchronized (monitor()) {
/*     */       
/* 145 */       check_orphaned();
/* 146 */       get_store().remove_element(ATTRIBUTE$0, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef[] getAttributeGroupArray() {
/* 155 */     synchronized (monitor()) {
/*     */       
/* 157 */       check_orphaned();
/* 158 */       ArrayList arrayList = new ArrayList();
/* 159 */       get_store().find_all_element_users(ATTRIBUTEGROUP$2, arrayList);
/* 160 */       AttributeGroupRef[] arrayOfAttributeGroupRef = new AttributeGroupRef[arrayList.size()];
/* 161 */       arrayList.toArray((Object[])arrayOfAttributeGroupRef);
/* 162 */       return arrayOfAttributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef getAttributeGroupArray(int paramInt) {
/* 171 */     synchronized (monitor()) {
/*     */       
/* 173 */       check_orphaned();
/* 174 */       AttributeGroupRef attributeGroupRef = null;
/* 175 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$2, paramInt);
/* 176 */       if (attributeGroupRef == null)
/*     */       {
/* 178 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 180 */       return attributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfAttributeGroupArray() {
/* 189 */     synchronized (monitor()) {
/*     */       
/* 191 */       check_orphaned();
/* 192 */       return get_store().count_elements(ATTRIBUTEGROUP$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeGroupArray(AttributeGroupRef[] paramArrayOfAttributeGroupRef) {
/* 201 */     synchronized (monitor()) {
/*     */       
/* 203 */       check_orphaned();
/* 204 */       arraySetterHelper((XmlObject[])paramArrayOfAttributeGroupRef, ATTRIBUTEGROUP$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributeGroupArray(int paramInt, AttributeGroupRef paramAttributeGroupRef) {
/* 213 */     synchronized (monitor()) {
/*     */       
/* 215 */       check_orphaned();
/* 216 */       AttributeGroupRef attributeGroupRef = null;
/* 217 */       attributeGroupRef = (AttributeGroupRef)get_store().find_element_user(ATTRIBUTEGROUP$2, paramInt);
/* 218 */       if (attributeGroupRef == null)
/*     */       {
/* 220 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 222 */       attributeGroupRef.set((XmlObject)paramAttributeGroupRef);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef insertNewAttributeGroup(int paramInt) {
/* 231 */     synchronized (monitor()) {
/*     */       
/* 233 */       check_orphaned();
/* 234 */       AttributeGroupRef attributeGroupRef = null;
/* 235 */       attributeGroupRef = (AttributeGroupRef)get_store().insert_element_user(ATTRIBUTEGROUP$2, paramInt);
/* 236 */       return attributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributeGroupRef addNewAttributeGroup() {
/* 245 */     synchronized (monitor()) {
/*     */       
/* 247 */       check_orphaned();
/* 248 */       AttributeGroupRef attributeGroupRef = null;
/* 249 */       attributeGroupRef = (AttributeGroupRef)get_store().add_element_user(ATTRIBUTEGROUP$2);
/* 250 */       return attributeGroupRef;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAttributeGroup(int paramInt) {
/* 259 */     synchronized (monitor()) {
/*     */       
/* 261 */       check_orphaned();
/* 262 */       get_store().remove_element(ATTRIBUTEGROUP$2, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wildcard getAnyAttribute() {
/* 271 */     synchronized (monitor()) {
/*     */       
/* 273 */       check_orphaned();
/* 274 */       Wildcard wildcard = null;
/* 275 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$4, 0);
/* 276 */       if (wildcard == null)
/*     */       {
/* 278 */         return null;
/*     */       }
/* 280 */       return wildcard;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetAnyAttribute() {
/* 289 */     synchronized (monitor()) {
/*     */       
/* 291 */       check_orphaned();
/* 292 */       return (get_store().count_elements(ANYATTRIBUTE$4) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnyAttribute(Wildcard paramWildcard) {
/* 301 */     synchronized (monitor()) {
/*     */       
/* 303 */       check_orphaned();
/* 304 */       Wildcard wildcard = null;
/* 305 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$4, 0);
/* 306 */       if (wildcard == null)
/*     */       {
/* 308 */         wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$4);
/*     */       }
/* 310 */       wildcard.set((XmlObject)paramWildcard);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wildcard addNewAnyAttribute() {
/* 319 */     synchronized (monitor()) {
/*     */       
/* 321 */       check_orphaned();
/* 322 */       Wildcard wildcard = null;
/* 323 */       wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$4);
/* 324 */       return wildcard;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetAnyAttribute() {
/* 333 */     synchronized (monitor()) {
/*     */       
/* 335 */       check_orphaned();
/* 336 */       get_store().remove_element(ANYATTRIBUTE$4, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 345 */     synchronized (monitor()) {
/*     */       
/* 347 */       check_orphaned();
/* 348 */       SimpleValue simpleValue = null;
/* 349 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
/* 350 */       if (simpleValue == null)
/*     */       {
/* 352 */         return null;
/*     */       }
/* 354 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlNCName xgetName() {
/* 363 */     synchronized (monitor()) {
/*     */       
/* 365 */       check_orphaned();
/* 366 */       XmlNCName xmlNCName = null;
/* 367 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$6);
/* 368 */       return xmlNCName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetName() {
/* 377 */     synchronized (monitor()) {
/*     */       
/* 379 */       check_orphaned();
/* 380 */       return (get_store().find_attribute_user(NAME$6) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 389 */     synchronized (monitor()) {
/*     */       
/* 391 */       check_orphaned();
/* 392 */       SimpleValue simpleValue = null;
/* 393 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
/* 394 */       if (simpleValue == null)
/*     */       {
/* 396 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$6);
/*     */       }
/* 398 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlNCName paramXmlNCName) {
/* 407 */     synchronized (monitor()) {
/*     */       
/* 409 */       check_orphaned();
/* 410 */       XmlNCName xmlNCName = null;
/* 411 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$6);
/* 412 */       if (xmlNCName == null)
/*     */       {
/* 414 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$6);
/*     */       }
/* 416 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetName() {
/* 425 */     synchronized (monitor()) {
/*     */       
/* 427 */       check_orphaned();
/* 428 */       get_store().remove_attribute(NAME$6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getRef() {
/* 437 */     synchronized (monitor()) {
/*     */       
/* 439 */       check_orphaned();
/* 440 */       SimpleValue simpleValue = null;
/* 441 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$8);
/* 442 */       if (simpleValue == null)
/*     */       {
/* 444 */         return null;
/*     */       }
/* 446 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetRef() {
/* 455 */     synchronized (monitor()) {
/*     */       
/* 457 */       check_orphaned();
/* 458 */       XmlQName xmlQName = null;
/* 459 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$8);
/* 460 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetRef() {
/* 469 */     synchronized (monitor()) {
/*     */       
/* 471 */       check_orphaned();
/* 472 */       return (get_store().find_attribute_user(REF$8) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRef(b paramb) {
/* 481 */     synchronized (monitor()) {
/*     */       
/* 483 */       check_orphaned();
/* 484 */       SimpleValue simpleValue = null;
/* 485 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$8);
/* 486 */       if (simpleValue == null)
/*     */       {
/* 488 */         simpleValue = (SimpleValue)get_store().add_attribute_user(REF$8);
/*     */       }
/* 490 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetRef(XmlQName paramXmlQName) {
/* 499 */     synchronized (monitor()) {
/*     */       
/* 501 */       check_orphaned();
/* 502 */       XmlQName xmlQName = null;
/* 503 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$8);
/* 504 */       if (xmlQName == null)
/*     */       {
/* 506 */         xmlQName = (XmlQName)get_store().add_attribute_user(REF$8);
/*     */       }
/* 508 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetRef() {
/* 517 */     synchronized (monitor()) {
/*     */       
/* 519 */       check_orphaned();
/* 520 */       get_store().remove_attribute(REF$8);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AttributeGroupImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */