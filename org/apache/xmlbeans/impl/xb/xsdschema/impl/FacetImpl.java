/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlBoolean;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FacetImpl
/*     */   extends AnnotatedImpl
/*     */   implements Facet
/*     */ {
/*     */   public FacetImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b VALUE$0 = new b("", "value");
/*     */   
/*  24 */   private static final b FIXED$2 = new b("", "fixed");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnySimpleType getValue() {
/*  33 */     synchronized (monitor()) {
/*     */       
/*  35 */       check_orphaned();
/*  36 */       XmlAnySimpleType xmlAnySimpleType = null;
/*  37 */       xmlAnySimpleType = (XmlAnySimpleType)get_store().find_attribute_user(VALUE$0);
/*  38 */       if (xmlAnySimpleType == null)
/*     */       {
/*  40 */         return null;
/*     */       }
/*  42 */       return xmlAnySimpleType;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(XmlAnySimpleType paramXmlAnySimpleType) {
/*  51 */     synchronized (monitor()) {
/*     */       
/*  53 */       check_orphaned();
/*  54 */       XmlAnySimpleType xmlAnySimpleType = null;
/*  55 */       xmlAnySimpleType = (XmlAnySimpleType)get_store().find_attribute_user(VALUE$0);
/*  56 */       if (xmlAnySimpleType == null)
/*     */       {
/*  58 */         xmlAnySimpleType = (XmlAnySimpleType)get_store().add_attribute_user(VALUE$0);
/*     */       }
/*  60 */       xmlAnySimpleType.set((XmlObject)paramXmlAnySimpleType);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnySimpleType addNewValue() {
/*  69 */     synchronized (monitor()) {
/*     */       
/*  71 */       check_orphaned();
/*  72 */       XmlAnySimpleType xmlAnySimpleType = null;
/*  73 */       xmlAnySimpleType = (XmlAnySimpleType)get_store().add_attribute_user(VALUE$0);
/*  74 */       return xmlAnySimpleType;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFixed() {
/*  83 */     synchronized (monitor()) {
/*     */       
/*  85 */       check_orphaned();
/*  86 */       SimpleValue simpleValue = null;
/*  87 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FIXED$2);
/*  88 */       if (simpleValue == null)
/*     */       {
/*  90 */         simpleValue = (SimpleValue)get_default_attribute_value(FIXED$2);
/*     */       }
/*  92 */       if (simpleValue == null)
/*     */       {
/*  94 */         return false;
/*     */       }
/*  96 */       return simpleValue.getBooleanValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlBoolean xgetFixed() {
/* 105 */     synchronized (monitor()) {
/*     */       
/* 107 */       check_orphaned();
/* 108 */       XmlBoolean xmlBoolean = null;
/* 109 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIXED$2);
/* 110 */       if (xmlBoolean == null)
/*     */       {
/* 112 */         xmlBoolean = (XmlBoolean)get_default_attribute_value(FIXED$2);
/*     */       }
/* 114 */       return xmlBoolean;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetFixed() {
/* 123 */     synchronized (monitor()) {
/*     */       
/* 125 */       check_orphaned();
/* 126 */       return (get_store().find_attribute_user(FIXED$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFixed(boolean paramBoolean) {
/* 135 */     synchronized (monitor()) {
/*     */       
/* 137 */       check_orphaned();
/* 138 */       SimpleValue simpleValue = null;
/* 139 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FIXED$2);
/* 140 */       if (simpleValue == null)
/*     */       {
/* 142 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FIXED$2);
/*     */       }
/* 144 */       simpleValue.setBooleanValue(paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetFixed(XmlBoolean paramXmlBoolean) {
/* 153 */     synchronized (monitor()) {
/*     */       
/* 155 */       check_orphaned();
/* 156 */       XmlBoolean xmlBoolean = null;
/* 157 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FIXED$2);
/* 158 */       if (xmlBoolean == null)
/*     */       {
/* 160 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FIXED$2);
/*     */       }
/* 162 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetFixed() {
/* 171 */     synchronized (monitor()) {
/*     */       
/* 173 */       check_orphaned();
/* 174 */       get_store().remove_attribute(FIXED$2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\FacetImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */