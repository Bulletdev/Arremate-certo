/*    */ package org.apache.poi.ddf;
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
/*    */ public abstract class EscherProperty
/*    */ {
/*    */   private short _id;
/*    */   
/*    */   public EscherProperty(short paramShort) {
/* 35 */     this._id = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EscherProperty(short paramShort, boolean paramBoolean1, boolean paramBoolean2) {
/* 47 */     this._id = (short)(paramShort + (paramBoolean1 ? 32768 : 0) + (paramBoolean2 ? 16384 : 0));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getId() {
/* 53 */     return this._id;
/*    */   }
/*    */   
/*    */   public short getPropertyNumber() {
/* 57 */     return (short)(this._id & 0x3FFF);
/*    */   }
/*    */   
/*    */   public boolean isComplex() {
/* 61 */     return ((this._id & Short.MIN_VALUE) != 0);
/*    */   }
/*    */   
/*    */   public boolean isBlipId() {
/* 65 */     return ((this._id & 0x4000) != 0);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 69 */     return EscherProperties.getPropertyName(getPropertyNumber());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPropertySize() {
/* 79 */     return 6;
/*    */   }
/*    */   
/*    */   public String toXml(String paramString) {
/* 83 */     StringBuilder stringBuilder = new StringBuilder();
/* 84 */     stringBuilder.append(paramString).append("<").append(getClass().getSimpleName()).append(" id=\"").append(getId()).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\"/>\n");
/*    */     
/* 86 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public abstract int serializeSimplePart(byte[] paramArrayOfbyte, int paramInt);
/*    */   
/*    */   public abstract int serializeComplexPart(byte[] paramArrayOfbyte, int paramInt);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */