/*     */ package org.apache.xmlbeans.impl.inst2xsd.util;
/*     */ 
/*     */ import javax.xml.namespace.b;
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
/*     */ public class Element
/*     */ {
/*  24 */   private b _name = null;
/*  25 */   private Element _ref = null;
/*     */   private boolean _isGlobal = false;
/*  27 */   private int _minOccurs = 1;
/*  28 */   private int _maxOccurs = 1;
/*     */   public static final int UNBOUNDED = -1;
/*     */   private boolean _isNillable = false;
/*  31 */   private Type _type = null;
/*  32 */   private String _comment = null;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public b getName() {
/*  36 */     return this._name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(b paramb) {
/*  41 */     this._name = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRef() {
/*  46 */     return (this._ref != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Element getRef() {
/*  51 */     return this._ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRef(Element paramElement) {
/*  56 */     assert !this._isGlobal;
/*  57 */     this._ref = paramElement;
/*  58 */     this._type = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGlobal() {
/*  63 */     return this._isGlobal;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGlobal(boolean paramBoolean) {
/*  68 */     this._isGlobal = paramBoolean;
/*  69 */     this._minOccurs = 1;
/*  70 */     this._maxOccurs = 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMinOccurs() {
/*  75 */     return this._minOccurs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMinOccurs(int paramInt) {
/*  80 */     this._minOccurs = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxOccurs() {
/*  85 */     return this._maxOccurs;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxOccurs(int paramInt) {
/*  90 */     this._maxOccurs = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNillable() {
/*  95 */     return this._isNillable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNillable(boolean paramBoolean) {
/* 100 */     this._isNillable = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getType() {
/* 105 */     return isRef() ? getRef().getType() : this._type;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setType(Type paramType) {
/* 110 */     assert !isRef();
/* 111 */     this._type = paramType;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 116 */     return this._comment;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setComment(String paramString) {
/* 121 */     this._comment = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 126 */     return "\n  Element{ _name = " + this._name + ", _ref = " + ((this._ref != null) ? 1 : 0) + ", _isGlobal = " + this._isGlobal + ", _minOccurs = " + this._minOccurs + ", _maxOccurs = " + this._maxOccurs + ", _isNillable = " + this._isNillable + ", _comment = " + this._comment + ",\n    _type = " + ((this._type == null) ? "null" : (this._type.isGlobal() ? this._type.getName().toString() : this._type.toString())) + "\n  }";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xs\\util\Element.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */