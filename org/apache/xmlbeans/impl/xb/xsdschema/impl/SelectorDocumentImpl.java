/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SelectorDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements SelectorDocument
/*     */ {
/*     */   public SelectorDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b SELECTOR$0 = new b("http://www.w3.org/2001/XMLSchema", "selector");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectorDocument.Selector getSelector() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       SelectorDocument.Selector selector = null;
/*  36 */       selector = (SelectorDocument.Selector)get_store().find_element_user(SELECTOR$0, 0);
/*  37 */       if (selector == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return selector;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelector(SelectorDocument.Selector paramSelector) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       SelectorDocument.Selector selector = null;
/*  54 */       selector = (SelectorDocument.Selector)get_store().find_element_user(SELECTOR$0, 0);
/*  55 */       if (selector == null)
/*     */       {
/*  57 */         selector = (SelectorDocument.Selector)get_store().add_element_user(SELECTOR$0);
/*     */       }
/*  59 */       selector.set((XmlObject)paramSelector);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectorDocument.Selector addNewSelector() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       SelectorDocument.Selector selector = null;
/*  72 */       selector = (SelectorDocument.Selector)get_store().add_element_user(SELECTOR$0);
/*  73 */       return selector;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SelectorImpl
/*     */     extends AnnotatedImpl
/*     */     implements SelectorDocument.Selector
/*     */   {
/*     */     public SelectorImpl(SchemaType param1SchemaType) {
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
/*     */     public SelectorDocument.Selector.Xpath xgetXpath() {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         SelectorDocument.Selector.Xpath xpath = null;
/* 120 */         xpath = (SelectorDocument.Selector.Xpath)get_store().find_attribute_user(XPATH$0);
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
/*     */     public void xsetXpath(SelectorDocument.Selector.Xpath param1Xpath) {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         SelectorDocument.Selector.Xpath xpath = null;
/* 152 */         xpath = (SelectorDocument.Selector.Xpath)get_store().find_attribute_user(XPATH$0);
/* 153 */         if (xpath == null)
/*     */         {
/* 155 */           xpath = (SelectorDocument.Selector.Xpath)get_store().add_attribute_user(XPATH$0);
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
/*     */       implements SelectorDocument.Selector.Xpath
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


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SelectorDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */