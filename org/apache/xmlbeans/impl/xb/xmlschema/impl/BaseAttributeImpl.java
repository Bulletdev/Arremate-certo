/*     */ package org.apache.xmlbeans.impl.xb.xmlschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlschema.BaseAttribute;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaseAttributeImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements BaseAttribute
/*     */ {
/*     */   public BaseAttributeImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b BASE$0 = new b("http://www.w3.org/XML/1998/namespace", "base");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBase() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       SimpleValue simpleValue = null;
/*  36 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$0);
/*  37 */       if (simpleValue == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI xgetBase() {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       XmlAnyURI xmlAnyURI = null;
/*  54 */       xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(BASE$0);
/*  55 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetBase() {
/*  64 */     synchronized (monitor()) {
/*     */       
/*  66 */       check_orphaned();
/*  67 */       return (get_store().find_attribute_user(BASE$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBase(String paramString) {
/*  76 */     synchronized (monitor()) {
/*     */       
/*  78 */       check_orphaned();
/*  79 */       SimpleValue simpleValue = null;
/*  80 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BASE$0);
/*  81 */       if (simpleValue == null)
/*     */       {
/*  83 */         simpleValue = (SimpleValue)get_store().add_attribute_user(BASE$0);
/*     */       }
/*  85 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetBase(XmlAnyURI paramXmlAnyURI) {
/*  94 */     synchronized (monitor()) {
/*     */       
/*  96 */       check_orphaned();
/*  97 */       XmlAnyURI xmlAnyURI = null;
/*  98 */       xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(BASE$0);
/*  99 */       if (xmlAnyURI == null)
/*     */       {
/* 101 */         xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(BASE$0);
/*     */       }
/* 103 */       xmlAnyURI.set((XmlObject)paramXmlAnyURI);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetBase() {
/* 112 */     synchronized (monitor()) {
/*     */       
/* 114 */       check_orphaned();
/* 115 */       get_store().remove_attribute(BASE$0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlschema\impl\BaseAttributeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */