/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xdgf.exceptions.XDGFException;
/*     */ import org.apache.poi.xdgf.usermodel.shape.ShapeRenderer;
/*     */ import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
/*     */ import org.apache.poi.xdgf.usermodel.shape.exceptions.StopVisiting;
/*     */ import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
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
/*     */ public class XDGFBaseContents
/*     */   extends XDGFXMLDocumentPart
/*     */ {
/*     */   protected PageContentsType _pageContents;
/*  52 */   protected List<XDGFShape> _toplevelShapes = new ArrayList<XDGFShape>();
/*  53 */   protected Map<Long, XDGFShape> _shapes = new HashMap<Long, XDGFShape>();
/*  54 */   protected List<XDGFConnection> _connections = new ArrayList<XDGFConnection>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFBaseContents(PackagePart paramPackagePart, XDGFDocument paramXDGFDocument) {
/*  60 */     super(paramPackagePart, paramXDGFDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XDGFBaseContents(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship, XDGFDocument paramXDGFDocument) {
/*  68 */     this(paramPackagePart, paramXDGFDocument);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public PageContentsType getXmlObject() {
/*  73 */     return this._pageContents;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() {
/*  80 */     if (this._pageContents.isSetShapes()) {
/*  81 */       for (ShapeSheetType shapeSheetType : this._pageContents.getShapes().getShapeArray()) {
/*  82 */         XDGFShape xDGFShape = new XDGFShape(shapeSheetType, this, this._document);
/*  83 */         this._toplevelShapes.add(xDGFShape);
/*  84 */         addToShapeIndex(xDGFShape);
/*     */       } 
/*     */     }
/*     */     
/*  88 */     if (this._pageContents.isSetConnects()) {
/*  89 */       for (ConnectType connectType : this._pageContents.getConnects().getConnectArray()) {
/*     */         
/*  91 */         XDGFShape xDGFShape1 = this._shapes.get(Long.valueOf(connectType.getFromSheet()));
/*  92 */         XDGFShape xDGFShape2 = this._shapes.get(Long.valueOf(connectType.getToSheet()));
/*     */         
/*  94 */         if (xDGFShape1 == null) {
/*  95 */           throw new POIXMLException(toString() + "; Connect; Invalid from id: " + connectType.getFromSheet());
/*     */         }
/*  97 */         if (xDGFShape2 == null) {
/*  98 */           throw new POIXMLException(toString() + "; Connect; Invalid to id: " + connectType.getToSheet());
/*     */         }
/* 100 */         this._connections.add(new XDGFConnection(connectType, xDGFShape1, xDGFShape2));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected void addToShapeIndex(XDGFShape paramXDGFShape) {
/* 106 */     this._shapes.put(Long.valueOf(paramXDGFShape.getID()), paramXDGFShape);
/*     */     
/* 108 */     List<XDGFShape> list = paramXDGFShape.getShapes();
/* 109 */     if (list == null) {
/*     */       return;
/*     */     }
/* 112 */     for (XDGFShape xDGFShape : list) {
/* 113 */       addToShapeIndex(xDGFShape);
/*     */     }
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
/*     */   public void draw(Graphics2D paramGraphics2D) {
/* 126 */     visitShapes((ShapeVisitor)new ShapeRenderer(paramGraphics2D));
/*     */   }
/*     */ 
/*     */   
/*     */   public XDGFShape getShapeById(long paramLong) {
/* 131 */     return this._shapes.get(Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   public Map<Long, XDGFShape> getShapesMap() {
/* 135 */     return Collections.unmodifiableMap(this._shapes);
/*     */   }
/*     */   
/*     */   public Collection<XDGFShape> getShapes() {
/* 139 */     return this._shapes.values();
/*     */   }
/*     */   
/*     */   public List<XDGFShape> getTopLevelShapes() {
/* 143 */     return Collections.unmodifiableList(this._toplevelShapes);
/*     */   }
/*     */   
/*     */   public List<XDGFConnection> getConnections() {
/* 147 */     return Collections.unmodifiableList(this._connections);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     return getPackagePart().getPartName().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitShapes(ShapeVisitor paramShapeVisitor) {
/*     */     try {
/* 162 */       for (XDGFShape xDGFShape : this._toplevelShapes) {
/* 163 */         xDGFShape.visitShapes(paramShapeVisitor, new AffineTransform(), 0);
/*     */       }
/* 165 */     } catch (StopVisiting stopVisiting) {
/*     */     
/* 167 */     } catch (POIXMLException pOIXMLException) {
/* 168 */       throw XDGFException.wrap(this, pOIXMLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFBaseContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */