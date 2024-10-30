/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.PageType;
/*     */ import java.awt.geom.Point2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xdgf.geom.Dimension2dDouble;
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
/*     */ public class XDGFPage
/*     */ {
/*     */   private PageType _page;
/*     */   protected XDGFPageContents _content;
/*     */   protected XDGFPages _pages;
/*  37 */   protected XDGFSheet _pageSheet = null;
/*     */ 
/*     */   
/*     */   public XDGFPage(PageType paramPageType, XDGFPageContents paramXDGFPageContents, XDGFDocument paramXDGFDocument, XDGFPages paramXDGFPages) {
/*  41 */     this._page = paramPageType;
/*  42 */     this._content = paramXDGFPageContents;
/*  43 */     this._pages = paramXDGFPages;
/*  44 */     paramXDGFPageContents.setPage(this);
/*     */     
/*  46 */     if (paramPageType.isSetPageSheet())
/*  47 */       this._pageSheet = new XDGFPageSheet(paramPageType.getPageSheet(), paramXDGFDocument); 
/*     */   }
/*     */   
/*     */   @Internal
/*     */   protected PageType getXmlObject() {
/*  52 */     return this._page;
/*     */   }
/*     */   
/*     */   public long getID() {
/*  56 */     return this._page.getID();
/*     */   }
/*     */   
/*     */   public String getName() {
/*  60 */     return this._page.getName();
/*     */   }
/*     */   
/*     */   public XDGFPageContents getContent() {
/*  64 */     return this._content;
/*     */   }
/*     */   
/*     */   public XDGFSheet getPageSheet() {
/*  68 */     return this._pageSheet;
/*     */   }
/*     */   
/*     */   public long getPageNumber() {
/*  72 */     return (this._pages.getPageList().indexOf(this) + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension2dDouble getPageSize() {
/*  79 */     XDGFCell xDGFCell1 = this._pageSheet.getCell("PageWidth");
/*  80 */     XDGFCell xDGFCell2 = this._pageSheet.getCell("PageHeight");
/*     */     
/*  82 */     if (xDGFCell1 == null || xDGFCell2 == null) {
/*  83 */       throw new POIXMLException("Cannot determine page size");
/*     */     }
/*  85 */     return new Dimension2dDouble(Double.parseDouble(xDGFCell1.getValue()), Double.parseDouble(xDGFCell2.getValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Point2D.Double getPageOffset() {
/*  93 */     XDGFCell xDGFCell1 = this._pageSheet.getCell("XRulerOrigin");
/*  94 */     XDGFCell xDGFCell2 = this._pageSheet.getCell("YRulerOrigin");
/*     */     
/*  96 */     double d1 = 0.0D;
/*  97 */     double d2 = 0.0D;
/*     */     
/*  99 */     if (xDGFCell1 != null) {
/* 100 */       d1 = Double.parseDouble(xDGFCell1.getValue());
/*     */     }
/* 102 */     if (xDGFCell1 != null) {
/* 103 */       d2 = Double.parseDouble(xDGFCell2.getValue());
/*     */     }
/* 105 */     return new Point2D.Double(d1, d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D getBoundingBox() {
/* 112 */     Dimension2dDouble dimension2dDouble = getPageSize();
/* 113 */     Point2D.Double double_ = getPageOffset();
/*     */     
/* 115 */     return new Rectangle2D.Double(-double_.getX(), -double_.getY(), dimension2dDouble.getWidth(), dimension2dDouble.getHeight());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */