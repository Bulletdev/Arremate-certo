/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*     */ 
/*     */ public class AttributeImpl
/*     */   extends AnnotatedImpl implements Attribute {
/*     */   public AttributeImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b SIMPLETYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*     */   
/*  24 */   private static final b NAME$2 = new b("", "name");
/*     */   
/*  26 */   private static final b REF$4 = new b("", "ref");
/*     */   
/*  28 */   private static final b TYPE$6 = new b("", "type");
/*     */   
/*  30 */   private static final b USE$8 = new b("", "use");
/*     */   
/*  32 */   private static final b DEFAULT$10 = new b("", "default");
/*     */   
/*  34 */   private static final b FIXED$12 = new b("", "fixed");
/*     */   
/*  36 */   private static final b FORM$14 = new b("", "form");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LocalSimpleType getSimpleType() {
/*  45 */     synchronized (monitor()) {
/*     */       
/*  47 */       check_orphaned();
/*  48 */       LocalSimpleType localSimpleType = null;
/*  49 */       localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/*  50 */       if (localSimpleType == null)
/*     */       {
/*  52 */         return null;
/*     */       }
/*  54 */       return localSimpleType;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetSimpleType() {
/*  63 */     synchronized (monitor()) {
/*     */       
/*  65 */       check_orphaned();
/*  66 */       return (get_store().count_elements(SIMPLETYPE$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSimpleType(LocalSimpleType paramLocalSimpleType) {
/*  75 */     synchronized (monitor()) {
/*     */       
/*  77 */       check_orphaned();
/*  78 */       LocalSimpleType localSimpleType = null;
/*  79 */       localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/*  80 */       if (localSimpleType == null)
/*     */       {
/*  82 */         localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*     */       }
/*  84 */       localSimpleType.set((XmlObject)paramLocalSimpleType);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LocalSimpleType addNewSimpleType() {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       LocalSimpleType localSimpleType = null;
/*  97 */       localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*  98 */       return localSimpleType;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetSimpleType() {
/* 107 */     synchronized (monitor()) {
/*     */       
/* 109 */       check_orphaned();
/* 110 */       get_store().remove_element(SIMPLETYPE$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 119 */     synchronized (monitor()) {
/*     */       
/* 121 */       check_orphaned();
/* 122 */       SimpleValue simpleValue = null;
/* 123 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
/* 124 */       if (simpleValue == null)
/*     */       {
/* 126 */         return null;
/*     */       }
/* 128 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlNCName xgetName() {
/* 137 */     synchronized (monitor()) {
/*     */       
/* 139 */       check_orphaned();
/* 140 */       XmlNCName xmlNCName = null;
/* 141 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$2);
/* 142 */       return xmlNCName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetName() {
/* 151 */     synchronized (monitor()) {
/*     */       
/* 153 */       check_orphaned();
/* 154 */       return (get_store().find_attribute_user(NAME$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 163 */     synchronized (monitor()) {
/*     */       
/* 165 */       check_orphaned();
/* 166 */       SimpleValue simpleValue = null;
/* 167 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
/* 168 */       if (simpleValue == null)
/*     */       {
/* 170 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$2);
/*     */       }
/* 172 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlNCName paramXmlNCName) {
/* 181 */     synchronized (monitor()) {
/*     */       
/* 183 */       check_orphaned();
/* 184 */       XmlNCName xmlNCName = null;
/* 185 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$2);
/* 186 */       if (xmlNCName == null)
/*     */       {
/* 188 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$2);
/*     */       }
/* 190 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetName() {
/* 199 */     synchronized (monitor()) {
/*     */       
/* 201 */       check_orphaned();
/* 202 */       get_store().remove_attribute(NAME$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getRef() {
/* 211 */     synchronized (monitor()) {
/*     */       
/* 213 */       check_orphaned();
/* 214 */       SimpleValue simpleValue = null;
/* 215 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$4);
/* 216 */       if (simpleValue == null)
/*     */       {
/* 218 */         return null;
/*     */       }
/* 220 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetRef() {
/* 229 */     synchronized (monitor()) {
/*     */       
/* 231 */       check_orphaned();
/* 232 */       XmlQName xmlQName = null;
/* 233 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$4);
/* 234 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetRef() {
/* 243 */     synchronized (monitor()) {
/*     */       
/* 245 */       check_orphaned();
/* 246 */       return (get_store().find_attribute_user(REF$4) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRef(b paramb) {
/* 255 */     synchronized (monitor()) {
/*     */       
/* 257 */       check_orphaned();
/* 258 */       SimpleValue simpleValue = null;
/* 259 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$4);
/* 260 */       if (simpleValue == null)
/*     */       {
/* 262 */         simpleValue = (SimpleValue)get_store().add_attribute_user(REF$4);
/*     */       }
/* 264 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetRef(XmlQName paramXmlQName) {
/* 273 */     synchronized (monitor()) {
/*     */       
/* 275 */       check_orphaned();
/* 276 */       XmlQName xmlQName = null;
/* 277 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$4);
/* 278 */       if (xmlQName == null)
/*     */       {
/* 280 */         xmlQName = (XmlQName)get_store().add_attribute_user(REF$4);
/*     */       }
/* 282 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetRef() {
/* 291 */     synchronized (monitor()) {
/*     */       
/* 293 */       check_orphaned();
/* 294 */       get_store().remove_attribute(REF$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getType() {
/* 303 */     synchronized (monitor()) {
/*     */       
/* 305 */       check_orphaned();
/* 306 */       SimpleValue simpleValue = null;
/* 307 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$6);
/* 308 */       if (simpleValue == null)
/*     */       {
/* 310 */         return null;
/*     */       }
/* 312 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetType() {
/* 321 */     synchronized (monitor()) {
/*     */       
/* 323 */       check_orphaned();
/* 324 */       XmlQName xmlQName = null;
/* 325 */       xmlQName = (XmlQName)get_store().find_attribute_user(TYPE$6);
/* 326 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetType() {
/* 335 */     synchronized (monitor()) {
/*     */       
/* 337 */       check_orphaned();
/* 338 */       return (get_store().find_attribute_user(TYPE$6) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(b paramb) {
/* 347 */     synchronized (monitor()) {
/*     */       
/* 349 */       check_orphaned();
/* 350 */       SimpleValue simpleValue = null;
/* 351 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$6);
/* 352 */       if (simpleValue == null)
/*     */       {
/* 354 */         simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$6);
/*     */       }
/* 356 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetType(XmlQName paramXmlQName) {
/* 365 */     synchronized (monitor()) {
/*     */       
/* 367 */       check_orphaned();
/* 368 */       XmlQName xmlQName = null;
/* 369 */       xmlQName = (XmlQName)get_store().find_attribute_user(TYPE$6);
/* 370 */       if (xmlQName == null)
/*     */       {
/* 372 */         xmlQName = (XmlQName)get_store().add_attribute_user(TYPE$6);
/*     */       }
/* 374 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetType() {
/* 383 */     synchronized (monitor()) {
/*     */       
/* 385 */       check_orphaned();
/* 386 */       get_store().remove_attribute(TYPE$6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute.Use.Enum getUse() {
/* 395 */     synchronized (monitor()) {
/*     */       
/* 397 */       check_orphaned();
/* 398 */       SimpleValue simpleValue = null;
/* 399 */       simpleValue = (SimpleValue)get_store().find_attribute_user(USE$8);
/* 400 */       if (simpleValue == null)
/*     */       {
/* 402 */         simpleValue = (SimpleValue)get_default_attribute_value(USE$8);
/*     */       }
/* 404 */       if (simpleValue == null)
/*     */       {
/* 406 */         return null;
/*     */       }
/* 408 */       return (Attribute.Use.Enum)simpleValue.getEnumValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute.Use xgetUse() {
/* 417 */     synchronized (monitor()) {
/*     */       
/* 419 */       check_orphaned();
/* 420 */       Attribute.Use use = null;
/* 421 */       use = (Attribute.Use)get_store().find_attribute_user(USE$8);
/* 422 */       if (use == null)
/*     */       {
/* 424 */         use = (Attribute.Use)get_default_attribute_value(USE$8);
/*     */       }
/* 426 */       return use;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetUse() {
/* 435 */     synchronized (monitor()) {
/*     */       
/* 437 */       check_orphaned();
/* 438 */       return (get_store().find_attribute_user(USE$8) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUse(Attribute.Use.Enum paramEnum) {
/* 447 */     synchronized (monitor()) {
/*     */       
/* 449 */       check_orphaned();
/* 450 */       SimpleValue simpleValue = null;
/* 451 */       simpleValue = (SimpleValue)get_store().find_attribute_user(USE$8);
/* 452 */       if (simpleValue == null)
/*     */       {
/* 454 */         simpleValue = (SimpleValue)get_store().add_attribute_user(USE$8);
/*     */       }
/* 456 */       simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetUse(Attribute.Use paramUse) {
/* 465 */     synchronized (monitor()) {
/*     */       
/* 467 */       check_orphaned();
/* 468 */       Attribute.Use use = null;
/* 469 */       use = (Attribute.Use)get_store().find_attribute_user(USE$8);
/* 470 */       if (use == null)
/*     */       {
/* 472 */         use = (Attribute.Use)get_store().add_attribute_user(USE$8);
/*     */       }
/* 474 */       use.set((XmlObject)paramUse);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetUse() {
/* 483 */     synchronized (monitor()) {
/*     */       
/* 485 */       check_orphaned();
/* 486 */       get_store().remove_attribute(USE$8);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefault() {
/* 495 */     synchronized (monitor()) {
/*     */       
/* 497 */       check_orphaned();
/* 498 */       SimpleValue simpleValue = null;
/* 499 */       simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULT$10);
/* 500 */       if (simpleValue == null)
/*     */       {
/* 502 */         return null;
/*     */       }
/* 504 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetDefault() {
/* 513 */     synchronized (monitor()) {
/*     */       
/* 515 */       check_orphaned();
/* 516 */       XmlString xmlString = null;
/* 517 */       xmlString = (XmlString)get_store().find_attribute_user(DEFAULT$10);
/* 518 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetDefault() {
/* 527 */     synchronized (monitor()) {
/*     */       
/* 529 */       check_orphaned();
/* 530 */       return (get_store().find_attribute_user(DEFAULT$10) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefault(String paramString) {
/* 539 */     synchronized (monitor()) {
/*     */       
/* 541 */       check_orphaned();
/* 542 */       SimpleValue simpleValue = null;
/* 543 */       simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULT$10);
/* 544 */       if (simpleValue == null)
/*     */       {
/* 546 */         simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULT$10);
/*     */       }
/* 548 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetDefault(XmlString paramXmlString) {
/* 557 */     synchronized (monitor()) {
/*     */       
/* 559 */       check_orphaned();
/* 560 */       XmlString xmlString = null;
/* 561 */       xmlString = (XmlString)get_store().find_attribute_user(DEFAULT$10);
/* 562 */       if (xmlString == null)
/*     */       {
/* 564 */         xmlString = (XmlString)get_store().add_attribute_user(DEFAULT$10);
/*     */       }
/* 566 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetDefault() {
/* 575 */     synchronized (monitor()) {
/*     */       
/* 577 */       check_orphaned();
/* 578 */       get_store().remove_attribute(DEFAULT$10);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFixed() {
/* 587 */     synchronized (monitor()) {
/*     */       
/* 589 */       check_orphaned();
/* 590 */       SimpleValue simpleValue = null;
/* 591 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FIXED$12);
/* 592 */       if (simpleValue == null)
/*     */       {
/* 594 */         return null;
/*     */       }
/* 596 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetFixed() {
/* 605 */     synchronized (monitor()) {
/*     */       
/* 607 */       check_orphaned();
/* 608 */       XmlString xmlString = null;
/* 609 */       xmlString = (XmlString)get_store().find_attribute_user(FIXED$12);
/* 610 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetFixed() {
/* 619 */     synchronized (monitor()) {
/*     */       
/* 621 */       check_orphaned();
/* 622 */       return (get_store().find_attribute_user(FIXED$12) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFixed(String paramString) {
/* 631 */     synchronized (monitor()) {
/*     */       
/* 633 */       check_orphaned();
/* 634 */       SimpleValue simpleValue = null;
/* 635 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FIXED$12);
/* 636 */       if (simpleValue == null)
/*     */       {
/* 638 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FIXED$12);
/*     */       }
/* 640 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFixed(XmlString paramXmlString) {
/* 649 */     synchronized (monitor()) {
/*     */       
/* 651 */       check_orphaned();
/* 652 */       XmlString xmlString = null;
/* 653 */       xmlString = (XmlString)get_store().find_attribute_user(FIXED$12);
/* 654 */       if (xmlString == null)
/*     */       {
/* 656 */         xmlString = (XmlString)get_store().add_attribute_user(FIXED$12);
/*     */       }
/* 658 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetFixed() {
/* 667 */     synchronized (monitor()) {
/*     */       
/* 669 */       check_orphaned();
/* 670 */       get_store().remove_attribute(FIXED$12);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormChoice.Enum getForm() {
/* 679 */     synchronized (monitor()) {
/*     */       
/* 681 */       check_orphaned();
/* 682 */       SimpleValue simpleValue = null;
/* 683 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FORM$14);
/* 684 */       if (simpleValue == null)
/*     */       {
/* 686 */         return null;
/*     */       }
/* 688 */       return (FormChoice.Enum)simpleValue.getEnumValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormChoice xgetForm() {
/* 697 */     synchronized (monitor()) {
/*     */       
/* 699 */       check_orphaned();
/* 700 */       FormChoice formChoice = null;
/* 701 */       formChoice = (FormChoice)get_store().find_attribute_user(FORM$14);
/* 702 */       return formChoice;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetForm() {
/* 711 */     synchronized (monitor()) {
/*     */       
/* 713 */       check_orphaned();
/* 714 */       return (get_store().find_attribute_user(FORM$14) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForm(FormChoice.Enum paramEnum) {
/* 723 */     synchronized (monitor()) {
/*     */       
/* 725 */       check_orphaned();
/* 726 */       SimpleValue simpleValue = null;
/* 727 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FORM$14);
/* 728 */       if (simpleValue == null)
/*     */       {
/* 730 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FORM$14);
/*     */       }
/* 732 */       simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetForm(FormChoice paramFormChoice) {
/* 741 */     synchronized (monitor()) {
/*     */       
/* 743 */       check_orphaned();
/* 744 */       FormChoice formChoice = null;
/* 745 */       formChoice = (FormChoice)get_store().find_attribute_user(FORM$14);
/* 746 */       if (formChoice == null)
/*     */       {
/* 748 */         formChoice = (FormChoice)get_store().add_attribute_user(FORM$14);
/*     */       }
/* 750 */       formChoice.set((XmlObject)paramFormChoice);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetForm() {
/* 759 */     synchronized (monitor()) {
/*     */       
/* 761 */       check_orphaned();
/* 762 */       get_store().remove_attribute(FORM$14);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class UseImpl
/*     */     extends JavaStringEnumerationHolderEx
/*     */     implements Attribute.Use
/*     */   {
/*     */     public UseImpl(SchemaType param1SchemaType) {
/* 775 */       super(param1SchemaType, false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected UseImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 780 */       super(param1SchemaType, param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AttributeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */