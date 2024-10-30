/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.NamespaceContext;
/*     */ import org.apache.xmlbeans.soap.SOAPArrayType;
/*     */ import org.apache.xmlbeans.soap.SchemaWSDLArrayType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaLocalAttributeImpl
/*     */   implements SchemaLocalAttribute, SchemaWSDLArrayType
/*     */ {
/*     */   private String _defaultText;
/*     */   XmlValueRef _defaultValue;
/*     */   private boolean _isFixed;
/*     */   private boolean _isDefault;
/*     */   private b _xmlName;
/*     */   private SchemaType.Ref _typeref;
/*     */   private SOAPArrayType _wsdlArrayType;
/*     */   private int _use;
/*     */   private SchemaAnnotation _annotation;
/*     */   protected XmlObject _parseObject;
/*     */   private Object _userData;
/*     */   
/*     */   public void init(b paramb, SchemaType.Ref paramRef, int paramInt, String paramString, XmlObject paramXmlObject, XmlValueRef paramXmlValueRef, boolean paramBoolean, SOAPArrayType paramSOAPArrayType, SchemaAnnotation paramSchemaAnnotation, Object paramObject) {
/*  41 */     if (this._xmlName != null || this._typeref != null)
/*  42 */       throw new IllegalStateException("Already initialized"); 
/*  43 */     this._use = paramInt;
/*  44 */     this._typeref = paramRef;
/*  45 */     this._defaultText = paramString;
/*  46 */     this._parseObject = paramXmlObject;
/*  47 */     this._defaultValue = paramXmlValueRef;
/*  48 */     this._isDefault = (paramString != null);
/*  49 */     this._isFixed = paramBoolean;
/*  50 */     this._xmlName = paramb;
/*  51 */     this._wsdlArrayType = paramSOAPArrayType;
/*  52 */     this._annotation = paramSchemaAnnotation;
/*  53 */     this._userData = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTypeResolved() {
/*  70 */     return (this._typeref != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resolveTypeRef(SchemaType.Ref paramRef) {
/*  75 */     if (this._typeref != null)
/*  76 */       throw new IllegalStateException(); 
/*  77 */     this._typeref = paramRef;
/*     */   }
/*     */   
/*     */   public int getUse() {
/*  81 */     return this._use;
/*     */   }
/*     */   public b getName() {
/*  84 */     return this._xmlName;
/*     */   }
/*     */   public String getDefaultText() {
/*  87 */     return this._defaultText;
/*     */   }
/*     */   public boolean isDefault() {
/*  90 */     return this._isDefault;
/*     */   }
/*     */   public boolean isFixed() {
/*  93 */     return this._isFixed;
/*     */   }
/*     */   public boolean isAttribute() {
/*  96 */     return true;
/*     */   }
/*     */   public SchemaAnnotation getAnnotation() {
/*  99 */     return this._annotation;
/*     */   }
/*     */   public SchemaType getType() {
/* 102 */     return this._typeref.get();
/*     */   }
/*     */   public SchemaType.Ref getTypeRef() {
/* 105 */     return this._typeref;
/*     */   }
/*     */   public BigInteger getMinOccurs() {
/* 108 */     return (this._use == 3) ? BigInteger.ONE : BigInteger.ZERO;
/*     */   }
/*     */   public BigInteger getMaxOccurs() {
/* 111 */     return (this._use == 1) ? BigInteger.ZERO : BigInteger.ONE;
/*     */   }
/*     */   public boolean isNillable() {
/* 114 */     return false;
/*     */   }
/*     */   public SOAPArrayType getWSDLArrayType() {
/* 117 */     return this._wsdlArrayType;
/*     */   }
/*     */   
/*     */   public XmlAnySimpleType getDefaultValue() {
/* 121 */     if (this._defaultValue != null)
/* 122 */       return this._defaultValue.get(); 
/* 123 */     if (this._defaultText != null && XmlAnySimpleType.type.isAssignableFrom(getType())) {
/*     */       
/* 125 */       if (this._parseObject != null) {
/*     */         
/*     */         try {
/*     */           
/* 129 */           NamespaceContext.push(new NamespaceContext(this._parseObject));
/* 130 */           return getType().newValue(this._defaultText);
/*     */         }
/*     */         finally {
/*     */           
/* 134 */           NamespaceContext.pop();
/*     */         } 
/*     */       }
/* 137 */       return getType().newValue(this._defaultText);
/*     */     } 
/* 139 */     return null;
/*     */   }
/*     */   
/*     */   public void setDefaultValue(XmlValueRef paramXmlValueRef) {
/* 143 */     this._defaultValue = paramXmlValueRef;
/*     */   }
/*     */   public Object getUserData() {
/* 146 */     return this._userData;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaLocalAttributeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */