/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import org.apache.xmlbeans.SchemaAnnotation;
/*     */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*     */ import org.apache.xmlbeans.SchemaLocalElement;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaLocalElementImpl
/*     */   extends SchemaParticleImpl
/*     */   implements SchemaLocalElement, SchemaWSDLArrayType
/*     */ {
/*     */   private boolean _blockExt;
/*     */   private boolean _blockRest;
/*     */   private boolean _blockSubst;
/*     */   protected boolean _abs;
/*     */   private SchemaAnnotation _annotation;
/*     */   private SOAPArrayType _wsdlArrayType;
/*  34 */   private SchemaIdentityConstraint.Ref[] _constraints = new SchemaIdentityConstraint.Ref[0];
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaLocalElementImpl() {
/*  39 */     setParticleType(4);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean blockExtension() {
/*  44 */     return this._blockExt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean blockRestriction() {
/*  49 */     return this._blockRest;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean blockSubstitution() {
/*  54 */     return this._blockSubst;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAbstract() {
/*  59 */     return this._abs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAbstract(boolean paramBoolean) {
/*  64 */     this._abs = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBlock(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  69 */     mutate();
/*  70 */     this._blockExt = paramBoolean1;
/*  71 */     this._blockRest = paramBoolean2;
/*  72 */     this._blockSubst = paramBoolean3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnnotation(SchemaAnnotation paramSchemaAnnotation) {
/*  77 */     this._annotation = paramSchemaAnnotation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setWsdlArrayType(SOAPArrayType paramSOAPArrayType) {
/*  82 */     this._wsdlArrayType = paramSOAPArrayType;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAnnotation getAnnotation() {
/*  87 */     return this._annotation;
/*     */   }
/*     */ 
/*     */   
/*     */   public SOAPArrayType getWSDLArrayType() {
/*  92 */     return this._wsdlArrayType;
/*     */   }
/*     */   
/*     */   public void setIdentityConstraints(SchemaIdentityConstraint.Ref[] paramArrayOfRef) {
/*  96 */     mutate();
/*  97 */     this._constraints = paramArrayOfRef;
/*     */   }
/*     */   
/*     */   public SchemaIdentityConstraint[] getIdentityConstraints() {
/* 101 */     SchemaIdentityConstraint[] arrayOfSchemaIdentityConstraint = new SchemaIdentityConstraint[this._constraints.length];
/* 102 */     for (byte b = 0; b < arrayOfSchemaIdentityConstraint.length; b++)
/* 103 */       arrayOfSchemaIdentityConstraint[b] = this._constraints[b].get(); 
/* 104 */     return arrayOfSchemaIdentityConstraint;
/*     */   }
/*     */   
/*     */   public SchemaIdentityConstraint.Ref[] getIdentityConstraintRefs() {
/* 108 */     SchemaIdentityConstraint.Ref[] arrayOfRef = new SchemaIdentityConstraint.Ref[this._constraints.length];
/* 109 */     System.arraycopy(this._constraints, 0, arrayOfRef, 0, arrayOfRef.length);
/* 110 */     return arrayOfRef;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaLocalElementImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */