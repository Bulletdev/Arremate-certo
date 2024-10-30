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
/*    */ @XmlType(name = "CT_Point2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */ public class CTPoint2D
/*    */ {
/*    */   @XmlAttribute(required = true)
/*    */   protected long x;
/*    */   @XmlAttribute(required = true)
/*    */   protected long y;
/*    */   
/*    */   public long getX() {
/* 58 */     return this.x;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setX(long paramLong) {
/* 66 */     this.x = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetX() {
/* 70 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getY() {
/* 78 */     return this.y;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setY(long paramLong) {
/* 86 */     this.y = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetY() {
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPoint2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */