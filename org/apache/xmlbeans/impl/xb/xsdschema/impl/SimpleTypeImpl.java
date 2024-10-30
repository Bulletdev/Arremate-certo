/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleDerivationSet;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
/*     */ 
/*     */ public class SimpleTypeImpl
/*     */   extends AnnotatedImpl
/*     */   implements SimpleType
/*     */ {
/*     */   public SimpleTypeImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b RESTRICTION$0 = new b("http://www.w3.org/2001/XMLSchema", "restriction");
/*     */   
/*  24 */   private static final b LIST$2 = new b("http://www.w3.org/2001/XMLSchema", "list");
/*     */   
/*  26 */   private static final b UNION$4 = new b("http://www.w3.org/2001/XMLSchema", "union");
/*     */   
/*  28 */   private static final b FINAL$6 = new b("", "final");
/*     */   
/*  30 */   private static final b NAME$8 = new b("", "name");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RestrictionDocument.Restriction getRestriction() {
/*  39 */     synchronized (monitor()) {
/*     */       
/*  41 */       check_orphaned();
/*  42 */       RestrictionDocument.Restriction restriction = null;
/*  43 */       restriction = (RestrictionDocument.Restriction)get_store().find_element_user(RESTRICTION$0, 0);
/*  44 */       if (restriction == null)
/*     */       {
/*  46 */         return null;
/*     */       }
/*  48 */       return restriction;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetRestriction() {
/*  57 */     synchronized (monitor()) {
/*     */       
/*  59 */       check_orphaned();
/*  60 */       return (get_store().count_elements(RESTRICTION$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRestriction(RestrictionDocument.Restriction paramRestriction) {
/*  69 */     synchronized (monitor()) {
/*     */       
/*  71 */       check_orphaned();
/*  72 */       RestrictionDocument.Restriction restriction = null;
/*  73 */       restriction = (RestrictionDocument.Restriction)get_store().find_element_user(RESTRICTION$0, 0);
/*  74 */       if (restriction == null)
/*     */       {
/*  76 */         restriction = (RestrictionDocument.Restriction)get_store().add_element_user(RESTRICTION$0);
/*     */       }
/*  78 */       restriction.set((XmlObject)paramRestriction);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RestrictionDocument.Restriction addNewRestriction() {
/*  87 */     synchronized (monitor()) {
/*     */       
/*  89 */       check_orphaned();
/*  90 */       RestrictionDocument.Restriction restriction = null;
/*  91 */       restriction = (RestrictionDocument.Restriction)get_store().add_element_user(RESTRICTION$0);
/*  92 */       return restriction;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetRestriction() {
/* 101 */     synchronized (monitor()) {
/*     */       
/* 103 */       check_orphaned();
/* 104 */       get_store().remove_element(RESTRICTION$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListDocument.List getList() {
/* 113 */     synchronized (monitor()) {
/*     */       
/* 115 */       check_orphaned();
/* 116 */       ListDocument.List list = null;
/* 117 */       list = (ListDocument.List)get_store().find_element_user(LIST$2, 0);
/* 118 */       if (list == null)
/*     */       {
/* 120 */         return null;
/*     */       }
/* 122 */       return list;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetList() {
/* 131 */     synchronized (monitor()) {
/*     */       
/* 133 */       check_orphaned();
/* 134 */       return (get_store().count_elements(LIST$2) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setList(ListDocument.List paramList) {
/* 143 */     synchronized (monitor()) {
/*     */       
/* 145 */       check_orphaned();
/* 146 */       ListDocument.List list = null;
/* 147 */       list = (ListDocument.List)get_store().find_element_user(LIST$2, 0);
/* 148 */       if (list == null)
/*     */       {
/* 150 */         list = (ListDocument.List)get_store().add_element_user(LIST$2);
/*     */       }
/* 152 */       list.set((XmlObject)paramList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListDocument.List addNewList() {
/* 161 */     synchronized (monitor()) {
/*     */       
/* 163 */       check_orphaned();
/* 164 */       ListDocument.List list = null;
/* 165 */       list = (ListDocument.List)get_store().add_element_user(LIST$2);
/* 166 */       return list;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetList() {
/* 175 */     synchronized (monitor()) {
/*     */       
/* 177 */       check_orphaned();
/* 178 */       get_store().remove_element(LIST$2, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnionDocument.Union getUnion() {
/* 187 */     synchronized (monitor()) {
/*     */       
/* 189 */       check_orphaned();
/* 190 */       UnionDocument.Union union = null;
/* 191 */       union = (UnionDocument.Union)get_store().find_element_user(UNION$4, 0);
/* 192 */       if (union == null)
/*     */       {
/* 194 */         return null;
/*     */       }
/* 196 */       return union;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetUnion() {
/* 205 */     synchronized (monitor()) {
/*     */       
/* 207 */       check_orphaned();
/* 208 */       return (get_store().count_elements(UNION$4) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnion(UnionDocument.Union paramUnion) {
/* 217 */     synchronized (monitor()) {
/*     */       
/* 219 */       check_orphaned();
/* 220 */       UnionDocument.Union union = null;
/* 221 */       union = (UnionDocument.Union)get_store().find_element_user(UNION$4, 0);
/* 222 */       if (union == null)
/*     */       {
/* 224 */         union = (UnionDocument.Union)get_store().add_element_user(UNION$4);
/*     */       }
/* 226 */       union.set((XmlObject)paramUnion);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnionDocument.Union addNewUnion() {
/* 235 */     synchronized (monitor()) {
/*     */       
/* 237 */       check_orphaned();
/* 238 */       UnionDocument.Union union = null;
/* 239 */       union = (UnionDocument.Union)get_store().add_element_user(UNION$4);
/* 240 */       return union;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetUnion() {
/* 249 */     synchronized (monitor()) {
/*     */       
/* 251 */       check_orphaned();
/* 252 */       get_store().remove_element(UNION$4, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getFinal() {
/* 261 */     synchronized (monitor()) {
/*     */       
/* 263 */       check_orphaned();
/* 264 */       SimpleValue simpleValue = null;
/* 265 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FINAL$6);
/* 266 */       if (simpleValue == null)
/*     */       {
/* 268 */         return null;
/*     */       }
/* 270 */       return simpleValue.getObjectValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleDerivationSet xgetFinal() {
/* 279 */     synchronized (monitor()) {
/*     */       
/* 281 */       check_orphaned();
/* 282 */       SimpleDerivationSet simpleDerivationSet = null;
/* 283 */       simpleDerivationSet = (SimpleDerivationSet)get_store().find_attribute_user(FINAL$6);
/* 284 */       return simpleDerivationSet;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetFinal() {
/* 293 */     synchronized (monitor()) {
/*     */       
/* 295 */       check_orphaned();
/* 296 */       return (get_store().find_attribute_user(FINAL$6) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFinal(Object paramObject) {
/* 305 */     synchronized (monitor()) {
/*     */       
/* 307 */       check_orphaned();
/* 308 */       SimpleValue simpleValue = null;
/* 309 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FINAL$6);
/* 310 */       if (simpleValue == null)
/*     */       {
/* 312 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FINAL$6);
/*     */       }
/* 314 */       simpleValue.setObjectValue(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFinal(SimpleDerivationSet paramSimpleDerivationSet) {
/* 323 */     synchronized (monitor()) {
/*     */       
/* 325 */       check_orphaned();
/* 326 */       SimpleDerivationSet simpleDerivationSet = null;
/* 327 */       simpleDerivationSet = (SimpleDerivationSet)get_store().find_attribute_user(FINAL$6);
/* 328 */       if (simpleDerivationSet == null)
/*     */       {
/* 330 */         simpleDerivationSet = (SimpleDerivationSet)get_store().add_attribute_user(FINAL$6);
/*     */       }
/* 332 */       simpleDerivationSet.set((XmlObject)paramSimpleDerivationSet);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetFinal() {
/* 341 */     synchronized (monitor()) {
/*     */       
/* 343 */       check_orphaned();
/* 344 */       get_store().remove_attribute(FINAL$6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 353 */     synchronized (monitor()) {
/*     */       
/* 355 */       check_orphaned();
/* 356 */       SimpleValue simpleValue = null;
/* 357 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
/* 358 */       if (simpleValue == null)
/*     */       {
/* 360 */         return null;
/*     */       }
/* 362 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlNCName xgetName() {
/* 371 */     synchronized (monitor()) {
/*     */       
/* 373 */       check_orphaned();
/* 374 */       XmlNCName xmlNCName = null;
/* 375 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$8);
/* 376 */       return xmlNCName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetName() {
/* 385 */     synchronized (monitor()) {
/*     */       
/* 387 */       check_orphaned();
/* 388 */       return (get_store().find_attribute_user(NAME$8) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 397 */     synchronized (monitor()) {
/*     */       
/* 399 */       check_orphaned();
/* 400 */       SimpleValue simpleValue = null;
/* 401 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$8);
/* 402 */       if (simpleValue == null)
/*     */       {
/* 404 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$8);
/*     */       }
/* 406 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlNCName paramXmlNCName) {
/* 415 */     synchronized (monitor()) {
/*     */       
/* 417 */       check_orphaned();
/* 418 */       XmlNCName xmlNCName = null;
/* 419 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$8);
/* 420 */       if (xmlNCName == null)
/*     */       {
/* 422 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$8);
/*     */       }
/* 424 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetName() {
/* 433 */     synchronized (monitor()) {
/*     */       
/* 435 */       check_orphaned();
/* 436 */       get_store().remove_attribute(NAME$8);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SimpleTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */