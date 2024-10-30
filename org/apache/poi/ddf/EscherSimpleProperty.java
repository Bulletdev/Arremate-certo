/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ 
/*     */ public class EscherSimpleProperty
/*     */   extends EscherProperty
/*     */ {
/*     */   protected int propertyValue;
/*     */   
/*     */   public EscherSimpleProperty(short paramShort, int paramInt) {
/*  41 */     super(paramShort);
/*  42 */     this.propertyValue = paramInt;
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
/*     */   public EscherSimpleProperty(short paramShort, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/*  55 */     super(paramShort, paramBoolean1, paramBoolean2);
/*  56 */     this.propertyValue = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serializeSimplePart(byte[] paramArrayOfbyte, int paramInt) {
/*  67 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getId());
/*  68 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 2, this.propertyValue);
/*  69 */     return 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serializeComplexPart(byte[] paramArrayOfbyte, int paramInt) {
/*  79 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPropertyValue() {
/*  87 */     return this.propertyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  96 */     if (this == paramObject) return true; 
/*  97 */     if (!(paramObject instanceof EscherSimpleProperty)) return false;
/*     */     
/*  99 */     EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)paramObject;
/*     */     
/* 101 */     if (this.propertyValue != escherSimpleProperty.propertyValue) return false; 
/* 102 */     if (getId() != escherSimpleProperty.getId()) return false;
/*     */     
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     return this.propertyValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 123 */     return "propNum: " + getPropertyNumber() + ", RAW: 0x" + HexDump.toHex(getId()) + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", value: " + this.propertyValue + " (0x" + HexDump.toHex(this.propertyValue) + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 133 */     StringBuilder stringBuilder = new StringBuilder();
/* 134 */     stringBuilder.append(paramString).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\" complex=\"").append(isComplex()).append("\" value=\"").append("0x").append(HexDump.toHex(this.propertyValue)).append("\"/>\n");
/*     */ 
/*     */ 
/*     */     
/* 138 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherSimpleProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */