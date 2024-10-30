/*    */ package org.apache.poi.ddf;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public class EscherRGBProperty
/*    */   extends EscherSimpleProperty
/*    */ {
/*    */   public EscherRGBProperty(short paramShort, int paramInt) {
/* 31 */     super(paramShort, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRgbColor() {
/* 39 */     return this.propertyValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getRed() {
/* 47 */     return (byte)(this.propertyValue & 0xFF);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getGreen() {
/* 55 */     return (byte)(this.propertyValue >> 8 & 0xFF);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getBlue() {
/* 63 */     return (byte)(this.propertyValue >> 16 & 0xFF);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toXml(String paramString) {
/* 68 */     StringBuilder stringBuilder = new StringBuilder();
/* 69 */     stringBuilder.append(paramString).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" blipId=\"").append(isBlipId()).append("\" value=\"0x").append(HexDump.toHex(this.propertyValue)).append("\"/>\n");
/*    */ 
/*    */     
/* 72 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherRGBProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */