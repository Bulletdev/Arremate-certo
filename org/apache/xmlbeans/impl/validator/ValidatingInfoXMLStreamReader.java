/*     */ package org.apache.xmlbeans.impl.validator;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamException;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.GDate;
/*     */ import org.apache.xmlbeans.GDuration;
/*     */ import org.apache.xmlbeans.SchemaAttributeModel;
/*     */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*     */ import org.apache.xmlbeans.SchemaLocalElement;
/*     */ import org.apache.xmlbeans.SchemaParticle;
/*     */ import org.apache.xmlbeans.SchemaType;
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
/*     */ 
/*     */ public class ValidatingInfoXMLStreamReader
/*     */   extends ValidatingXMLStreamReader
/*     */   implements XMLStreamReader
/*     */ {
/*  48 */   private int _attCount = -1;
/*  49 */   private int _attIndex = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextWithAttributes() throws XMLStreamException {
/*  54 */     if (this._attIndex < this._attCount) {
/*     */       
/*  56 */       validate_attribute(this._attIndex);
/*  57 */       this._attIndex++;
/*  58 */       return 10;
/*     */     } 
/*     */     
/*  61 */     return next();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_attributes(int paramInt) {
/*  66 */     this._attCount = paramInt;
/*  67 */     this._attIndex = 0;
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
/*     */   public SchemaType getCurrentElementSchemaType() {
/*  82 */     return (this._validator == null) ? null : this._validator.getCurrentElementSchemaType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaLocalElement getCurrentElement() {
/*  90 */     return (this._validator == null) ? null : this._validator.getCurrentElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaParticle getCurrentWildcardElement() {
/* 100 */     return (this._validator == null) ? null : this._validator.getCurrentWildcardElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaLocalAttribute getCurrentAttribute() {
/* 109 */     return (this._validator == null) ? null : this._validator.getCurrentAttribute();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaAttributeModel getCurrentWildcardAttribute() {
/* 117 */     return (this._validator == null) ? null : this._validator.getCurrentWildcardAttribute();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getStringValue() {
/* 122 */     return (this._validator == null) ? null : this._validator.getStringValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 127 */     return (this._validator == null) ? null : this._validator.getDecimalValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getBooleanValue() {
/* 132 */     return (this._validator == null) ? false : this._validator.getBooleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFloatValue() {
/* 137 */     return (this._validator == null) ? 0.0F : this._validator.getFloatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDoubleValue() {
/* 142 */     return (this._validator == null) ? 0.0D : this._validator.getDoubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public b getQNameValue() {
/* 147 */     return (this._validator == null) ? null : this._validator.getQNameValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public GDate getGDateValue() {
/* 152 */     return (this._validator == null) ? null : this._validator.getGDateValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public GDuration getGDurationValue() {
/* 157 */     return (this._validator == null) ? null : this._validator.getGDurationValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteArrayValue() {
/* 162 */     return (this._validator == null) ? null : this._validator.getByteArrayValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public List getListValue() {
/* 167 */     return (this._validator == null) ? null : this._validator.getListValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public List getListTypes() {
/* 172 */     return (this._validator == null) ? null : this._validator.getListTypes();
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType getUnionType() {
/* 177 */     return (this._validator == null) ? null : this._validator.getUnionType();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\validator\ValidatingInfoXMLStreamReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */