/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.QNameSet;
/*     */ import org.apache.xmlbeans.SchemaParticle;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.values.NamespaceContext;
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
/*     */ public class SchemaParticleImpl
/*     */   implements SchemaParticle
/*     */ {
/*     */   private int _particleType;
/*     */   private BigInteger _minOccurs;
/*     */   private BigInteger _maxOccurs;
/*     */   private SchemaParticle[] _particleChildren;
/*     */   private boolean _isImmutable;
/*     */   private QNameSet _startSet;
/*     */   private QNameSet _excludeNextSet;
/*     */   private boolean _isSkippable;
/*     */   private boolean _isDeterministic;
/*     */   private int _intMinOccurs;
/*     */   private int _intMaxOccurs;
/*     */   private QNameSet _wildcardSet;
/*     */   private int _wildcardProcess;
/*     */   private String _defaultText;
/*     */   private boolean _isDefault;
/*     */   private boolean _isFixed;
/*     */   private b _qName;
/*     */   private boolean _isNillable;
/*     */   private SchemaType.Ref _typeref;
/*     */   protected XmlObject _parseObject;
/*     */   private Object _userData;
/*     */   private XmlValueRef _defaultValue;
/*     */   
/*     */   protected void mutate() {
/*  56 */     if (this._isImmutable) throw new IllegalStateException(); 
/*     */   }
/*     */   public void setImmutable() {
/*  59 */     mutate(); this._isImmutable = true;
/*     */   }
/*     */   public boolean hasTransitionRules() {
/*  62 */     return (this._startSet != null);
/*     */   }
/*     */   public boolean hasTransitionNotes() {
/*  65 */     return (this._excludeNextSet != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransitionRules(QNameSet paramQNameSet, boolean paramBoolean) {
/*  70 */     this._startSet = paramQNameSet;
/*  71 */     this._isSkippable = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTransitionNotes(QNameSet paramQNameSet, boolean paramBoolean) {
/*  76 */     this._excludeNextSet = paramQNameSet;
/*  77 */     this._isDeterministic = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean canStartWithElement(b paramb) {
/*  81 */     return (paramb != null && this._startSet.contains(paramb));
/*     */   }
/*     */   public QNameSet acceptedStartNames() {
/*  84 */     return this._startSet;
/*     */   }
/*     */   public QNameSet getExcludeNextSet() {
/*  87 */     return this._excludeNextSet;
/*     */   }
/*     */   public boolean isSkippable() {
/*  90 */     return this._isSkippable;
/*     */   }
/*     */   public boolean isDeterministic() {
/*  93 */     return this._isDeterministic;
/*     */   }
/*     */   public int getParticleType() {
/*  96 */     return this._particleType;
/*     */   }
/*     */   public void setParticleType(int paramInt) {
/*  99 */     mutate(); this._particleType = paramInt;
/*     */   }
/*     */   public boolean isSingleton() {
/* 102 */     return (this._maxOccurs != null && this._maxOccurs.compareTo(BigInteger.ONE) == 0 && this._minOccurs.compareTo(BigInteger.ONE) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public BigInteger getMinOccurs() {
/* 107 */     return this._minOccurs;
/*     */   }
/*     */   public void setMinOccurs(BigInteger paramBigInteger) {
/* 110 */     mutate(); this._minOccurs = paramBigInteger; this._intMinOccurs = pegBigInteger(paramBigInteger);
/*     */   }
/*     */   public int getIntMinOccurs() {
/* 113 */     return this._intMinOccurs;
/*     */   }
/*     */   public BigInteger getMaxOccurs() {
/* 116 */     return this._maxOccurs;
/*     */   }
/*     */   public int getIntMaxOccurs() {
/* 119 */     return this._intMaxOccurs;
/*     */   }
/*     */   public void setMaxOccurs(BigInteger paramBigInteger) {
/* 122 */     mutate(); this._maxOccurs = paramBigInteger; this._intMaxOccurs = pegBigInteger(paramBigInteger);
/*     */   }
/*     */   
/*     */   public SchemaParticle[] getParticleChildren() {
/* 126 */     if (this._particleChildren == null) {
/*     */       
/* 128 */       assert this._particleType != 1 && this._particleType != 3 && this._particleType != 2;
/*     */ 
/*     */       
/* 131 */       return null;
/*     */     } 
/* 133 */     SchemaParticle[] arrayOfSchemaParticle = new SchemaParticle[this._particleChildren.length];
/* 134 */     System.arraycopy(this._particleChildren, 0, arrayOfSchemaParticle, 0, this._particleChildren.length);
/* 135 */     return arrayOfSchemaParticle;
/*     */   }
/*     */   
/*     */   public void setParticleChildren(SchemaParticle[] paramArrayOfSchemaParticle) {
/* 139 */     mutate(); this._particleChildren = paramArrayOfSchemaParticle;
/*     */   }
/*     */   public SchemaParticle getParticleChild(int paramInt) {
/* 142 */     return this._particleChildren[paramInt];
/*     */   }
/*     */   public int countOfParticleChild() {
/* 145 */     return (this._particleChildren == null) ? 0 : this._particleChildren.length;
/*     */   }
/*     */   public void setWildcardSet(QNameSet paramQNameSet) {
/* 148 */     mutate(); this._wildcardSet = paramQNameSet;
/*     */   }
/*     */   public QNameSet getWildcardSet() {
/* 151 */     return this._wildcardSet;
/*     */   }
/*     */   public void setWildcardProcess(int paramInt) {
/* 154 */     mutate(); this._wildcardProcess = paramInt;
/*     */   }
/*     */   public int getWildcardProcess() {
/* 157 */     return this._wildcardProcess;
/*     */   }
/* 159 */   private static final BigInteger _maxint = BigInteger.valueOf(2147483647L);
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static final int pegBigInteger(BigInteger paramBigInteger) {
/* 163 */     if (paramBigInteger == null)
/* 164 */       return Integer.MAX_VALUE; 
/* 165 */     if (paramBigInteger.signum() <= 0)
/* 166 */       return 0; 
/* 167 */     if (paramBigInteger.compareTo(_maxint) >= 0)
/* 168 */       return Integer.MAX_VALUE; 
/* 169 */     return paramBigInteger.intValue();
/*     */   }
/*     */   
/*     */   public b getName() {
/* 173 */     return this._qName;
/*     */   }
/*     */   public void setNameAndTypeRef(b paramb, SchemaType.Ref paramRef) {
/* 176 */     mutate(); this._qName = paramb; this._typeref = paramRef;
/*     */   }
/*     */   
/*     */   public boolean isTypeResolved() {
/* 180 */     return (this._typeref != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resolveTypeRef(SchemaType.Ref paramRef) {
/* 185 */     if (this._typeref != null)
/* 186 */       throw new IllegalStateException(); 
/* 187 */     this._typeref = paramRef;
/*     */   }
/*     */   
/*     */   public boolean isAttribute() {
/* 191 */     return false;
/*     */   }
/*     */   public SchemaType getType() {
/* 194 */     return (this._typeref == null) ? null : this._typeref.get();
/*     */   }
/*     */   public String getDefaultText() {
/* 197 */     return this._defaultText;
/*     */   }
/*     */   public boolean isDefault() {
/* 200 */     return this._isDefault;
/*     */   }
/*     */   public boolean isFixed() {
/* 203 */     return this._isFixed;
/*     */   }
/*     */   
/*     */   public void setDefault(String paramString, boolean paramBoolean, XmlObject paramXmlObject) {
/* 207 */     mutate();
/* 208 */     this._defaultText = paramString;
/* 209 */     this._isDefault = (paramString != null);
/* 210 */     this._isFixed = paramBoolean;
/* 211 */     this._parseObject = paramXmlObject;
/*     */   }
/*     */   
/*     */   public boolean isNillable() {
/* 215 */     return this._isNillable;
/*     */   }
/*     */   public void setNillable(boolean paramBoolean) {
/* 218 */     mutate(); this._isNillable = paramBoolean;
/*     */   }
/*     */   
/*     */   public XmlAnySimpleType getDefaultValue() {
/* 222 */     if (this._defaultValue != null)
/* 223 */       return this._defaultValue.get(); 
/* 224 */     if (this._defaultText != null && XmlAnySimpleType.type.isAssignableFrom(getType())) {
/*     */       
/* 226 */       if (this._parseObject != null && XmlQName.type.isAssignableFrom(getType())) {
/*     */         
/*     */         try {
/*     */           
/* 230 */           NamespaceContext.push(new NamespaceContext(this._parseObject));
/* 231 */           return getType().newValue(this._defaultText);
/*     */         }
/*     */         finally {
/*     */           
/* 235 */           NamespaceContext.pop();
/*     */         } 
/*     */       }
/* 238 */       return getType().newValue(this._defaultText);
/*     */     } 
/* 240 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDefaultValue(XmlValueRef paramXmlValueRef) {
/* 245 */     mutate();
/* 246 */     this._defaultValue = paramXmlValueRef;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getUserData() {
/* 251 */     return this._userData;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUserData(Object paramObject) {
/* 256 */     this._userData = paramObject;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaParticleImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */