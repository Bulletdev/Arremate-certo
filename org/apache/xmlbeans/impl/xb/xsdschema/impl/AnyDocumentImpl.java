/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnyDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements AnyDocument
/*     */ {
/*     */   public AnyDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b ANY$0 = new b("http://www.w3.org/2001/XMLSchema", "any");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnyDocument.Any getAny() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       AnyDocument.Any any = null;
/*  36 */       any = (AnyDocument.Any)get_store().find_element_user(ANY$0, 0);
/*  37 */       if (any == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return any;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAny(AnyDocument.Any paramAny) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       AnyDocument.Any any = null;
/*  54 */       any = (AnyDocument.Any)get_store().find_element_user(ANY$0, 0);
/*  55 */       if (any == null)
/*     */       {
/*  57 */         any = (AnyDocument.Any)get_store().add_element_user(ANY$0);
/*     */       }
/*  59 */       any.set((XmlObject)paramAny);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnyDocument.Any addNewAny() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       AnyDocument.Any any = null;
/*  72 */       any = (AnyDocument.Any)get_store().add_element_user(ANY$0);
/*  73 */       return any;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AnyImpl
/*     */     extends WildcardImpl
/*     */     implements AnyDocument.Any
/*     */   {
/*     */     public AnyImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b MINOCCURS$0 = new b("", "minOccurs");
/*     */     
/*  91 */     private static final b MAXOCCURS$2 = new b("", "maxOccurs");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BigInteger getMinOccurs() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         SimpleValue simpleValue = null;
/* 104 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MINOCCURS$0);
/* 105 */         if (simpleValue == null)
/*     */         {
/* 107 */           simpleValue = (SimpleValue)get_default_attribute_value(MINOCCURS$0);
/*     */         }
/* 109 */         if (simpleValue == null)
/*     */         {
/* 111 */           return null;
/*     */         }
/* 113 */         return simpleValue.getBigIntegerValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlNonNegativeInteger xgetMinOccurs() {
/* 122 */       synchronized (monitor()) {
/*     */         
/* 124 */         check_orphaned();
/* 125 */         XmlNonNegativeInteger xmlNonNegativeInteger = null;
/* 126 */         xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$0);
/* 127 */         if (xmlNonNegativeInteger == null)
/*     */         {
/* 129 */           xmlNonNegativeInteger = (XmlNonNegativeInteger)get_default_attribute_value(MINOCCURS$0);
/*     */         }
/* 131 */         return xmlNonNegativeInteger;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetMinOccurs() {
/* 140 */       synchronized (monitor()) {
/*     */         
/* 142 */         check_orphaned();
/* 143 */         return (get_store().find_attribute_user(MINOCCURS$0) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMinOccurs(BigInteger param1BigInteger) {
/* 152 */       synchronized (monitor()) {
/*     */         
/* 154 */         check_orphaned();
/* 155 */         SimpleValue simpleValue = null;
/* 156 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MINOCCURS$0);
/* 157 */         if (simpleValue == null)
/*     */         {
/* 159 */           simpleValue = (SimpleValue)get_store().add_attribute_user(MINOCCURS$0);
/*     */         }
/* 161 */         simpleValue.setBigIntegerValue(param1BigInteger);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetMinOccurs(XmlNonNegativeInteger param1XmlNonNegativeInteger) {
/* 170 */       synchronized (monitor()) {
/*     */         
/* 172 */         check_orphaned();
/* 173 */         XmlNonNegativeInteger xmlNonNegativeInteger = null;
/* 174 */         xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$0);
/* 175 */         if (xmlNonNegativeInteger == null)
/*     */         {
/* 177 */           xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().add_attribute_user(MINOCCURS$0);
/*     */         }
/* 179 */         xmlNonNegativeInteger.set((XmlObject)param1XmlNonNegativeInteger);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetMinOccurs() {
/* 188 */       synchronized (monitor()) {
/*     */         
/* 190 */         check_orphaned();
/* 191 */         get_store().remove_attribute(MINOCCURS$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getMaxOccurs() {
/* 200 */       synchronized (monitor()) {
/*     */         
/* 202 */         check_orphaned();
/* 203 */         SimpleValue simpleValue = null;
/* 204 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MAXOCCURS$2);
/* 205 */         if (simpleValue == null)
/*     */         {
/* 207 */           simpleValue = (SimpleValue)get_default_attribute_value(MAXOCCURS$2);
/*     */         }
/* 209 */         if (simpleValue == null)
/*     */         {
/* 211 */           return null;
/*     */         }
/* 213 */         return simpleValue.getObjectValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AllNNI xgetMaxOccurs() {
/* 222 */       synchronized (monitor()) {
/*     */         
/* 224 */         check_orphaned();
/* 225 */         AllNNI allNNI = null;
/* 226 */         allNNI = (AllNNI)get_store().find_attribute_user(MAXOCCURS$2);
/* 227 */         if (allNNI == null)
/*     */         {
/* 229 */           allNNI = (AllNNI)get_default_attribute_value(MAXOCCURS$2);
/*     */         }
/* 231 */         return allNNI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetMaxOccurs() {
/* 240 */       synchronized (monitor()) {
/*     */         
/* 242 */         check_orphaned();
/* 243 */         return (get_store().find_attribute_user(MAXOCCURS$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMaxOccurs(Object param1Object) {
/* 252 */       synchronized (monitor()) {
/*     */         
/* 254 */         check_orphaned();
/* 255 */         SimpleValue simpleValue = null;
/* 256 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MAXOCCURS$2);
/* 257 */         if (simpleValue == null)
/*     */         {
/* 259 */           simpleValue = (SimpleValue)get_store().add_attribute_user(MAXOCCURS$2);
/*     */         }
/* 261 */         simpleValue.setObjectValue(param1Object);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetMaxOccurs(AllNNI param1AllNNI) {
/* 270 */       synchronized (monitor()) {
/*     */         
/* 272 */         check_orphaned();
/* 273 */         AllNNI allNNI = null;
/* 274 */         allNNI = (AllNNI)get_store().find_attribute_user(MAXOCCURS$2);
/* 275 */         if (allNNI == null)
/*     */         {
/* 277 */           allNNI = (AllNNI)get_store().add_attribute_user(MAXOCCURS$2);
/*     */         }
/* 279 */         allNNI.set((XmlObject)param1AllNNI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetMaxOccurs() {
/* 288 */       synchronized (monitor()) {
/*     */         
/* 290 */         check_orphaned();
/* 291 */         get_store().remove_attribute(MAXOCCURS$2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AnyDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */