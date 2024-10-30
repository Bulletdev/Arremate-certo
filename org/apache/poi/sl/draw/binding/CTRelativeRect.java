/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlType;
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
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_RelativeRect", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */ public class CTRelativeRect
/*     */ {
/*     */   @XmlAttribute
/*     */   protected Integer l;
/*     */   @XmlAttribute
/*     */   protected Integer t;
/*     */   @XmlAttribute
/*     */   protected Integer r;
/*     */   @XmlAttribute
/*     */   protected Integer b;
/*     */   
/*     */   public int getL() {
/*  68 */     if (this.l == null) {
/*  69 */       return 0;
/*     */     }
/*  71 */     return this.l.intValue();
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
/*     */   public void setL(int paramInt) {
/*  84 */     this.l = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isSetL() {
/*  88 */     return (this.l != null);
/*     */   }
/*     */   
/*     */   public void unsetL() {
/*  92 */     this.l = null;
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
/*     */   public int getT() {
/* 104 */     if (this.t == null) {
/* 105 */       return 0;
/*     */     }
/* 107 */     return this.t.intValue();
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
/*     */   public void setT(int paramInt) {
/* 120 */     this.t = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isSetT() {
/* 124 */     return (this.t != null);
/*     */   }
/*     */   
/*     */   public void unsetT() {
/* 128 */     this.t = null;
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
/*     */   public int getR() {
/* 140 */     if (this.r == null) {
/* 141 */       return 0;
/*     */     }
/* 143 */     return this.r.intValue();
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
/*     */   public void setR(int paramInt) {
/* 156 */     this.r = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isSetR() {
/* 160 */     return (this.r != null);
/*     */   }
/*     */   
/*     */   public void unsetR() {
/* 164 */     this.r = null;
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
/*     */   public int getB() {
/* 176 */     if (this.b == null) {
/* 177 */       return 0;
/*     */     }
/* 179 */     return this.b.intValue();
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
/*     */   public void setB(int paramInt) {
/* 192 */     this.b = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isSetB() {
/* 196 */     return (this.b != null);
/*     */   }
/*     */   
/*     */   public void unsetB() {
/* 200 */     this.b = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTRelativeRect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */