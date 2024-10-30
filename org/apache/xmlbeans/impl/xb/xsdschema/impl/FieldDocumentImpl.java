/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FieldDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements FieldDocument
/*     */ {
/*     */   public FieldDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b FIELD$0 = new b("http://www.w3.org/2001/XMLSchema", "field");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDocument.Field getField() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       FieldDocument.Field field = null;
/*  36 */       field = (FieldDocument.Field)get_store().find_element_user(FIELD$0, 0);
/*  37 */       if (field == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return field;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(FieldDocument.Field paramField) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       FieldDocument.Field field = null;
/*  54 */       field = (FieldDocument.Field)get_store().find_element_user(FIELD$0, 0);
/*  55 */       if (field == null)
/*     */       {
/*  57 */         field = (FieldDocument.Field)get_store().add_element_user(FIELD$0);
/*     */       }
/*  59 */       field.set((XmlObject)paramField);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDocument.Field addNewField() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       FieldDocument.Field field = null;
/*  72 */       field = (FieldDocument.Field)get_store().add_element_user(FIELD$0);
/*  73 */       return field;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FieldImpl
/*     */     extends AnnotatedImpl
/*     */     implements FieldDocument.Field
/*     */   {
/*     */     public FieldImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b XPATH$0 = new b("", "xpath");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXpath() {
/*  98 */       synchronized (monitor()) {
/*     */         
/* 100 */         check_orphaned();
/* 101 */         SimpleValue simpleValue = null;
/* 102 */         simpleValue = (SimpleValue)get_store().find_attribute_user(XPATH$0);
/* 103 */         if (simpleValue == null)
/*     */         {
/* 105 */           return null;
/*     */         }
/* 107 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FieldDocument.Field.Xpath xgetXpath() {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         FieldDocument.Field.Xpath xpath = null;
/* 120 */         xpath = (FieldDocument.Field.Xpath)get_store().find_attribute_user(XPATH$0);
/* 121 */         return xpath;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setXpath(String param1String) {
/* 130 */       synchronized (monitor()) {
/*     */         
/* 132 */         check_orphaned();
/* 133 */         SimpleValue simpleValue = null;
/* 134 */         simpleValue = (SimpleValue)get_store().find_attribute_user(XPATH$0);
/* 135 */         if (simpleValue == null)
/*     */         {
/* 137 */           simpleValue = (SimpleValue)get_store().add_attribute_user(XPATH$0);
/*     */         }
/* 139 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetXpath(FieldDocument.Field.Xpath param1Xpath) {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         FieldDocument.Field.Xpath xpath = null;
/* 152 */         xpath = (FieldDocument.Field.Xpath)get_store().find_attribute_user(XPATH$0);
/* 153 */         if (xpath == null)
/*     */         {
/* 155 */           xpath = (FieldDocument.Field.Xpath)get_store().add_attribute_user(XPATH$0);
/*     */         }
/* 157 */         xpath.set((XmlObject)param1Xpath);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class XpathImpl
/*     */       extends JavaStringHolderEx
/*     */       implements FieldDocument.Field.Xpath
/*     */     {
/*     */       public XpathImpl(SchemaType param2SchemaType) {
/* 170 */         super(param2SchemaType, false);
/*     */       }
/*     */ 
/*     */       
/*     */       protected XpathImpl(SchemaType param2SchemaType, boolean param2Boolean) {
/* 175 */         super(param2SchemaType, param2Boolean);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\FieldDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */