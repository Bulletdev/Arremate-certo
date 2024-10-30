/*    */ package org.apache.xmlbeans.impl.inst2xsd.util;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Attribute
/*    */ {
/*    */   private b _name;
/*    */   private Type _type;
/* 26 */   private Attribute _ref = null;
/*    */   private boolean _isGlobal = false;
/*    */   private boolean _isOptional = false;
/*    */   static final boolean $assertionsDisabled;
/*    */   
/*    */   public b getName() {
/* 32 */     return this._name;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setName(b paramb) {
/* 37 */     this._name = paramb;
/*    */   }
/*    */ 
/*    */   
/*    */   public Type getType() {
/* 42 */     return isRef() ? getRef().getType() : this._type;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setType(Type paramType) {
/* 47 */     assert !isRef();
/* 48 */     this._type = paramType;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRef() {
/* 53 */     return (this._ref != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public Attribute getRef() {
/* 58 */     return this._ref;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setRef(Attribute paramAttribute) {
/* 63 */     assert !isGlobal();
/* 64 */     this._ref = paramAttribute;
/* 65 */     this._type = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isGlobal() {
/* 70 */     return this._isGlobal;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setGlobal(boolean paramBoolean) {
/* 75 */     this._isGlobal = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOptional() {
/* 80 */     return this._isOptional;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOptional(boolean paramBoolean) {
/* 85 */     assert paramBoolean && !isGlobal() : "Global attributes cannot be optional.";
/* 86 */     this._isOptional = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 91 */     return "\n    Attribute{_name=" + this._name + ", _type=" + this._type + ", _ref=" + ((this._ref != null) ? 1 : 0) + ", _isGlobal=" + this._isGlobal + ", _isOptional=" + this._isOptional + "}";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xs\\util\Attribute.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */