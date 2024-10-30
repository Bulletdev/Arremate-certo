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
/*    */ @XmlType(name = "CT_PositiveSize2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */ public class CTPositiveSize2D
/*    */ {
/*    */   @XmlAttribute(required = true)
/*    */   protected long cx;
/*    */   @XmlAttribute(required = true)
/*    */   protected long cy;
/*    */   
/*    */   public long getCx() {
/* 58 */     return this.cx;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCx(long paramLong) {
/* 66 */     this.cx = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetCx() {
/* 70 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getCy() {
/* 78 */     return this.cy;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setCy(long paramLong) {
/* 86 */     this.cy = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetCy() {
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPositiveSize2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */