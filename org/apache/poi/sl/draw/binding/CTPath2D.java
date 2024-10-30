/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlElements;
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
/*     */ @XmlType(name = "CT_Path2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"closeOrMoveToOrLnTo"})
/*     */ public class CTPath2D
/*     */ {
/*     */   @XmlElements({@XmlElement(name = "lnTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPath2DLineTo.class), @XmlElement(name = "close", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPath2DClose.class), @XmlElement(name = "cubicBezTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPath2DCubicBezierTo.class), @XmlElement(name = "quadBezTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPath2DQuadBezierTo.class), @XmlElement(name = "arcTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPath2DArcTo.class), @XmlElement(name = "moveTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPath2DMoveTo.class)})
/*     */   protected List<Object> closeOrMoveToOrLnTo;
/*     */   @XmlAttribute
/*     */   protected Long w;
/*     */   @XmlAttribute
/*     */   protected Long h;
/*     */   @XmlAttribute
/*     */   protected STPathFillMode fill;
/*     */   @XmlAttribute
/*     */   protected Boolean stroke;
/*     */   @XmlAttribute
/*     */   protected Boolean extrusionOk;
/*     */   
/*     */   public List<Object> getCloseOrMoveToOrLnTo() {
/* 113 */     if (this.closeOrMoveToOrLnTo == null) {
/* 114 */       this.closeOrMoveToOrLnTo = new ArrayList();
/*     */     }
/* 116 */     return this.closeOrMoveToOrLnTo;
/*     */   }
/*     */   
/*     */   public boolean isSetCloseOrMoveToOrLnTo() {
/* 120 */     return (this.closeOrMoveToOrLnTo != null && !this.closeOrMoveToOrLnTo.isEmpty());
/*     */   }
/*     */   
/*     */   public void unsetCloseOrMoveToOrLnTo() {
/* 124 */     this.closeOrMoveToOrLnTo = null;
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
/*     */   public long getW() {
/* 136 */     if (this.w == null) {
/* 137 */       return 0L;
/*     */     }
/* 139 */     return this.w.longValue();
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
/*     */   public void setW(long paramLong) {
/* 152 */     this.w = Long.valueOf(paramLong);
/*     */   }
/*     */   
/*     */   public boolean isSetW() {
/* 156 */     return (this.w != null);
/*     */   }
/*     */   
/*     */   public void unsetW() {
/* 160 */     this.w = null;
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
/*     */   public long getH() {
/* 172 */     if (this.h == null) {
/* 173 */       return 0L;
/*     */     }
/* 175 */     return this.h.longValue();
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
/*     */   public void setH(long paramLong) {
/* 188 */     this.h = Long.valueOf(paramLong);
/*     */   }
/*     */   
/*     */   public boolean isSetH() {
/* 192 */     return (this.h != null);
/*     */   }
/*     */   
/*     */   public void unsetH() {
/* 196 */     this.h = null;
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
/*     */   public STPathFillMode getFill() {
/* 208 */     if (this.fill == null) {
/* 209 */       return STPathFillMode.NORM;
/*     */     }
/* 211 */     return this.fill;
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
/*     */   public void setFill(STPathFillMode paramSTPathFillMode) {
/* 224 */     this.fill = paramSTPathFillMode;
/*     */   }
/*     */   
/*     */   public boolean isSetFill() {
/* 228 */     return (this.fill != null);
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
/*     */   public boolean isStroke() {
/* 240 */     if (this.stroke == null) {
/* 241 */       return true;
/*     */     }
/* 243 */     return this.stroke.booleanValue();
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
/*     */   public void setStroke(boolean paramBoolean) {
/* 256 */     this.stroke = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetStroke() {
/* 260 */     return (this.stroke != null);
/*     */   }
/*     */   
/*     */   public void unsetStroke() {
/* 264 */     this.stroke = null;
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
/*     */   public boolean isExtrusionOk() {
/* 276 */     if (this.extrusionOk == null) {
/* 277 */       return true;
/*     */     }
/* 279 */     return this.extrusionOk.booleanValue();
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
/*     */   public void setExtrusionOk(boolean paramBoolean) {
/* 292 */     this.extrusionOk = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetExtrusionOk() {
/* 296 */     return (this.extrusionOk != null);
/*     */   }
/*     */   
/*     */   public void unsetExtrusionOk() {
/* 300 */     this.extrusionOk = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPath2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */