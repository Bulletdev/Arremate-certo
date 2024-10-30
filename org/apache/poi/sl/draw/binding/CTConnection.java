/*    */ package org.apache.poi.sl.draw.binding;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlAttribute;
/*    */ import javax.xml.bind.annotation.XmlSchemaType;
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
/*    */ @XmlType(name = "CT_Connection", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */ public class CTConnection
/*    */ {
/*    */   @XmlAttribute(required = true)
/*    */   protected long id;
/*    */   @XmlAttribute(required = true)
/*    */   @XmlSchemaType(name = "unsignedInt")
/*    */   protected long idx;
/*    */   
/*    */   public long getId() {
/* 60 */     return this.id;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setId(long paramLong) {
/* 68 */     this.id = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetId() {
/* 72 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long getIdx() {
/* 80 */     return this.idx;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIdx(long paramLong) {
/* 88 */     this.idx = paramLong;
/*    */   }
/*    */   
/*    */   public boolean isSetIdx() {
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */