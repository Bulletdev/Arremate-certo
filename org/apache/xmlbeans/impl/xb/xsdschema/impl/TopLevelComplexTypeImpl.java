/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TopLevelComplexTypeImpl
/*     */   extends ComplexTypeImpl
/*     */   implements TopLevelComplexType
/*     */ {
/*     */   public TopLevelComplexTypeImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b NAME$0 = new b("", "name");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  31 */     synchronized (monitor()) {
/*     */       
/*  33 */       check_orphaned();
/*  34 */       SimpleValue simpleValue = null;
/*  35 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
/*  36 */       if (simpleValue == null)
/*     */       {
/*  38 */         return null;
/*     */       }
/*  40 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlNCName xgetName() {
/*  49 */     synchronized (monitor()) {
/*     */       
/*  51 */       check_orphaned();
/*  52 */       XmlNCName xmlNCName = null;
/*  53 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$0);
/*  54 */       return xmlNCName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetName() {
/*  63 */     synchronized (monitor()) {
/*     */       
/*  65 */       check_orphaned();
/*  66 */       return (get_store().find_attribute_user(NAME$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/*  75 */     synchronized (monitor()) {
/*     */       
/*  77 */       check_orphaned();
/*  78 */       SimpleValue simpleValue = null;
/*  79 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
/*  80 */       if (simpleValue == null)
/*     */       {
/*  82 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0);
/*     */       }
/*  84 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlNCName paramXmlNCName) {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       XmlNCName xmlNCName = null;
/*  97 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$0);
/*  98 */       if (xmlNCName == null)
/*     */       {
/* 100 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$0);
/*     */       }
/* 102 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetName() {
/* 111 */     synchronized (monitor()) {
/*     */       
/* 113 */       check_orphaned();
/* 114 */       get_store().remove_attribute(NAME$0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\TopLevelComplexTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */