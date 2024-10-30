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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "CT_FixedPercentage", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */ public class CTFixedPercentage
/*    */ {
/*    */   @XmlAttribute(required = true)
/*    */   protected int val;
/*    */   
/*    */   public int getVal() {
/* 55 */     return this.val;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVal(int paramInt) {
/* 63 */     this.val = paramInt;
/*    */   }
/*    */   
/*    */   public boolean isSetVal() {
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTFixedPercentage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */