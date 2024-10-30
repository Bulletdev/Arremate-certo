/*    */ package org.apache.poi.sl.draw.binding;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlAttribute;
/*    */ import javax.xml.bind.annotation.XmlType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "CT_Ratio", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */ public class CTRatio
/*    */ {
/*    */   @XmlAttribute(required = true)
/*    */   protected long n;
/*    */   @XmlAttribute(required = true)
/*    */   protected long d;
/*    */   
/*    */   public long getN() {
/* 58 */     return this.n;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setN(long paramLong) {
/* 66 */     this.n = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetN() {
/* 70 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getD() {
/* 78 */     return this.d;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setD(long paramLong) {
/* 86 */     this.d = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetD() {
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTRatio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */