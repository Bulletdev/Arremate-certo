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
/*    */ public class EscherBoolProperty
/*    */   extends EscherSimpleProperty
/*    */ {
/*    */   public EscherBoolProperty(short paramShort, int paramInt) {
/* 42 */     super(paramShort, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isTrue() {
/* 52 */     return (this.propertyValue != 0);
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
/*    */   public boolean isFalse() {
/* 64 */     return (this.propertyValue == 0);
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
/*    */   
/*    */   public String toXml(String paramString) {
/* 77 */     StringBuilder stringBuilder = new StringBuilder();
/* 78 */     stringBuilder.append(paramString).append("<").append(getClass().getSimpleName()).append(" id=\"0x").append(HexDump.toHex(getId())).append("\" name=\"").append(getName()).append("\" simpleValue=\"").append(getPropertyValue()).append("\" blipId=\"").append(isBlipId()).append("\" value=\"").append(isTrue()).append("\"").append("/>\n");
/*    */ 
/*    */     
/* 81 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherBoolProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */