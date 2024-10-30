/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.CellType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.SectionType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.SheetType;
/*     */ import java.awt.Color;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.xdgf.exceptions.XDGFException;
/*     */ import org.apache.poi.xdgf.usermodel.section.CharacterSection;
/*     */ import org.apache.poi.xdgf.usermodel.section.GeometrySection;
/*     */ import org.apache.poi.xdgf.usermodel.section.XDGFSection;
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
/*     */ public abstract class XDGFSheet
/*     */ {
/*     */   protected XDGFDocument _document;
/*     */   protected SheetType _sheet;
/*  46 */   protected Map<String, XDGFCell> _cells = new HashMap<String, XDGFCell>();
/*     */ 
/*     */   
/*  49 */   protected Map<String, XDGFSection> _sections = new HashMap<String, XDGFSection>();
/*     */ 
/*     */   
/*  52 */   protected SortedMap<Long, GeometrySection> _geometry = new TreeMap<Long, GeometrySection>();
/*     */ 
/*     */   
/*  55 */   protected CharacterSection _character = null;
/*     */   
/*     */   public XDGFSheet(SheetType paramSheetType, XDGFDocument paramXDGFDocument) {
/*     */     try {
/*  59 */       this._sheet = paramSheetType;
/*  60 */       this._document = paramXDGFDocument;
/*     */       
/*  62 */       for (CellType cellType : paramSheetType.getCellArray()) {
/*  63 */         if (this._cells.containsKey(cellType.getN())) {
/*  64 */           throw new POIXMLException("Unexpected duplicate cell " + cellType.getN());
/*     */         }
/*  66 */         this._cells.put(cellType.getN(), new XDGFCell(cellType));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  74 */       for (SectionType sectionType : paramSheetType.getSectionArray()) {
/*  75 */         String str = sectionType.getN();
/*  76 */         if (str.equals("Geometry")) {
/*  77 */           this._geometry.put(Long.valueOf(sectionType.getIX()), new GeometrySection(sectionType, this));
/*  78 */         } else if (str.equals("Character")) {
/*  79 */           this._character = new CharacterSection(sectionType, this);
/*     */         } else {
/*  81 */           this._sections.put(str, XDGFSection.load(sectionType, this));
/*     */         } 
/*     */       } 
/*  84 */     } catch (POIXMLException pOIXMLException) {
/*  85 */       throw XDGFException.wrap(toString(), pOIXMLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract SheetType getXmlObject();
/*     */   
/*     */   public XDGFDocument getDocument() {
/*  92 */     return this._document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFCell getCell(String paramString) {
/* 101 */     return this._cells.get(paramString);
/*     */   }
/*     */   
/*     */   public XDGFSection getSection(String paramString) {
/* 105 */     return this._sections.get(paramString);
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getLineStyle() {
/* 109 */     if (!this._sheet.isSetLineStyle()) {
/* 110 */       return null;
/*     */     }
/* 112 */     return this._document.getStyleById(this._sheet.getLineStyle());
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getFillStyle() {
/* 116 */     if (!this._sheet.isSetFillStyle()) {
/* 117 */       return null;
/*     */     }
/* 119 */     return this._document.getStyleById(this._sheet.getFillStyle());
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getTextStyle() {
/* 123 */     if (!this._sheet.isSetTextStyle()) {
/* 124 */       return null;
/*     */     }
/* 126 */     return this._document.getStyleById(this._sheet.getTextStyle());
/*     */   }
/*     */   
/*     */   public Color getFontColor() {
/* 130 */     Color color = null;
/*     */     
/* 132 */     if (this._character != null) {
/* 133 */       color = this._character.getFontColor();
/* 134 */       if (color != null) {
/* 135 */         return color;
/*     */       }
/*     */     } 
/* 138 */     XDGFStyleSheet xDGFStyleSheet = getTextStyle();
/* 139 */     if (xDGFStyleSheet != null) {
/* 140 */       return xDGFStyleSheet.getFontColor();
/*     */     }
/* 142 */     return null;
/*     */   }
/*     */   
/*     */   public Double getFontSize() {
/* 146 */     Double double_ = null;
/*     */     
/* 148 */     if (this._character != null) {
/* 149 */       double_ = this._character.getFontSize();
/* 150 */       if (double_ != null) {
/* 151 */         return double_;
/*     */       }
/*     */     } 
/* 154 */     XDGFStyleSheet xDGFStyleSheet = getTextStyle();
/* 155 */     if (xDGFStyleSheet != null) {
/* 156 */       return xDGFStyleSheet.getFontSize();
/*     */     }
/* 158 */     return null;
/*     */   }
/*     */   
/*     */   public Integer getLineCap() {
/* 162 */     Integer integer = XDGFCell.maybeGetInteger(this._cells, "LineCap");
/* 163 */     if (integer != null) {
/* 164 */       return integer;
/*     */     }
/* 166 */     XDGFStyleSheet xDGFStyleSheet = getLineStyle();
/* 167 */     if (xDGFStyleSheet != null) {
/* 168 */       return xDGFStyleSheet.getLineCap();
/*     */     }
/* 170 */     return null;
/*     */   }
/*     */   
/*     */   public Color getLineColor() {
/* 174 */     String str = XDGFCell.maybeGetString(this._cells, "LineColor");
/* 175 */     if (str != null) {
/* 176 */       return Color.decode(str);
/*     */     }
/* 178 */     XDGFStyleSheet xDGFStyleSheet = getLineStyle();
/* 179 */     if (xDGFStyleSheet != null) {
/* 180 */       return xDGFStyleSheet.getLineColor();
/*     */     }
/* 182 */     return null;
/*     */   }
/*     */   
/*     */   public Integer getLinePattern() {
/* 186 */     Integer integer = XDGFCell.maybeGetInteger(this._cells, "LinePattern");
/* 187 */     if (integer != null) {
/* 188 */       return integer;
/*     */     }
/* 190 */     XDGFStyleSheet xDGFStyleSheet = getLineStyle();
/* 191 */     if (xDGFStyleSheet != null) {
/* 192 */       return xDGFStyleSheet.getLinePattern();
/*     */     }
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   public Double getLineWeight() {
/* 198 */     Double double_ = XDGFCell.maybeGetDouble(this._cells, "LineWeight");
/* 199 */     if (double_ != null) {
/* 200 */       return double_;
/*     */     }
/* 202 */     XDGFStyleSheet xDGFStyleSheet = getLineStyle();
/* 203 */     if (xDGFStyleSheet != null) {
/* 204 */       return xDGFStyleSheet.getLineWeight();
/*     */     }
/* 206 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */