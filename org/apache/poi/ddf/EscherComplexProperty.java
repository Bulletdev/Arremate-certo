/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ public class EscherComplexProperty
/*     */   extends EscherProperty
/*     */ {
/*     */   protected byte[] _complexData;
/*     */   
/*     */   public EscherComplexProperty(short paramShort, byte[] paramArrayOfbyte) {
/*  43 */     super(paramShort);
/*  44 */     if (paramArrayOfbyte == null) {
/*  45 */       throw new IllegalArgumentException("complexData can't be null");
/*     */     }
/*  47 */     this._complexData = (byte[])paramArrayOfbyte.clone();
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
/*     */   public EscherComplexProperty(short paramShort, boolean paramBoolean, byte[] paramArrayOfbyte) {
/*  59 */     super(paramShort, true, paramBoolean);
/*  60 */     if (paramArrayOfbyte == null) {
/*  61 */       throw new IllegalArgumentException("complexData can't be null");
/*     */     }
/*  63 */     this._complexData = (byte[])paramArrayOfbyte.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serializeSimplePart(byte[] paramArrayOfbyte, int paramInt) {
/*  71 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getId());
/*  72 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 2, this._complexData.length);
/*  73 */     return 6;
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
/*     */   public int serializeComplexPart(byte[] paramArrayOfbyte, int paramInt) {
/*  85 */     System.arraycopy(this._complexData, 0, paramArrayOfbyte, paramInt, this._complexData.length);
/*  86 */     return this._complexData.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getComplexData() {
/*  95 */     return this._complexData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 106 */     if (this == paramObject) {
/* 107 */       return true;
/*     */     }
/* 109 */     if (paramObject == null || !(paramObject instanceof EscherComplexProperty)) {
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     EscherComplexProperty escherComplexProperty = (EscherComplexProperty)paramObject;
/*     */     
/* 115 */     return Arrays.equals(this._complexData, escherComplexProperty._complexData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPropertySize() {
/* 126 */     return 6 + this._complexData.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return getId() * 11;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     String str = HexDump.toHex(this._complexData, 32);
/*     */     
/* 141 */     return "propNum: " + getPropertyNumber() + ", propName: " + EscherProperties.getPropertyName(getPropertyNumber()) + ", complex: " + isComplex() + ", blipId: " + isBlipId() + ", data: " + System.getProperty("line.separator") + str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 150 */     return paramString + "<" + getClass().getSimpleName() + " id=\"0x" + HexDump.toHex(getId()) + "\" name=\"" + getName() + "\" blipId=\"" + isBlipId() + "\">\n" + paramString + "</" + getClass().getSimpleName() + ">\n";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherComplexProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */